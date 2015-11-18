package com.bajie.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bajie.swing.Swing;

public class Piercing {
	private static final Logger LOGGER = LoggerFactory.getLogger(Piercing.class);
	public static Piercing piercing = null;
	
	public static void main(String[] args) {
		LOGGER.info("开始启动");
		piercing = new Piercing();
		Swing.vguangSample = new Swing();
		Swing.vguangSample.frame.setVisible(true);
		//设置参数设置
		LOGGER.info("开始设置打印机参数");
		//ConfigUtil.applySetting();
		//VguangApi.beep(2);
		LOGGER.info("打印机参数设置完毕,响铃2秒");
		
	}
	
	
}
