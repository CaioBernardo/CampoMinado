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
				"A �rea de jogo consiste num campo de quadrados retangular. Cada quadrado pode ser revelado clicando sobre ele, "
						+ "e se o quadrado clicado contiver uma mina, ent�o o jogo acaba. Se, por outro lado, o quadrado n�o contiver uma mina,"
						+ " uma de duas coisas poder� acontecer:\r\n"
						+ "   1. Um n�mero aparece, indicando a qunatidade de quadrados adjacentes que cont�m minas;\r\n"
						+ "   2. Nenhum n�mero aparece. Neste caso, o jogo revela automaticamente os quadrados que se encontram adjacentes ao quadrado vazio, j� que n�o podem conter minas;\r\n\n"
						+ "O jogo � ganho quando todos os quadrados que n�o t�m minas s�o revelados.");

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
