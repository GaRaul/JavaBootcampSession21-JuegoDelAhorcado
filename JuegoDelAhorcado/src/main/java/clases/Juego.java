package clases;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import vista.Ventana;

public class Juego {

	Palabra palabra = new Palabra();
	private int fallos = 1;
	private int vidas = 6;

	public void abrirJuego() {
		Ventana.vista();

	}

	public void activarBotones() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Ventana.frame.getBotones();
		for (int i = 0; i < Ventana.frame.getBotones().length; i++) {
			Ventana.frame.getBotones()[i].setEnabled(true);
		}
		
		Ventana.frame.getBtnResolver().setEnabled(true);
	}

	public void iniciarJuego() {

		fallos = 1;
		vidas = 6;
		
		palabra.generarPalabra();
		Ventana.frame.getLblPalabraJugador().setText(palabra.generarGuiones());
		Ventana.frame.getLblPalabraResuelta().setText("");
		rellenarVidas();
		activarBotones();
		
	}

	public void resolver() {
		Ventana.frame.getLblPalabraResuelta().setText(palabra.getPalabra());
		quitarVida();
		
	}

	public void comprobarLetra(char letra, JButton button) {
		boolean acierto = false;

		button.setEnabled(false);
		
		String palabra = Ventana.frame.getLblPalabraJugador().getText();

		char[] letras = new char[palabra.length()];

		for (int i = 0; i < letras.length; i++) {
			letras[i] = palabra.charAt(i);
		}

		for (int i = 0; i < this.palabra.getPalabra().length(); i++) {
			if (this.palabra.getPalabra().charAt(i) == letra) {
				letras[i] = letra;
				acierto = true;
			}
		}

		palabra = "";

		for (int i = 0; i < letras.length; i++) {
			palabra += letras[i];
		}

		Ventana.frame.getLblPalabraJugador().setText(palabra);

		if (!acierto) {
			fallos++;
			fallo();
		}

	}

	public void rellenarVidas() {
		for (int i = 0; i < vidas; i++) {
			Ventana.frame.getVidas()[i].setEnabled(true);

		}
	}

	public void fallo() {

		if (fallos == 7) {
			Ventana.frame.getLblAhorcado().setIcon(new ImageIcon(Ventana.class.getResource("/images/ahorcado7.png")));
			quitarVida();


		} else {
			Ventana.frame.getLblAhorcado()
					.setIcon(new ImageIcon(Ventana.class.getResource("/images/ahorcado" + fallos + ".png")));

		}
	}
	
	public void quitarVida() {
		vidas--;
		fallos = 0;
		Ventana.frame.getVidas()[vidas].setEnabled(false);
		
		if (vidas > 0) {
			Ventana.frame.getLblAhorcado()
					.setIcon(new ImageIcon(Ventana.class.getResource("/images/ahorcado1.png")));

			palabra.generarPalabra();
			Ventana.frame.getLblPalabraJugador().setText(palabra.generarGuiones());
			activarBotones();

		} else {
			perder();
		}
		
	}

	public void perder() {
		int opcion = JOptionPane.showConfirmDialog(null, "Has perdido, quieres intentarlo de nuevo?",
				"Selecciona una opcion", JOptionPane.YES_NO_OPTION);

		switch (opcion) {
		case 0:
			iniciarJuego();
			break;
		case 1:
			System.exit(1);
			;

		default:
			System.exit(1);
		}

	}

}
