package com.generationtestetdd.SprintTDD.contato;

import javax.validation.ConstraintViolationException;

import org.aspectj.lang.annotation.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.generationtestetdd.SprintTDD.models.ContatoModel;
import com.generationtestetdd.SprintTDD.repository.ContatoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest 
public class ContatosRepositoryIntegrationTest{

	private ContatoModel contato;

	@Autowired
	private ContatoRepository contatoRepository;

	@Before(value = "")
	public void start() {
		contato = new ContatoModel("Gabriel", "011y", "9xxxxxxx9");
	}

	@Rule
	public ExpectedException esperadaExcecao = ExpectedException.none();

	@Test
	public void salvarComTelNulo() throws Exception {
		esperadaExcecao.expect(ConstraintViolationException.class);
		esperadaExcecao.expectMessage("O Telefone deve ser preenchido");

		contato.setTelefone(null);
		contatoRepository.save(contato);
	}

	@Test
	public void salvarComDddNulo() throws Exception {
		esperadaExcecao.expect(ConstraintViolationException.class);
		esperadaExcecao.expectMessage("O DDD deve ser preenchido");

		contato.setDdd(null);
		contatoRepository.save(contato);
	}

	@Test
	public void salvarComNomeNulo() throws Exception {
		esperadaExcecao.expect(ConstraintViolationException.class);
		esperadaExcecao.expectMessage("O Nome deve ser preenchido");

		contato.setNome(null);
		contatoRepository.save(contato);
	}

}