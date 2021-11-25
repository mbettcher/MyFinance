package br.com.mtonon.myfinance.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.mtonon.myfinance.domain.Usuario;
import br.com.mtonon.myfinance.repository.UsuarioRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class UsuarioServiceTests {

	@InjectMocks
	UsuarioService usuarioService;

	@Mock
	UsuarioRepository repository;

	@Test
	public void testDeveValidarEmail() {
		// Arrange
		repository.deleteAll();

		// Act
		usuarioService.validateEmail("mtonon.pmg@gmail.com");

		verify(repository, times(1)).existsByEmail("mtonon.pmg@gmail.com");
	}

	@Test
	public void testDeveLancarErroAoValidarEmailQuandoExistirEmailCadastrado() {
		// Arrange
		Usuario usuario = new Usuario(null, "Marcelo Tonon Bettcher", "mtonon.pmg@gmail.com", "123");
		repository.save(usuario);

		// Act
		usuarioService.validateEmail("mtonon.pmg@gmail.com");

		verify(repository, times(1)).existsByEmail("mtonon.pmg@gmail.com");

	}

}
