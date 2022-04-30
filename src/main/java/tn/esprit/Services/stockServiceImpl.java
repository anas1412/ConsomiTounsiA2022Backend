package tn.esprit.Services;

import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.Entities.stock;
import tn.esprit.Repository.stockRepository;



@Slf4j
@Service
public class stockServiceImpl implements IStockService{
	
	
	@Autowired
	stockRepository StockRepo;
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	
	
	@Override
	public List<stock> retrieveAllStock() {
		// TODO Auto-generated method stub
		return (List<stock>) StockRepo.findAll();
	}

	@Override
	public stock addStock(stock c) {
		StockRepo.save(c);
		return c;
	}

	@Override
	public void deleteStock(Long id) {
		StockRepo.deleteById(id);
		
	}

	@Override
	public stock retrieveStock(Long id) {
		
		return StockRepo.findById(id).orElse(null);
	}

	@Override
	public stock updateStock(stock s) {
		stock stock = StockRepo.findById(s.getIdStock()).get();
		stock.setLibelleStock(s.getLibelleStock());
		stock.setQuantite(s.getQuantite());
		stock.setSupplier_name(s.getSupplier_name());
		stock.setSupplier_mail(s.getSupplier_mail());
	
		return StockRepo.save(stock);
	}

	@Override
	public List<stock> listAll(String keyword) {
		if (keyword != null) {
			return StockRepo.search(keyword);
		}
		return (List<stock>) StockRepo.findAll();
	}
	
	
	
	@Bean
	public JavaMailSender getJavaMailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost("smtp.gmail.com");
	    mailSender.setPort(587);
	    
	    mailSender.setUsername("ah.sass.nas@gmail.com");
	    mailSender.setPassword("anas21541416");
	    
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	    
	    return mailSender;
	}
	
	
	

	@Scheduled(cron = "*/15 * * * * *")
	@Override
	public void status() {
		SimpleMailMessage msg = new SimpleMailMessage();
		 List<stock> stocks= (List<stock>)StockRepo.findAll();
	        if(stocks!=null) {
	        for (stock stock : stocks){
	        	
	            if (stock.getQuantite()<=stock.getQuantiteMin()){
	            	
	            	//msg.setTo("nourmrad171199@gmail.com", "nourmrad171199@gmail.com");
	            	msg.setTo(stock.getSupplier_mail(), stock.getSupplier_mail());
	            	
	                msg.setSubject("Testing from Spring Boot");
	                msg.setText("Monsieur "+stock.getSupplier_name()+" produit "+ stock.getLibelleStock()+" est epuisé ");

	                javaMailSender.send(msg);

	          
	            }
		
	        	}
	        }
	}
	
	
	
	

}
