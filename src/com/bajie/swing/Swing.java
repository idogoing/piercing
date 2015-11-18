package com.bajie.swing;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.vguang.VguangApi;

public class Swing {

	public JFrame frame;
	private JTextArea decodeTextArea;
	private JLabel lblDeviceStatus;
	public static Swing vguangSample = null;
	private JTextField textDecodeTime;
	private JTextField textAiLimit;
	private JTextField textAiResponeTime;
	private JCheckBox chckbxQr;
	private JCheckBox checkboxDm;
	private JCheckBox chckbxBar;
	private JCheckBox chckbxBeep;
	private JCheckBox chckbxAi;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtJF;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vguangSample = new Swing();
					vguangSample.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Swing() {
		//初始化控件
		initialize();
//		//应用设置
//		applySetting();
//		//打开设备
//		VguangApi.openDevice();
	}

	//应用设置
	private void applySetting(){
		//设置QR状态
		VguangApi.setQRable(chckbxQr.isSelected());
		//设置DM状态
		VguangApi.setDMable(checkboxDm.isSelected());
		//设置Bar状态
		VguangApi.setBarcode(chckbxBar.isSelected());
		
		// 设置解码间隔时间，单位毫秒
		VguangApi.setDeodeIntervalTime(StringToInt(textDecodeTime.getText(), 300));
		
		//设置自动休眠状态
		VguangApi.setAI(chckbxAi.isSelected());
		int aiLimit = StringToInt(textAiLimit.getText(), 20);
		if(aiLimit < 1 || aiLimit > 64){
			aiLimit = 20;
		}
		// 设置自动休眠灵敏度
		VguangApi.setAISensitivity(aiLimit);
		// 设置自动休眠响应时间，单位秒
		VguangApi.setAIResponseTime(StringToInt(textAiResponeTime.getText(), 30));

		//设置扬声器状态
		VguangApi.setBeepable(chckbxBeep.isSelected());
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("简孚网络科技核销专用软件");
		frame.setBounds(100, 100, 742, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton buttonBegin = new JButton("打开设备");
		buttonBegin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				VguangApi.openDevice();
			}
		});
		buttonBegin.setBounds(123, 413, 93, 23);
		frame.getContentPane().add(buttonBegin);
		
		JButton buttonEnd = new JButton("关闭设备");
		buttonEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				VguangApi.closeDevice();
				lblDeviceStatus.setText("设备无效");
				lblDeviceStatus.setEnabled(false);
			}
		});
		buttonEnd.setBounds(347, 413, 93, 23);
		frame.getContentPane().add(buttonEnd);
		
		JButton buttonQuit = new JButton("退出程序");
		buttonQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				VguangApi.closeDevice();
				System.exit(0);
			}
		});
		buttonQuit.setBounds(464, 413, 93, 23);
		frame.getContentPane().add(buttonQuit);
		
		decodeTextArea = new JTextArea();
		decodeTextArea.setRows(5);
		decodeTextArea.setLineWrap(true);
		decodeTextArea.setColumns(10);
		decodeTextArea.setBounds(113, 94, 347, 211);
		frame.getContentPane().add(decodeTextArea);
		
		JLabel label = new JLabel("核销结果：");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("宋体", Font.BOLD, 14));
		label.setBounds(21, 90, 93, 23);
		frame.getContentPane().add(label);
		
		chckbxQr = new JCheckBox("QR");
		chckbxQr.setSelected(true);
		chckbxQr.setBounds(567, 96, 87, 23);
		frame.getContentPane().add(chckbxQr);
		
		checkboxDm = new JCheckBox("DM");
		checkboxDm.setSelected(true);
		checkboxDm.setBounds(567, 123, 103, 23);
		frame.getContentPane().add(checkboxDm);
		
		chckbxBar = new JCheckBox("条形码");
		chckbxBar.setSelected(true);
		chckbxBar.setBounds(567, 148, 103, 23);
		frame.getContentPane().add(chckbxBar);
		
		chckbxBeep = new JCheckBox("蜂鸣器");
		chckbxBeep.setSelected(true);
		chckbxBeep.setBounds(595, 324, 103, 23);
		frame.getContentPane().add(chckbxBeep);
		
		chckbxAi = new JCheckBox("自动休眠");
		chckbxAi.setSelected(true);
		chckbxAi.setBounds(567, 231, 103, 23);
		frame.getContentPane().add(chckbxAi);
		
		JLabel lblNewLabel = new JLabel("appid:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(21, 28, 66, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("响应时间：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(533, 294, 66, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("解码间隔时间：");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(507, 180, 93, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(507, 168, 191, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(507, 49, 191, 2);
		frame.getContentPane().add(separator_1);
		
		JLabel label_1 = new JLabel("码制：");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("宋体", Font.BOLD, 14));
		label_1.setBounds(507, 96, 54, 23);
		frame.getContentPane().add(label_1);
		
		JLabel lblNewLabel_3 = new JLabel("自动休眠：");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel_3.setBounds(507, 210, 93, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(518, 303, 180, 2);
		frame.getContentPane().add(separator_2);
		
		JLabel lblNewLabel_4 = new JLabel("蜂鸣器：");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel_4.setBounds(521, 328, 66, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton buttonBeep1 = new JButton("响一声");
		buttonBeep1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				VguangApi.beep(1);
			}
		});
		buttonBeep1.setBounds(265, 380, 93, 23);
		frame.getContentPane().add(buttonBeep1);
		
		JButton buttonBeep2 = new JButton("响二声");
		buttonBeep2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				VguangApi.beep(2);
			}
		});
		buttonBeep2.setBounds(374, 380, 93, 23);
		frame.getContentPane().add(buttonBeep2);
		
		JButton buttonBeep3 = new JButton("响三声");
		buttonBeep3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				VguangApi.beep(3);
			}
		});
		buttonBeep3.setBounds(477, 380, 93, 23);
		frame.getContentPane().add(buttonBeep3);
		
		JLabel lblNewLabel_5 = new JLabel("设备状态：");
		lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(10, 324, 93, 23);
		frame.getContentPane().add(lblNewLabel_5);
		
		lblDeviceStatus = new JLabel("设备无效");
		lblDeviceStatus.setBounds(122, 324, 93, 23);
		lblDeviceStatus.setEnabled(false);
		frame.getContentPane().add(lblDeviceStatus);
		
		JButton buttonLightOn = new JButton("开灯");
		buttonLightOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				VguangApi.lightOn();
			}
		});
		buttonLightOn.setBounds(113, 380, 66, 23);
		frame.getContentPane().add(buttonLightOn);
		
		JButton buttonLightOff = new JButton("关灯");
		buttonLightOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				VguangApi.lightOff();
			}
		});
		buttonLightOff.setBounds(189, 380, 66, 23);
		frame.getContentPane().add(buttonLightOff);
		
		JLabel label_2 = new JLabel("毫秒");
		label_2.setBounds(684, 180, 32, 15);
		frame.getContentPane().add(label_2);
		
		JLabel lblNewLabel_11 = new JLabel("秒");
		lblNewLabel_11.setBounds(684, 315, 32, 15);
		frame.getContentPane().add(lblNewLabel_11);
		
		textDecodeTime = new JTextField();
		textDecodeTime.setText("1000");
		textDecodeTime.setBounds(604, 177, 66, 21);
		frame.getContentPane().add(textDecodeTime);
		textDecodeTime.setColumns(10);
		
		textAiLimit = new JTextField();
		textAiLimit.setText("20");
		textAiLimit.setBounds(604, 260, 66, 21);
		frame.getContentPane().add(textAiLimit);
		textAiLimit.setColumns(10);
		
		textAiResponeTime = new JTextField();
		textAiResponeTime.setText("300");
		textAiResponeTime.setBounds(604, 291, 66, 21);
		frame.getContentPane().add(textAiResponeTime);
		textAiResponeTime.setColumns(10);
		
		JButton btnNewButton = new JButton("更新设置");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				applySetting();
			}
		});
		btnNewButton.setBounds(234, 413, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setText("123456789");
		textField.setColumns(10);
		textField.setBounds(113, 24, 134, 21);
		frame.getContentPane().add(textField);
		
		JLabel label_3 = new JLabel("灵敏度：");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(543, 266, 66, 15);
		frame.getContentPane().add(label_3);
		
		txtJF = new JTextField();
		txtJF.setText("jf_admisl87wehkfsd98");
		txtJF.setColumns(10);
		txtJF.setBounds(113, 57, 170, 21);
		frame.getContentPane().add(txtJF);
		
		JLabel lblSecret = new JLabel("secret:");
		lblSecret.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSecret.setBounds(21, 60, 66, 15);
		frame.getContentPane().add(lblSecret);
		
		JButton button = new JButton("核销测试");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(317, 25, 93, 23);
		frame.getContentPane().add(button);
		
		JLabel label_4 = new JLabel("测试成功");
		label_4.setEnabled(false);
		label_4.setBounds(411, 24, 93, 23);
		frame.getContentPane().add(label_4);
	}
	
	public void setResultString(final String str){
		//在主线程中更新UI
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				decodeTextArea.setText(str);
			}
		});
	}
	
	public void setDeviceStatus(final int istatus){
		//在主线程中更新UI
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				if(istatus == VguangApi.DEVICE_VALID){
					lblDeviceStatus.setText("设备有效");
					lblDeviceStatus.setEnabled(true);
				}else{
					lblDeviceStatus.setText("设备无效");
					lblDeviceStatus.setEnabled(false);
				}
			}
		});
	}

	private static int StringToInt(String str, int defautValue){
		if(str != null){
			try{
				return Integer.parseInt(str);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return defautValue;
	}
}
