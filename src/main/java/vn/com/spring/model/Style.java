package vn.com.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Style" database table.
 * 
 */
@Entity
@Table(name="\"Style\"")
@NamedQuery(name="Style.findAll", query="SELECT s FROM Style s")
public class Style implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String stylename;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="style")
	private List<Product> products;

	public Style() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStylename() {
		return this.stylename;
	}

	public void setStylename(String stylename) {
		this.stylename = stylename;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setStyle(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setStyle(null);

		return product;
	}

}