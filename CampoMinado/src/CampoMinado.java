import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.Random;
import java.awt.GridLayout;

public class CampoMinado extends JFrame implements ActionListener {

	JFrame frm;
	JPanel fld;
	String rJogo;
	Bomba[][] campo = new Bomba[16][18];
	Tempo temp = new Tempo();
	Random rdm = new Random();
	int rows = 0;
	int cols = 0;
	int bombas = 0;

	public CampoMinado(int jogo) {

		frm = new JFrame("Campo Minado");
		frm.setSize(800, 600);
		frm.setLocationRelativeTo(null);
		frm.setVisible(true);
		frm.setLayout(new FlowLayout());
		frm.setLayout(new BorderLayout());

		iniciaJogo(jogo);

	}

	public void limpaCampo() {

		getContentPane().removeAll();
		getContentPane().repaint();

	}

	public void iniciaJogo(int jogo) {

		switch (jogo) {
		// Fácil

		case 1:
			rJogo = "Fácil";
			limpaCampo();
			setSize((10) * 45, 10 * 45);
			novoJogo(8, 10, 10);
			temp.CalculaTempo();

			break;

		// Médio
		case 2:
			rJogo = "Médio";
			limpaCampo();
			setSize((14) * 45, 14 * 45);
			novoJogo(12, 14, 15);
			temp.CalculaTempo();
			break;

		// Difícil
		case 3:
			rJogo = "Difícil";
			System.out.println("Difícl");
			limpaCampo();
			setSize((18) * 45, 18 * 45);
			novoJogo(16, 18, 40);
			temp.CalculaTempo();
			break;

		}

	}

	public void novoJogo(int row, int col, int qtdBombas) {

		fld = new JPanel();
		fld.setLayout(new GridLayout(row, col));
		frm.add(fld);
		this.rows = row;
		this.cols = col;
		this.bombas = qtdBombas;

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < col; j++) {

				campo[i][j] = new Bomba(false);
				campo[i][j].addActionListener(this);
				campo[i][j].setActionCommand("Botão-" + i + "-" + j);

			}

		}

		setLocationRelativeTo(null);
		setResizable(false);
		geraBomba(row, col, qtdBombas);
		bombasRedor();
		for (int i = 0; i < row; i++) {

			for (int j = 0; j < col; j++) {

				fld.add(campo[i][j]);
			}

		}

		frm.add(fld);
		fld.setVisible(true);
		fld.updateUI();
		// Teste para saber se ganhou
		mostrarBombas();

	}

	// Verifica ação sobre os Botões (Campo)
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().contains("Botão")) {

			String[] bRedor = e.getActionCommand().split("-");
			int linha = Integer.parseInt(bRedor[1]);
			int coluna = Integer.parseInt(bRedor[2]);
			clicouBomba(linha, coluna);

		}

		ganhou(rows, cols);

	}

	// Verifica se o número de casa está pronta para o fim do jogo
	private void ganhou(int row, int col) {

		int conta = 0;

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < col; j++) {

				if (!campo[i][j].isEnabled()) {

					conta++;
				}
			}
		}
		if ((conta + 1) >= (row * col) - bombas) {

			terminaJogo(1);
			limpaCampo();

		}

	}

	private void geraBomba(int row, int col, int qtdBombas) {

		boolean sort;
		int linhaSort, colSort;

		for (int i = 0; i < qtdBombas + 1; i++) {

			do {

				linhaSort = rdm.nextInt(row);
				colSort = rdm.nextInt(col);

				if (campo[linhaSort][colSort].getBomb() == true) {

					sort = true;

				} else {

					sort = false;

				}

			} while (sort);

			campo[linhaSort][colSort].setBomb(true);

		}
	}

	private void clicouBomba(int row, int col) {

		if (campo[row][col].getBomb()) {

			mostrarBombas();
			terminaJogo(2);
			limpaCampo();

		} else if (!campo[row][col].getBomb()) {

			abrirVizinhas(row, col);

		}

	}

	private void mostrarBombas() {

		for (int i = 0; i < this.rows; i++) {

			for (int j = 0; j < this.cols; j++) {

				if (campo[i][j].getBomb()) {

					campo[i][j].setIcon(Bomba.imgBomba);

				}

			}

		}

	}

	private void abrirVizinhas(int row, int col) {

		for (int i = -1; i < 2; i++) {

			for (int j = -1; j < 2; j++) {

				if ((row + i >= 0) && (row + i < rows) && (col + j >= 0) && (col + j < cols)) {

					if (!campo[row + i][col + j].getBomb()) {

						campo[row + i][col + j].setEnabled(false);

						if (campo[row + i][col + j].getQtdBombas() > 0) {

							campo[row + i][col + j].setText(Integer.toString(campo[row + i][col + j].getQtdBombas()));

						}

					}

				}

			}

		}

	}

	// Termina o jogo
	private void terminaJogo(int ganhou) {

		if (ganhou == 1) {

			JOptionPane.showMessageDialog(null, "Você ganhou!", "Fim de Jogo", JOptionPane.INFORMATION_MESSAGE);
			temp.Tempo_fim();
			frm.dispose();

			// Inserir
			Historico historico = new Historico(temp.dt, temp.dif, rJogo);

			HistoricoDAO dao = new HistoricoDAOJDBC();

			dao.inserir(historico);

		} else {

			JOptionPane.showMessageDialog(null, "Você Perdeu!", "Fim de Jogo", JOptionPane.INFORMATION_MESSAGE);
			temp.Tempo_fim();
			frm.dispose();

			// Inserir
			Historico historico = new Historico(temp.dt, temp.dif, rJogo);

			HistoricoDAO dao = new HistoricoDAOJDBC();

			dao.inserir(historico);

		}

	}

	// Esta função faz com que mostre as quantiades de bombas ao redos
	private void bombasRedor() {

		for (int linha = 0; linha < rows; linha++) {

			for (int coluna = 0; coluna < cols; coluna++) {

				if (!campo[linha][coluna].getBomb()) {

					for (int i = -1; i < 2; i++) {

						for (int j = -1; j < 2; j++) {

							if ((linha + i >= 0) && (linha + i < rows) && (coluna + j >= 0) && (coluna + j < cols)) {

								if (campo[linha + i][coluna + j].getBomb()) {

									campo[linha][coluna].incrementaBombas();

								}

							}

						}

					}

				}

			}

		}

	}

}