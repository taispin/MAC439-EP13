package bd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.Matriculado;
import modelo.Aluno;

public class MatriculadoDAO {

	// a conexão com o banco de dados
	private Connection conexao;

	public MatriculadoDAO() {
		this.conexao = FabricaDeConexao.obterInstancia().obterConexao();
	}

	// Adiciona
	public void adiciona(Matriculado matri) {
		String sql = "INSERT INTO Matriculado "
				+ "(nroAluno, nomeCurso)" + " VALUES (?,?)";

		try {

			Statement stat1 = conexao.createStatement();
			stat1.execute("set search_path to mac439_exercicio13");

			// prepared statement para inserção
			PreparedStatement stmt = conexao.prepareStatement(sql);

			// seta os valores
			stmt.setLong(1, matri.getnroAluno());
			stmt.setString(2, matri.getnomeCurso());

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// A SQLException é "encapsulada" em uma RuntimeException
			// para desacoplar o código da API de JDBC
			throw new RuntimeException(e);
		}
	}


/*	// Lista de matriculados pelo curso recebido como argumento
	public List<Matriculado> alunosNoCurso(String curso) {
		try {

			String sql = "SELECT * "
					+ "FROM Matriculado WHERE nomeCurso = ?";

			//Lista
			List<Matriculado> lista = new ArrayList<Matriculado>();
			Matriculado elemento = null;

			Statement stat1 = conexao.createStatement();
			stat1.execute("set search_path to mac439_exercicio13");

			// prepared statement
			PreparedStatement stmt = conexao.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, curso);
			ResultSet res = stmt.executeQuery();

			while (res.next()) {
				elemento = new Matriculado();
				elemento.setnroAluno(res.getLong("nroAluno"));
				elemento.setnomeCurso(res.getString("nomeCurso"));
				lista.add(elemento);

			}
			res.close();
			stmt.close();
			return lista;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}*/

	// Lista de alunos no curso recebido como argumento
	public List<Aluno> alunosNoCurso(String curso) {
		try {
			List<Aluno> lista = new ArrayList<Aluno>();
			Aluno elemento = null;

			String sql = "SELECT Aluno.* "
					+ "FROM Aluno, Matriculado "
					+ "WHERE Aluno.nroAluno = Matriculado.nroAluno AND nomeCurso = ?";

			Statement stat1 = conexao.createStatement();
			stat1.execute("set search_path to mac439_exercicio13");

			// prepared statement para busca
			PreparedStatement stmt = conexao.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, curso);

			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				elemento = new Aluno();
				elemento.setnroAluno(res.getLong("nroAluno"));
				elemento.setnomeAluno(res.getString("nomeAluno"));
				elemento.setformacao(res.getString("formacao"));
				elemento.setnivel(res.getString("nivel"));
				elemento.setidade(res.getInt("idade"));
				lista.add(elemento);
			}
			res.close();
			stmt.close();
			return lista;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
