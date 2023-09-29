package br.com.dev.demo.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.demo.application.entity.Usuario;
import br.com.dev.demo.application.exception.ResourceNotFoundException;
import br.com.dev.demo.application.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario obterPorId(Long id) {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario nao existe com o id: " + id));
		return usuario;
	}

	public List<Usuario> getAllUsers() {
		return usuarioRepository.findAll();
	}

	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario atualizar(Long id, Usuario usuarioUpdate) {

		Usuario usuario = obterPorId(id);

		usuario.setNome(usuarioUpdate.getNome());
		usuario.setEmail(usuarioUpdate.getEmail());
		usuario.setLogin(usuarioUpdate.getLogin());
		usuario.setSenha(usuarioUpdate.getSenha());

		return usuarioRepository.save(usuario);
	}

	public void remover(Long id) {
		usuarioRepository.delete(obterPorId(id));
	}

}