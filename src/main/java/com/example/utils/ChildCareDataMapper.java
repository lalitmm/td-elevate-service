package com.example.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.example.pojo.ChildCareData;

public class ChildCareDataMapper {

	@SuppressWarnings("rawtypes")
	public List<ChildCareData> convertCsvToJson(List < Map< String, String >> list){
		List<ChildCareData> childDataList = new ArrayList<>();
		if(list != null) {
			Iterator it = list.iterator();
			while(it.hasNext()) {
				@SuppressWarnings("unchecked")
				Map<String, String> item = (Map<String, String>) it.next();
				childDataList = mapToChildDataList(childDataList, item);
			}
		}
		return childDataList;
	}

	private List<ChildCareData> mapToChildDataList(List<ChildCareData> childDataList, Map<String, String> item) {
		ChildCareData childData = new ChildCareData();
		childData.setLoc_id(item.get("LOC_ID"));
		childData.setLoc_name(item.get("LOC_NAME"));
		childData.setAuspice(item.get("AUSPICE"));
		childData.setStr_no(item.get("STR_NO"));
		childData.setStreet(item.get("STREET"));
		childData.setUnit(item.get("UNIT"));
		childData.setPcode(item.get("PCODE"));
		childData.setWard(item.get("ward"));
		childData.setPhone(item.get("PHONE"));
		childData.setBldg_type(item.get("bldg_type"));
		childData.setBldgname(item.get("bldgname"));
		childData.setIgspace(item.get("IGSPACE"));
		childData.setTgspace(item.get("TGSPACE"));
		childData.setPgspace(item.get("PGSPACE"));
		childData.setKgspace(item.get("KGSPACE"));
		childData.setSgspace(item.get("SGSPACE"));
		childData.setTotspace(item.get("TOTSPACE"));
		childData.setSubsidy(item.get("SUBSIDY"));
		childData.setGc_geoid(item.get("GC_GEOID"));
		childData.setLongitude(item.get("LONGITUDE"));
		childData.setLatitude(item.get("LATITUDE"));
		childData.setRun_date(item.get("run_date"));
		
		childDataList.add(childData);
		return childDataList;
	}
}
