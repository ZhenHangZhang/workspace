package com.coolweather.app.util;

import java.util.ArrayList;
import java.util.List;

import com.coolweather.app.db.CoolWeatherOpenHelper;
import com.coolweather.app.model.City;
import com.coolweather.app.model.County;
import com.coolweather.app.model.Province;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CoolweatherDB {

//	数据库名
	public static final String DB_NAME = "cool_weather";
//	数据库版本
	public static final int VERSION = 1;
	
	private static CoolweatherDB coolweatherDB;
	private SQLiteDatabase db;
	
	
//	构造方法私有化。
	private CoolweatherDB(Context context) {
		// TODO Auto-generated constructor stub
		
		CoolWeatherOpenHelper dbHelper = new CoolWeatherOpenHelper(context, DB_NAME, null, VERSION);
		db = dbHelper.getWritableDatabase();
		
		
	} 
//	获取 coolweather实例，单例方法的使用
	public synchronized static CoolweatherDB getInstance(Context context) {
		if (coolweatherDB == null) {
			coolweatherDB = new CoolweatherDB(context);
		}return coolweatherDB;

	}
//	保存 province到数据库
public void saveProvince(Province province) {


	if (province != null) {

		ContentValues values = new ContentValues();

		values.put("province_name", province.getProvincenName());
		values.put("province_code", province.getProvinceCode());

		db.insert("Province", null, values);

	}
	
}
//读取数据库province
	public List<Province> loadProvince() {
		List< Province>list = new ArrayList<Province>();
		Cursor cursor = db.query("Province", null, null, null, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				Province province = new Province();
				province.setId(cursor.getInt(cursor.getColumnIndex("id")));
				province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
				province.setProvincenName(cursor.getString(cursor.getColumnIndex("province_name")));
				list.add(province);
			} while (cursor.moveToNext());
		}
		if (cursor != null) {
			cursor.close();
		}
		return list;
	}
//	保存 city到数据库
public void saveCity(City city) {


	if (city != null) {

		ContentValues values = new ContentValues();

		values.put("city_name", city.getCityName());
		values.put("city_code", city.getCityCode());
		values.put("provinceId", city.getProvinceId());
		db.insert("City", null, values);
	}
	
}
//读取数据库city
	public List<City> loadCity(int provinceId) {
		List< City>list = new ArrayList<City>();
		Cursor cursor = db.query("City", null, "province_id = ?", new String[]{String.valueOf(provinceId)}, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				City city = new City();
				city.setId(cursor.getInt(cursor.getColumnIndex("id")));
				city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
				city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
				city.setProvinceId(provinceId);
				list.add(city);
			} while (cursor.moveToNext());
		}
		if (cursor != null) {
			cursor.close();
		}
		return list;
	}
	
//	保存 County到数据库
public void savecounty(County county) {


	if (county != null) {

		ContentValues values = new ContentValues();

		values.put("county_name", county.getCountyName());
		values.put("county_code",county.getCountyCode());
		values.put("cityId", county.getCityId());
		db.insert("County", null, values);
	}
	
}
//读取数据库city
	public List<County> loadCounty(int cityId) {
		List< County>list = new ArrayList<County>();
		Cursor cursor = db.query("County", null, "city_id = ?", new String[]{String.valueOf(cityId)}, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				County county = new County();
				county.setId(cursor.getInt(cursor.getColumnIndex("id")));
				county.setCountyCode(cursor.getString(cursor.getColumnIndex("county_code")));
				county.setCountyName(cursor.getString(cursor.getColumnIndex("county_name")));
				county.setCityId(cityId);
				list.add(county);
			} while (cursor.moveToNext());
		}
		if (cursor != null) {
			cursor.close();
		}
		return list;
	}
	
	
	
}
