package cn.wishhust.demo.controller;

import cn.wishhust.demo.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/test")
@Api(value = "测试")
public class HelloWorld {

    Logger log = LoggerFactory.getLogger(HelloWorld.class);


    @GetMapping(value={"/hello","/hi"})
    @ApiOperation(value = "hello")
//    @ApiImplicitParam
    public String hello(){
        return "Hello Spring Boot";
    }

    // 访问：http://localhost:8080/test/get/xxx
    @GetMapping("/get/{name}")
    @ApiOperation(value = "测试get")
    public String get(@PathVariable(value = "name") String name2){
        System.out.println("name: "+ name2);
        return "Hi "+ name2;
    }

    // 访问：http://localhost:8080/test/get2?name=yyy
    @GetMapping("/get2")
    @ApiOperation(value = "测试get2")
    // 请求参数名字与方法中的形参一致，可以省略@RequestParam
//    public String get2(@RequestParam("name") String name2) {
    public String get2(String name2) {
        System.out.println("name: "+ name2);
        return "Hi "+ name2;
    }

    @GetMapping("/get3")
    @ApiOperation(value = "测试get3")
    public String get3(@RequestParam(value = "name",defaultValue = "admin",required = false) String name) {
        System.out.println("name: "+ name);
        return "Hi "+ name;
    }

    @PostMapping("/post")
    @ApiOperation(value = "测试post")
    public String post(@RequestParam("username") String name, Integer age){
        log.info("name=" + name+", age=" + age);
        return "name=" + name+", age=" + age;
    }

    @PostMapping("post2")
    @ApiOperation(value = "测试post2")
    public String post2(HttpServletRequest request) {
        ServletInputStream is = null;
        StringBuilder sb = null;
        try {
            is = request.getInputStream();
            sb = new StringBuilder();
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = is.read(buf)) != -1){
                sb.append(new String(buf,0,len));
            }
            System.out.println(sb.toString());
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    @PostMapping("/post3")
    @ApiOperation(value = "测试post3")
    public String post3(@RequestBody User user) {
        log.info(user.toString());
        return null;
    }

}
