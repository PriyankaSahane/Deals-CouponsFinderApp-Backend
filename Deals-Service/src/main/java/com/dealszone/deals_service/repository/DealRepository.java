package com.dealszone.deals_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dealszone.deals_service.entity.Deal;

@Repository
public interface DealRepository extends MongoRepository<Deal, Integer> {
	
	//public Optional<Deal> findByCompanyName(String icon_Link);

	public List<Deal> findByCategory(String category);

	//public List<Deal> findByProductType(String produType);
}
