package Lesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartService {

    private ProductService productService;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    public CartService(ProductService productService) {
        this.productService = productService;
    }

    public void putToCart(List<Long> ids){  //Нужно,конечно, по одному продукту добавлять, а не списком
                                            //Но для этого user'а надо вводить, чтобы корзины идентифицировать
        Cart cart = new Cart();     //Правильно ли здесь создавать корзину?
        cart.setIds(ids);
        cartRepository.setCarts(cart);
    }

    public void deleteFromCartById(int numCart, Long id){
        cartRepository.deleteFromCart(numCart, id);
    }

    public void printAllCarts(){
        List<Cart> carts;
        carts = cartRepository.getCarts();
//        carts.stream().filter(i -> i.getId().equals(id)).findFirst().get(); // С этим не стал возиться
//        carts.stream().map((s) -> s + " ").forEach((s) -> cartRepository.printCart(s));
        for (int i = 0; i < carts.size(); i++) { //Пока печатаем все карты из массива карт
            cartRepository.printCart(i);         //Когда запилим user'а будем печатать корзину user'а по имени
        }
    }
}
