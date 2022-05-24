package ru.geekbrains.spring.lesson2.Shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.inject.Provider;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products;
    private Provider<Cart> cartProvider;

    @Autowired
    public ProductRepository(List<Product> products) {
        this.products = products;
    }

    @Autowired
    public void setCartProvider(Provider<Cart> cartProvider)
    {
        this.cartProvider = cartProvider;
    }

    @PostConstruct
    public void setProducts(){
        products.add(new Product(001,"Milk",5));
        products.add(new Product(002,"Book",10));
        products.add(new Product(003,"Box",1));
        products.add(new Product(004,"Plate",7));
        products.add(new Product(005,"Cup",3));
    }
    // Посмотреть список продуктов в магазине
    public void getProducts() {
        System.out.println("Доступный список товаров: ");
        for (Product product : products){
            System.out.println(product.toString());
        }
    }
    // Получить продукт по его ID
    public Product getProductByID(Integer id){return products.stream().filter(s -> s.getId().equals(id)).findFirst().get();}


    // Запрос клиентской корзины при старте работы с магазином
    public Cart getCart(){
        Cart cart = cartProvider.get();
        return cart;
    }



    public void addProductToCartByID(Cart cart, Integer id){
        cart.getProductsInCart().add(getProductByID(id));
        cart.showCart();
    }

    public void deleteProductFromCartById(Cart cart, Integer id){
        cart.getProductsInCart().remove(getProductByID(id));
        cart.showCart();
    }


}
