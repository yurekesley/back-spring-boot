package com.example.demospringboot.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demospringboot.repository.AtaRepository;

import com.example.demospringboot.models.Ata;

@RestController
@RequestMapping("ata")
public class AtaResource {
	
	@Autowired
	private AtaRepository ar;
	
	@GetMapping
	  public ResponseEntity<List<Ata>> listarTodos() {
	    return new ResponseEntity<List<Ata>>(new ArrayList<Ata>(ar.findAll()), HttpStatus.OK);
	 }
	
	@GetMapping("/{id}")
	public ResponseEntity<Ata> buscarPorId(@PathVariable("id") Integer id) {
	Ata ata = ar.findById(id);
	  if (ata == null) {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }else {
		  return new ResponseEntity<Ata>(ata, HttpStatus.OK);
       }
	}
	
	@GetMapping("/pesquisar")
	public ResponseEntity<List<Ata>> pesquisar(@RequestParam(required = false) String nome, 
												@RequestParam(required = false) String ano,
												@RequestParam(required = false) String mes) {
		List<Ata> atas = ar.findByNomeOrAnoOrMes(nome,ano,mes);
		return new ResponseEntity<List<Ata>>(new ArrayList<Ata>(atas), HttpStatus.OK);
	}
	
	@PostMapping
    public ResponseEntity < Ata > salvar(@RequestBody @Valid Ata ata) {
			ar.save(ata);
            return new ResponseEntity<Ata>(ata, HttpStatus.CREATED);
        
    }
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Ata> atualizar(@RequestBody Ata ata, @PathVariable long id) {
		Ata ata_ = ar.findById(id);
		if (ata_ == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			ata.setId(id);			
			ar.save(ata);
  	        return new ResponseEntity<Ata>(HttpStatus.NO_CONTENT);
		}

	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") int id) {
    	   Ata ata = ar.findById(id);
    	  if (ata == null) {
    	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	  }else {
  	        ar.delete(ata);
  	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	  }
    	 
    	}
	
	
	
	
}
