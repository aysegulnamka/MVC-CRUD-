package net.codejava.contact.model;

public class Contact {

	private Integer id;
	private String first_name;
	private String last_name;
	private String email;
	private String address;
	private String phone_number;
	
	
	public Contact() {
		
	}
	public Contact(Integer id, String first_name, String last_name, String email, String address,
			String phone_number) {
		this(first_name, last_name, email, address, phone_number);
		this.id = id;
	}
	
	public Contact(String first_name, String last_name, String email, String address,
			String phone_number) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.address = address;
		this.phone_number = phone_number;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", address=" + address + ", phone_number=" + phone_number + "]";
	}
	
	
}
