package com.myself.spring.log;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.logging.*;

/**
 * jdk自带的原生的日志JUL测试
 */
public class JULTest {
    //基本
    @Test
    public void testJULBase(){
        Logger logger = Logger.getLogger("myLogger");
        logger.info("消息");
        logger.warning("警告");
        logger.severe("严重");
    }

    /**
     * 自定义设置的logger。
     * @throws Exception
     */
    @Test
    public void testLogConfig() throws Exception {
        // 1.创建日志记录器对象,这个参数name，主要是用于判断其父类logger对象为谁
        Logger logger = Logger.getLogger("com.ydlclass.log.JULTest");
        // 一、自定义日志级别
        // a.关闭系统默认配置
        logger.setUseParentHandlers(false);
        // b.创建consoleHandler对象，设置输出控制器的日志的模式
        ConsoleHandler consoleHandler = new ConsoleHandler();
        // c.创建formatter对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        // d.进行关联
        consoleHandler.setFormatter(simpleFormatter);
        logger.addHandler(consoleHandler);
        // e.设置日志级别
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);
        // 二、输出到日志文件
        //创建fileHandler对象，设置输出文件的日志的模式
        FileHandler fileHandler = new FileHandler("./src/main/logs/jul1.log");
        fileHandler.setFormatter(simpleFormatter);
        logger.addHandler(fileHandler);
        // 2.日志记录输出
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    /**
     * 解释的利用name参数来设置logger的父子关系
     * @throws Exception
     */
    @Test
    public void testLogParent() throws Exception {
        Logger logger1 = Logger.getLogger("com.ydlclass.service");
        Logger logger2 = Logger.getLogger("com.ydlclass");
        // 一、对logger2进行独立的配置
        // 1.关闭系统默认配置，其实就是放弃继承父Logger的配置
        logger2.setUseParentHandlers(false);
        // 2.创建handler对象
        ConsoleHandler consoleHandler = new ConsoleHandler();
        // 3.创建formatter对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        // 4.进行关联
        consoleHandler.setFormatter(simpleFormatter);
        logger2.addHandler(consoleHandler);
        // 5.设置日志级别
        logger2.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);
        // 测试logger1是否被logger2影响
        logger1.severe("severe");
        logger1.warning("warning");
        logger1.info("info");
        logger1.config("config");
        logger1.fine("fine");
        logger1.finer("finer");
        logger1.finest("finest");
    }


    /**
     * 使用简易的自定义格式化器，来定义日志格式
     * @throws Exception
     */
    @Test
    public void testLogBaseFormatter() throws Exception {
        Logger logger2 = Logger.getLogger("com.ydlclass");
        // 一、对logger2进行独立的配置
        // 1.关闭系统默认配置，其实就是放弃继承父Logger的配置
        logger2.setUseParentHandlers(false);
        // 2.创建handler对象
        ConsoleHandler consoleHandler = new ConsoleHandler();
        // 3.创建自定义的formatter对象
        Formatter myFormatter = new Formatter(){
            @Override
            public String format(LogRecord record) {
                return "myFormatter "+record.getLoggerName()+"." +record.getSourceMethodName() + " " + LocalDateTime.ofInstant(record.getInstant(), ZoneId.systemDefault())+"\r\n"
                        +record.getLevel()+": " +record.getMessage() + "\r\n";
            }
        };
        // 4.进行关联
        consoleHandler.setFormatter(myFormatter);
        logger2.addHandler(consoleHandler);
        // 5.设置日志级别
        logger2.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);
        // 测试logger1是否被logger2影响
        logger2.severe("severe");
        logger2.warning("warning");
        logger2.info("info");
        logger2.config("config");
        logger2.fine("fine");
        logger2.finer("finer");
        logger2.finest("finest");
    }

    /**
     * 获取自定义日志配置文件，作为日志配置文件
     */
    @Test
    public void testLogMyselfConfiguration() throws Exception {
        // 读取自定义配置文件
        InputStream in =
                JULTest.class.getClassLoader().getResourceAsStream("logging.properties");
        // 获取日志管理器对象
        LogManager logManager = LogManager.getLogManager();
        // 通过日志管理器加载配置文件
        logManager.readConfiguration(in);
        //Logger logger = Logger.getLogger("com.myself.spring");
        Logger logger = Logger.getLogger("com");
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    /**
     * 将异常对象打印到日志中
     */
    @Test
    public void testLogException()  throws IOException{
        // 读取自定义配置文件
        InputStream in = JULTest.class.getClassLoader().getResourceAsStream("logging.properties");
        // 获取日志管理器对象
        LogManager logManager = LogManager.getLogManager();
        // 通过日志管理器加载配置文件
        logManager.readConfiguration(in);
        Logger logger = Logger.getLogger("com.myself.spring");
        logger.finer("finer");
        try{
            int i=1/0;
        }catch (Exception e){
            //用于打印详细异常信息，这个方法要正确的生效，需要日志打印级别达到finer
            logger.throwing(this.getClass().getName(),"testLogException",e);
        }
    }
}
