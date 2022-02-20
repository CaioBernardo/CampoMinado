import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class Jogo extends JFrame implements ActionListener {

	JFrame frm;
	JMenuBar mnuBar;
	JMenu mnuInicio, mnuNovoJogo;
	JMenuItem mnuItmHistorico, mnuItmSobre, mnuItmSair, mnuItmFacil, mnuItmMedio, mnuItmDificil;
	JDBCUtil banco;

	public Jogo() {

		banco = new JDBCUtil();

		frm = new JFrame("Campo Minado");
		frm.setSize(800, 600);
		frm.setLocationRelativeTo(null);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);

		frm.setLayout(new FlowLayout());
		frm.setLayout(new BorderLayout());

		mnuBar = new JMenuBar();
		frm.setJMenuBar(mnuBar);

		mnuInicio = new JMenu("Início");
		mnuBar.add(mnuInicio);

		mnuNovoJogo = new JMenu("Novo Jogo");
		mnuInicio.add(mnuNovoJogo);

		mnuItmFacil = new JMenuItem("Fácil");
		mnuNovoJogo.add(mnuItmFacil);
		mnuItmFacil.addActionListener(this);

		mnuItmMedio = new JMenuItem("Médio");
		mnuNovoJogo.add(mnuItmMedio);
		mnuItmMedio.addActionListener(this);

		mnuItmDificil = new JMenuItem("Difícil");
		mnuNovoJogo.add(mnuItmDificil);
		mnuItmDificil.addActionListener(this);

		mnuItmHistorico = new JMenuItem("Histórico");
		mnuInicio.add(mnuItmHistorico);
		mnuItmHistorico.addActionListener(this);

		mnuItmSobre = new JMenuItem("Sobre");
		mnuInicio.add(mnuItmSobre);
		mnuItmSobre.addActionListener(this);

		mnuItmSair = new JMenuItem("Sair");
		mnuInicio.add(mnuItmSair);
		mnuItmSair.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equalsIgnoreCase("Fácil")) {

			new CampoMinado(1);

		}

		if (e.getActionCommand().equalsIgnoreCase("Médio")) {

			new CampoMinado(2);

		}

		if (e.getActionCommand().equalsIgnoreCase("Difícil")) {

			new CampoMinado(3);

		}

		if (e.getActionCommand().equalsIgnoreCase("Histórico")) {

			new PageHistorico();

		}

		if (e.getActionCommand().equalsIgnoreCase("Sobre")) {

			new Sobre();

		}

		if (e.getActionCommand().equalsIgnoreCase("Sair")) {

			System.exit(0);

		}

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Jogo();

			}

		});

	}

}
