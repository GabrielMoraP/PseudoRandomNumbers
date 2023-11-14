package utileria;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FechaActual {

	public void Fecha(javax.swing.JLabel Label) {

		Date FechaActual = new Date();
		SimpleDateFormat FormatoFecha = new SimpleDateFormat("dd/MM/yyyy");

		Label.setText(FormatoFecha.format(FechaActual));
	}

}
