package com.example.Product.API;

import java.util.ArrayList;

import com.example.Product.Model.Product;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductsViewController {
    @GetMapping("/products")
    public ModelAndView Products(@RequestParam(name ="productId",required = false,defaultValue = "0") int productId){
     ArrayList<Product> pro = ProductsController.GetForId(productId);
     ModelAndView mv = new ModelAndView("products");
     mv.addObject("products", pro);
     return mv;
    }

}
