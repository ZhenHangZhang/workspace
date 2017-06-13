package com.coolweather.app.util;

public interface HttpCallbackListen {

	
	void onFinish(String response);
	void onError(Exception e);

	
}
