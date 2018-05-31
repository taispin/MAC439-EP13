package modelo;

public class Curso {

	private String nome;
	private String horario;
	private String sala;
	private Long idProf;

	/* métodos get e set para Curso */

	/* nome */
	public String getnome() {
		return this.nome;
	}

	public void setnome(String novo) {
		this.nome = novo;
	}

	/* horario */
	public String gethorario() {
		return this.horario;
	}

	public void sethorario(String novo) {
		this.horario = novo;
	}

	/* sala */
	public String getsala() {
		return this.sala;
	}

	public void setsala(String novo) {
		this.sala = novo;
	}

	/* idProf */
	public Long getidProf() {
		return this.idProf;
	}

	public void setidProf(Long novo) {
		this.idProf = novo;
	}
}
