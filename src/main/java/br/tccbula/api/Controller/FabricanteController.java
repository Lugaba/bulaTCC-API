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

import br.tccbula.api.Entity.Fabricante;
import br.tccbula.api.Repository.FabricanteRepository;

@RestController
public class FabricanteController {
    @Autowired
    private FabricanteRepository repository;

    @RequestMapping(value = "fabricantes", method = RequestMethod.POST)
    public ResponseEntity<Fabricante> createItem(@Valid @RequestBody Fabricante fabricante) {
        repository.save(fabricante);
        return new ResponseEntity<Fabricante>(fabricante, HttpStatus.OK);
    }

    @RequestMapping(value = "fabricantes", method = RequestMethod.GET)
    public ResponseEntity<List<Fabricante>> getAllItems() {
        return new ResponseEntity<List<Fabricante>>(repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/fabricantes/{fabricanteID}", method = RequestMethod.DELETE)
    public ResponseEntity<Fabricante> deleteItem(@PathVariable(value = "fabricanteID") long fabricanteID) {
        Optional<Fabricante> response = repository.findById(fabricanteID);

        if (!response.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            repository.delete(response.get());
            return new ResponseEntity<Fabricante>(HttpStatus.OK);
        }

    }
}