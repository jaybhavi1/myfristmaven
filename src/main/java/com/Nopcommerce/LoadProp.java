package com.Nopcommerce;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @ author Jay Vaghani on 21/04/2017.
 */
public class LoadProp extends BasePage
{
    static Properties prop;

    static FileInputStream input;

    public String getProperty(String key)
    {
        prop = new Properties();

        try {
            input= new FileInputStream("C:\\Users\\user\\IdeaProjects\\myfristmaven\\src\\test\\Resources\\config.properties");
            prop.load(input);
        }catch (IOException e){
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }
}


