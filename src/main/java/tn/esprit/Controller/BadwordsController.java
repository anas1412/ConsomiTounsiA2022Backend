package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.Services.BadwordsService;

@RestController
@RequestMapping("/profanity")
public class BadwordsController {
	@Autowired
	private BadwordsService serviceBadwords;
	
	@PostMapping("/add-badwords/{filename}") 
	public void addBadwords(@PathVariable("filename")String filename) {
		
		serviceBadwords.addBadwords(filename);
	}
	
}
