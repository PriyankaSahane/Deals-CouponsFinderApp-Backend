package com.couponszone.coupons_service.resource;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.couponszone.coupons_service.entity.Coupon;
import com.couponszone.coupons_service.service.CouponService;
import com.couponszone.exception.CouponNotFoundException;


//@CrossOrigin(origins="*",maxAge = 3600)
@RestController
@RequestMapping("/Coupon")
public class CouponController {

	@Autowired
	private CouponService couponServiceImpl;
	
	Logger logger= LoggerFactory.getLogger(CouponController.class);

	CouponController() {
	}
	
	@PostMapping("/add")
	public ResponseEntity<Coupon> addCoupons(  @RequestBody Coupon coupon) {
		
		logger.warn("coupon"+coupon);
		Coupon addedCoupon= couponServiceImpl.addCoupons(coupon);
		
		return new ResponseEntity<>(addedCoupon,HttpStatus.CREATED);
		
	}

	@GetMapping("/get")
	public List<Coupon> getAllCoupons() {
	 List<Coupon> coupon=couponServiceImpl.getAllCoupons();
		return coupon;
	}

	
	@GetMapping("/findById/{couponId}")
	public ResponseEntity<Coupon> getCouponById(@PathVariable int couponId) {
	return new ResponseEntity<>	(couponServiceImpl.getCouponById(couponId),HttpStatus.OK);
		
	}

	/*@GetMapping("/findByType/{productType}")
	public ResponseEntity<List<Product>> getProductByType(@PathVariable String productType) {
		
		return new ResponseEntity<>(productServiceImpl.getProductByType(productType),HttpStatus.OK);
	}
*/
	@GetMapping("/findByCompanyName/{icon_link}")
	public ResponseEntity<Coupon> getCouponByCompanyName(@PathVariable String icon_Link) {
		
		return new ResponseEntity<>(couponServiceImpl.getCouponByCompanyName(icon_Link),HttpStatus.OK);
	}

	@GetMapping("/findByCategory/{category}")
	public ResponseEntity<List<Coupon>> getCouponByCategory(@PathVariable String category) {
		
		return new ResponseEntity<>(couponServiceImpl.getCouponByCategory(category),HttpStatus.OK);
	}

	@PutMapping("/update/{couponId}")
	public ResponseEntity<Coupon> updateCoupon(@PathVariable int couponId, @Valid @RequestBody Coupon coupon) throws CouponNotFoundException {
		;
		return  ResponseEntity.ok(couponServiceImpl.updateCoupons(couponId,coupon));
	}

	@DeleteMapping("/delete/{couponId}")
	public Map<String,Boolean> deleteCoupon(@PathVariable int couponId)throws CouponNotFoundException {
		
		return couponServiceImpl.deleteCouponById(couponId);
	}
}
