package com.couponszone.coupons_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.couponszone.coupons_service.entity.Coupon;

@Repository
public interface CouponRepository extends MongoRepository<Coupon, Integer> {
	
	public List<Coupon> findByCategory(String category);

	public Optional<Coupon> findByCompanyName(String icon_Link);

}
