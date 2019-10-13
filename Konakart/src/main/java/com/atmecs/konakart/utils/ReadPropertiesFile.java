package com.atmecs.konakart.utils;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.util.Properties;

import com.atmecs.konakart.constants.ConstantPaths;

public class ReadPropertiesFile {
	FileInputStream data;
	FileInputStream config;
	FileInputStream locators;

	public String readPropertiesFile(String elements) {
		Properties prop = new Properties();

		try {
			config = new FileInputStream(ConstantPaths.CONFIG_FILE);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			locators = new FileInputStream(ConstantPaths.LOCATORS_FILE);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			prop.load(config);

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			prop.load(locators);

		} catch (Exception e) {
			e.printStackTrace();
		}
		String data = prop.getProperty(elements);
		return data;

	}
}
