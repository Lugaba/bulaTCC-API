package br.tccbula.api.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.tccbula.api.DTO.BulaDTO;
import br.tccbula.api.DTO.BulaDTOPost;
import br.tccbula.api.Entity.Bula;
import br.tccbula.api.Entity.Categoria;
import br.tccbula.api.Entity.Fabricante;
import br.tccbula.api.Repository.BulaRepository;
import br.tccbula.api.Repository.CategoriaRepository;
import br.tccbula.api.Repository.FabricanteRepository;

@RestController
public class BulaController {
    @Autowired
    private BulaRepository repository;

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @RequestMapping(value = "fabricantes/{fabricanteID}/bulas", method = RequestMethod.POST)
    public ResponseEntity<BulaDTO> createItem(@Valid @RequestBody BulaDTOPost bulaDTO,
            @PathVariable(value = "fabricanteID") long fabricanteID) {
        Fabricante fabricante = fabricanteRepository.getReferenceById(fabricanteID);
        if (fabricante != null) {
            Bula bula = new Bula();
            bula.setBulaCompletaURL(bulaDTO.getBulaCompletaURL());
            bula.setContraindicacao(bulaDTO.getContraindicacao());
            bula.setEfeitosColaterais(bulaDTO.getEfeitosColaterais());
            bula.setImagesURL(bulaDTO.getImagesURL());
            bula.setIndicacao(bulaDTO.getIndicacao());
            bula.setNome(bulaDTO.getNome());
            bula.setPosologia(bulaDTO.getPosologia());
            bula.setInteracoesMedicamentosas(bulaDTO.getInteracoesMedicamentosas());
            bula.setFabricante(fabricante);

            List<Categoria> categorias = categoriaRepository.findAllById(bulaDTO.getCategoriasID());

            bula.setCategorias(categorias);

            Bula novaBula = repository.save(bula);

            ModelMapper modelMapper = new ModelMapper();
            BulaDTO bulaDTO1 = modelMapper.map(novaBula, BulaDTO.class);
            return new ResponseEntity<BulaDTO>(bulaDTO1, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "bulas", method = RequestMethod.GET)
    public ResponseEntity<List<BulaDTO>> getAllItems() {
        ArrayList<BulaDTO> bulasDTO = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (Bula bula : repository.findAll()) {
            System.out.println(bula.getCategorias());
            BulaDTO bulaDTO = modelMapper.map(bula, BulaDTO.class);
            bulasDTO.add(bulaDTO);
        }

        return new ResponseEntity<List<BulaDTO>>(bulasDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "bulas/{bulaID}", method = RequestMethod.GET)
    public ResponseEntity<Bula> getById(@PathVariable(value = "bulaID") long bulaID) {
        Optional<Bula> bulaResponse = repository.findById(bulaID);
        if (bulaResponse.isPresent()) {
            return new ResponseEntity<Bula>(bulaResponse.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Bula>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/bulas/{bulaID}", method = RequestMethod.DELETE)
    public ResponseEntity<Bula> deleteItem(@PathVariable(value = "bulaID") long bulaID) {
        Optional<Bula> response = repository.findById(bulaID);
        if (!response.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            repository.delete(response.get());
            return new ResponseEntity<Bula>(HttpStatus.OK);
        }

    }
}