package gr.upatras.library.services;

import gr.upatras.library.models.GenericResponse;
import gr.upatras.library.models.Product;
import gr.upatras.library.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gr.upatras.library.models.Error;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repo;

    public ProductService(ProductRepo repo) {
        this.repo = repo;
    }

    public GenericResponse<List<Product>> getAllProducts(){
        try{
            Iterable<Product> retrievedProducts = repo.findAll();
            List<Product> products = new ArrayList<>();
            for (Product product : retrievedProducts) {
                products.add(product);
            }
            if (products.isEmpty()) {
                return new GenericResponse<>(new Error(0, "Empty Repository", "Please add Product"));
            }
            return new GenericResponse<>(products);
        }catch(Exception e){
            e.printStackTrace();
            return new GenericResponse<>(new Error(0,"Internal Server Error","Unable to retrieve data"));
        }
    }
}
