package com.example.demo.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dataobjects.TestData;
import com.example.pojo.ChildCareData;
import com.example.utils.CSVFileReaderDemo;
import com.example.utils.ChildCareDataMapper;

@CrossOrigin(origins = "*", allowedHeaders = "*",  methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE} )
@RestController
public class ChildCareController {
	
	private static List<ChildCareData> listOfObjects = new ArrayList<>();
	
	@RequestMapping(value = "/getAllData", method = RequestMethod.GET)
	public ArrayList<TestData> getAllServiceProviders() throws FileNotFoundException, IOException {
		ArrayList<TestData> serviceProviders = new ArrayList<TestData>();
		
		TestData data1 = new TestData();
		data1.setService_id("1");
		data1.setService_name("Child Care");
		TestData data2 = new TestData();
		data2.setService_id("2");
		data2.setService_name("Property Taxes & Utilities");
		TestData data3 = new TestData();
		data3.setService_id("3");
		data3.setService_name("Tickets, Fines & Penalties");
		TestData data4 = new TestData();
		data4.setService_id("4");
		data4.setService_name("Water & Environment");
		TestData data5 = new TestData();
		data5.setService_id("5");
		data5.setService_name("Permits & Licensing");
		TestData data6 = new TestData();
		data6.setService_id("6");
		data6.setService_name("Building & Contruction");
		TestData data7 = new TestData();
		data7.setService_id("7");
		data7.setService_name("Venues, Facilities & Bookings");
		TestData data8 = new TestData();
		data8.setService_id("8");
		data8.setService_name("Streets, Parking & Transportation");
		serviceProviders.add(data1);
		serviceProviders.add(data2);
		serviceProviders.add(data3);
		serviceProviders.add(data4);
		serviceProviders.add(data5);
		serviceProviders.add(data6);
		serviceProviders.add(data7);
		serviceProviders.add(data8);
		
		return serviceProviders;
	}
	
	@RequestMapping(value = "/childCare", method = RequestMethod.GET)
	public List<ChildCareData> getAllChildCareServiceProviders() throws FileNotFoundException, IOException {
		CSVFileReaderDemo fileReader = new CSVFileReaderDemo();
		ChildCareDataMapper dataMapper = new ChildCareDataMapper();
		return dataMapper.convertCsvToJson(fileReader.mapCsvToChildCare("classpath:input/child-care.csv"));
	}
	
	@RequestMapping(value = "/availability", method = RequestMethod.GET)
	public List<ChildCareData> getAllAvailableChildCareServiceProviders() throws FileNotFoundException, IOException {
		CSVFileReaderDemo fileReader = new CSVFileReaderDemo();
		ChildCareDataMapper dataMapper = new ChildCareDataMapper();
		if(listOfObjects.isEmpty())
		{
			listOfObjects = dataMapper.convertCsvToJson(fileReader.mapCsvToChildCare("classpath:input/child-care-availability.csv"));
		}
		return listOfObjects;
	}
	
	@RequestMapping(value = "/update/{loc_id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateAvailability(@RequestBody ChildCareData childCareData,
			  @PathVariable("loc_id") String id) {
		if(!listOfObjects.isEmpty()) {
			for(ChildCareData childCare : listOfObjects) {
				if(childCare.getLoc_id().equals(id)) {
					childCare.setIgwaitlist(childCareData.getIgwaitlist());
					childCare.setIgvacant(childCareData.getIgvacant());
				}
			}
		}
		return ResponseEntity.ok("resource saved");
	}
	
	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public List<ChildCareData> resetChildCareData() throws FileNotFoundException, IOException {
		CSVFileReaderDemo fileReader = new CSVFileReaderDemo();
		ChildCareDataMapper dataMapper = new ChildCareDataMapper();
		listOfObjects = dataMapper.convertCsvToJson(fileReader.mapCsvToChildCare("classpath:input/child-care-availability.csv"));
		return listOfObjects;
	}
}