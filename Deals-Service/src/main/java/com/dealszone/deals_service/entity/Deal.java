package com.dealszone.deals_service.entity;

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
@Document(collection = "Deals")
public class Deal {
	
	 /*This helps ignoring the field by not mapping it to the database*/
	@Transient
	public  static final String sequenceName="DealSequence";
	
	/*Providing all variables required */
    /*Setting up the below variable as primary key in the collection*/
	@Id
	private int dealId;
	
	@NotEmpty(message="Title is empty")
	String title;
    @NotEmpty(message="Category is empty")
	String category;
	String link;
	String icon_link;
	String view_deal;
	String img;
	int min_prize;
	int max_prize;
	
	public Deal(int dealId, String title, String category, String link, String icon_link,
			String view_deal, String img)// int min_prize, int max_prize)
	{
		super();
		this.dealId = dealId;
		this.title = title;
		this.category = category;
		this.link = link;
		this.icon_link = icon_link;
		this.view_deal = view_deal;
		this.img = img;
		//this.min_prize = min_prize;
	//	this.max_prize = max_prize;
	}

	public Deal() {
		
	}
	public int getDealId() {
		return dealId;
	}

	public void setDealId(int dealId) {
		this.dealId = dealId;
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

	public String getView_deal() {
		return view_deal;
	}

	public void setView_deal(String view_deal) {
		this.view_deal = view_deal;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	/*public int getMin_prize() {
		return min_prize;
	}

	public void setMin_prize(int min_prize) {
		this.min_prize = min_prize;
	}

	public int getMax_prize() {
		return max_prize;
	}

	public void setMax_prize(int max_prize) {
		this.max_prize = max_prize;
	}
*/
	public static String getSequencename() {
		return sequenceName;
	}
	

}
