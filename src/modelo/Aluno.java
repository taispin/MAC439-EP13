package modelo;

public class Aluno {

	private Long nroAluno;
	private String nomeAluno;
	private String formacao;
	private String nivel;
	private int idade;

/* métodos get e set para Aluno */

	/* nroAluno */
	public Long getnroAluno() {
		return this.nroAluno;
	}

	public void setnroAluno(Long novo) {
		this.nroAluno = novo;
	}

	/* nomeAluno */
	public String getnomeAluno() {
		return this.nomeAluno;
	}

	public void setnomeAluno(String novo) {
		this.nomeAluno = novo;
	}

	/* formacao */
	public String getformacao() {
		return this.formacao;
	}

	public void setformacao(String novo) {
		this.formacao = novo;
	}

	/* nivel */
	public String getnivel() {
		return this.nivel;
	}

	public void setnivel(String novo) {
		this.nivel = novo;
	}

	/* idade */
	public int getidade() {
		return this.idade;
	}

	public void setidade(int idade) {
		this.idade = idade;
	}
}
