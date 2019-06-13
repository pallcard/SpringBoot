package cn.wishhust.demo.controller;

import cn.wishhust.demo.pojo.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigTest {

    Logger log = LoggerFactory.getLogger(HelloWorld.class);


    @Value("${person.name}")
    private String name;

    @Value("${person.name2}")
    private String name2;

    @Value("${person.name3}")
    private String name3;

    //spEL表达式
    @Value("#{person.age+10}")
    private Integer age;

    @Value("${person.boss}")
    private String boss;

    @Autowired
    private Student student;

    @GetMapping("/test")
    public String testConfig() {
        log.info("name=" + name + "name2=" + name2 + "name3=" + name3 +" age="+ age +" IsBoss="+boss);
        return "name=" + name + "name2=" + name2 + "name3=" + name3 +" age="+ age +" IsBoss="+boss;
    }

    @GetMapping("/test2")
    public String testConfig2() {
        log.info(student.toString());
        return "test";
    }

}

