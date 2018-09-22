package com.example.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.ResourceUtils;

public class CSVFileReaderDemo {
	
	public List<Map<String, String>> mapCsvToChildCare() throws FileNotFoundException, IOException{
		
		try (InputStream in = new FileInputStream(ResourceUtils.getFile("classpath:input/child-care.csv"));) {
		    CSV csv = new CSV(true, ',', in );
		    List< String > fieldNames = null;
		    if (csv.hasNext()) fieldNames = new ArrayList<>(csv.next());
		    List < Map< String, String >> list = new ArrayList < > ();
		    while (csv.hasNext()) {
		        List < String > x = csv.next();
		        Map < String, String > obj = new LinkedHashMap < > ();
		        for (int i = 0; i < fieldNames.size(); i++) {
		            obj.put(fieldNames.get(i), x.get(i));
		        }
		        list.add(obj);
		    }
		    return list;
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return null;
	}
}
