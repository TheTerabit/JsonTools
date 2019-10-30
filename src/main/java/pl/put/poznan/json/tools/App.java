package pl.put.poznan.json.tools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.json.tools.controller"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
