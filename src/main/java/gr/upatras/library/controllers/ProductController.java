package gr.upatras.library.controllers;

import gr.upatras.library.models.GenericResponse;
import gr.upatras.library.models.Product;
import gr.upatras.library.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getAllProducts")
    public ResponseEntity getAllProducts(){
        GenericResponse<List<Product>> response = productService.getAllProducts();
        if(response.getError() != null)
            return new ResponseEntity<>(
                    response.getError(),
                    null,
                    HttpStatus.INTERNAL_SERVER_ERROR
            );

        return new ResponseEntity<>(
                response.getData(),
                null,
                HttpStatus.OK);
    }
}
