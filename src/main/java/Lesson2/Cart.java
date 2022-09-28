package Lesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Scope("prototype")
public class Cart {
List<Long> ids;             //Это лист id'шников. Потом нужно будет добавить user'а, чтобы идентифицировать корзину
                            //Также можно добавить сумму цен всех товаров, кол-во товаров, вес и т.д.

    public Cart(List<Long> ids) {
        this.ids = ids;
    }

    public Cart() {

    }

    public List<Long> getIds() {
        return ids;
    }   //Возвращает сразу весь список из корзины

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }   //Вставляет сразу весь список в корзину

    @Override
    public String toString() {
        return "Cart include : [" +
                "id=" + ids +
                ']' + "\n";
    }
}
