package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.*;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Ventana extends JFrame {

	private JPanel contentPane;

	static Juego juego = new Juego();
	public static Ventana frame;

	private JLabel lblPalabraJugador;
	private JLabel lblVida1, lblVida2, lblVida3, lblVida4, lblVida5, lblVida6, lblAhorcado;

	private JButton btnA, btnB, btnC, btnD, btnE, btnF, btnG, btnH, btnI, btnJ, btnK, btnL, btnM, btnN, btnÑ, btnO,
			btnP, btnQ, btnR, btnS, btnT, btnU, btnV, btnW, btnX, btnY, btnZ;

	private JButton[] botones = new JButton[27];
	
	//{btnA, btnB, btnC, btnD, btnE, btnF, btnG, btnH, btnI, btnJ, btnK, btnL, btnM, btnN,
		//btnÑ, btnO, btnP, btnQ, btnR, btnS, btnT, btnU, btnV, btnW, btnX, btnY, btnZ };

	private char letra = ' ';
	
	public void rellenarBotones() {
		botones[0] = btnA;
		botones[1] = btnB;
		botones[2] = btnC;
		botones[3] = btnD;
		botones[4] = btnE;
		botones[5] = btnF;
		botones[6] = btnG;
		botones[7] = btnH;
		botones[8] = btnI;
		botones[9] = btnJ;
		botones[10] = btnK;
		botones[11] = btnL;
		botones[12] = btnM;
		botones[13] = btnN;
		botones[14] = btnÑ;
		botones[15] = btnO;
		botones[16] = btnP;
		botones[17] = btnQ;
		botones[18] = btnR;
		botones[19] = btnS;
		botones[20] = btnT;
		botones[21] = btnU;
		botones[22] = btnV;
		botones[23] = btnW;
		botones[24] = btnX;
		botones[25] = btnY;
		botones[26] = btnZ;
		
	}

//	public void activarDesactivarBotones(boolean onOf) {
//		for (int i = 0; i < botones.length; i++) {
//			botones[i].setEnabled(onOf);
//			System.out.println(botones[i].toString());
//		}
//	}

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
		setBounds(100, 100, 773, 624);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMenu.setBounds(24, 38, 89, 14);
		contentPane.add(lblMenu);

		JButton btnIniciarJuego = new JButton("Iniciar juego");
		btnIniciarJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juego.iniciarJuego();

			}
		});

		btnIniciarJuego.setBackground(Color.WHITE);
		btnIniciarJuego.setForeground(Color.BLACK);
		btnIniciarJuego.setFont(new Font("Verdana", Font.BOLD, 17));
		btnIniciarJuego.setBounds(34, 63, 255, 35);
		contentPane.add(btnIniciarJuego);

		JButton btnResolver = new JButton("Resolver");
		btnResolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

		botones[0] = btnA = new JButton("A");
		btnA.setEnabled(false);
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'a';
				comprobarLetra(btnA, letra);
			}
		});
		btnA.setBounds(24, 381, 50, 23);
		contentPane.add(btnA);

		btnB = new JButton("B");
		btnB.setEnabled(false);
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'b';
				comprobarLetra(btnB, letra);
			}
		});
		btnB.setBounds(73, 381, 50, 23);
		contentPane.add(btnB);

		btnC = new JButton("C");
		btnC.setEnabled(false);
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'c';
				comprobarLetra(btnC, letra);
			}
		});
		btnC.setBounds(123, 381, 50, 23);
		contentPane.add(btnC);

		btnD = new JButton("D");
		btnD.setEnabled(false);
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'd';
				comprobarLetra(btnD, letra);
			}
		});
		btnD.setBounds(173, 381, 50, 23);
		contentPane.add(btnD);

		btnE = new JButton("E");
		btnE.setEnabled(false);
		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'e';
				comprobarLetra(btnE, letra);
			}
		});
		btnE.setBounds(223, 381, 50, 23);
		contentPane.add(btnE);

		btnF = new JButton("F");
		btnF.setEnabled(false);
		btnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'f';
				comprobarLetra(btnF, letra);
			}
		});
		btnF.setBounds(24, 415, 50, 23);
		contentPane.add(btnF);

		btnG = new JButton("G");
		btnG.setEnabled(false);
		btnG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'g';
				comprobarLetra(btnG, letra);
			}
		});
		btnG.setBounds(73, 415, 50, 23);
		contentPane.add(btnG);

		btnH = new JButton("H");
		btnH.setEnabled(false);
		btnH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'h';
				juego.comprobarLetra(letra);
			}
		});
		btnH.setBounds(123, 415, 50, 23);
		contentPane.add(btnH);

		btnI = new JButton("I");
		btnI.setEnabled(false);
		btnI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'i';
				juego.comprobarLetra(letra);
			}
		});
		btnI.setBounds(173, 415, 50, 23);
		contentPane.add(btnI);

		btnJ = new JButton("J");
		btnJ.setEnabled(false);
		btnJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'j';
				juego.comprobarLetra(letra);
			}
		});
		btnJ.setBounds(223, 415, 50, 23);
		contentPane.add(btnJ);

		btnK = new JButton("K");
		btnK.setEnabled(false);
		btnK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'k';
				juego.comprobarLetra(letra);
			}
		});
		btnK.setBounds(24, 449, 50, 23);
		contentPane.add(btnK);

		btnL = new JButton("L");
		btnL.setEnabled(false);
		btnL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'l';
				juego.comprobarLetra(letra);
			}
		});
		btnL.setBounds(73, 449, 50, 23);
		contentPane.add(btnL);

		btnM = new JButton("M");
		btnM.setEnabled(false);
		btnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'm';
				juego.comprobarLetra(letra);
			}
		});
		btnM.setBounds(123, 449, 50, 23);
		contentPane.add(btnM);

		btnN = new JButton("N");
		btnN.setEnabled(false);
		btnN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'n';
				juego.comprobarLetra(letra);
			}
		});
		btnN.setBounds(173, 449, 50, 23);
		contentPane.add(btnN);

		btnO = new JButton("O");
		btnO.setEnabled(false);
		btnO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'o';
				juego.comprobarLetra(letra);
			}
		});
		btnO.setBounds(24, 483, 50, 23);
		contentPane.add(btnO);

		btnP = new JButton("P");
		btnP.setEnabled(false);
		btnP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'p';
				juego.comprobarLetra(letra);
			}
		});
		btnP.setBounds(74, 483, 50, 23);
		contentPane.add(btnP);

		btnQ = new JButton("Q");
		btnQ.setEnabled(false);
		btnQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'q';
				juego.comprobarLetra(letra);
			}
		});
		btnQ.setBounds(123, 483, 50, 23);
		contentPane.add(btnQ);

		btnR = new JButton("R");
		btnR.setEnabled(false);
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'r';
				juego.comprobarLetra(letra);
			}
		});
		btnR.setBounds(173, 483, 50, 23);
		contentPane.add(btnR);

		btnS = new JButton("S");
		btnS.setEnabled(false);
		btnS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 's';
				juego.comprobarLetra(letra);
			}
		});
		btnS.setBounds(223, 483, 50, 23);
		contentPane.add(btnS);

		btnÑ = new JButton("Ñ");
		btnÑ.setEnabled(false);
		btnÑ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'ñ';
				juego.comprobarLetra(letra);
			}
		});
		btnÑ.setBounds(223, 449, 50, 23);
		contentPane.add(btnÑ);

		btnT = new JButton("T");
		btnT.setEnabled(false);
		btnT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 't';
				juego.comprobarLetra(letra);
			}
		});
		btnT.setBounds(24, 517, 50, 23);
		contentPane.add(btnT);

		btnU = new JButton("U");
		btnU.setEnabled(false);
		btnU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'u';
				juego.comprobarLetra(letra);
			}
		});
		btnU.setBounds(74, 517, 50, 23);
		contentPane.add(btnU);

		btnW = new JButton("W");
		btnW.setEnabled(false);
		btnW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'w';
				juego.comprobarLetra(letra);
			}
		});
		btnW.setBounds(173, 517, 50, 23);
		contentPane.add(btnW);

		btnV = new JButton("V");
		btnV.setEnabled(false);
		btnV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'v';
				juego.comprobarLetra(letra);
			}
		});
		btnV.setBounds(123, 517, 50, 23);
		contentPane.add(btnV);

		btnZ = new JButton("Z");
		btnZ.setEnabled(false);
		btnZ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'z';
				juego.comprobarLetra(letra);
			}
		});
		btnZ.setBounds(74, 551, 50, 23);
		contentPane.add(btnZ);

		btnY = new JButton("Y");
		btnY.setEnabled(false);
		btnY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra = 'y';
				juego.comprobarLetra(letra);
			}
		});
		btnY.setBounds(24, 551, 50, 23);
		contentPane.add(btnY);

		btnX = new JButton("X");
		btnX.setEnabled(false);
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnX.setBounds(223, 517, 50, 23);
		contentPane.add(btnX);

		lblAhorcado = new JLabel("");
		lblAhorcado.setIcon(new ImageIcon(Ventana.class.getResource("/images/ahorcado1.png")));
		lblAhorcado.setBackground(new Color(204, 204, 255));
		lblAhorcado.setHorizontalAlignment(SwingConstants.CENTER);
		lblAhorcado.setBounds(359, 11, 429, 563);
		contentPane.add(lblAhorcado);

		setResizable(false);

		rellenarBotones();

		
	}

	private void comprobarLetra(JButton button, char letra) {
		juego.comprobarLetra(letra);
		button.setEnabled(false);
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
}
