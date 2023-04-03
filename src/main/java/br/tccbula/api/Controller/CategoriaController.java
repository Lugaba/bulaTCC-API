package br.tccbula.api.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.tccbula.api.Entity.Categoria;
import br.tccbula.api.Repository.CategoriaRepository;

@RestController
public class CategoriaController {
    @Autowired
    private CategoriaRepository repository;

    @RequestMapping(value = "categorias", method = RequestMethod.POST)
    public ResponseEntity<Categoria> createItem(@Valid @RequestBody Categoria categoria) {
        repository.save(categoria);
        return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
    }

    @RequestMapping(value = "categorias", method = RequestMethod.GET)
    public ResponseEntity<List<Categoria>> getAllItems() {
        return new ResponseEntity<List<Categoria>>(repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/categorias/{categoriaID}", method = RequestMethod.DELETE)
    public ResponseEntity<Categoria> deleteItem(@PathVariable(value = "categoriaID") long categoriaID) {
        Optional<Categoria> response = repository.findById(categoriaID);
        if (response.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            repository.delete(response.get());
            return new ResponseEntity<Categoria>(HttpStatus.OK);
        }

    }
}