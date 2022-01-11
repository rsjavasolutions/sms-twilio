package com.rsjava.twilio.messages.service;

import com.rsjava.twilio.messages.configuration.TwilioProperties;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TwilioService {

    private final TwilioProperties twilioProperties;

    public Message.Status sendMessage(String text) {
        Twilio.init(twilioProperties.getAccountSid(), twilioProperties.getAuthToken());

        Message message = Message.creator(
                new PhoneNumber("+48603351210"), //to
                new PhoneNumber(twilioProperties.getTrialNumber()), //from
                text)
                .create();

        return message.getStatus();
    }
}
