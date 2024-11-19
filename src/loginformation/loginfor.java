/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginformation;

import org.apache.log4j.Logger;

/**
 *
 * @author danushka nandalochan
 */
public class loginfor {
    public static void main(String[] args){
        inforfilepath.initLogger();
        Logger log=Logger.getLogger("finalprojectlog");
        log.info("Test");
        log.warn("Test");
        log.error("Test");
        log.fatal("Test");
    
    
    }
}
