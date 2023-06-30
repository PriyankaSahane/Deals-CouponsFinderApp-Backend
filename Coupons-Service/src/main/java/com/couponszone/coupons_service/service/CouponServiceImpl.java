package com.couponszone.coupons_service.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.couponszone.coupons_service.entity.Coupon;
import com.couponszone.coupons_service.repository.CouponRepository;
import com.couponszone.exception.CategoryNotFoundException;
import com.couponszone.exception.CouponAlreadyExistsException;
import com.couponszone.exception.CouponNotFoundException;


@Service
public class CouponServiceImpl implements CouponService {

	
	Logger logger= LoggerFactory.getLogger(CouponServiceImpl.class);

	
	@Autowired
	private CouponRepository couponRepository;
	
	
	@Autowired
	private SequenceGeneratorService seqService;
	
	
	//adding new product
	@Override
	public Coupon addCoupons(Coupon coupon) throws CouponAlreadyExistsException {
		if(couponRepository.existsById(coupon.getCouponId())) {
			
			throw new CouponAlreadyExistsException();
		}
			
		coupon.setCouponId(seqService.getSequenceNum(Coupon.sequenceName));
		
		return couponRepository.save(coupon);
	}
	
	// list all existing product
	@Override
	public List<Coupon> getAllCoupons() {

		return couponRepository.findAll();
	}
	
	// get product by productId
	@Override
	public Coupon getCouponById(int couponId) throws CouponNotFoundException{
		return couponRepository.findById(couponId).orElseThrow(()->new CouponNotFoundException());
	}

	//get deal by company Name
	@Override
	public Coupon getCouponByCompanyName(String icon_Link) throws CouponNotFoundException {
		
		Coupon coupon;
		if(couponRepository.findByCompanyName(icon_Link).isEmpty()) {
			logger.error("Deal not found  in find by company name");
			throw new CouponNotFoundException();
		}
		else {
			coupon=couponRepository.findByCompanyName(icon_Link).get();
		}
		
		return coupon;
	}
	
	// update existing  deal by its dealId
	@Override
	public Coupon updateCoupons(int couponId,Coupon coupon) throws CouponNotFoundException {
		
		Coupon updatedCoupon=couponRepository.findById(couponId).orElseThrow(()-> new CouponNotFoundException());
		
		updatedCoupon.setCategory(coupon.getCategory());
		updatedCoupon.setTitle(coupon.getTitle());
		updatedCoupon.setLink(coupon.getLink());
		updatedCoupon.setIcon_link(coupon.getIcon_link());
		updatedCoupon.setView_details(coupon.getView_details());
	//	updatedDeal.setImg(deal.getImg());
		final Coupon finalUpdatedCoupon= couponRepository.save(updatedCoupon);
		

		return finalUpdatedCoupon;
	}
	
	//delete product by productId
	@Override
	public Map<String,Boolean> deleteCouponById(int couponId) throws CouponNotFoundException {
		
		Coupon coupon=couponRepository.findById(couponId).orElseThrow(()->new CouponNotFoundException());
		
		couponRepository.delete(coupon);
		
		
		
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("Deleted", Boolean.TRUE);
		return response;
	}
	
	//get all products by category
	@Override
	public List<Coupon> getCouponByCategory(String category)  throws CategoryNotFoundException{

		List<Coupon> coupon;
		if(couponRepository.findByCategory(category).isEmpty()) {
			throw new CategoryNotFoundException();
		}
		else {
			coupon=couponRepository.findByCategory(category);
		}
		
		return coupon;
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
