package com.coolweather.app.activity;

import java.util.ArrayList;
import java.util.List;

import com.coolweather.app.model.City;
import com.coolweather.app.model.County;
import com.coolweather.app.model.Province;
import com.coolweather.app.util.CoolweatherDB;
import com.coolweather.app.util.HttpCallbackListen;
import com.coolweather.app.util.HttpUtil;
import com.coolweather.app.util.Utility;

import android.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class mainActivity extends Activity {

	
	public static final int LEVEL_PROVINCE = 0;
	public static final int LEVEL_CITY = 1;
	public static final int LEVEL_COUNTY = 2;

	private ProgressDialog progressDialog;
	
	private TextView titleText;
	private ListView listView;
	private ArrayAdapter<String> adapter;
	private CoolweatherDB coolweatherDB;
	private List<String> dataList = new ArrayList<String>();

	
	
	private List<Province>provinceList;
	
	private List<City>citieList;
	private List<County>countyList;

	
	private Province selectedProvince;
	private City selectedCity;
	private County selectedCounty;
	
	private int currentLevel;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(com.coolweather.app.R.layout.main_activity);
		
		listView = (ListView)findViewById(com.coolweather.app.R.id.list_view);
		titleText = (TextView)findViewById(com.coolweather.app.R.id.title_text);
		adapter = new ArrayAdapter<String>(this, R.layout.simple_list_item_1, dataList);
		listView.setAdapter(adapter);
		coolweatherDB = CoolweatherDB.getInstance(this);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int index, long arg3) {
				// TODO Auto-generated method stub
				if (currentLevel == LEVEL_PROVINCE) {
					selectedProvince = provinceList.get(index);
					queryCities();
				}else if (currentLevel == LEVEL_CITY) {
					selectedCity = citieList.get(index);
					queryCounties();
				}
			}
		});
		queryProvinces();
	}
	
	private void queryProvinces() {
		provinceList = coolweatherDB.loadProvince();
		if (provinceList.size() > 0) {
			dataList.clear();
			for (Province province  : provinceList) {
				dataList.add(province.getProvincenName());
			}
			adapter.notifyDataSetChanged();
			listView.setSelection(0);
			titleText.setText("中国");
			currentLevel = LEVEL_PROVINCE;
		}else {
			queryFromServer(null, "province");
		}
	
	}
	private void queryCities() {
		
		citieList = coolweatherDB.loadCity(selectedProvince.getId());
		if (citieList.size()> 0) {
			
			dataList.clear();
			for (City city : citieList) {
				
				dataList.add(city.getCityName());
				
			}
			
			adapter.notifyDataSetChanged();
			listView.setSelection(0);
			titleText.setText(selectedProvince.getProvincenName());
			currentLevel = LEVEL_CITY;
			
			
		}else {
			queryFromServer(selectedProvince.getProvinceCode(), "city");
		}
		
		
	}
	private void queryCounties() {
		
		
		countyList  =coolweatherDB.loadCounty(selectedCity.getId());
		
		if (countyList.size()> 0) {
			dataList.clear();
			for (County county : countyList) {
				
				dataList.add(county.getCountyName());
				
			}
			adapter.notifyDataSetChanged();
			listView.setSelection(0);
			titleText.setText(selectedCity.getCityName());
			currentLevel = LEVEL_COUNTY;
		}else {
			queryFromServer(selectedCity.getCityCode(), "county");
		}
		
		
		
		
	}
	
	private void queryFromServer(final String code, final String type) {
		
		
	String address ;
	if (TextUtils.isEmpty(code)) {
		
		address = "http://www.weather.com.cn/data/list3/city" + code + ".xml";
		
	}else {
		address = "http://www.weather.com.cn/data/list3/city.xml";
	}
	
	showProgressDialog();
	
	HttpUtil.sendHttpRequest(address, new HttpCallbackListen() {
		
		@Override
		public void onFinish(String response) {
			// TODO Auto-generated method stub
			
			
			boolean result = false;
			if ("province".equals(type)) {
				
				result = Utility.handleProvincesResponse(coolweatherDB, response);
				
			}else if ("city".equals(type)) {
				result = Utility.handleCityResponse(coolweatherDB, response,selectedProvince.getId());

			}else if ("county".equals(type)) {
				result = Utility.handleCountyResponse(coolweatherDB, response, selectedCity.getId());

			}
			if (result) {
				
				runOnUiThread(new Runnable() {
					public void run() {
						closeProgressDialog();
						if ("province".equals(type)) {
							queryProvinces();
						}else if ("city".equals(type)) {
							queryCities();
						}else if ("county".equals(type)) {
							queryCounties();
						}	
					}
				});
				
				
			}
			
		}
		
		@Override
		public void onError(Exception e) {
			// TODO Auto-generated method stub
			
			runOnUiThread(new  Runnable() {
				public void run() {
			
					
					closeProgressDialog();
					
					Toast.makeText(mainActivity.this, "加载失败", Toast.LENGTH_SHORT).show();
					
					
				}
			});
			
			
		}
	});
	
		
		
	}
	
//	显示进度对话框
	private void showProgressDialog() {
		
		if (progressDialog == null) {
			progressDialog = new ProgressDialog(this);
			progressDialog.setMessage("正在加载中……");
			progressDialog.setCanceledOnTouchOutside(false);
		}
		progressDialog.show();
	}
//	关闭对话框
	private void closeProgressDialog() {
		if (progressDialog != null) {
			progressDialog.dismiss();
		}
	}
//	根据back键 根据当前层级 判断是否返回市列表 省列表 还是直接退出
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		if (currentLevel == LEVEL_COUNTY) {
			queryCities();
		}else if (currentLevel == LEVEL_CITY) {
			queryProvinces();
		}else {
			finish();
		}
	}
}
