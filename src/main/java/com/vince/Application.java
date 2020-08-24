package com.vince;

import com.vince.server.TCPServer;

import lombok.extern.slf4j.Slf4j;

//import com.vince.toolkit.framework.util.log.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class Application {
//    private final static Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        TCPServer tcpServer = ctx.getBean(TCPServer.class);
        log.info("Start server...");
        tcpServer.startup();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> tcpServer.shutdown()));
    }
}
