package com.allica.write.log;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class CustomLogger {

   public static final String loggingFilename="detailsInfo.txt";

  public PrintStream requestResponseLogging() throws FileNotFoundException {

      FileOutputStream fileOutputStream=new FileOutputStream(loggingFilename,true);

       return new PrintStream(fileOutputStream);
  }
}
