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

	// Metodo que llama al metodo vista en la clase Ventana
	public static void abrirJuego() {
		Ventana.vista();

	}

	// Metodo que activa los botones del teclado
	public void activarBotones() {

//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		Ventana.frame.getBotones();
		for (int i = 0; i < Ventana.frame.getBotones().length; i++) {
			Ventana.frame.getBotones()[i].setEnabled(true);
		}

		Ventana.frame.getBtnResolver().setEnabled(true);
	}

	// Metodo que inicia el juego, genera una palabra nueva, genera los guiones,
	// borra la ultima palabra resuelta, rellena las vidas del jugador y activa los
	// botones para que pueda jugar
	public void iniciarJuego() {

		fallos = 1;
		vidas = 6;

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

		if (vidas > 0) {
			Ventana.frame.getLblAhorcado().setIcon(new ImageIcon(Ventana.class.getResource("/images/ahorcado1.png")));

			palabra.generarPalabra();
			Ventana.frame.getLblPalabraJugador().setText(palabra.generarGuiones());
			activarBotones();

		} else {
			perder();
		}

	}

	// Metodo que muestra un mensaje de confirmacion preguntando si quiere jugar otra partida o salir
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
