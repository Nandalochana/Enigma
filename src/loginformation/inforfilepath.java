/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginformation;

import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

/**
 *
 * @author danushka nandalochan
 */
public class inforfilepath {
     public static void initLogger(){
    
        try {
            String path="D:/finalproject.txt";
            PatternLayout p=new PatternLayout("%p %d %m %L %n");
            RollingFileAppender apender=new RollingFileAppender(p, path);
            apender.setName("finalprojectlog");
            apender.setMaxFileSize("1MB");
            apender.activateOptions();
            
            
            Logger.getRootLogger().addAppender(apender);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
