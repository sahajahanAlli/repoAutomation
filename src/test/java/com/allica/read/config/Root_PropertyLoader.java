package com.allica.read.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Root_PropertyLoader {



    // static variable for loading root properties data
    private  Properties props;

    // default constuctor
    public Root_PropertyLoader(){

    }

    //Method for loading properties
    public Properties load(String typeOfSystem) throws IOException {

        File currentDir= new File(".");
        String path=currentDir.getAbsolutePath();

        String APICONFIGPATH="src\\test\\java\\config\\"+typeOfSystem+"_env.properties";
        System.out.println(APICONFIGPATH);
        InputStream input=new FileInputStream(new File(path.substring(0,path.length()-1)+APICONFIGPATH));
        props=new Properties();
        props.load(input);
        
        return props;
        
    }


}
