package ua.skuhtin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.skuhtin.dto.Message;
import ua.skuhtin.dto.RabbitResponse;

import java.util.Objects;

@RestController
public class MessageController {
    Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${rabbit.queue.name.first}")
    private String queueFirst;
    @Value("${rabbit.queue.name.second}")
    private String queueSecond;

    @RequestMapping(value = "/sender/first", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> sendFirstQueueMessages(@RequestBody Message message) {
        logger.info("send message");
        amqpTemplate.convertAndSend(queueFirst, message);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

    @RequestMapping(value = "/sender/second", method = RequestMethod.POST)
    public ResponseEntity<RabbitResponse> sendSecondQueueMessages(@RequestBody Message message) {
        logger.info("send message");
        Object response = amqpTemplate.convertSendAndReceive(queueSecond, message);
        if (response instanceof RabbitResponse) {
            return new ResponseEntity<RabbitResponse>((RabbitResponse) response, HttpStatus.OK);
        }

        return new ResponseEntity<RabbitResponse>(new RabbitResponse("unsuccessfully"), HttpStatus.OK);
    }
}
