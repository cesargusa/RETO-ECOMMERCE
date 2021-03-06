package com.example.Product.API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.example.Product.Model.Order;
import com.example.Product.Model.OrderProduct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {
    public int num=0;
     public static ArrayList<Order> orders = new ArrayList<Order>(Arrays.asList(

                new Order("10/11/2020","Cesar","En Curso"),
                new Order("13/9/2020","Antonio","Entregado"),
                new Order("10/11/2020","Alvaro","Aceptado"),
                new Order("10/11/2020","Elena","Enviado"),
                new Order("10/11/2020","Gabriela","En Curso")

    ));

    
 

   
    public static ArrayList<Order> GetAllOrdersId(int orderId){
        ArrayList<Order> result = new ArrayList<>();
        if(orderId==0){
            return  orders;
        }else{
            for(Order element : orders){
                if(element.getId()==orderId){
                    result.add(element);
                }
            }
            return result;
        }
    }

    //METODO PARA BORRAR PEDIDOS Y ORDERSPRODUCTS MEDIANTE UN ITERATOR
    @DeleteMapping("/orders/{id}")
    public void Delete(@PathVariable("id") int id){
            Iterator<OrderProduct> itOrderProduct = OrdersProductsController.orderproducts.iterator();

            while(itOrderProduct.hasNext()){
                OrderProduct ele = itOrderProduct.next();
                if(ele.getOrderId()==id){
                    itOrderProduct.remove();
                }
            }
            for(Order ele2 : orders){
                if(ele2.getId()==id){
                    orders.remove(ele2);
                    break;
                }
            }
              
        }
       
        
    
    @GetMapping("/g")
    public ArrayList<Order> All(){
        return orders;
    }
}

