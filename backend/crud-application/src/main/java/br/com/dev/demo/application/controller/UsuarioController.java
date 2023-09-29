package br.com.dev.demo.application.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev.demo.application.dto.UsuarioDTO;
import br.com.dev.demo.application.entity.UsuarioEntity;
import br.com.dev.demo.application.service.UsuarioService;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/usuario/v1")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;

	// get all users
	@GetMapping("/todos")
	public List<UsuarioEntity> getAllUsers() {
		return usuarioService.getAllUsers();
	}

	// create user rest API
	@PostMapping("/adicionar")
	public UsuarioEntity criar(@RequestBody UsuarioDTO usuario) {
		return usuarioService.salvar(usuario);
	}

	// get user by id rest api
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioEntity> obterPorId(@PathVariable Long id) {
		return ResponseEntity.ok(usuarioService.obterPorId(id));
	}

	// update user rest api
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<UsuarioEntity> atualizar(@PathVariable Long id, @RequestBody UsuarioEntity usuarioUpdate) {
		return ResponseEntity.ok(usuarioService.atualizar(id, usuarioUpdate));
	}

	// delete user rest api
	@DeleteMapping("/remover/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id) {
		usuarioService.remover(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Removido", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
