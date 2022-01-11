package com.rsjava.twilio.messages;

import com.rsjava.twilio.messages.request.Content;
import com.rsjava.twilio.messages.service.TwilioService;
import com.twilio.rest.api.v2010.account.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("messages")
@RequiredArgsConstructor
public class MessageController {

    private final TwilioService twilioService;

    @PostMapping
    public ResponseEntity<Message.Status> sendSMS(@RequestBody Content content) {

        return ResponseEntity.ok(twilioService.sendMessage(content.getText()));
    }
}
