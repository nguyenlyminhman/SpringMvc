package vn.com.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "Order" database table.
 * 
 */
@Entity
@Table(name="\"Order\"")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private Long no;

	private String orderaddress;

	@Temporal(TemporalType.DATE)
	private Date orderdate;

	private String orderphone;

	private String payment;

	@Temporal(TemporalType.DATE)
	private Date receivedate;

	private String receiver;

	private String status;

	private double total;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="\"idCustomer\"")
	private Customer customer;

	//bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy="order")
	private List<OrderDetail> orderDetails;

	//bi-directional many-to-one association to StaffOrder
	@OneToMany(mappedBy="order")
	private List<StaffOrder> staffOrders;

	public Order() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getNo() {
		return this.no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getOrderaddress() {
		return this.orderaddress;
	}

	public void setOrderaddress(String orderaddress) {
		this.orderaddress = orderaddress;
	}

	public Date getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public String getOrderphone() {
		return this.orderphone;
	}

	public void setOrderphone(String orderphone) {
		this.orderphone = orderphone;
	}

	public String getPayment() {
		return this.payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public Date getReceivedate() {
		return this.receivedate;
	}

	public void setReceivedate(Date receivedate) {
		this.receivedate = receivedate;
	}

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public OrderDetail addOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().add(orderDetail);
		orderDetail.setOrder(this);

		return orderDetail;
	}

	public OrderDetail removeOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().remove(orderDetail);
		orderDetail.setOrder(null);

		return orderDetail;
	}

	public List<StaffOrder> getStaffOrders() {
		return this.staffOrders;
	}

	public void setStaffOrders(List<StaffOrder> staffOrders) {
		this.staffOrders = staffOrders;
	}

	public StaffOrder addStaffOrder(StaffOrder staffOrder) {
		getStaffOrders().add(staffOrder);
		staffOrder.setOrder(this);

		return staffOrder;
	}

	public StaffOrder removeStaffOrder(StaffOrder staffOrder) {
		getStaffOrders().remove(staffOrder);
		staffOrder.setOrder(null);

		return staffOrder;
	}

}