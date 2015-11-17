package com.bajie.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeviceStatusCallback {
	private static final Logger LOGGER = LoggerFactory.getLogger(DeviceStatusCallback.class);
	/**
	 * 
	 * @param status 设备状态,DEVICE_VALID(1)-设备有效,DEVICE_INVALID(2)-设备无效 
	 */
	public static void callback(int status) {
		String statusText = "";
		if(status == 1){
			statusText = "设备有效";
		}else if(status == 2){
			statusText = "设备无效";
		}
		LOGGER.info("机器状态切换为:{}",statusText);
	}
}
