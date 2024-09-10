package hei.school.kenny.todoliste.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
        "hei.school.kenny.todoliste.Application",
        "hei.school.kenny.todoliste.Controller",
        "hei.school.kenny.todoliste.Models"
})

public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
