//package com.example.vueboot.config;
//
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.core.env.Profiles;
//import org.springframework.stereotype.Component;
//import springfox.documentation.RequestHandler;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.ArrayList;
//
////@Configuration等同于@Component
//@Configuration
////开启swagger
//@EnableSwagger2
//public class SwaggerConfig {
//    //配置swagger的Docket的bean实例 可以配置多个Docket 则就是分组操作
//    @Bean
//    public Docket docketA(Environment environment){
//        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
//    }
//
//    @Bean
//    public Docket docketB(Environment environment){
//        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
//    }
//
//    @Bean
//    public Docket docketC(Environment environment){
//        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
//    }
//
//    @Bean
//    public Docket docket(Environment environment){
//        //如果希望在开发环境中使用 在发布环境不使用 就使用下面的方法
//        //设置要显示的swagger环境 参数是可选参数
//        Profiles profiles=Profiles.of("dev","test");
//        //获取项目环境:acceptsProfiles环境监听变量判断是否处在自己设定的环境当中
//        boolean flag = environment.acceptsProfiles(profiles);
//
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                //.enable(false 关闭,true 开启 默认是开启的) 是否启用swagger
//                .enable(flag)
//                .select()
//                //RequestHandlerSelectors 配置要扫描接口的方式
//                //basePackage 基于某个包去扫描接口
//                //any() 扫描全部
//                //none() 都不扫描
//                //withClassAnnotation( 扫描类上有RestController的接口
//                //列如:RestController.class) 扫描类上的注解,参数是一个注解的反射对象
//                //withMethodAnnotation(GetMapping) 扫描方法上的注解
//                .apis(RequestHandlerSelectors.basePackage("com.example.vueboot.controller"))
//                //paths() 过滤什么路径 这里的路径区分大小写
//                .paths(PathSelectors.ant("/vue/**"))
//                .build();
//    }
//    //配置swagger信息 apiinfo
//    private ApiInfo apiInfo(){
//
//        //作者信息
//        Contact contact=
//                new Contact("Thomas", "html://666", "3361952465@qq.com");
//
//        return  new ApiInfo(
//                "Thomas的swagger api 文档",
//                "Thomas",
//                "v1.0",
//                "urn:tos",
//                contact,
//                "Apache 2.0",
//                "http://www.apache.org/licenses/LICENSE-2.0",
//                new ArrayList());
//    }
//}
