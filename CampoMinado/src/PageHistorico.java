import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class PageHistorico extends JFrame implements ActionListener {

	JFrame frm;
	JLabel lbl;
	String[] opc;
	JPanel cabPnl, rodPnl;
	JComboBox<String> cbo;
	JButton btn;
	JTable tbl;
	String[] colunas = { "Data", "Dificuldade", "Duração" };
	ArrayList<String> data = new ArrayList<String>();
	ArrayList<String> dur = new ArrayList<String>();
	ArrayList<String> dif = new ArrayList<String>();

	public PageHistorico() {

		frm = new JFrame("Histórico");
		frm.setSize(300, 400);
		frm.setLocationRelativeTo(null);
		frm.setVisible(true);

		cabPnl = new JPanel(new GridLayout(0, 2));

		lbl = new JLabel("Nível: ");
		cabPnl.add(lbl, BorderLayout.NORTH);

		String[] hist = { "Fácil", "Médio", "Difícil" };

		//

		String[] colunas = { "Data", "Dificuldade", "Duração" };

		Object[][] dados = { { data, dur, dif } };

		JTable tabela = new JTable(dados, colunas);

		frm.add(tabela);

		//

		cbo = new JComboBox<String>(hist);
		cbo.addActionListener(this);
		cabPnl.add(cbo, BorderLayout.NORTH);

		frm.add(cabPnl, BorderLayout.NORTH);

		rodPnl = new JPanel(new GridLayout(0, 4));

		btn = new JButton("OK");
		btn.addActionListener(this);

		rodPnl.add(btn);

		frm.add(rodPnl, BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equalsIgnoreCase("OK")) {

			HistoricoDAO dao = new HistoricoDAOJDBC();

			String s = (String) cbo.getSelectedItem();

			switch (s) {
			case "Fácil":

				dao.listar("Fácil");

				break;

			case "Médio":

				dao.listar("Médio");

				break;

			case "Difícil":

				dao.listar("Difícil");

				break;

			default:
				break;
			}

		}

	}

	public void setData(String string) {
		data.add(string);

	}

	public void setDif(String string) {
		dif.add(string);

	}

	public void setDur(String string) {
		dur.add(string);

	}

}
