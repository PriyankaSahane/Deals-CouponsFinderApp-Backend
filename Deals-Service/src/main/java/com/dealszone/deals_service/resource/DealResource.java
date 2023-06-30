package com.dealszone.deals_service.resource;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dealszone.deals_service.entity.Deal;
import com.dealszone.deals_service.service.DealService;
import com.dealszone.exception.DealNotFoundException;


//@CrossOrigin(origins="*",maxAge = 3600)
@RestController
@RequestMapping("/Deals")
public class DealResource {

	@Autowired
	private DealService dealServiceImpl;
	
	Logger logger= LoggerFactory.getLogger(DealResource.class);

	DealResource() {
	}
	
	@PostMapping("/add")
	public ResponseEntity<Deal> addDeals(  @RequestBody Deal deal) {
		
		logger.warn("deal"+deal);
		Deal addedDeal= dealServiceImpl.addDeals(deal);
		
		return new ResponseEntity<>(addedDeal,HttpStatus.CREATED);
		
	}

	@GetMapping("/get")
	public List<Deal> getAllDeals() {
	 List<Deal> d=dealServiceImpl.getAllDeals();
		return d;
	}

	
	@GetMapping("/findById/{dealId}")
	public ResponseEntity<Deal> getDealById(@PathVariable int dealId) {
	return new ResponseEntity<>	(dealServiceImpl.getDealById(dealId),HttpStatus.OK);
		
	}

	/*@GetMapping("/findByType/{productType}")
	public ResponseEntity<List<Product>> getProductByType(@PathVariable String productType) {
		
		return new ResponseEntity<>(productServiceImpl.getProductByType(productType),HttpStatus.OK);
	}

	@GetMapping("/findByCompanyName/{icon_link}")
	public ResponseEntity<Deal> getDealByCompanyName(@PathVariable String icon_Link) {
		
		return new ResponseEntity<>(dealServiceImpl.getDealByCompanyName(icon_Link),HttpStatus.OK);
	}*/

	@GetMapping("/findByCategory/{category}")
	public ResponseEntity<List<Deal>> getDealByCategory(@PathVariable String category) {
		
		return new ResponseEntity<>(dealServiceImpl.getDealByCategory(category),HttpStatus.OK);
	}

	@PutMapping("/update/{dealId}")
	public ResponseEntity<Deal> updateDeal(@PathVariable int dealId, @Valid @RequestBody Deal deal) throws DealNotFoundException {
		;
		return  ResponseEntity.ok(dealServiceImpl.updateDeals(dealId,deal));
	}

	@DeleteMapping("/delete/{dealId}")
	public Map<String,Boolean> deleteDeal(@PathVariable int dealId)throws DealNotFoundException {
		
		return dealServiceImpl.deleteDealById(dealId);
	}
}
