package br.com.dev.demo.application.entity;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "TB_USUARIO")
public class UsuarioEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Length(min = 1, max =100, message = "Campo de preenchimento obrigatório")
	@JsonProperty(value = "nome")
	@Column(name = "NOME", length = 30, nullable = false, unique = false)
	private String nome;

	@Column(name = "EMAIL", length = 50, nullable = false, unique = true)
	@NotBlank
	@Length(min = 1, max =100, message = "Campo de preenchimento obrigatório")
	@JsonProperty(value = "email")
	private String email;

	@NotBlank
	@Length(min = 1, max =30, message = "Campo de preenchimento obrigatório")
	@JsonProperty(value = "login")
	@Column(name = "LOGIN", length = 30, nullable = false, unique = true)
	private String login;

	@NotBlank
	@Length(min = 1, max =30, message = "Campo de preenchimento obrigatório")
	@JsonProperty(value = "senha")
	@Column(name = "SENHA", length = 30, nullable = false, unique = false)
	private String senha;

	public UsuarioEntity() {
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}