package vn.com.spring.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "OrderDetails" database table.
 * 
 */
@Entity
@Table(name="\"OrderDetails\"")
@NamedQuery(name="OrderDetail.findAll", query="SELECT o FROM OrderDetail o")
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private double price;

	private Integer quantity;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="\"idOrder\"")
	private Order order;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="\"idProduct\"")
	private Product product;

	public OrderDetail() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}