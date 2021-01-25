package springbootalipay.alipay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import springbootalipay.alipay.service.ProductService;

@CrossOrigin
@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String allproduct(ModelMap modelMap){
        modelMap.put("allproduct",productService.selectAll());
        return "index";
    }
}
