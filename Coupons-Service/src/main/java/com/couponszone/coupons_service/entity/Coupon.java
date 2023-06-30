package com.couponszone.coupons_service.entity;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*getters, setters, all arguments and no argument constructors by annotations*/
@Data
@AllArgsConstructor
@NoArgsConstructor
/*@document- to specify custom property values*/
/*Defining collection name of mongodb to the model class*/
@Getter
@Setter
@Document(collection = "Coupon")
public class Coupon {
	
	 /*This helps ignoring the field by not mapping it to the database*/
	@Transient
	public  static final String sequenceName="CouponSequence";
	
	/*Providing all variables required */
    /*Setting up the below variable as primary key in the collection*/
	@Id
	private int couponId;
	
	@NotEmpty(message="Title is empty")
	String title;
    @NotEmpty(message="Category is empty")
	String category;
	String link;
	String icon_link;
	String view_details;
	
	public Coupon() {
		
	}
	
	public int getCouponId() {
		return couponId;
	}
	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getIcon_link() {
		return icon_link;
	}
	public void setIcon_link(String icon_link) {
		this.icon_link = icon_link;
	}
	public String getView_details() {
		return view_details;
	}
	public void setView_details(String view_details) {
		this.view_details = view_details;
	}
	public Coupon(int couponId, @NotEmpty(message = "Title is empty") String title,
			@NotEmpty(message = "Category is empty") String category, String link, String icon_link,
			String view_details) {
		super();
		this.couponId = couponId;
		this.title = title;
		this.category = category;
		this.link = link;
		this.icon_link = icon_link;
		this.view_details = view_details;
	}

	public static String getSequencename() {
		return sequenceName;
	}
	
	
	

}
