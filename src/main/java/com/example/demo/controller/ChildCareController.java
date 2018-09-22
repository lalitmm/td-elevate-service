package com.example.demo.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.ChildCareData;
import com.example.utils.CSVFileReaderDemo;
import com.example.utils.ChildCareDataMapper;

@RestController
public class ChildCareController {
	
	@RequestMapping(value = "/getAllData", method = RequestMethod.GET)
	public List<ChildCareData> getAllServiceProviders() throws FileNotFoundException, IOException {
		CSVFileReaderDemo fileReader = new CSVFileReaderDemo();
		ChildCareDataMapper dataMapper = new ChildCareDataMapper();
		return dataMapper.convertCsvToJson(fileReader.mapCsvToChildCare());
	}
}