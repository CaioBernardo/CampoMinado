import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HistoricoDAOJDBC implements HistoricoDAO {

	private JDBCUtil banco;
	PreparedStatement st;
	ResultSet rs;

	public HistoricoDAOJDBC() {
		banco = new JDBCUtil();
	}

	public void inserir(Historico historico) {

		try {

			String sql = "insert into jogo(dataJogo,dificuldade,duracao) values (?,?,?);";
			PreparedStatement st = null;

			st = banco.getConnection().prepareStatement(sql);

			st.setString(1, historico.getDataJogo());
			st.setString(2, historico.getDificuldade());
			st.setString(3, historico.getDuracao());

			st.execute();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	@Override
	public void listar(String dificuldade) {

		try {

			String sql = "select * from jogo where dificuldade = ?;";
			PreparedStatement st = null;

			st = banco.getConnection().prepareStatement(sql);

			st.setString(1, dificuldade);
			rs = st.executeQuery();

			PageHistorico save = new PageHistorico();

			while (rs.next()) {

				save.setData(rs.getString("dataJogo"));
				save.setDif(rs.getString("dificuldade"));
				save.setDur(rs.getString("duracao"));

			}

		} catch (SQLException e1) {

			e1.printStackTrace();

		}

	}

}
