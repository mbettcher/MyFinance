package br.com.mtonon.myfinance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mtonon.myfinance.domain.Usuario;
import br.com.mtonon.myfinance.repository.UsuarioRepository;
import br.com.mtonon.myfinance.service.exception.RegraNegocioException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;

	public Usuario login(String email, String senha) {
		return null;
	}
	
	public Usuario save(Usuario usuario) {
		return null;
	}
	
	public void validateEmail(String email) {
		
		boolean existe = repository.existsByEmail(email);
		if(existe) {
			throw new RegraNegocioException("Já existe um usuário cadastrado com este e-mail!");
		}
		
	}
}
