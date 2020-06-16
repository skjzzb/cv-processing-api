package com.gslab.talent.controller;


import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {
	
	 Logger logger = Logger.getLogger(LoggingController.class);
	 
	    @RequestMapping("/")
	    public String index() {
	        logger.trace("A TRACE Message");
	        logger.debug("A DEBUG Message");
	        logger.info("An INFO Message");
	        logger.warn("A WARN Message");
	        logger.error("An ERROR Message");
	 
	        return "Howdy! Check out the Logs to see the output...";
	    }

}
