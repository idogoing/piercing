package com.bajie.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DecodeCallback {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DecodeCallback.class);
	public static void callback(String code){
		LOGGER.info("扫码结果为:{}",code);
	}
}
