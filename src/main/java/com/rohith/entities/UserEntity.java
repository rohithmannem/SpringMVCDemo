package com.rohith.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users1")
public class UserEntity {

	// form:hidden - hidden value
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	// form:input - textbox

	@Column(name = "username")
	private String name;

	// form:input - textbox
	@Column(name = "email")
	private String email;

	// form:textarea - textarea
	@Column(name = "address")
	private String address;

	// form:input - password
	@Column(name = "password")
	private String password;

	// form:input - password
	@Column(name = "confirmPassword")
	private String confirmPassword;

/*	@OneToMany(mappedBy="userEntity")
	private Set<AddressEntity> addressEntities;
*/
	// form:checkbox - single checkbox
	// @Column(name="")
	// private boolean newsletter;

	// form:checkboxes - multiple checkboxes
	// @Column(name="")
	// private List<String> framework;

	// form:radiobutton - radio button
	@Column(name = "sex")
	private String sex;

	// form:radiobuttons - radio button
	// @Column(name="")
	// private Integer number;

	// form:select - form:option - dropdown - single select
	@Column(name = "country")
	private String country;

	// form:select - multiple=true - dropdown - multiple select

	// @Column(name="")
	// private List<String> skill;
	
	

	public boolean isNew() {
		return (this.id == null);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	/**
	 * @return the addressEntities
	 *//*
	public Set<AddressEntity> getAddressEntities() {
		return addressEntities;
	}

	*//**
	 * @param addressEntities the addressEntities to set
	 *//*
	public void setAddressEntities(Set<AddressEntity> addressEntities) {
		this.addressEntities = addressEntities;
	}*/

	/*
	 * public boolean isNewsletter() { return newsletter; }
	 * 
	 * public void setNewsletter(boolean newsletter) { this.newsletter =
	 * newsletter; }
	 */

	/*
	 * public List<String> getFramework() { return framework; }
	 * 
	 * public void setFramework(List<String> framework) { this.framework =
	 * framework; }
	 */

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	/*
	 * public Integer getNumber() { return number; }
	 * 
	 * public void setNumber(Integer number) { this.number = number; }
	 */

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	/*
	 * public List<String> getSkill() { return skill; }
	 * 
	 * public void setSkill(List<String> skill) { this.skill = skill; }
	 */

}
