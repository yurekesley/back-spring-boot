package com.example.demospringboot.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity	
public class Ata implements java.io.Serializable {
	
private static final long serialVersionUID = 1L;
	public Ata() {}
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust_ata_seq")
    @SequenceGenerator(sequenceName = "seq_ata_id", allocationSize = 1, name = "cust_ata_seq")
	private Long id;
	
	@NotBlank
	private String nome;
	
	private String ano;
	
	private String mes;
	
	
}
