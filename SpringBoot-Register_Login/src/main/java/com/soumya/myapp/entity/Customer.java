package com.soumya.myapp.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_id")
	private Long customerId;
	
	@Column(name = "cust_name")
	private String customerName;
	
	@Column(name = "cust_email")
	private String customerEmail;
	
	@Column(name = "cust_password")
	private String password;
	
	@Column(name = "cust_address")
	private String address;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "cust_products",
			joinColumns = @JoinColumn(name ="cid" ,referencedColumnName = "cust_id"),
			inverseJoinColumns = @JoinColumn(name ="pid",referencedColumnName = "product_id")
			
			)
	private List<Product> products;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

	public List<Product> getProducts() {
		return products;
	}
	
	public void setProduct(Product product) {
	    this.getProducts().add(product);
	}


}

// kunal_768@gmail.com kunal@123
// roshni234@gmail.com desai123roshni  0DE006D89D011466A851E1B1B8F2ADB0  0DE006D89D011466A851E1B1B8F2ADB0
// kumar234tamal@gmail.com  tamal345
//                          annu7886
// soumyajit4banerjee@gmail.com bubun123

// Damini$23@gmail.com damini879 Admin