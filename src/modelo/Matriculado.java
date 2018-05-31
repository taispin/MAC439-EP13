package modelo;

public class Matriculado {

	private Long nroAluno;
	private String nomeCurso;

	/* métodos get e set para Matriculado */

	/* nroAluno */
	public Long getnroAluno() {
		return this.nroAluno;
	}

	public void setnroAluno(Long novo) {
		this.nroAluno = novo;
	}

	/* nomeCurso */
	public String getnomeCurso() {
		return this.nomeCurso;
	}

	public void setnomeCurso(String novo) {
		this.nomeCurso = novo;
	}
}
