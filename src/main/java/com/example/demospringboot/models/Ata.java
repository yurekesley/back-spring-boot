package com.example.demospringboot.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

@Entity
public class Ata implements java.io.Serializable {
	
private static final long serialVersionUID = 1L;
	
	public Ata() {}
	public Ata(Long id, String nome, String ano, String mes ) {
		this.id = id;
		this.nome = nome;
		this.mes = mes;
		this.ano = ano;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust_ata_seq")
    @SequenceGenerator(sequenceName = "seq_ata_id", allocationSize = 1, name = "cust_ata_seq")

	private Long id;
	
	@NotBlank
	private String nome;
	
	private String ano;
	
	private String mes;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}

}
