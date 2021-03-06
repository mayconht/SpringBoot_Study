package com.estudos.spring.resources;

import com.estudos.spring.domain.Category;
import com.estudos.spring.dto.CategoryDTO;
import com.estudos.spring.services.CategoryService;
import com.estudos.spring.services.exceptions.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

//Classe controladora Rest

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> find(@PathVariable final Integer id) {

        final Category obj = service.find(id);

        return ResponseEntity.ok(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Category obj) {
        obj = service.insert(obj);
        final URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();

        return ResponseEntity.created(uri).build();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Category> update(@PathVariable final Integer id, @RequestBody final Category obj) {

        obj.setId(id);
        service.update(obj);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable final Integer id) {

        try {
            service.delete(id);
        } catch (final DataIntegrityViolationException e) {
            throw new DataIntegrityException("Not able to delete a category that has products associated to it");
        }
        return ResponseEntity.noContent().build();

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CategoryDTO>> findAll() {
        final List<Category> catList = service.findAll();
        final List<CategoryDTO> listDTO = catList.stream().map(CategoryDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
}

