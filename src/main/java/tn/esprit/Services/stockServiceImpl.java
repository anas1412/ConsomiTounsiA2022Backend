package tn.esprit.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.Entities.stock;
import tn.esprit.Repository.stockRepository;




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
	public stock updateStock(stock c,Long id) {
		StockRepo.save(c);
		return c;
	}

	@Override
	public stock retrieveStock(Long id) {
		
		return StockRepo.findById(id).orElse(null);
	}
			
}
