package Lab5;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RoboTest {

	private final int energy = 10;
	Sala sala;

	@Before
	public void criaRobo() throws Exception {
		sala = new Sala(10, 10);
		Robo robo = new Robo(energy, sala);
	}

	@Test
	public void testaCriaRobo() {
		try {
			new Robo(-1, sala);
			Assert.fail("Esperava excecao, pois a quantidade de energia esta errada.");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada",
					"Parametro incorreto para a criacao do robo. A energia deve ser representada por valore positivos maiores que zero",
					e.getMessage());
		}

		try {
			new Robo(0, sala);
			Assert.fail("Esperava excecao, pois a quantidade de energia esta errada.");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada",
					"Parametro incorreto para a criacao do robo. A energia deve ser representada por valore positivos maiores que zero",
					e.getMessage());
		}
		
		try {
			new Robo(10, null);
			Assert.fail("Esperava excecao, pois a quantidade de energia esta errada.");
		} catch (Exception e) {
			Assert.assertEquals(
					"Mensagem errada",
					"Parametro incorreto para a criacao do robo. A sala é nula",
					e.getMessage());
		}
	}
	
	@Test
	public void testaIsVazia() throws Exception {
		sala.sala[0][0] = new Robo(10, sala);
		Assert.assertTrue(sala.sala[0][0] != sala.LIVRE);
		Assert.assertFalse(sala.isVazia());
	}
	@Test
	public void testaVerificaPosicao() throws Exception {
		new Sala(10, 10);
		Robo robo = new Robo(10, sala);
		sala.inserirObstaculo(0, 0);
		Assert.assertTrue(sala.sala[0][0] == sala.OCUPADO);
		Assert.assertTrue((boolean) (sala.sala[0][1] = robo));
	}
	
	@Test
	public void testaVerificaObstaculos() throws Exception {
		new Sala(10, 10);
		Robo robo = new Robo(10, sala);
		sala.inserirObstaculo(0, 2);
		sala.inserirObstaculo(1, 0);
		Assert.assertFalse(robo.direita());
		Assert.assertEquals(10, robo.energia);
		Assert.assertTrue(sala.sala[0][0] == sala.OCUPADO);
		robo.frente();
		Assert.assertTrue(sala.sala[0][1] == sala.OCUPADO);
		Assert.assertEquals(9, robo.energia);
		Assert.assertEquals(1, robo.passos);
		robo.esquerda();
		Assert.assertTrue(sala.sala[1][1] == sala.OCUPADO);
		Assert.assertEquals(8, robo.energia);
		Assert.assertEquals(2, robo.passos);
		robo.direita();
		Assert.assertTrue(sala.sala[1][2] == sala.OCUPADO);
		Assert.assertEquals(7, robo.energia);
		Assert.assertEquals(1, robo.passos);
	}
	
	
}
