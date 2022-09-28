package Lesson2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductService productService = context.getBean(ProductService.class);
        CartService cartService = context.getBean(CartService.class);

        List<Long> ids;
        ids = new ArrayList<>(Arrays.asList(new Long(1L), new Long(2L))); //Не пойму, почему подсвечивает
        cartService.putToCart(ids);
        List<Long> ids1;
        ids1 = new ArrayList<>(Arrays.asList(new Long(5L), new Long(10L), new Long(3L), new Long(5L)));
        cartService.putToCart(ids1);

        System.out.println("\n After pushing products!!!");
        cartService.printAllCarts();

        cartService.deleteFromCartById(0, 1L);
        cartService.deleteFromCartById(1, 5L);

        System.out.println("\n After delete!!!");
        cartService.printAllCarts();

        context.close();
    }
}
