package info.lazycompiler.awssqstest.service;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import info.lazycompiler.awssqstest.config.SQSConfigurer;
import info.lazycompiler.awssqstest.model.MessageObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SQSPublisherService {

    private String url;
    private AmazonSQSAsync amazonSQSAsync;
    private ObjectMapper mapper = new ObjectMapper();

    public SQSPublisherService(@Value("${cloud.aws.sqs.url}") String url, final SQSConfigurer sqsConfigurer) {
        this.url = url;
        this.amazonSQSAsync = sqsConfigurer.getSqsAsyncClient();
    }

    public void sendMessage(MessageObject o) throws Exception{
        if (amazonSQSAsync != null) {
            SendMessageResult result = amazonSQSAsync.sendMessage(url, mapper.writeValueAsString(o));
            log.info("Message published with id " + result.getMessageId());
        }
        else{
            log.error("Aws-Sqs client null.");
        }
    }
}


