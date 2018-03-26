package com.example.demospringboot.models.auth;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
@Entity
@Table(name="SEC_ROLE")
public class Role implements GrantedAuthority {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_role_id")
    @SequenceGenerator(sequenceName = "seq_role_id", allocationSize = 1, name = "seq_role_id")
	private Long id;
	
	@NotBlank
	private String authority;
	@ManyToMany(mappedBy = "roles")
	private List<User> users;
	

}
