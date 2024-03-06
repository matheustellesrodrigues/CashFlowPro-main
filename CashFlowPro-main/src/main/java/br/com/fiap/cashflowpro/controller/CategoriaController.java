package br.com.fiap.cashflowpro.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.fiap.cashflowpro.model.Categoria;

@Controller
public class CategoriaController {

    Logger log = LoggerFactory.getLogger(getClass());

    List<Categoria> repository = new ArrayList<>();

    @RequestMapping(method=RequestMethod.GET , path="/categoria")//n precisa mais d: produces = "application/json"
    @ResponseBody
    public List<Categoria> index(){
        return repository;
    }

    @RequestMapping(method=RequestMethod.POST ,path="/categoria")
    @ResponseBody
    //@ResponseStatus(code = HttpStatus.CREATED)//vai responder com 201, q é o codigo d criação
    
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria){
        // categoria.setId(new Random().nextLong()); //esse codigo é responsabilidade da Categoria, e n deve estar aqui
        log.info("cadastrando categoria: {}", categoria);
        repository.add(categoria);
        return ResponseEntity.status(201).body(categoria);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/categoria/{id}")
    @ResponseBody
    public ResponseEntity<Categoria> get (@PathVariable() Long id) {
        log.info("buscando categoria com id {}", id);

        //stream
        var categoria = repository
            .stream()
            .filter(c -> c.id().equals(id))
            .findFirst(); //esses codigo filtra por id e pega o primeiro resultado
        
        if (categoria.isEmpty()){
                return ResponseEntity.status(404).build();
            }
                return ResponseEntity.status(200).body(categoria.get());
    }


}
