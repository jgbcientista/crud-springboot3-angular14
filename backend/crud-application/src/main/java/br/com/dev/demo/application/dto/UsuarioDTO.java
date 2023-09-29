package br.com.dev.demo.application.dto;

public class UsuarioDTO {

	private Long id;

//	@NotBlank
//	@Length(min = 1, max =100, message = "Campo de preenchimento obrigatório")
//	@JsonProperty(value = "nome")
	private String nome;

//	@NotBlank
//	@Length(min = 1, max =100, message = "Campo de preenchimento obrigatório")
//	@JsonProperty(value = "email")
	private String email;

//	@NotBlank
//	@Length(min = 1, max =30, message = "Campo de preenchimento obrigatório")
//	@JsonProperty(value = "login")
	private String login;

//	@NotBlank
//	@Length(min = 1, max =30, message = "Campo de preenchimento obrigatório")
//	@JsonProperty(value = "senha")
	private String senha;

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
