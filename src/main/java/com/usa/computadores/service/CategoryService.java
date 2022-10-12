package com.usa.computadores.service;

import com.usa.computadores.model.Category;
import com.usa.computadores.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category category){
        if(category.getId() == null){
            return categoryRepository.save(category);
        }else{
            Optional<Category> category1 = categoryRepository.getCategory(category.getId());
            if(category1.isEmpty()){
                return categoryRepository.save(category);
            }else{
                return category;
            }
        }
    }

    public Category update(Category category){
        if(category.getId() != null){
            Optional<Category> g = categoryRepository.getCategory(category.getId());
            if(!g.isEmpty()){
                if(category.getDescription() != null){
                    g.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    g.get().setName(category.getName());
                }
                return  categoryRepository.save(g.get());
            }
        }
        return category;
    }

    public boolean deleteCategory(int id){
        boolean dato = getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return dato;
    }

}
