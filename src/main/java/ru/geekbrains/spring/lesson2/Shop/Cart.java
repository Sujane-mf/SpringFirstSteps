package ru.geekbrains.spring.lesson2.Shop;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Cart {
    private List<Product> productsInCart;

    public Cart(List<Product> productsInCart) {
        this.productsInCart = productsInCart;
    }

    public List<Product> getProductsInCart() {
        return productsInCart;
    }

    public void showCart(){
        System.out.println("Список продуктов в корзине: ");
        for (Product product : productsInCart){
            System.out.println(product.toString());
        }

    }
}
