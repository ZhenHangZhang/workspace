package com.coolweather.app.util;

import com.coolweather.app.model.City;
import com.coolweather.app.model.County;
import com.coolweather.app.model.Province;

import android.R.bool;
import android.text.TextUtils;

public class Utility {

	
	public synchronized static Boolean handleProvincesResponse(CoolweatherDB coolweatherDB,String response) {
		
		if (!TextUtils.isEmpty(response)) {
			String[] allProvinces = response.split(",");
			if (allProvinces != null && allProvinces.length > 0) {
				for (String p : allProvinces) {
					String[] array = p.split("\\|");
					Province province = new Province();
					province.setProvinceCode(array[0]);
					province.setProvincenName(array[1]);
					coolweatherDB.saveProvince(province);
					
				}
			 return true;
			}
		}
		return false;
	}
	
	
	
	public static Boolean handleCityResponse(CoolweatherDB coolweatherDB,String response,int provinceId) {
		
		if (!TextUtils.isEmpty(response)) {
			String[] allCities = response.split(",");
			if (allCities != null && allCities.length > 0) {
				for (String c : allCities) {
					String[] array = c.split("\\|");
					City city = new City();
					city.setCityCode(array[0]);
					city.setCityName(array[1]);
					city.setProvinceId(provinceId);
					coolweatherDB.saveCity(city);
					
				}
			 return true;
			}
		}
		return false;
	}
	
	
	public static Boolean handleCountyResponse(CoolweatherDB coolweatherDB,String response,int cityId) {
		
		if (!TextUtils.isEmpty(response)) {
			String[] allCounty = response.split(",");
			if (allCounty != null && allCounty.length > 0) {
				for (String c : allCounty) {
					String[] array = c.split("\\|");
					County county = new County();
					county.setCountyCode(array[0]);
					county.setCountyName(array[1]);
					county.setCityId(cityId);
					coolweatherDB.savecounty(county);
					
				}
			 return true;
			}
		}
		return false;
	}
	

}
