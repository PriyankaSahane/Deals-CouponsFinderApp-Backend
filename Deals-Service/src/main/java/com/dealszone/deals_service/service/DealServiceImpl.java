package com.dealszone.deals_service.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealszone.deals_service.entity.Deal;
import com.dealszone.deals_service.repository.DealRepository;
import com.dealszone.exception.CategoryNotFoundException;
import com.dealszone.exception.DealAlreadyExistsException;
import com.dealszone.exception.DealNotFoundException;


@Service
public class DealServiceImpl implements DealService {

	
	Logger logger= LoggerFactory.getLogger(DealServiceImpl.class);

	
	@Autowired
	private DealRepository dealRepository;
	
	
	@Autowired
	private SequenceGeneratorService seqService;
	
	
	//adding new product
	@Override
	public Deal addDeals(Deal deal) throws DealAlreadyExistsException {
		if(dealRepository.existsById(deal.getDealId())) {
			
			throw new DealAlreadyExistsException();
		}
			
		deal.setDealId(seqService.getSequenceNum(Deal.sequenceName));
		
		return dealRepository.save(deal);
	}
	
	// list all existing product
	@Override
	public List<Deal> getAllDeals() {

		return dealRepository.findAll();
	}
	
	// get product by productId
	@Override
	public Deal getDealById(int dealId) throws DealNotFoundException{
		return dealRepository.findById(dealId).orElseThrow(()->new DealNotFoundException());
	}

	//get deal by company Name
	/*@Override
	public Deal getDealByCompanyName(String icon_Link) throws DealNotFoundException {
		
		Deal deal;
		if(dealRepository.findByCompanyName(icon_Link).isEmpty()) {
			logger.error("Deal not found  in find by company name");
			throw new DealNotFoundException();
		}
		else {
			deal=dealRepository.findByCompanyName(icon_Link).get();
		}
		
		return deal;
	}*/
	
	// update existing  deal by its dealId
	@Override
	public Deal updateDeals(int dealId,Deal deal) throws DealNotFoundException {
		
		Deal updatedDeal=dealRepository.findById(dealId).orElseThrow(()-> new DealNotFoundException());
		
		updatedDeal.setCategory(deal.getCategory());
		updatedDeal.setTitle(deal.getTitle());
		updatedDeal.setLink(deal.getLink());
		updatedDeal.setIcon_link(deal.getIcon_link());
		updatedDeal.setView_deal(deal.getView_deal());
		updatedDeal.setImg(deal.getImg());
		final Deal finalUpdatedProduct= dealRepository.save(updatedDeal);
		

		return finalUpdatedProduct;
	}
	
	//delete product by productId
	@Override
	public Map<String,Boolean> deleteDealById(int dealId) throws DealNotFoundException {
		
		Deal deal=dealRepository.findById(dealId).orElseThrow(()->new DealNotFoundException());
		
		dealRepository.delete(deal);
		
		
		
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("Deleted", Boolean.TRUE);
		return response;
	}
	
	//get all products by category
	@Override
	public List<Deal> getDealByCategory(String category)  throws CategoryNotFoundException{

		List<Deal> deal;
		if(dealRepository.findByCategory(category).isEmpty()) {
			throw new CategoryNotFoundException();
		}
		else {
			deal=dealRepository.findByCategory(category);
		}
		
		return deal;
	}
	
	//get all product by productType
	/*@Override
	public List<Product> getProductByType(String productType) throws ProductTypeNotExistsException {
		List<Product> product;
		if(productRepository.findByProductType(productType).isEmpty()) {
			throw new ProductTypeNotExistsException();
		}
		else {
			product=productRepository.findByProductType(productType);
		}
		
		return product;
	}
*/
}
