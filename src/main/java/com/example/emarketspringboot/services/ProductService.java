package com.example.emarketspringboot.services;


import com.example.emarketspringboot.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private long ID = 0;

    {
        products.add(new Product(++ID,"fdf","efwe",67000,"fwefe","wfewf"));
        products.add(new Product(++ID,"fdf","efwe",67000,"fwefe","wfewf"));
    }

    public List<Product> list(){return products;}

    public void saveProducts(Product product) {
        product.setId(++ID);
        products.add(product);
    }
    public void deleteProducts(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    public Product getProductById(Long id) {
        for (Product product : products){
            if (product.getId().equals(id)) return product;
        }
        return null;
    }
}















