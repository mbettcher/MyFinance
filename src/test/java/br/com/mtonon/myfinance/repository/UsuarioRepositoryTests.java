package br.com.mtonon.myfinance.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.mtonon.myfinance.domain.Usuario;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
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
	
	@Test
	public void testDeveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComEmail() {
		//Arrange
		usuarioRepository.deleteAll();
		
		//Act
		boolean result = usuarioRepository.existsByEmail("mtonon.pmg@gmail.com");
		//Assert
		Assertions.assertEquals(false, result);
	}

}
