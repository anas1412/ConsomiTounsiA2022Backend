package tn.esprit.Services;

import java.util.List;

import tn.esprit.Entities.stock;

public interface IStockService {
	
	List<stock> retrieveAllStock();

	stock addStock (stock s);

	void deleteStock (Long id);

	stock updateStock (stock s);

	stock retrieveStock (Long id);	
	
	List<stock> listAll(String keyword);
}
