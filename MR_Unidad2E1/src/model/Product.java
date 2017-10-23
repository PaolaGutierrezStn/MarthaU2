package model;

public class Product {
	
	private String id;
	private String name;
	private int unitInStock;
	private int unitPrice;
	private String type;
	public Product(String id,String name, int unitInStock, int unitPrice, String type) {
		super();
		this.id = id;
		this.name=name;
		this.unitInStock = unitInStock;
		this.unitPrice = unitPrice;
		this.type = type;
	}
	public Product() {
		this("","",0,0,"");
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUnitInStock() {
		return unitInStock;
	}
	public void setUnitInStock(int unitInStock) {
		this.unitInStock = unitInStock;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
