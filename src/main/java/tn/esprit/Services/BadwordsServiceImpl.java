package tn.esprit.Services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lombok.extern.slf4j.Slf4j;
import tn.esprit.Entities.Badwords;
import tn.esprit.Repository.BadwordsRepository;


@Service
@Slf4j
public class BadwordsServiceImpl implements BadwordsService{
	@Autowired
	BadwordsRepository badwordsRepository;
	@Override
	public void addBadwords(String filename) {
		log.info("in add function");
		try  { 
		BufferedReader br = new BufferedReader(new FileReader("D:\\Uni Life\\MERGE2\\ConsomiTounsiA2022\\src\\\\main\\resources\\"+filename));
         String s;                                              
         while ((s = br.readLine()) != null) {
             	log.info("in while loop");
             	if (badwordsRepository.findByWord(s) == null) {
             		log.info("if condition");
            	 Badwords word = new Badwords(s);
            	 log.info("New word"+word.getWord());
            	 badwordsRepository.save(word);
             	}
         }
         br.close();
         log.info("out of while loop");
         File file = new File("D:\\Uni Life\\MERGE2\\ConsomiTounsiA2022\\src\\\\main\\resources\\"+filename);
         log.info("File exist? "+file.exists());
         boolean isDeleted = file.delete();
         log.info("file is deleted ? : "+isDeleted);
	  } catch (Exception ex) {
	  
	  }

	}}
 