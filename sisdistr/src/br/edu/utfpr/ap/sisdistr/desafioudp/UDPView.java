package br.edu.utfpr.ap.sisdistr.desafioudp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UDPView extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8670791162453534302L;
	JPanel panel;
	JButton server;
	JButton client;
	JPanel screen;
	JLabel lblX;
	JLabel lblY;
	JTextField txtX;
	JTextField txtY;
	JButton enviar;
	UDPServer udpServer;
	UDPClient udpClient;

	public UDPView() {
		super("Server/Client UDP");
	}
	
	public void initialize() {
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(1, 1));
		createPanel();
		setVisible(true);
	}
	
	private void setText(String title) {
		super.setTitle(title);
	}
	
	private void createPanel() {
		BorderLayout layout = new BorderLayout();
		//int[] rw = {10,580,10}; 
		//gbLayout.
		panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(layout);
		//Painel Superior
		JPanel superior = new JPanel();
		panel.add(superior, BorderLayout.NORTH);
		superior.setLayout(new FlowLayout());
		server = new JButton("Abrir servidor");
		client = new JButton("Abrir cliente");
		server.addActionListener(new ServerListener());
		client.addActionListener(new ClientListener());
		superior.add(server);
		superior.add(client);
		// Painel central
		screen = new JPanel();
		panel.add(screen, BorderLayout.CENTER);
		//Painel inferior;
		JPanel inferior = new JPanel();
		panel.add(inferior, BorderLayout.SOUTH);
		inferior.setLayout(new FlowLayout());
		lblX = new JLabel("X:");
		inferior.add(lblX);
		txtX = new JTextField("       ");
		inferior.add(txtX);
		lblY = new JLabel("Y:");
		inferior.add(lblY);
		txtY = new JTextField("       ");
		inferior.add(txtY);
		enviar = new JButton("Enviar");
		enviar.addActionListener(new EnviarListener());
		inferior.add(enviar);
		enableClient(false);
	}
	
	private void enableClient(boolean enabled) {
		server.setEnabled(!enabled);
		client.setEnabled(!enabled);
		txtX.setEnabled(enabled);
		txtY.setEnabled(enabled);
		enviar.setEnabled(enabled);
	}
	
	public void createServer() {
		
	}
	
	public void createClient() {
		
	}
	
	class ServerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			udpServer = new UDPServer(screen);
			udpServer.start();
			server.setEnabled(false);
			client.setEnabled(false);
			setText("Servidor UDP - Iniciado aguardando requisições...");
		}
	}
	class ClientListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			enableClient(true);
			udpClient = new UDPClient();
			setText("Cliente UDP - Iniciado...");
			txtX.requestFocus();
		}
	}
	class EnviarListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				int x = Integer.parseInt(txtX.getText().trim());
				int y = Integer.parseInt(txtY.getText().trim());
				udpClient.desenhar(x, y);
			} catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(panel, "Não é possível converter para inteiro: " + nfe.getMessage(),
						"Erro!", JOptionPane.ERROR_MESSAGE);
				txtX.setText("");
				txtY.setText("");
				txtX.requestFocus();
			}
		}
	}

}
