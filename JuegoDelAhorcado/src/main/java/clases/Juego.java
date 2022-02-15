package clases;

import javax.swing.JButton;

import vista.Ventana;

public class Juego {

	Palabra palabra = new Palabra();

	public void abrirJuego() {
		Ventana.vista();

		
	}
	
	public void activarBotones() {
		Ventana.frame.getBotones();
		for (int i = 0; i < Ventana.frame.getBotones().length; i++) {
			Ventana.frame.getBotones()[i].setEnabled(false);
		}
	}

	public void iniciarJuego() {
		palabra.generarPalabra();
		Ventana.frame.getLblPalabraJugador().setText(palabra.generarGuiones());
		activarBotones();
	}

	public void resolverJuego() {

	}

	public void comprobarLetra(char letra) {
		
		String palabra = Ventana.frame.getLblPalabraJugador().getText();
		
		char[] letras = new char[palabra.length()];
		
		for (int i = 0; i < letras.length; i++) {
			letras[i] = palabra.charAt(i);
		}

		for (int i = 0; i < this.palabra.getPalabra().length(); i++) {
			if (this.palabra.getPalabra().charAt(i) == letra) {
				letras[i] = letra;
			}
		}
		
		palabra = "";
		
		for (int i = 0; i < letras.length; i++) {	
			palabra += letras[i];
		}

		Ventana.frame.getLblPalabraJugador().setText(palabra);
		
	}

}
