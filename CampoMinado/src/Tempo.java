import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Tempo {

	String dif;
	String dt;
	long tmpInicial;
	long tmpFinal;
	long ms;

	Historico hist = new Historico();

	public void CalculaTempo() {

		tmpInicial = System.currentTimeMillis();

		System.out.println("Tempo Inicio: " + tmpInicial);

	}

	public void Tempo_fim() {

		tmpFinal = System.currentTimeMillis();

		System.out.println("Tempo Fim: " + tmpInicial);

		long ms = (tmpFinal - tmpInicial);

		System.out.println("Long dif: " + ms);

		dif = String.format("%02d:%02d:%02d", ms / 3600000, (ms / 60000) % 60, (ms / 1000) % 60);
		System.out.println("dif: " + dif);

		dt = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

		System.out.println("Data: " + dt);

	}

}
