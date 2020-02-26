package com.internship2.demo1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "contact_us")
@EntityListeners(AuditingEntityListener.class)
@JsonInclude(Include.NON_NULL)
public class ContactUs extends BaseAudit<String>{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column @NotNull
	private String name;
	
	@Column @NotNull
	private String email;
	
	@Column @NotNull
	private String mobile;
	
	@Column @Size(min=10)
	private String message;
	
	public ContactUs() {
	}

	public ContactUs(Long id, String name, String email, String mobile, String message) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
