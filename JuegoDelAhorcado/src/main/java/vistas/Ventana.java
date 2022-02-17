package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.*;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Ventana extends JFrame {

	private JPanel contentPane;

	Juego juego = new Juego();

	public static Ventana frame;

	private JLabel[] vidas;
	private JButton[] botones;
	private JLabel lblPalabraJugador, lblPalabraResuelta, lblVida1, lblVida2, lblVida3, lblVida4, lblVida5, lblVida6,
			lblAhorcado;

	private JButton btnResolver, btnPista, btnA, btnB, btnC, btnD, btnE, btnF, btnG, btnH, btnI, btnJ, btnK, btnL, btnM,
			btnN, btnÑ, btnO, btnP, btnQ, btnR, btnS, btnT, btnU, btnV, btnW, btnX, btnY, btnZ;

	private JMenuItem fallosTotales;

	private char letra = ' ';

	/**
	 * Launch the application.
	 */
	public static void vista() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setTitle("Juego del ahorcado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 649);

		JMenuBar barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenu archivo = new JMenu("Archivo");
		JMenu info = new JMenu("Información");

		JMenuItem salir = new JMenuItem("Salir");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		JMenuItem nuevoJuego = new JMenuItem("Nuevo juego");
		nuevoJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juego.iniciarJuego();
			}
		});
		JMenuItem palabraNueva = new JMenuItem("Añadir palabra");
		palabraNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String palabraNueva = JOptionPane.showInputDialog("Introduce la palabra que quieres añadir al diccionario de palabras");
				juego.nuevaPalabra(palabraNueva);
				
			}
		});
		JMenuItem comoJugar = new JMenuItem("Como jugar");
		comoJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Descripción general. Usando una fila de guiones, se representa la palabra a adivinar,\n"
						+ " dando el número de letras, números y categoría. Si el jugador adivinador sugiere una letra o \n"
						+ "número que aparece en la palabra, el otro jugador la escribe en todas sus posiciones correctas.");
			}
		});
		JMenuItem acercaDe = new JMenuItem("Acerca de");
		acercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "AUTORES\nAbel, Edgar y Raúl");
			}
		});

		fallosTotales = new JMenuItem("Fallos totales: ");

		barraMenu.add(archivo);
		barraMenu.add(info);
		barraMenu.add(fallosTotales);

		archivo.add(nuevoJuego);
		archivo.add(salir);
		archivo.add(palabraNueva);
		info.add(comoJugar);
		info.add(acercaDe);

		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMenu.setBounds(24, 38, 89, 14);
		contentPane.add(lblMenu);

		JButton btnIniciarJuego = new JButton("Iniciar juego");
		btnIniciarJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdicional.vista(juego);
			}
		});
		btnIniciarJuego.setFont(new Font("Verdana", Font.BOLD, 17));
		btnIniciarJuego.setBounds(34, 63, 255, 35);
		contentPane.add(btnIniciarJuego);

		btnResolver = new JButton("Resolver");
		btnResolver.setEnabled(false);
		btnResolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juego.resolver();
			}
		});
		btnResolver.setFont(new Font("Verdana", Font.BOLD, 17));
		btnResolver.setBounds(34, 97, 255, 35);
		contentPane.add(btnResolver);

		lblVida1 = new JLabel("");
		lblVida1.setIcon(new ImageIcon(Ventana.class.getResource("/images/vida.png")));
		lblVida1.setBounds(24, 184, 35, 62);
		contentPane.add(lblVida1);

		lblVida2 = new JLabel("");
		lblVida2.setIcon(new ImageIcon(Ventana.class.getResource("/images/vida.png")));
		lblVida2.setBounds(80, 184, 35, 62);
		contentPane.add(lblVida2);

		lblVida3 = new JLabel("");
		lblVida3.setIcon(new ImageIcon(Ventana.class.getResource("/images/vida.png")));
		lblVida3.setBounds(136, 184, 35, 62);
		contentPane.add(lblVida3);

		lblVida4 = new JLabel("");
		lblVida4.setIcon(new ImageIcon(Ventana.class.getResource("/images/vida.png")));
		lblVida4.setBounds(192, 184, 35, 62);
		contentPane.add(lblVida4);

		lblVida5 = new JLabel("");
		lblVida5.setIcon(new ImageIcon(Ventana.class.getResource("/images/vida.png")));
		lblVida5.setBounds(248, 184, 35, 62);
		contentPane.add(lblVida5);

		lblVida6 = new JLabel("New label");
		lblVida6.setIcon(new ImageIcon(Ventana.class.getResource("/images/vida.png")));
		lblVida6.setBounds(304, 184, 35, 62);
		contentPane.add(lblVida6);

		JLabel lblPalabraSecreta = new JLabel("Palabra secreta");
		lblPalabraSecreta.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPalabraSecreta.setBounds(24, 257, 158, 14);
		contentPane.add(lblPalabraSecreta);

		lblPalabraJugador = new JLabel("");
		lblPalabraJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblPalabraJugador.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblPalabraJugador.setForeground(Color.BLACK);
		lblPalabraJugador.setBackground(Color.GRAY);
		lblPalabraJugador.setBounds(10, 282, 367, 35);
		contentPane.add(lblPalabraJugador);

		JLabel lblTeclado = new JLabel("Teclado");
		lblTeclado.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTeclado.setBounds(24, 356, 89, 14);
		contentPane.add(lblTeclado);

		btnA = new JButton("A");
		btnA.setEnabled(false);
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'A';
				juego.comprobarLetra(letra, btnA);
			}
		});
		btnA.setBounds(24, 381, 50, 23);
		contentPane.add(btnA);

		btnB = new JButton("B");
		btnB.setEnabled(false);
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'B';
				juego.comprobarLetra(letra, btnB);
			}
		});
		btnB.setBounds(73, 381, 50, 23);
		contentPane.add(btnB);

		btnC = new JButton("C");
		btnC.setEnabled(false);
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'C';
				juego.comprobarLetra(letra, btnC);
			}
		});
		btnC.setBounds(123, 381, 50, 23);
		contentPane.add(btnC);

		btnD = new JButton("D");
		btnD.setEnabled(false);
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'D';
				juego.comprobarLetra(letra, btnD);
			}
		});
		btnD.setBounds(173, 381, 50, 23);
		contentPane.add(btnD);

		btnE = new JButton("E");
		btnE.setEnabled(false);
		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'E';
				juego.comprobarLetra(letra, btnE);
			}
		});
		btnE.setBounds(223, 381, 50, 23);
		contentPane.add(btnE);

		btnF = new JButton("F");
		btnF.setEnabled(false);
		btnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'F';
				juego.comprobarLetra(letra, btnF);
			}
		});
		btnF.setBounds(24, 415, 50, 23);
		contentPane.add(btnF);

		btnG = new JButton("G");
		btnG.setEnabled(false);
		btnG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'G';
				juego.comprobarLetra(letra, btnG);
			}
		});
		btnG.setBounds(73, 415, 50, 23);
		contentPane.add(btnG);

		btnH = new JButton("H");
		btnH.setEnabled(false);
		btnH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'H';
				juego.comprobarLetra(letra, btnH);
			}
		});
		btnH.setBounds(123, 415, 50, 23);
		contentPane.add(btnH);

		btnI = new JButton("I");
		btnI.setEnabled(false);
		btnI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'I';
				juego.comprobarLetra(letra, btnI);
			}
		});
		btnI.setBounds(173, 415, 50, 23);
		contentPane.add(btnI);

		btnJ = new JButton("J");
		btnJ.setEnabled(false);
		btnJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'J';
				juego.comprobarLetra(letra, btnJ);
			}
		});
		btnJ.setBounds(223, 415, 50, 23);
		contentPane.add(btnJ);

		btnK = new JButton("K");
		btnK.setEnabled(false);
		btnK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'K';
				juego.comprobarLetra(letra, btnK);
			}
		});
		btnK.setBounds(24, 449, 50, 23);
		contentPane.add(btnK);

		btnL = new JButton("L");
		btnL.setEnabled(false);
		btnL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'L';
				juego.comprobarLetra(letra, btnL);
			}
		});
		btnL.setBounds(73, 449, 50, 23);
		contentPane.add(btnL);

		btnM = new JButton("M");
		btnM.setEnabled(false);
		btnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'M';
				juego.comprobarLetra(letra, btnM);
			}
		});
		btnM.setBounds(123, 449, 50, 23);
		contentPane.add(btnM);

		btnN = new JButton("N");
		btnN.setEnabled(false);
		btnN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'N';
				juego.comprobarLetra(letra, btnN);
			}
		});
		btnN.setBounds(173, 449, 50, 23);
		contentPane.add(btnN);

		btnO = new JButton("O");
		btnO.setEnabled(false);
		btnO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'O';
				juego.comprobarLetra(letra, btnO);
			}
		});
		btnO.setBounds(24, 483, 50, 23);
		contentPane.add(btnO);

		btnP = new JButton("P");
		btnP.setEnabled(false);
		btnP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'P';
				juego.comprobarLetra(letra, btnP);
			}
		});
		btnP.setBounds(74, 483, 50, 23);
		contentPane.add(btnP);

		btnQ = new JButton("Q");
		btnQ.setEnabled(false);
		btnQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'Q';
				juego.comprobarLetra(letra, btnQ);
			}
		});
		btnQ.setBounds(123, 483, 50, 23);
		contentPane.add(btnQ);

		btnR = new JButton("R");
		btnR.setEnabled(false);
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'R';
				juego.comprobarLetra(letra, btnR);
			}
		});
		btnR.setBounds(173, 483, 50, 23);
		contentPane.add(btnR);

		btnS = new JButton("S");
		btnS.setEnabled(false);
		btnS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'S';
				juego.comprobarLetra(letra, btnS);
			}
		});
		btnS.setBounds(223, 483, 50, 23);
		contentPane.add(btnS);

		btnÑ = new JButton("Ñ");
		btnÑ.setEnabled(false);
		btnÑ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'Ñ';
				juego.comprobarLetra(letra, btnÑ);
			}
		});
		btnÑ.setBounds(223, 449, 50, 23);
		contentPane.add(btnÑ);

		btnT = new JButton("T");
		btnT.setEnabled(false);
		btnT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'T';
				juego.comprobarLetra(letra, btnT);
			}
		});
		btnT.setBounds(24, 517, 50, 23);
		contentPane.add(btnT);

		btnU = new JButton("U");
		btnU.setEnabled(false);
		btnU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'U';
				juego.comprobarLetra(letra, btnU);
			}
		});
		btnU.setBounds(74, 517, 50, 23);
		contentPane.add(btnU);

		btnW = new JButton("W");
		btnW.setEnabled(false);
		btnW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'W';
				juego.comprobarLetra(letra, btnW);
			}
		});
		btnW.setBounds(173, 517, 50, 23);
		contentPane.add(btnW);

		btnV = new JButton("V");
		btnV.setEnabled(false);
		btnV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'V';
				juego.comprobarLetra(letra, btnV);
			}
		});
		btnV.setBounds(123, 517, 50, 23);
		contentPane.add(btnV);

		btnZ = new JButton("Z");
		btnZ.setEnabled(false);
		btnZ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'Z';
				juego.comprobarLetra(letra, btnZ);
			}
		});
		btnZ.setBounds(74, 551, 50, 23);
		contentPane.add(btnZ);

		btnY = new JButton("Y");
		btnY.setEnabled(false);
		btnY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'Y';
				juego.comprobarLetra(letra, btnY);
			}
		});
		btnY.setBounds(24, 551, 50, 23);
		contentPane.add(btnY);

		btnX = new JButton("X");
		btnX.setEnabled(false);
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'X';
				juego.comprobarLetra(letra, btnX);
			}
		});
		btnX.setBounds(223, 517, 50, 23);
		contentPane.add(btnX);

		vidas = new JLabel[] { lblVida1, lblVida2, lblVida3, lblVida4, lblVida5, lblVida6 };

		botones = new JButton[] { btnA, btnB, btnC, btnD, btnE, btnF, btnG, btnH, btnI, btnJ, btnK, btnL, btnM, btnN,
				btnÑ, btnO, btnP, btnQ, btnR, btnS, btnT, btnU, btnV, btnW, btnX, btnY, btnZ };

		lblAhorcado = new JLabel("");
		lblAhorcado.setIcon(new ImageIcon(Ventana.class.getResource("/images/ahorcado1.png")));
		lblAhorcado.setBackground(new Color(204, 204, 255));
		lblAhorcado.setHorizontalAlignment(SwingConstants.CENTER);
		lblAhorcado.setBounds(345, 38, 446, 469);
		contentPane.add(lblAhorcado);

		lblPalabraResuelta = new JLabel("");
		lblPalabraResuelta.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPalabraResuelta.setBounds(136, 551, 140, 23);
		contentPane.add(lblPalabraResuelta);

		btnPista = new JButton("PISTA");
		btnPista.setEnabled(false);
		btnPista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juego.darPista();
			}
		});
		btnPista.setBackground(Color.YELLOW);
		btnPista.setForeground(Color.RED);
		btnPista.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnPista.setBounds(345, 517, 106, 57);
		contentPane.add(btnPista);

		setResizable(false);

	}

	// GETTERS Y SETTERS
	public JLabel getLblPalabraJugador() {
		return lblPalabraJugador;
	}

	public void setLblPalabraJugador(JLabel lblPalabraJugador) {
		this.lblPalabraJugador = lblPalabraJugador;
	}

	public JLabel getLblVida1() {
		return lblVida1;
	}

	public void setLblVida1(JLabel lblVida1) {
		this.lblVida1 = lblVida1;
	}

	public JLabel getLblVida2() {
		return lblVida2;
	}

	public void setLblVida2(JLabel lblVida2) {
		this.lblVida2 = lblVida2;
	}

	public JLabel getLblVida3() {
		return lblVida3;
	}

	public void setLblVida3(JLabel lblVida3) {
		this.lblVida3 = lblVida3;
	}

	public JLabel getLblVida4() {
		return lblVida4;
	}

	public void setLblVida4(JLabel lblVida4) {
		this.lblVida4 = lblVida4;
	}

	public JLabel getLblVida5() {
		return lblVida5;
	}

	public void setLblVida5(JLabel lblVida5) {
		this.lblVida5 = lblVida5;
	}

	public JLabel getLblVida6() {
		return lblVida6;
	}

	public void setLblVida6(JLabel lblVida6) {
		this.lblVida6 = lblVida6;
	}

	public JLabel getLblAhorcado() {
		return lblAhorcado;
	}

	public void setLblAhorcado(JLabel lblAhorcado) {
		this.lblAhorcado = lblAhorcado;
	}

	public JButton[] getBotones() {
		return botones;
	}

	public void setBotones(JButton[] botones) {
		this.botones = botones;
	}

	public JLabel[] getVidas() {
		return vidas;
	}

	public void setVidas(JLabel[] vidas) {
		this.vidas = vidas;
	}

	public JLabel getLblPalabraResuelta() {
		return lblPalabraResuelta;
	}

	public void setLblPalabraResuelta(JLabel lblPalabraResuelta) {
		this.lblPalabraResuelta = lblPalabraResuelta;
	}

	public JButton getBtnResolver() {
		return btnResolver;
	}

	public void setBtnResolver(JButton btnResolver) {
		this.btnResolver = btnResolver;
	}

	public JButton getBtnPista() {
		return btnPista;
	}

	public void setBtnPista(JButton btnPista) {
		this.btnPista = btnPista;
	}

	public JMenuItem getFallosTotales() {
		return fallosTotales;
	}

	public void setFallosTotales(JMenuItem fallosTotales) {
		this.fallosTotales = fallosTotales;
	}
	
	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}
}
