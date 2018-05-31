package modelo;

public class Professor {

	private Long idProf;
	private String nomeProf;
	private int idDepto;

	/* métodos get e set para Professor */

	/* idProf */
	public Long getidProf() {
		return this.idProf;
	}

	public void setidProf(Long novo) {
		this.idProf = novo;
	}

	/* nomeProf */
	public String getnomeProf() {
		return this.nomeProf;
	}

	public void setnomeProf(String novo) {
		this.nomeProf = novo;
	}

	/* idDepto */
	public int getidDepto() {
		return this.idDepto;
	}

	public void setidDepto(int novo) {
		this.idDepto = novo;
	}
}
