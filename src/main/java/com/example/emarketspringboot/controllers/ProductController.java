package com.example.emarketspringboot.controllers;

import com.example.emarketspringboot.models.Product;
import com.example.emarketspringboot.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public String products(Model model) {
        model.addAttribute("products", productService.list());
        return "products";
    }

    @GetMapping("product/{id}")
    public  String productInfo(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "product-info";
    }

    @PostMapping("/product/create")
    public String createProduct(Product product) {
        productService.saveProducts(product);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProductById(@PathVariable Long id) {
        productService.deleteProducts(id);
        return "redirect:/";
    }



}




















