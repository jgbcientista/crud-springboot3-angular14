package br.com.dev.demo.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.demo.application.dto.UsuarioDTO;
import br.com.dev.demo.application.entity.UsuarioEntity;
import br.com.dev.demo.application.exception.ResourceNotFoundException;
import br.com.dev.demo.application.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public UsuarioEntity obterPorId(Long id) {
		UsuarioEntity usuarioEntity = usuarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("UsuarioEntity nao existe com o id: " + id));
		return usuarioEntity;
	}

	public List<UsuarioEntity> getAllUsers() {
		return usuarioRepository.findAll();
	}

	public UsuarioEntity salvar(UsuarioDTO usuario) {
		
		UsuarioEntity entity = new UsuarioEntity();
		entity.setEmail(usuario.getEmail());
		entity.setId(usuario.getId());
		entity.setLogin(usuario.getLogin());
		entity.setNome(usuario.getNome());
		entity.setSenha(usuario.getSenha());

		return usuarioRepository.save(entity);
	}

	public UsuarioEntity atualizar(Long id, UsuarioEntity usuarioUpdate) {

		UsuarioEntity usuarioEntity = obterPorId(id);

		usuarioEntity.setNome(usuarioUpdate.getNome());
		usuarioEntity.setEmail(usuarioUpdate.getEmail());
		usuarioEntity.setLogin(usuarioUpdate.getLogin());
		usuarioEntity.setSenha(usuarioUpdate.getSenha());

		return usuarioRepository.save(usuarioEntity);
	}

	public void remover(Long id) {
		usuarioRepository.delete(obterPorId(id));
	}

}