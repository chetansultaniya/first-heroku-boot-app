package com.internship2.demo1.service;

import java.util.List;

import com.internship2.demo1.model.ContactUs;
import com.internship2.demo1.model.api.Response;

public interface ContactUsService {

	public Response save(ContactUs contactUs);
	public List<ContactUs> getAll();
}
