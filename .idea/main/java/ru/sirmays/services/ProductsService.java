package ru.sirmays.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sirmays.model.Product;
import ru.sirmays.repositories.ProductsRepository;

import java.util.List;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> findAll(){
        return productsRepository.findAll();
    }

    public void addProduct (Product product){
        productsRepository.addProduct(product);
    }

    public Product  getById(Long id){
        return  productsRepository.getById(id);
    }
    public void costUp (Long id){
       (productsRepository.getById(id)).setCost((productsRepository.getById(id)).getCost()+1);
    }

    public void costDown (Long id){
        (productsRepository.getById(id)).setCost((productsRepository.getById(id)).getCost()-1);
    }
}
