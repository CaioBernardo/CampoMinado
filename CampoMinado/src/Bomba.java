import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Bomba extends JButton {
	private boolean isBomb;
	private int qtdBombas;
	public static ImageIcon imgBomba = new ImageIcon("img/mina.png");

	Bomba(boolean isBomb) {
		super();
		this.isBomb = isBomb;
		qtdBombas = 0;
	}

	public boolean getBomb() {
		return isBomb;
	}

	public void setBomb(boolean bomb) {
		isBomb = bomb;
	}

	public void incrementaBombas() {
		qtdBombas++;
	}

	public int getQtdBombas() {
		return qtdBombas;
	}

}