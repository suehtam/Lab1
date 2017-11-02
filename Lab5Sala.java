package Lab5;

import java.util.Scanner;

import org.junit.Assert;

/*Aluno 1: Samuel Alves*/
/*Aluno 2: Matheus Rodrigues*/
/*Aluno 3: Ivandro Rodrigues*/

public class Sala {
	private int NUM_LINHAS;
	private int NUM_COLUNAS;
    Object[][] sala;
	final static Object OCUPADO = 1;
	final static Object LIVRE = 0;

	public Sala(int linhas, int colunas) {
		this.NUM_LINHAS = linhas;
		this.NUM_COLUNAS = colunas;
		sala = new Object[NUM_LINHAS][NUM_COLUNAS];
		
		for(int i=0; i < sala.length; i++) {
			for(int j = 0; j < sala.length; j++) {
				sala[i][j] = 0;
			}
		}
	}

	public void criaSala() throws Exception {
		if (NUM_LINHAS > 0 && NUM_COLUNAS > 0) {
			sala = new Object[NUM_LINHAS][NUM_COLUNAS];

		} else
			throw new Exception(
					
					"Parametros incorretos para a criacao da sala. As dimensoes da sala devem ser representadas por valores positivos maiores que zero");
	}

	public boolean isVazia() {
		for (int i = 0; i < NUM_LINHAS; i++) {
			for (int j = 0; j < NUM_COLUNAS; j++) {
				if (sala[NUM_LINHAS][NUM_COLUNAS] == OCUPADO)
					return false;
			}
		}
		return true;
	}

	public boolean inserirObstaculo(int linha, int coluna) {
		if (sala[linha][coluna] == LIVRE) {
			sala[linha][coluna] = OCUPADO;
			return true;
		}
		return false;
	}

	public boolean posicaoValida(int linha, int coluna) {
		return ((linha >= 0 && linha <= 9) && (coluna >= 0 && coluna <= 9));
	}

	public boolean isPosicaoLivre(int linha, int coluna) throws Exception {
		if ((linha >= 0 && linha <= 9) && (coluna >= 0 && coluna <= 9)) {
			if ((sala[linha][coluna] == LIVRE))
				return true;
			else
				return false;
		} else
			throw new Exception("Posicao inexistente.");
	}

	public boolean setPosicao(int linha, int coluna, Object status) {
		if (posicaoValida(linha, coluna)) {
			sala[linha][coluna] = status;
			return true;
		}
		return false;
	}

	public int getNumPosicoesHorizontais() {
		return NUM_LINHAS;
	}

	public int getNumPosicoesVerticais() {
		return NUM_COLUNAS;
	}
}
