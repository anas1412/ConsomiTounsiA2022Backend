package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.Entities.stock;
import tn.esprit.Services.IStockService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/stock")
public class StockRestController {

	@Autowired
	IStockService stockService;
	
	
	// http://localhost:8080/SpringMVC/stock/retrieve-all-stocks
	@GetMapping("/retrieve-all-stocks")
	@ResponseBody
	public List<stock> getStocks() {
	List<stock> listStocks = stockService.retrieveAllStock();
	return listStocks;
	}

	//http://localhost:8080/SpringMVC/stock/retrieve-stock/8
	@GetMapping("/retrieve-stock/{stock-id}")
	@ResponseBody
	public stock retrieveStock(@PathVariable("stock-id") Long stockId) {
	return stockService.retrieveStock(stockId);
	}

	//http://localhost:8080/SpringMVC/stock/add-stock
	@PostMapping("/add-stock")
	@ResponseBody
	public stock addStock(@RequestBody stock s)
	{
	stock stock = stockService.addStock(s);
	return stock;
	}

	//http://localhost:8080/SpringMVC/stock/remove-stock/{stock-id}
	@DeleteMapping("/remove-stock/{stock-id}")
	@ResponseBody
	public void removeStock(@PathVariable("stock-id") Long stockId) {
		stockService.deleteStock(stockId);
	}

	//http://localhost:8080/SpringMVC/stock/modify-stock/@stock-id}
	@PutMapping("/modify-stock")
	@ResponseBody
	public stock modifyOperateur(@RequestBody stock stock) {
	return stockService.updateStock(stock);
	}

	
	
}
