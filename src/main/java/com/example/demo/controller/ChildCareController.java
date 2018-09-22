package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dataobjects.TestData;

@RestController
public class ChildCareController {
	@RequestMapping(value = "/getAllData", method = RequestMethod.GET)
	public ArrayList<TestData> getAllServiceProviders() {
		ArrayList<TestData> serviceProviders = new ArrayList<TestData>();
		
		TestData data1 = new TestData();
		data1.setService_id("1");
		data1.setService_name("Child Care");
		TestData data2 = new TestData();
		data2.setService_id("2");
		data2.setService_name("Property Taxes & Utilities");
		TestData data3 = new TestData();
		data3.setService_id("3");
		data3.setService_name("Tickets, Fines and Penalties");
		TestData data4 = new TestData();
		data4.setService_id("4");
		data4.setService_name("Water And Environment");
		TestData data5 = new TestData();
		data5.setService_id("5");
		data5.setService_name("Transportation");
		serviceProviders.add(data1);
		serviceProviders.add(data2);
		serviceProviders.add(data3);
		serviceProviders.add(data4);
		serviceProviders.add(data5);
		
		return serviceProviders;
	}
}