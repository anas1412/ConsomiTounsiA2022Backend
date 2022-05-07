package tn.esprit.Services;

import java.util.List;
import tn.esprit.Entities.stock;

public interface IStockService {
	
	List<stock> retrieveAllStock();

	stock addStock (stock s);

	void deleteStock (Long id);

	stock updateStock (stock s, Long id);

	stock retrieveStock (Long id);	
}
