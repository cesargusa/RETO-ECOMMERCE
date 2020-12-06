package com.example.Product.API;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.Product.Model.Order;
import com.example.Product.Model.OrderProduct;
import com.example.Product.Model.Product;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrdersProductsViewController {
    @GetMapping("/OrderProducts")
    public ModelAndView GetAll(@RequestParam( name="orderId", required=false,defaultValue="0") int orderId){
        ArrayList<OrderProduct> result = OrdersProductsController.GetOrderProductbyOrder(orderId);
        ArrayList<Order> result2 = OrdersController.GetAllOrdersId(orderId);
        ArrayList<Product> productsByOrder = OrdersProductsController.GetProductsByOrderId(orderId);

        ModelAndView mv = new ModelAndView("ordersProducts");
        mv.addObject("orderproduct", result);
        mv.addObject("orders", OrdersController.orders);
        mv.addObject("ord", result2);
        mv.addObject("productsOrder", productsByOrder);
       return mv;
    }
     @GetMapping("/OrderProducts/new")
    public ModelAndView CreateOrderProduct(){
        ModelAndView mv = new ModelAndView("addProductsOrder");
            ArrayList<Product> pro = ProductsController.products;
         
       
        mv.addObject("orderProduct", new OrderProduct());
        mv.addObject("product", pro);
        return mv;
    }

    //METODO QUE CREA UN ORDERPRODUCT Y REDIRIGE A LA INFORMACION DEL PEDIDO AÑADIDO
    @PostMapping("/OrderProducts")
    public String Add(@ModelAttribute("orderProduct") OrderProduct newOrderProduct, HttpServletRequest request, HttpServletResponse response){
        for(Order ele : OrdersController.orders){
           
                  if(ele.getId()==newOrderProduct.getOrderId()){
                OrdersProductsController.orderproducts.add(
                    new OrderProduct(
                    newOrderProduct.getCantidad(),
                    newOrderProduct.getOrderId(),
                    newOrderProduct.getProductId()
                    ));
                return "redirect:/OrderProducts?orderId="+newOrderProduct.getOrderId();
            }else{
                throw new ElementNotFoundException();
           /* response.setStatus(HttpServletResponse.SC_NOT_FOUND); */
            }
        }
            
          
                    return null;

      
    }
   
    //METODO QUE MUESTRA UN ERROR SI SE INTRODUCE UNA ID INCORRECTA
    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="----ID INCORRECTA-----")
    public class ElementNotFoundException extends RuntimeException{
        
    }
}
