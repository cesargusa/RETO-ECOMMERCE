package com.example.Product.API;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.Product.Model.OrderProduct;

public class OrdersProductsController {
    
 public static ArrayList<OrderProduct> orderproducts = new ArrayList<OrderProduct>(Arrays.asList(

    new OrderProduct(20, 1, 1), 
    new OrderProduct(12, 1, 2), 
    new OrderProduct(4, 2, 3),
    new OrderProduct(5, 3, 4),
    new OrderProduct(1, 4, 1),
    new OrderProduct(2, 3, 1),
    new OrderProduct(1, 1, 5),
    new OrderProduct(1, 3, 5),
    new OrderProduct(2, 3, 3),
    new OrderProduct(2, 1, 2),
    new OrderProduct(3, 2, 1),
    new OrderProduct(13, 1, 1)
    
    
    ));





public static ArrayList<OrderProduct> GetOrderProductbyOrder(int orderId){
ArrayList<OrderProduct> orderproductsnew = new ArrayList<>();
if(orderId==0){
    return OrdersProductsController.orderproducts;
}else{
    for(OrderProduct element : OrdersProductsController.orderproducts){
        if(element.getOrderId()==orderId){

        
            orderproductsnew.add(element);
        }
    }                    return orderproductsnew;

}


}




}
