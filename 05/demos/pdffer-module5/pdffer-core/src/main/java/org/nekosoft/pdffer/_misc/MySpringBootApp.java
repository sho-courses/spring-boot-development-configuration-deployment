package org.nekosoft.pdffer._misc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Properties;

@SpringBootApplication
@PropertySource("classpath:org/nekosoft/pdffer/_misc/pdffer-defaults.yaml")
public class MySpringBootApp {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(MySpringBootApp.class);
        Properties properties = new Properties();
        properties.setProperty("pdffer.mailer.send-from.name", "My Spring PDF");
        properties.setProperty("pdffer.mailer.send-from.address", "myspring@my.pdf");
        properties.setProperty("pdffer.web.controller.base-uri", "myspringpdf");
        application.setDefaultProperties(properties);
        ApplicationContext ctx = application.run(args);
        AppSecrets secrets = ctx.getBean(AppSecrets.class);
        System.out.println("secrets.getSecretRandomInt() = " + secrets.getSecretRandomInt());
        System.out.println("secrets.getSecretRandomLong() = " + secrets.getSecretRandomLong());
        System.out.println("secrets.getSecretRandomUUID() = " + secrets.getSecretRandomUUID());
        System.out.println("secrets.getSecretRandomBytes() = " + Arrays.toString(secrets.getSecretRandomBytes()));
    }

}
