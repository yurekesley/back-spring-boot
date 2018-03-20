package com.example.demospringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.example.demospringboot.models.Ata;

public interface AtaRepository extends JpaRepository<Ata, Long>, JpaSpecificationExecutor<Ata> {
	Ata findById(long id);
	List<Ata> findByNomeOrAnoOrMes(String nome, String ano, String mes);

}
