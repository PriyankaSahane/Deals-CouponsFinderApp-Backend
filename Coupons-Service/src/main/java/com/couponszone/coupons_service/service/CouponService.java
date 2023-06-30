package com.couponszone.coupons_service.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.couponszone.coupons_service.entity.Coupon;


//interface for service layer
@Service
public interface CouponService {

	public Coupon addCoupons(Coupon coupon);

	public List<Coupon> getAllCoupons();

    public Coupon getCouponById(int couponId);
    //by company name
	public Coupon getCouponByCompanyName(String icon_Link );
	
	public List<Coupon> getCouponByCategory(String category);

	public Coupon updateCoupons(int couponId,Coupon coupon);

	public Map<String,Boolean> deleteCouponById(int couponId);

}
