package  com.compass.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;


public class Util {

	/*
	 * Keep all the final variable
	 */
	public static final int WAIT_TIME = 5; // 20
	public static final int POLL_TIME = 5;
	public static Properties properties = null;
	public static final String PropFilePath = System.getProperty("user.dir") + "/configuration/config.properties";
	public static final String ExcelBasePath = System.getProperty("user.dir") + "/data/";
	
	/*
	 * Keep all static variable
	 */
	public static String group = "";
	public static String baseUrl = "";
	public static String browserVersion = "";
	public static String browserName = "";
	public static boolean testStatus = false;
	public static String username = "";
	public static String excelFileName = "";
	public static String excelSheetName = "";
	public static String applicationName = "";
	public static String confNum = "";
	

//	public static final String ExcelBasePath = System.getProperty("user.dir")
//			+ Utility.propertiesFile(Utility.PropFilePath).getProperty("excelBasePath");

	public static String setDate() {
		SimpleDateFormat dFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 1);
		String date = dFormat.format(c.getTime());
		return date;
	}

	public static Properties propertiesFile(String propFilePath) {
		properties = new Properties();
		FileInputStream file;

		try {
			file = new FileInputStream(propFilePath);
			properties.load(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return properties;
	}
	
	public static void writePropertiesFile(String url) {
		
		try(FileOutputStream file = new FileOutputStream(Util.PropFilePath)) {
			properties = new Properties();
			System.out.println(Util.baseUrl);
			Util.propertiesFile(Util.PropFilePath).setProperty("baseURL", url);

			properties.store(file, "change the below path value to test against another env");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
