package vn.com.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "StaffOrder" database table.
 * 
 */
@Entity
@Table(name="\"StaffOrder\"")
@NamedQuery(name="StaffOrder.findAll", query="SELECT s FROM StaffOrder s")
public class StaffOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date handlingdate;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="\"idOrder\"")
	private Order order;

	//bi-directional many-to-one association to Staff
	@ManyToOne
	@JoinColumn(name="\"idStaff\"")
	private Staff staff;

	public StaffOrder() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getHandlingdate() {
		return this.handlingdate;
	}

	public void setHandlingdate(Date handlingdate) {
		this.handlingdate = handlingdate;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

}