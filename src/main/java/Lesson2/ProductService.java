package Lesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {

    private ProductRepository productRepository;    //Почему просит сделать его final?

    @Autowired
    public ProductService(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    public int getSumPrice(){

        return productRepository.findByAll().stream().mapToInt(Product::getPrice).sum();
    }

    public Product findById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findByIds(List<Long> ids) {

        return productRepository.findByAll();
    }

    public List<Product> findByAll() {

        return productRepository.findByAll();
    }

    public void saveNewProduct(Product product){

        productRepository.saveNewProduct(product);
    }
}
