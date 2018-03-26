package com.example.demospringboot.resources;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demospringboot.error.ResourceNotFoundExecption;
import com.example.demospringboot.models.Ata;
import com.example.demospringboot.repository.AtaRepository;

@RestController
@RequestMapping("atas")
@Transactional
public class AtaController {
	
	private final AtaRepository ataRepository;
	
	@Autowired
	public AtaController(AtaRepository ataRepository) {
		this.ataRepository = ataRepository;
	}

	@GetMapping
	public ResponseEntity<?> listar(Pageable pageable) {
		return new ResponseEntity<> (ataRepository.findAll(pageable), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Ata>> buscarPorId(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		verificarAtaExistente(id);
		return new ResponseEntity<Optional<Ata>>(ataRepository.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody @Valid Ata ata) {
		ataRepository.save(ata);
		return new ResponseEntity<Ata>(ata, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
		verificarAtaExistente(id);
		ataRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> atualizar(@RequestBody @Valid Ata ata) {
		verificarAtaExistente(ata.getId());
		ataRepository.save(ata);
		return new ResponseEntity<Ata>(ata, HttpStatus.OK);
	}
	
	private void verificarAtaExistente(Long id) {
		if(!ataRepository.existsById(id))
			throw new ResourceNotFoundExecption("Ata não encontrada com o id: "+id);
	}

}
