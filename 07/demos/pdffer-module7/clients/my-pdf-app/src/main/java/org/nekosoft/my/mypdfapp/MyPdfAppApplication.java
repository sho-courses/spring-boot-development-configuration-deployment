package org.nekosoft.my.mypdfapp;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MyPdfAppApplication {

    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(MyPdfAppApplication.class);
//        application.setBannerMode(Banner.Mode.CONSOLE);
        application.run(args);

//        new SpringApplicationBuilder(MyPdfAppApplication.class)
//                .bannerMode(Banner.Mode.CONSOLE)
//                .run(args);

    }

}
