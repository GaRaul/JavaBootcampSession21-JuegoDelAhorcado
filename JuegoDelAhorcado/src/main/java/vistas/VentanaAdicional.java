package vistas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Juego;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VentanaAdicional extends JFrame {

	private JPanel contentPane;
	public static VentanaAdicional frame;
	private JButton btnFacil;
	private JButton btnIntermedio;
	private JButton btnDificil;
	private static String nivel = "";
	static Juego juego;

	/**
	 * Launch the application.
	 */
	public static void vista(Juego j) {
		juego = j;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAdicional frame = new VentanaAdicional();
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
	public VentanaAdicional() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 176);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnFacil = new JButton("FACIL");
		btnFacil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juego.ponerDificultad(1);
				juego.iniciarJuego();
			}
		});

		btnFacil.setBounds(40, 72, 89, 23);
		contentPane.add(btnFacil);

		btnIntermedio = new JButton("INTERMEDIO");
		btnIntermedio.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				juego.ponerDificultad(2);
				juego.iniciarJuego();
			}
		});
		btnIntermedio.setBounds(149, 72, 100, 23);
		contentPane.add(btnIntermedio);

		btnDificil = new JButton("DIFICIL");
		btnDificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juego.ponerDificultad(3);
				juego.iniciarJuego();
			}
		});
		btnDificil.setBounds(270, 72, 89, 23);
		contentPane.add(btnDificil);

		JLabel lblTexto = new JLabel("SELECCIONA UNA DIFICULTAD");
		lblTexto.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblTexto.setBounds(47, 29, 405, 32);
		contentPane.add(lblTexto);
	}

	public JButton getBtnFacil() {
		return btnFacil;
	}

	public void setBtnFacil(JButton btnFacil) {
		this.btnFacil = btnFacil;
	}

	public JButton getBtnIntermedio() {
		return btnIntermedio;
	}

	public void setBtnIntermedio(JButton btnIntermedio) {
		this.btnIntermedio = btnIntermedio;
	}

	public JButton getBtnDificil() {
		return btnDificil;
	}

	public void setBtnDificil(JButton btnDificil) {
		this.btnDificil = btnDificil;
	}

	public static String getNivel() {
		return nivel;
	}

	public static void setNivel(String nivel) {
		VentanaAdicional.nivel = nivel;
	}

}
