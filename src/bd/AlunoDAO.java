package bd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.Aluno;

public class AlunoDAO {

	// a conexão com o banco de dados
	private Connection conexao;

	public AlunoDAO() {
		this.conexao = FabricaDeConexao.obterInstancia().obterConexao();
	}

	// Adiciona
	public void adiciona(Aluno aluno) {
		String sql = "INSERT INTO Aluno "
				+ "(nroAluno, nomeAluno, formacao, nivel, idade)" + " VALUES (?,?,?,?,?)";

		try {

			Statement stat1 = conexao.createStatement();
			stat1.execute("set search_path to mac439_exercicio13");

			// prepared statement para inserção
			PreparedStatement stmt = conexao.prepareStatement(sql);

			// seta os valores

			stmt.setLong(1, aluno.getnroAluno());
			stmt.setString(2, aluno.getnomeAluno());
			stmt.setString(3, aluno.getformacao());
			stmt.setString(4, aluno.getnivel());
			stmt.setInt(5, aluno.getidade());

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// A SQLException é "encapsulada" em uma RuntimeException
			// para desacoplar o código da API de JDBC
			throw new RuntimeException(e);
		}
	}

	// Altera
	public void altera(Aluno aluno) {

		String sql = "UPDATE Aluno SET nomeAluno=?, formacao=?, nivel=?,"
				+ "idade=? WHERE nroAluno=?";
		try {

			Statement stat1 = conexao.createStatement();
			stat1.execute("set search_path to mac439_exercicio13");

			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setString(1, aluno.getnomeAluno());
			stmt.setString(2, aluno.getformacao());
			stmt.setString(3, aluno.getnivel());
			stmt.setInt(4, aluno.getidade());
			stmt.setLong(5, aluno.getnroAluno());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//Remove
	//CASCADE????
	public void remove(Aluno aluno) {
		try {

			Statement stat1 = conexao.createStatement();
			stat1.execute("set search_path to mac439_exercicio13");

			PreparedStatement stmt = conexao.prepareStatement("DELETE "
					+ "FROM aluno WHERE nroAluno=?");
			stmt.setLong(1, aluno.getnroAluno());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Obter Aluno
	public Aluno obter(Long nro) {
		try {

			Aluno aluno = null;

			Statement stat1 = conexao.createStatement();
			stat1.execute("set search_path to mac439_exercicio13");

			PreparedStatement stmt = conexao.prepareStatement("select * "
					+ "from Aluno where nroAluno=?");
			stmt.setLong(1, nro);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				aluno = new Aluno();
				aluno.setnroAluno(rs.getLong("nroAluno"));
				aluno.setnomeAluno(rs.getString("nomeAluno"));
				aluno.setformacao(rs.getString("formacao"));
				aluno.setnivel(rs.getString("nivel"));
				aluno.setidade(rs.getInt("idade"));

			}
			rs.close();
			stmt.close();
			return aluno;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
/*
	public List<Contato> obterLista() {
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
