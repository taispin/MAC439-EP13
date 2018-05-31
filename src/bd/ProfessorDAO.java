package bd;

import java.sql.*;

import modelo.Professor;

public class ProfessorDAO {

	// a conexão com o banco de dados
	private Connection conexao;

	public ProfessorDAO() {
		this.conexao = FabricaDeConexao.obterInstancia().obterConexao();
	}

	// Adiciona
	public void adiciona(Professor professor) {
		String sql = "INSERT INTO Professor "
				+ "(idProf, nomeProf, idDepto)" + " VALUES (?,?,?)";

		try {

			Statement stat1 = conexao.createStatement();
			stat1.execute("set search_path to mac439_exercicio13");

			// prepared statement para inserção
			PreparedStatement stmt = conexao.prepareStatement(sql);

			// seta os valores

			stmt.setLong(1, professor.getidProf());
			stmt.setString(2, professor.getnomeProf());
			stmt.setInt(3, professor.getidDepto());

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
	public void altera(Professor professor) {
		String sql = "UPDATE Professor SET nomeProf=?, idDepto=? WHERE idProf=?";
		try {

			Statement stat1 = conexao.createStatement();
			stat1.execute("set search_path to mac439_exercicio13");

			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, professor.getnomeProf());
			stmt.setInt(2, professor.getidDepto());
			stmt.setLong(3, professor.getidProf());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//Deleta
	public void remove(Professor professor) {
		try {

			Statement stat1 = conexao.createStatement();
			stat1.execute("set search_path to mac439_exercicio13");

			PreparedStatement stmt = conexao.prepareStatement("DELETE "
					+ "FROM Professor WHERE idProf=?");
			stmt.setLong(1, professor.getidProf());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Obter Professor
	public Professor obter(Long nro) {
		try {

			Professor professor = null;

			Statement stat1 = conexao.createStatement();
			stat1.execute("set search_path to mac439_exercicio13");

			PreparedStatement stmt = conexao.prepareStatement("select * "
					+ "from Professor where idProf=?");
			stmt.setLong(1, nro);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				professor = new Professor();
				professor.setidProf(rs.getLong("idProf"));
				professor.setnomeProf(rs.getString("nomeProf"));
				professor.setidDepto(rs.getInt("idDepto"));
			}
			rs.close();
			stmt.close();
			return professor;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

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
