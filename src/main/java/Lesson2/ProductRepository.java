package Lesson2;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {
    List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(new Product(1L, "Milk", 10),
                new Product(2L, "Bread", 5),
                new Product(3L, "Butter", 20),
                new Product(4L, "Potato", 3),
                new Product(5L, "Apple", 5),
                new Product(6L, "Meet", 30),
                new Product(7L, "Egg", 2),
                new Product(8L, "Ketchup", 10),
                new Product(9L, "Spaghetti", 7),
                new Product(10L, "Salt", 1)));
    }

    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().get();
    }

    public List<Product> findByAll() {
        return products;
    }

    public void saveNewProduct(Product product){
        Long newId = products.stream().mapToLong(Product::getId).max().getAsLong() + 1;
        product.setId(newId);
        products.add(product);
    }
}
