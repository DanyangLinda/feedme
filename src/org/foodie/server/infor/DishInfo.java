package org.foodie.server.infor;

import org.foodie.server.entity.Dish;

/**
 * @author Danyang Li
 */
public class DishInfo extends Infor{
	private static final long serialVersionUID = 1L;	
	private long id;
	private long shopId;
	private String type;
	private String name;
	private String description;
	private String photo;
	private String ingredient;
	private Integer price;
	private Integer discount;
	private String flavor;
	private Integer sold;
	
	public DishInfo(){
		
	}
	
	public DishInfo(final long id){
		this.id=id;
	}
	
	public DishInfo(final long id, final String photo){
		this.id=id;
		this.photo=photo;
	}
	
	public DishInfo(final Dish dish){
		this.id=dish.getId();
		this.shopId=dish.getShopId();
		this.type=dish.getType();
		this.name=dish.getName();
		this.description=dish.getDescription();
		this.photo=dish.getPhoto();
		this.ingredient=dish.getIngredient();
		this.price=dish.getPrice();
		this.discount=dish.getDiscount();
		this.flavor=dish.getFlavor();
		this.sold=dish.getSold();
	}
	
	public DishInfo(final String statusInfo,final Integer statusCode){
		super(statusInfo,statusCode);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getShopId() {
		return shopId;
	}

	public void setShopId(long shopId) {
		this.shopId = shopId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public Integer getSold() {
		return sold;
	}

	public void setSold(Integer sold) {
		this.sold = sold;
	}
}
