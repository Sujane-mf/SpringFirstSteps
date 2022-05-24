package ru.geekbrains.spring.lesson2.MainApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.spring.lesson2.Shop.Cart;
import ru.geekbrains.spring.lesson2.Shop.ProductRepository;
import ru.geekbrains.spring.lesson2.config.AppConfig;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductRepository pr1 = context.getBean(ProductRepository.class);
        System.out.println("Добро пожаловать в магазин");
        pr1.getProducts();
        Cart cart = pr1.getCart();
        System.out.println(
                "Доступный список действий: " + "\n" +
                        "/add - добавить товар в корзину" + "\n" +
                        "/delete - удалить товар из корзины" + "\n" +
                        "/end - завершить покупку"
        );
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("Введите действие в заданном формате: ");
            String str = sc.nextLine();
            if (str.equals("/add")){
                System.out.println("Введи ID товара из списка доступных товаров");
                Integer id = Integer.parseInt(sc.nextLine());
                pr1.addProductToCartByID(cart, id);
            }
            if (str.equals("/delete")){
                System.out.println("Введи ID товара для удаления из корзины");
                Integer id = Integer.parseInt(sc.nextLine());
                pr1.deleteProductFromCartById(cart, id);
            }
            if(str.equals("/end") ){
                break;
            }
        }
    }

}
