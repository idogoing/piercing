package com.bajie.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vguang.VguangApi;

public class ConfigUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConfigUtil.class);
	// 应用设置
	public static void applySetting() {
		// 设置QR状态
		VguangApi.setQRable(true);
		LOGGER.info("开启QR");
		// 设置DM状态
		VguangApi.setDMable(true);
		LOGGER.info("开启QM");
		// 设置Bar状态
		VguangApi.setBarcode(true);
		LOGGER.info("开启条形码");
		// 设置解码间隔时间，单位毫秒
		VguangApi.setDeodeIntervalTime(300);
		LOGGER.info("设置解码时间300毫秒");
		// 设置自动休眠状态
		VguangApi.setAI(true);
		LOGGER.info("设置自动休眠");
		int aiLimit = 20;
		// 设置自动休眠灵敏度
		VguangApi.setAISensitivity(aiLimit);
		LOGGER.info("设置灵敏度20s");
		// 设置自动休眠响应时间，单位秒
		VguangApi.setAIResponseTime(300);
		LOGGER.info("设置自动休眠300秒");
		// 设置扬声器状态
		VguangApi.setBeepable(true);
		LOGGER.info("设置扬声器开");
		//开灯
		VguangApi.lightOn();
	}
}
