package cn.wishhust.demo.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;
import java.util.Map;


@ConfigurationProperties(prefix = "student")
@Component
@Data
@Validated //数据校验
public class Student {

    private String name;
    @Max(value = 300,message = "年龄不能超过300岁")
    @Min(value = 0,message = "年龄必须大于0")
    private Integer age;
    private Boolean boss;
    private Date birth;
    private Map<String, Object> maps;
    private List<String> lists;
    private Dog dog;

}
