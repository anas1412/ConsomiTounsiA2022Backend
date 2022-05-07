package tn.esprit.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import tn.esprit.Entities.SmsRequest;
import tn.esprit.Entities.TwilioSmsSender;

@Service
public class SmsService {
	private final SmsSender smsSender;

    @Autowired
    public SmsService(@Qualifier("twilio") SmsSender smsSender) {
        this.smsSender = smsSender;
    }

    public void sendSms(SmsRequest smsRequest) {
        smsSender.sendSms(smsRequest);
}
    
}