package tn.esprit.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Scheduled(cron = "0/15 * * * * *")
	@Override
	public void status() {
		 List<stock> stocks= (List<stock>)StockRepo.findAll();
	        if(stocks!=null) {
	        for (stock stock : stocks){
	        	
	            if (stock.getQuantite()<=stock.getQuantiteMin()){
	            	log.info("Le produit "+ stock.getLibelleStock()+" est epuisé ");         
	          
	            }
		
	        	}
	        }
	}
	
	

}
