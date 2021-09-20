package com.template.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component("logUtils")
public class LogUtils {

    private static final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    public void info(String message){
        logger.info(message);
    }

    public void debug(String message){
        logger.debug(message);
    }

    public void warn(String message){
        logger.warn(message);
    }
}
