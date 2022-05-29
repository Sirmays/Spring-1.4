package ru.sirmays.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sirmays.model.Product;
import ru.sirmays.services.ProductsService;

import java.util.List;


@Controller
public class ProductsController {
    private ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    // GET http://localhost:8080/app/show_all
    @GetMapping(value = "/show_all")
    public String showProductsPage(Model model) {
        model.addAttribute("products", productsService.findAll());
        return "products";
    }

    // GET http://localhost:8080/app/show/{id}
    @GetMapping(value = "/show/{id}")
    public String showProductPageById(Model model, @PathVariable Long id) {
        model.addAttribute("product", productsService.getById(id));
        return "product_info";
    }

    @GetMapping(value = "/costUp/{id}")
    public String costUp(@PathVariable Long id) {
      productsService.costUp(id);
        return "redirect:/show_all";
    }

    @GetMapping(value = "/costDown/{id}")
    public String costDown(@PathVariable Long id) {
        productsService.costDown(id);
        return "redirect:/show_all";
    }

//    @GetMapping(value = "/costUp/{id}")
//    public String costUp() {
//        return "show_all";
//    }



    // POST http://localhost:8080/app/create}
    @PostMapping(value = "/create")
    public String saveProduct(@RequestParam Long id, @RequestParam String title, @RequestParam int cost) {
        productsService.addProduct(new Product(id, title, cost));
        return "redirect:show_all";
    }

    // GET http://localhost:8080/app/create}
    @GetMapping(value = "/create")
    public String createProduct() {
        return "create_product";
    }

//    // GET http://localhost:8080/app/show_all
//    @GetMapping(value = "/show_all")
//    @ResponseBody
//    public List<Product> showAll() {
//        return productsService.findAll();
//    }
//

//    @GetMapping("/info")
//    @ResponseBody
//    public String demoInfo() {
//        return "Hello World!";
//    }
//
//    // GET http://localhost:8080/app/echo?word=Hello&num=123
//    @GetMapping(value = "/echo", produces = MediaType.TEXT_HTML_VALUE)
//    @ResponseBody
//    public String demoEcho(@RequestParam String word, int num) {
//        return "Echo: " + word + " " + num * 2;
//    }
//
//    // GET http://localhost:8080/app/product/{id}
//    @GetMapping(value = "/product/{id}")
//    @ResponseBody
//    public Product demoProduct(@PathVariable Long id) {
//        return new Product(id, "Хлеб", 100);
//    }
}
