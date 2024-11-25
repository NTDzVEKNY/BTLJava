package quanlylaptop.Models;

import java.io.Serializable;

public class Laptop implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String manufacturer;
	private int quantity;
	private int price;
	
	public Laptop() {
	}

	public Laptop(int id, String name, String manufacturer, int quantity, int price) {
		this.id = id;
		this.name = name;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.price = price;
	}

	public Laptop(String name, String manufacturer, int quantity, int price) {
		this.name = name;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", name=" + name + ", manufacturer=" + manufacturer + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
	
}
