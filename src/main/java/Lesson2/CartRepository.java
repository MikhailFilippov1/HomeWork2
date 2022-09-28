package Lesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static java.lang.System.out;

@Component
public class CartRepository {
    List<Cart> carts;

    @PostConstruct
    public void init() {
        carts = new ArrayList<>(10);    //Как лучше инициализировать?
    }

    private ProductService productService;

    @Autowired
    public CartRepository(ProductService productService) {
        this.productService = productService;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Cart cart) {
        this.carts.add(cart);
    }

    public void printCart(int numCart){
//        carts.stream().map((s) -> s + " ").forEach((s) -> out.print(s));
        List<Long> tmp;
        tmp = carts.get(numCart).ids;   //Количество продуктов в корзине
        out.println("Cart#" + numCart);
        for (int i = 0; i < tmp.size(); i++) {
            Long tmpId = carts.get(numCart).ids.get(i); //Берем id из списка корзины numCart
            out.println("Id:" + tmpId + " Title:" + productService.findById(tmpId).getTitle() + " Price:" + productService.findById(tmpId).getPrice());
        }
    }

        public void deleteFromCart(int numCart, Long id){        //Тут тоже идентификация корзин нужна, поэтому не доделал
            List<Long> tmp;                                 //Нужно ли возвращать false, если не удалилось по каким-то причинам???
            tmp = carts.get(numCart).ids;
            for (int i = tmp.size() - 1; i >= 0; i--) {
                if(carts.get(numCart).ids.get(i).equals(id)){    //Берем id из списка корзины numCart и сравниваем с id в параметре
                    carts.get(numCart).ids.remove(i);
                }
            }
    }
}
