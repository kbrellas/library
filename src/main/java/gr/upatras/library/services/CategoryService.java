package gr.upatras.library.services;

import gr.upatras.library.models.Category;
import gr.upatras.library.models.Error;
import gr.upatras.library.models.GenericResponse;
import gr.upatras.library.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo repo;

    public CategoryService(CategoryRepo repo) {
        this.repo = repo;
    }

    public GenericResponse<List<Category>> getAllCategories(){
        try{
            Iterable<Category> retrievedCategories = repo.findAll();
            List<Category> categories = new ArrayList<>();
            for (Category category : retrievedCategories) {
                categories.add(category);
            }
            if (categories.isEmpty()) {
                return new GenericResponse<>(new Error(0, "Empty Repository", "Please add Category"));
            }
            return new GenericResponse<>(categories);
        }catch(Exception e){
            e.printStackTrace();
            return new GenericResponse<>(new Error(0,"Internal Server Error","Unable to retrieve data"));
        }
    }
}
