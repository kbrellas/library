package gr.upatras.library;

import gr.upatras.library.models.Category;
import gr.upatras.library.models.Product;
import gr.upatras.library.repositories.CategoryRepo;
import gr.upatras.library.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {

	@Autowired
	ProductRepo productRepo;

	@Autowired
	CategoryRepo categoryRepo;

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product product1 = new Product("Lord of the Rings","LOTR1",49.90,1);
		Product product2 = new Product("Harry Potter","HP1",49.90,2);

		productRepo.save(product1);
		productRepo.save(product2);

		List<Product> productList = new ArrayList<>();
		productList.add(product1);
		productList.add(product2);

		Category category1 = new Category("Fantasy",productList);
		categoryRepo.save(category1);
	}

}
