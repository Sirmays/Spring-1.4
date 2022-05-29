package ru.sirmays.repositories;

import org.springframework.stereotype.Component;
import ru.sirmays.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductsRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        this.products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Хлеб", 100),
                new Product(2L, "Сок", 200),
                new Product(3L, "Молоко", 300),
                new Product(4L, "Помидор", 500),
                new Product(5L, "Вода", 500)
        ));
    }

    public List<Product> findAll(){
        return Collections.unmodifiableList(products);
    }
    public void addProduct (Product product){
        products.add(product);
    }

    public Product  getById(Long id){
        return products.stream().filter(product -> product.getId().equals(id)).findFirst().get();
    }
}
