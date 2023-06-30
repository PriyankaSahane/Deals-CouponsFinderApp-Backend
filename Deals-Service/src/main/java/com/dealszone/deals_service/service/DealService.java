package com.dealszone.deals_service.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dealszone.deals_service.entity.Deal;
//import com.eshoppingzone.productservice.entity.Product;

//interface for service layer
@Service
public interface DealService {

	public Deal addDeals(Deal deal);

	public List<Deal> getAllDeals();

	//public Object addDeals(Deal deal);

    public Deal getDealById(int deal_Id);
    //by company name
	//public Deal getDealByCompanyName(String icon_Link );
	
	public List<Deal> getDealByCategory(String category);

	public Deal updateDeals(int dealId,Deal deal);

	public Map<String,Boolean> deleteDealById(int dealId);

	//public List<Deal> getProductByType(String productType);
}
