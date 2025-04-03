package leandro.marcos.spring_study.resources;

import leandro.marcos.spring_study.dtos.CategoryDTO;
import leandro.marcos.spring_study.entities.Category;
import leandro.marcos.spring_study.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(){
        List<CategoryDTO> categories = categoryService.findAll();

        return ResponseEntity.ok().body(categories);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id){
        CategoryDTO category = categoryService.findById(id);

        return ResponseEntity.ok().body(category);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> insert(CategoryDTO categoryDTO) {
        categoryDTO = categoryService.insert(categoryDTO);

        return ResponseEntity.ok().body(categoryDTO);
    }
    }