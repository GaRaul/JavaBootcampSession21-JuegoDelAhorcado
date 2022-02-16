package clases;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import vista.Ventana;

public class Juego {

	// Atributos
	Palabra palabra = new Palabra();
	private int fallos = 1;
	private int vidas = 6;
	private boolean pistaDada = false;
	private boolean victoria = false;
	private int fallosTotales = 0;

	// Metodo que llama al metodo vista en la clase Ventana
	public static void abrirJuego() {
		Ventana.vista();

	}

	// Metodo que activa los botones del teclado
	public void activarBotones() {

//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		Ventana.frame.getBotones();
		for (int i = 0; i < Ventana.frame.getBotones().length; i++) {
			Ventana.frame.getBotones()[i].setEnabled(true);
		}

		Ventana.frame.getBtnResolver().setEnabled(true);

		if (!pistaDada) {
			Ventana.frame.getBtnPista().setEnabled(true);

		}
	}

	// Metodo que inicia el juego, genera una palabra nueva, genera los guiones,
	// borra la ultima palabra resuelta, rellena las vidas del jugador y activa los
	// botones para que pueda jugar
	public void iniciarJuego() {

		fallosTotales = 0;
		fallos = 1;
		vidas = 6;
		pistaDada = false;

		palabra.generarPalabra();
		Ventana.frame.getLblPalabraJugador().setText(palabra.generarGuiones());
		Ventana.frame.getLblPalabraResuelta().setText("");
		rellenarVidas();
		activarBotones();

	}

	// Metodo que muestra la solucion de la palabra actual y le quita una vida al
	// jugador
	public void resolver() {
		Ventana.frame.getLblPalabraResuelta().setText(palabra.getPalabra());
		quitarVida();

	}

	// Metodo que desactiva y comprueba si la letra que ha pulsado el jugador está
	// en la palabra, si está añade la letra a la palabra
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
		} else if (comprobarVictoria(palabra)) {
			victoria = true;
			finPartida();
		}

	}
	
	private boolean comprobarVictoria(String palabraJugador) {
		if (palabraJugador.equalsIgnoreCase(this.palabra.getPalabra())) {
			return true;
		}
		
		return false;
	}

	// Metodo que muestra un mensaje de confirmacion preguntando si quiere jugar
	// otra partida o salir
	private void finPartida() {

		String msg;
		
		if (victoria) {
			msg = "Felicidades has ganado!!! Quieres volver a jugar?";
		} else {
			msg = "Has perdido :(, quieres volver a jugar?";
		}
		
		int opcion = JOptionPane.showConfirmDialog(null, msg,
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

	// Metodo para rellenar las vidas del jugador
	public void rellenarVidas() {
		for (int i = 0; i < vidas; i++) {
			Ventana.frame.getVidas()[i].setEnabled(true);

		}
	}

	// Metodo que procesa los fallos del jugador
	public void fallo() {
		fallosTotales++;

		Ventana.frame.getFallosTotales().setText("Fallos totales: " + fallosTotales);
		
		// Si ha gastado todos los intentos le quita una vida
		if (fallos == 7) {
			Ventana.frame.getLblAhorcado().setIcon(new ImageIcon(Ventana.class.getResource("/images/ahorcado7.png")));
			quitarVida();
			
			// Si aun le quedan intentos carga la siguiente imagen del ahorcado
		} else {
			Ventana.frame.getLblAhorcado()
					.setIcon(new ImageIcon(Ventana.class.getResource("/images/ahorcado" + fallos + ".png")));

		}
	}

	// Metodo para quitarle una vida al jugador, si aun le quedan vidas vuelve a
	// generar una palabra y activa los botones que ha pulsado, si no le quedan
	// vidas llama al metodo perder
	public void quitarVida() {
		vidas--;
		fallos = 0;
		Ventana.frame.getVidas()[vidas].setEnabled(false);

		if (vidas > 0 && !pistaDada) {
			Ventana.frame.getLblAhorcado().setIcon(new ImageIcon(Ventana.class.getResource("/images/ahorcado1.png")));

			palabra.generarPalabra();
			Ventana.frame.getLblPalabraJugador().setText(palabra.generarGuiones());
			activarBotones();

		} else if (pistaDada){
			pistaDada = false;
		} else {
			victoria = false;
			finPartida();
		}

	}

	
	// Metodo que pone la primera letra oculta en la palabra y quita una vida al jugador
	public void darPista() {

		if (vidas == 1) {
			JOptionPane.showMessageDialog(null, "No puedes pedir una pista teniendo solo 1 vida");
			pistaDada = true;
		}
		
		String palabra = Ventana.frame.getLblPalabraJugador().getText();

		char[] letras = new char[palabra.length()];
		char[] letrasReveladas = new char[palabra.length()];

		for (int i = 0; i < letras.length; i++) {
			letras[i] = palabra.charAt(i);
			letrasReveladas[i] = this.palabra.getPalabra().charAt(i);
		}

		for (int i = 0; i < this.palabra.getPalabra().length(); i++) {

			if (palabra.charAt(i) == '-' && !pistaDada) {
				letras[i] = letrasReveladas[i];
				pistaDada = true;
			}
		}
		
		quitarVida();

		palabra = "";

		for (int i = 0; i < letras.length; i++) {
			palabra += letras[i];
		}

		Ventana.frame.getLblPalabraJugador().setText(palabra);
		Ventana.frame.getBtnPista().setEnabled(false);
		
		if (comprobarVictoria(palabra)) {
			victoria = true;
			finPartida();
		}

	}

	public int getFallosTotales() {
		return fallosTotales;
	}

	public void setFallosTotales(int fallosTotales) {
		this.fallosTotales = fallosTotales;
	}

}
