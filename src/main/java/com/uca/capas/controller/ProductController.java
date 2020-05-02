package com.uca.capas.controller;

import java.util.ArrayList;
import java.util.List;
import com.uca.capas.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    private List<Product> products = new ArrayList<Product>();

    @GetMapping("/comprarProducto")
    public ModelAndView comprarProducto(){
        ModelAndView mav = new ModelAndView();

        products.add(new Product(0, "Brownies", 10));
        products.add(new Product(1, "Tres leches", 25));
        products.add(new Product(2, "Cheesecake", 2));
        products.add(new Product(3, "Gelato", 45));
        products.add(new Product(4, "Alfajores", 15));

        mav.setViewName("productos");
        mav.addObject("product", new Product());
        mav.addObject("producto", products);

        return mav;
    }

    @PostMapping("/validar")
    public ModelAndView validar(Product product){
        ModelAndView mav = new ModelAndView();
        String view = "compra";

        if (product.getCantidad() > products.get(product.getId()).getCantidad()){
            view = "error";
        }
        
        mav.setViewName(view);
        mav.addObject("nombre", this.products.get(product.getId()).getNombre());

        return mav;
    }
}