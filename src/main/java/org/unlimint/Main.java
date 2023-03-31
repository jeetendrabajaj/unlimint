package org.unlimint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.unlimint.scanners.CsvFileScanner;
import org.unlimint.scanners.JsonFileScanner;
import org.unlimint.scanners.SuperScanner;


@Configuration
public class Main {

    @Value("spring.xml")
    static String config = "spring.xml";


    public static void main(String[] args) {
        try {
            String filepth1 = args[0];
            String filepth2 = args[1];

            ApplicationContext context = new ClassPathXmlApplicationContext(Main.config);

            SuperScanner csvFileScanner = context.getBean(CsvFileScanner.class);
            csvFileScanner.setFileName(filepth1);
            Thread td1 = new Thread(csvFileScanner);

            SuperScanner jsonFileScanner = context.getBean(JsonFileScanner.class);
            jsonFileScanner.setFileName(filepth2);
            Thread td2 = new Thread(jsonFileScanner);

            td1.start();
            td2.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}