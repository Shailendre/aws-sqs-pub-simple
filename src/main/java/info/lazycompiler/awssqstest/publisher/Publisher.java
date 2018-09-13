package info.lazycompiler.awssqstest.publisher;

import info.lazycompiler.awssqstest.model.MessageObject;
import info.lazycompiler.awssqstest.service.SQSPublisherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Publisher {

    @Autowired
    private SQSPublisherService sqsPublisherService;
    private MessageObject messageObject;

    public Publisher() {
        messageObject = MessageObject.build()
                .withId(12319890)
                .withFrom("from")
                .withTo("to")
                .withSubject("subject")
                .withBody("body");
    }

    @Scheduled(fixedDelay = 2000)
    public void sendTestMessage() {
        try {
            sqsPublisherService.sendMessage(messageObject);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


}
