import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sobre extends JFrame implements ActionListener {

	JFrame frm;
	JPanel pnl;
	ImageIcon ico;
	JButton btn;
	JLabel lbl, lbl_titullo;
	JTextArea txt;

	public Sobre() {

		frm = new JFrame("Sobre");
		frm.setSize(800, 650);
		frm.setLocationRelativeTo(null);
		frm.setVisible(true);

		pnl = new JPanel(new GridLayout(4, 1));

		lbl_titullo = new JLabel("Campo Minado");
		pnl.add(lbl_titullo, BorderLayout.WEST);

		ico = new ImageIcon("img/mina.png");
		lbl = new JLabel(ico);
		pnl.add(lbl, BorderLayout.CENTER);
		frm.add(pnl);
		//
		txt = new JTextArea(20, 55);

		txt.setText(
				"A área de jogo consiste num campo de quadrados retangular. Cada quadrado pode ser revelado clicando sobre ele, "
						+ "e se o quadrado clicado contiver uma mina, então o jogo acaba. Se, por outro lado, o quadrado não contiver uma mina,"
						+ " uma de duas coisas poderá acontecer:\r\n"
						+ "   1. Um número aparece, indicando a qunatidade de quadrados adjacentes que contêm minas;\r\n"
						+ "   2. Nenhum número aparece. Neste caso, o jogo revela automaticamente os quadrados que se encontram adjacentes ao quadrado vazio, já que não podem conter minas;\r\n\n"
						+ "O jogo é ganho quando todos os quadrados que não têm minas são revelados.");

		pnl.add(txt, BorderLayout.SOUTH);
		//

		btn = new JButton("Fechar");
		btn.addActionListener(this);
		frm.add(btn, BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equalsIgnoreCase("Fechar")) {

			frm.dispose();

		}

	}

}
