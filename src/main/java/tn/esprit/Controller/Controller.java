package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import tn.esprit.Entities.SmsRequest;
import tn.esprit.Services.SmsService;

@RestController
@RequestMapping("api/v1/sms")
public class Controller {
	 private final SmsService service;

	    @Autowired
	    public Controller(SmsService service) {
	        this.service = service;
	    }

	    @PostMapping
	    public void sendSms(@Validated @RequestBody SmsRequest smsRequest) {
	        service.sendSms(smsRequest);
	    }
}
