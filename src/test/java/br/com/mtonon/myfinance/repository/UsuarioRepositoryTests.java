package br.com.mtonon.myfinance.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.mtonon.myfinance.domain.Usuario;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UsuarioRepositoryTests {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Test
	public void testVerificarEmailEstaCadastrado() {
		//Arrange
		Usuario usuario = new Usuario(null, "Marcelo Tonon Bettcher", "mtonon.pmg@gmail.com", "123");
		usuarioRepository.save(usuario);
		
		//Act
		boolean result = usuarioRepository.existsByEmail("mtonon.pmg@gmail.com");
		
		//Assert
		Assertions.assertEquals(true, result);
	}

}
