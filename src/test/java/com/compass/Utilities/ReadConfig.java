package com.compass.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
        Properties pro;

        public ReadConfig()
        {
            File src =new File(".//Configurations//config.properties");

            try{
                FileInputStream fis=new FileInputStream(src);
                pro=new Properties();
                pro.load(fis);
            } catch (Exception e) {
                System.out.println("exception is "+ e.getMessage());
                e.printStackTrace();
            }
        }

        public String getApplicationURL()
        {
            String url=pro.getProperty("baseURL");
            return url;
        }

        public String getEmailAddress()
        {
            String url=pro.getProperty("emailaddress");
            return url;
        }

         public String getPassWord()
         {
             String url=pro.getProperty("passWord");
             return url;
         }

         public String getChrome()
         {
             String url=pro.getProperty("chromepath");
             return url;
         }
         public String getFireFox()
        {
            String url=pro.getProperty("firepath");
            return url;
         }

}
