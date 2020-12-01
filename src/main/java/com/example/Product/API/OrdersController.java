package com.example.Product.API;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.Product.Model.Order;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {
   
    
        public static ArrayList<Order> orders = new ArrayList<Order>(Arrays.asList(
   
                   new Order("10/11/2020","Cesar","En Curso"),
                   new Order("13/9/2020","Antonio","Entregado"),
                   new Order("10/11/2020","Alvaro","Aceptado"),
                   new Order("10/11/2020","Elena","Enviado"),
                   new Order("10/11/2020","Gabriela","En Curso")
   
       ));
   
       
       @GetMapping("/orders")
       private ArrayList<Order> GetAllOrders(){
           return orders;
       }
    
   
   
      
      
    }

