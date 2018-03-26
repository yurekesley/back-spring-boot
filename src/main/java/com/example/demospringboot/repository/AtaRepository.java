package com.example.demospringboot.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demospringboot.models.Ata;

public interface AtaRepository extends PagingAndSortingRepository<Ata, Long> {
	

}
