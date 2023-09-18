package com.amigoscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

//@ComponentScan(basePackages = "com.amigoscode") //telling application to only look for com.amigoscode package only
//@EnableAutoConfiguration // to make default configurations
//@Configuration // Instead of these 3 annotations we can simply use "@SpringBootApplication"

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

    @GetMapping("/path")
    public PathResponse greet(
            @RequestParam(value = "name", required = false) String name) {
        String greetMessage = name == null ||  name.isBlank() ? "Hello" : "Hello " + name;
        PathResponse response = new PathResponse(
                greetMessage,
                List.of("Java", "Golang", "Javascript"),
                new Person("Harish",25, 30000)
        );
        return response;
    }
    record Person(String name,int age, double savings){
    }
    record PathResponse(
            String greet,
            List<String> favProgrammingLanguages,
            Person person
            ){}

//Instead of writing all the below class we can simply use record
//    class PathResponse{
//        private final String greet;
//
//        public PathResponse(String greet) {
//            this.greet = greet;
//        }
//
//        @Override
//        public String toString() {
//            return "PathResponse{" +
//                    "greet='" + greet + '\'' +
//                    '}';
//        }
//
//        public String getGreet() {
//            return greet;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            PathResponse that = (PathResponse) o;
//            return Objects.equals(greet, that.greet);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(greet);
//        }
//    }
}
