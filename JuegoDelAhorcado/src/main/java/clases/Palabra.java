package clases;

import java.util.ArrayList;

public class Palabra {

	private String palabra = "";


	private ArrayList<String> palabras = new ArrayList<String>();

	public Palabra() {
		
		palabras.add("perro");
		palabras.add("puerta");
		palabras.add("gato");
		palabras.add("vaso");
		palabras.add("raton");
		palabras.add("esdrujula");
		palabras.add("ordenador");
		palabras.add("pastilla");
		palabras.add("monitor");
		palabras.add("servilleta");
		palabras.add("avion");
		palabras.add("mesa");
		palabras.add("camion");
		palabras.add("bebida");
		palabras.add("montaña");
		palabras.add("antena");
		palabras.add("paradoja");
		palabras.add("moroso");
		palabras.add("dinero");
		palabras.add("billete");
		palabras.add("alcohol");
		palabras.add("adiccion");
		palabras.add("boligrafo");
		palabras.add("libreta");
		palabras.add("aprobar");
		palabras.add("explorador");
		palabras.add("conductor");
		palabras.add("cazador");
		palabras.add("biblioteca");
		palabras.add("programa");
		palabras.add("ahorcado");
		palabras.add("juego");
		palabras.add("silla");
		palabras.add("covid");
		palabras.add("vitamina");
		palabras.add("independentismo");
		palabras.add("escribir");
		
	}

	public void generarPalabra() {

		String palabra = "";

		int numRandom = (int) (Math.random() * palabras.size());

		palabra = palabras.get(numRandom);

		this.palabra = palabra;
	}

	public String generarGuiones() {

		String guiones = "";

		for (int i = 0; i < this.palabra.length(); i++) {
			guiones += "-";
		}

		System.out.println(this.palabra);
		
		return guiones;

	}
	
	public String getPalabra() {
		return palabra;
	}


}
