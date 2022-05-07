package tn.esprit.Services;

import org.springframework.stereotype.Service;

import tn.esprit.Entities.SmsRequest;
import tn.esprit.Entities.TwilioSmsSender;


public interface SmsSender {
	void sendSms(SmsRequest smsRequest) ;
	 void SmsService( TwilioSmsSender smsSender);
	    // or maybe void sendSms(String phoneNumber, String message);
}
