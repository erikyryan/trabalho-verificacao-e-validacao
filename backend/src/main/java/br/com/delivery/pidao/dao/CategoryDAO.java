package br.com.delivery.pidao.dao;

import br.com.delivery.pidao.entities.Category;
import br.com.delivery.pidao.repositories.CategoryRepository;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class CategoryDAO {

    private CategoryRepository categoryRepository;

    public Category isPresent(String details,Long idMenu){
        Optional<Category> category = categoryRepository.findByDetailsAndIdmenu(details,idMenu);
        return category.isPresent() ? category.get() : null;
    }

    public Category isPresent(String details){
        Optional<Category> category = categoryRepository.findByDetails(details);
        return category.isPresent() ? category.get() : null;
    }

}
