package bd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.Curso;

public class CursoDAO {

	// a conexão com o banco de dados
	private Connection conexao;

	public CursoDAO() {
		this.conexao = FabricaDeConexao.obterInstancia().obterConexao();
	}

	//Adiciona
	public void adiciona(Curso curso) {
		String sql = "INSERT INTO Curso "
				+ "(nome, horario, sala, idProf)" + " VALUES (?,?,?,?)";

		try {

			Statement stat1 = conexao.createStatement();
			stat1.execute("set search_path to mac439_exercicio13");

			// prepared statement para inserção
			PreparedStatement stmt = conexao.prepareStatement(sql);

			// seta os valores

			stmt.setString(1, curso.getnome());
			stmt.setString(2, curso.gethorario());
			stmt.setString(3, curso.getsala());
			stmt.setLong(4, curso.getidProf());


			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// A SQLException é "encapsulada" em uma RuntimeException
			// para desacoplar o código da API de JDBC
			throw new RuntimeException(e);
		}
	}

	//Altera
	public void altera(Curso curso) {
		String sql = "UPDATE Curso SET horario=?, sala=?, idProf=? WHERE nome=?";
		try {

			Statement stat1 = conexao.createStatement();
			stat1.execute("set search_path to mac439_exercicio13");

			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, curso.gethorario());
			stmt.setString(2, curso.getsala());
			stmt.setLong(3, curso.getidProf());
			stmt.setString(4, curso.getnome());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//Remove
	public void remove(Curso curso) {
		try {

			Statement stat1 = conexao.createStatement();
			stat1.execute("set search_path to mac439_exercicio13");

			PreparedStatement stmt = conexao.prepareStatement("DELETE "
					+ "FROM Curso WHERE idProf=?");
			stmt.setLong(1, curso.getidProf());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Obter Curso
	public Curso obter(String nome) {
		try {

			Curso c = null;

			Statement stat1 = conexao.createStatement();
			stat1.execute("set search_path to mac439_exercicio13");

			PreparedStatement stmt = conexao.prepareStatement("select * "
					+ "from Curso where nome=?");
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				c = new Curso();
				c.setnome(rs.getString("nome"));
				c.sethorario(rs.getString("horario"));
				c.setsala(rs.getString("sala"));
				c.setidProf(rs.getLong("idProf"));
			}
			rs.close();
			stmt.close();
			return c;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Retorna uma lista de cursos que tenham contidos em seu nome
	// o argumento "nome"
	/*public List<Curso> obterPorNomeCurso(String nome) {
		try {
			List<Curso> cursoLista = new ArrayList<Curso>();
			Curso curso = null;
			String padraoBusca = "%" + nome + "%";

			PreparedStatement stmt = conexao.prepareStatement("SELECT * "
					+ "FROM curso WHERE nome LIKE ?");
			stmt.setString(1, padraoBusca);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				curso = new Curso();
				curso.setNome(rs.getString("nome"));
				curso.setHorario(rs.getString("horario"));
				curso.setSala(rs.getString("sala"));
				curso.setIdprof(rs.getLong("idprof"));

				cursoLista.add(curso);

			}
			rs.close();
			stmt.close();
			return cursoLista;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}*/


/*	// Retorna uma lista de cursos que o nome do professor contenha
	// o argumento "nome"
	public List<Curso> obterPorNomeProf(String nome) {
		try {
			List<Curso> cursoLista = new ArrayList<Curso>();
			Curso curso = null;
			String padraoBusca = "%" + nome + "%";

			PreparedStatement stmt = conexao.prepareStatement("SELECT * "
					+ "FROM curso WHERE nome LIKE ?");
			stmt.setString(1, padraoBusca);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				curso = new Curso();
				curso.setNome(rs.getString("nome"));
				curso.setHorario(rs.getString("horario"));
				curso.setSala(rs.getString("sala"));
				curso.setIdprof(rs.getLong("idprof"));

				cursoLista.add(curso);

			}
			rs.close();
			stmt.close();
			return cursoLista;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}*/

/*	public List<Contato> obterLista() {
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.conexao
					.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);

				// adicionando o objeto à lista
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}*/

}
