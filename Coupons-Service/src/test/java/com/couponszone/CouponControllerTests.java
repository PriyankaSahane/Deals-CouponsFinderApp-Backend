package com.couponszone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.couponszone.coupons_service.entity.Coupon;
import com.couponszone.coupons_service.resource.CouponController;
import com.couponszone.coupons_service.service.CouponService;

@SpringBootTest(classes= {CouponControllerTests.class})
public class CouponControllerTests {
	
	@Mock
	CouponService couponService;
	
	@InjectMocks 
	CouponController couponController;
	
	
	List<Coupon> coupons;
	Coupon coupon;
	
	@Test
	@Order(1)
	public void test_getAllCoupons() {
		
		coupons= new ArrayList<Coupon>();
		coupons.add(new  Coupon(1, "pants", "electric", "www.flipkart.com","5", "ok"));
		coupons.add(new  Coupon(2, "shirts", "Arrow", "formal","5", "ok"));
		
		when(couponService.getAllCoupons()).thenReturn(coupons);
		
		List<Coupon> result=couponController.getAllCoupons();
		
		assertEquals(2,result.size() );
	}
	
	
	@Test
	@Order(2)
	public void test_getCouponById() {
		
		
		coupon= new  Coupon(1, "pants", "electric", "www.flipkart.com","5", "ok");
		
		int couponId=1;
	
		
		when(couponService.getCouponById(couponId)).thenReturn(coupon);
		
		
		ResponseEntity<Coupon> result=couponController.getCouponById(couponId);
		
		assertEquals(HttpStatus.OK,result.getStatusCode() );
		assertEquals(couponId, result.getBody().getCouponId());
	}
	
	
	@Test
	@Order(3)
	public void test_addCoupon() {
			
		coupon= new  Coupon(1, "pants", "electric", "www.flipkart.com","5", "ok");
		
		when(couponService.addCoupons(coupon)).thenReturn(coupon);
		ResponseEntity<Coupon> result= couponController.addCoupons(coupon);
		
		assertEquals(HttpStatus.CREATED, result.getStatusCode());
		assertEquals(coupon, result.getBody());
	}
	
	
	/*@Test
	@Order(4)
	public void test_updateProduct() {			
		product = new  Product(1, "pants", "killer", "sports","5", "ok",
				"img", 45, "Merchant", "abc@123");
		
		int productId=1;
	
		
		when(productService.getProductById(productId)).thenReturn(product);
		when(productService.updateProducts(productId,product)).thenReturn(product);
		
		
		ResponseEntity<Product> result= productResource.updateProduct(productId,product);
		
	assertEquals(HttpStatus.OK, result.getStatusCode());
	assertEquals("killer", result.getBody().getProductName());
		assertEquals(productId, result.getBody().getProductId());
	}
	
	
	
	@Test
	@Order(5)
	public void test_deleteProfile() {
			
		product = new  Product(1, "pants", "killer", "sports","5", "ok",
				"img", 45, "Merchant", "abc@123");
		
		int productId=1;
		
		Map<String,Boolean> response= new HashMap<String, Boolean>();
		response.put("Deleted", true);
		
		when(productService.getProductById(productId)).thenReturn(product);
		when(productService.deleteProductById(productId)).thenReturn(response);
		Map<String,Boolean> result= productResource.deleteProduct(productId);
		
		
		
		assertEquals(response, result);
	}
	
	
	@Test
	@Order(6)
	public void test_getDealByCompanyName() {
		
		
		deal= new  Deal(1, "pants", "electric", "www.flipkart.com","5", "ok",
				"img");
		
		String companyName="www.flipkart.com";
	
		
		when(dealService.getDealByCompanyName(companyName)).thenReturn(deal);
		
		
		ResponseEntity<Deal> result=dealResource.getDealByCompanyName(companyName);
		
		assertEquals(HttpStatus.OK,result.getStatusCode() );
		assertEquals(companyName, result.getBody().getIcon_link());
	}
	
	@Test
	@Order(7)
	public void test_getDealByDealCategory() {
		
		deals= new ArrayList<Deal>();
		deal= new  Deal(1, "pants", "electric", "www.flipkart.com","5", "ok",
				"img" );
		
		deals.add(deal);
		
		String dealCategory="eletric";
	
		
		when(dealService.getDealByCategory(dealCategory)).thenReturn(deals);
		
		
		ResponseEntity<List<Deal>> result=dealResource.getDealByCategory(dealCategory);
		
		assertEquals(HttpStatus.OK,result.getStatusCode() );
		assertEquals(deals, result.getBody());
	}
	
	@Test
	@Order(8)
	public void test_getProductByProductType() {
		
		products= new ArrayList<Product>();
		product= new  Product(1, "pants", "killer", "sports","5", "ok",
				"img", 45, "Merchant", "abc@123");
		
		products.add(product);
		
		String productType="pants";
	
		
		when(productService.getProductByType(productType)).thenReturn(products);
		
		
		ResponseEntity<List<Product>> result=productResource.getProductByType(productType);
		
		assertEquals(HttpStatus.OK,result.getStatusCode() );
		assertEquals(products, result.getBody());
	}*/

}
