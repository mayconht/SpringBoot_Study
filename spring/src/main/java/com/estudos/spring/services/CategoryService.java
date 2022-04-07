package com.estudos.spring.services;

import com.estudos.spring.domain.Category;
import com.estudos.spring.repositories.CategoryRepository;
import com.estudos.spring.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {


    @Autowired // Injeção de Dependencia, não há necessidade de instanciar. (inversão de controle)
    private CategoryRepository repo;

    public Category find(final Integer id) {
        final Optional<Category> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Category not found: " + id + ", Type: " + Category.class.getName()));
    }

    public List<Category> findAll() {
        return repo.findAll();
    }

    public Category insert(final Category obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public void update(final Category obj) {
        find(obj.getId());
        repo.save(obj);
    }

    public void delete(final Integer id) {
        find(id);
        repo.deleteById(id);

    }
}
