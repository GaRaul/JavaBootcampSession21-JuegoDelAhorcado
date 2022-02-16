package clases;

import java.util.ArrayList;

public class Palabra {

	private String palabra = "";

	private ArrayList<String> palabras = new ArrayList<String>();

	public Palabra() {

		palabras.add("VASO");
		palabras.add("RATON");
		palabras.add("ESDRUJULA");
		palabras.add("ORDENADOR");
		palabras.add("PASTILLA");
		palabras.add("MONITOR");
		palabras.add("SERVILLETA");
		palabras.add("AVION");
		palabras.add("ESPAÑA");
		palabras.add("CAMION");

	}

	// Metodo que coge una palabra del diccionario y la asigna al atributo palabra
	public void generarPalabra() {

		String palabra = "";

		int numRandom = (int) (Math.random() * palabras.size());

		palabra = palabras.get(numRandom);

		this.palabra = palabra;
	}

	// Metodo que devuelve guiones segun la longitud de la palabra
	public String generarGuiones() {

		String guiones = "";

		for (int i = 0; i < this.palabra.length(); i++) {
			guiones += "-";
		}

		System.out.println(this.palabra);

		return guiones;

	}

	public void nuevaPalabra(String palabra) {
		if (comprobarFormatoPalabra(palabra)) {
			palabras.add(palabra);
			mostrarDiccionario();
		}

	}

	private boolean comprobarFormatoPalabra(String palabra) {

		palabra.toUpperCase();
		
		for (int i = 0; i < palabra.length(); i++) {
			if (!((palabra.charAt(i) >= 65 && palabra.charAt(i) <= 90) || (palabra.charAt(i) == 'Ñ'))) {
				return false;
			}
		}

		return true;

	}

	public void mostrarDiccionario() {
		for (int i = 0; i < palabras.size(); i++) {
			System.out.println(palabras.get(i));
		}
	}

	// GETTER
	public String getPalabra() {
		return palabra;
	}

}
