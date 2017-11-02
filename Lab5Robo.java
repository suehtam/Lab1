package Lab5;

/*Aluno 1: Samuel Alves*/
/*Aluno 2: Matheus Rodrigues*/
/*Aluno 3: Ivandro Rodrigues*/

public class Robo {
	Sala sala;
	static int i = 0, j = 0, passos, energia;
	int linhas = sala.getNumPosicoesHorizontais();
	int colunas = sala.getNumPosicoesVerticais();

	public Robo(int energy, Sala sala) throws Exception{
		Robo robo = new Robo(energy, sala);
		Robo.passos = 0;
		
		if (sala.sala[0][0] == Sala.OCUPADO) {
			do {
				i++;
			} while (sala.sala[i][j] == Sala.OCUPADO);
		}
		sala.sala[i][j] = robo;
		sala.sala[i][j] = Sala.OCUPADO;
		
		if (energy > 0)
			Robo.energia = energy;
		else
			throw new Exception("energia negativa");
	}

	public boolean frente() throws Exception {
		if (j > 0 && j < colunas - 1) {
			if (energia > 0) {
				sala.sala[i][j] = Sala.LIVRE;
				sala.sala[i + 1][j] = Sala.OCUPADO;
				passos++;
				energia--;
				return true;
			} else
				throw new Exception("acabou a energia!");
		} else
			throw new Exception("frente demais, passou dos limites!");
	}

	public boolean tras() throws Exception {
		if (j > 0 && j < colunas - 1) {
			if (energia > 0) {
				sala.sala[i][j] = Sala.LIVRE;
				sala.sala[i - 1][j] = Sala.OCUPADO;
				passos++;
				energia--;
				return true;
			} else
				throw new Exception("acabou a energia!");

		} else
			throw new Exception("voltou demais, passou dos limites!");
	}

	public boolean esquerda() throws Exception {
		if (i > 0 && i < linhas - 1) {
			if (energia > 0) {
				sala.sala[i][j] = Sala.LIVRE;
				sala.sala[i][j + 1] = Sala.OCUPADO;
				passos++;
				energia--;
				return true;
			} else
				throw new Exception("acabou a energia!");
		} else
			throw new Exception("passou dos limites!");	
	}

	public boolean direita() throws Exception {
		if (i > 0 && i < linhas - 1) {
			if (energia > 0) {
				sala.sala[i][j] = Sala.LIVRE;
				sala.sala[i][j - 1] = Sala.OCUPADO;
				passos++;
				energia--;
				return true;
			} else
				throw new Exception("acabou a energia!");
		} else
			throw new Exception("passou dos limites!");
	}
}
