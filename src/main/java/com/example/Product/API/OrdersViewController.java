package com.example.Product.API;

import java.util.ArrayList;

import com.example.Product.Model.Order;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrdersViewController {
    @GetMapping("/orders")
    public ModelAndView GetAll(@RequestParam(name = "orderId", defaultValue = "0", required = false) int orderId){
        ArrayList<Order> result = OrdersController.GetAllOrdersId(orderId);
        ModelAndView mv = new ModelAndView("orders");
        mv.addObject("orders", result);
        return mv;
    }
    @GetMapping("/orders/new")
    public ModelAndView CreateOrder(){
        ModelAndView mv = new ModelAndView("addOrder");
        mv.addObject("order", new Order());
        return mv;
    }
    @PostMapping("/orders")
    public String Add(@ModelAttribute("order") Order newUser){
        OrdersController.orders.add(new Order(newUser.getDate(),newUser.getNameUser(),newUser.getStatus()));
        return "redirect:/orders";
    }

}
