package com.ustc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesUtil {
	private Properties p;

	private FileInputStream in;


	/**
	 * 
	 * 
	 * 根据传进的文件名载入文件
	 * 
	 * 
	 * @param fileName
	 *            String
	 * 
	 * 
	 */

	public PropertiesUtil(String fileName) {

		File file = new File(fileName);

		try {

			in = new FileInputStream(file);

			p = new Properties();

			// 载入文件

			p.load(in);

			in.close();

		}

		catch (FileNotFoundException e) {

			System.err.println("配置文件config.properties找不到！！");

			e.printStackTrace();

		}

		catch (Exception e) {

			System.err.println("读取配置文件config.properties错误！！");

			e.printStackTrace();

		}

	}

	/**
	 * 
	 * 
	 * 列出所有的配置文件内容
	 * 
	 * 
	 */

	public void list() {

		p.list(System.out);

	}

	/**
	 * 
	 * 
	 * 指定配置项名称，返回配置值
	 * 
	 * 
	 * @param itemName
	 *            String
	 * 
	 * 
	 * @return String
	 * 
	 * 
	 */

	public String getValue(String itemName) {

		return p.getProperty(itemName);

	}

	/**
	 * 
	 * 
	 * 指定配置项名称和默认值，返回配置值
	 * 
	 * 
	 * @param itemName
	 *            String
	 * 
	 * 
	 * @param defaultValue
	 *            String
	 * 
	 * 
	 * @return String
	 * 
	 * 
	 */

	public String getValue(String itemName,

	String defaultValue) {

		return p.getProperty(itemName, defaultValue);

	}

	/**
	 * 
	 * 
	 * 设置配置项名称及其值
	 * 
	 * 
	 * @param itemName
	 *            String
	 * 
	 * 
	 * @param value
	 *            String
	 * 
	 * 
	 */

	public void setValue(String itemName, String value) {

		p.setProperty(itemName, value);

		return;

	}


	/**
	 * 
	 * 
	 * main method for test
	 * 
	 * 
	 * @param args
	 *            String[]
	 * 
	 * 
	 */

	public static void main(String[] args) {

		String file = "config.properties";

		PropertiesUtil pu = new PropertiesUtil(file);

		pu.list();
		System.out.print("test ="+pu.getValue("url"));

	}

}
