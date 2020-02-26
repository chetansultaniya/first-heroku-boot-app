package com.internship2.demo1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internship2.demo1.model.ContactUs;
import com.internship2.demo1.model.api.Response;
import com.internship2.demo1.repository.ContactUsRepository;

@Service
public class ContactUsServiceImpl implements ContactUsService{

	@Autowired
	ContactUsRepository contactUsRepository;
	
	@Override
	public Response save(ContactUs contactUs) {
		contactUs = contactUsRepository.save(contactUs);
		return new Response(0, contactUs.getId().toString());
	}

	@Override
	public List<ContactUs> getAll() {
		List<ContactUs> listContactUs = contactUsRepository.findAll();
		return listContactUs;
	}

	
}
