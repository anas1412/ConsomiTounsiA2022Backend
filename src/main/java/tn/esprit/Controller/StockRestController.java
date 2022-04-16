package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
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

import io.swagger.annotations.ApiOperation;
import tn.esprit.Entities.stock;
import tn.esprit.Services.IStockService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/stock")
public class StockRestController {

	@Autowired
	IStockService stockService;
	
	
	// http://localhost:8080/SpringMVC/stock/retrieve-all-stocks
	@GetMapping("/retrieve-all-stocks")
	@ResponseBody
	@ApiOperation(value = "Récupérer la liste des stocks")
	public List<stock> getStocks() {
	List<stock> listStocks = stockService.retrieveAllStock();
	return listStocks;
	}

	//http://localhost:8080/SpringMVC/stock/retrieve-stock/8
	@GetMapping("/retrieve-stock/{stock-id}")
	@ResponseBody
	@ApiOperation(value = "Récupérer les données de stock")
	public stock retrieveStock(@PathVariable("stock-id") Long stockId) {
	return stockService.retrieveStock(stockId);
	}

	//http://localhost:8080/SpringMVC/stock/add-stock
	@PostMapping("/add-stock")
	@ResponseBody
	@ApiOperation(value = "Ajouter stock")
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
	@ApiOperation(value = "Modifier stock")
	public stock modifyOperateur(@RequestBody stock stock) {
	return stockService.updateStock(stock);
	}

	@RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<stock> listStocks = stockService.listAll(keyword);
        model.addAttribute("listStocks", listStocks);
        model.addAttribute("keyword", keyword);
         
        return "index";
    }
	
}
