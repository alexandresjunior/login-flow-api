package com.login.flow.api.model;

import org.hibernate.annotations.Table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TipoUsuario")


public class TipoUsuario {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoUsuario;

	@Column(nullable = false)
	private String nome;

	@OneToOne
	@JoinColumn(name = "Usuario_id")
	private Usuario usuario;

}
