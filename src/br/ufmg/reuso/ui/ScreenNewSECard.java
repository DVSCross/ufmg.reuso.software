package br.ufmg.reuso.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.ufmg.reuso.negocio.carta.CartaEngenheiro;

public class ScreenNewSECard extends JDialog implements ActionListener  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textCodigo;
	private JTextField textNome;
	private JTextField textSalario;
	private JTextField textHabilidade;
	private JTextField textMaturidade;
	private JTextArea textTexto;
	
	
	public ScreenNewSECard(ScreenTabuleiro tabuleiro) {
		super(tabuleiro);

		this.setLocationRelativeTo(tabuleiro);
		this.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setLayout(null);

		panel.setPreferredSize(new Dimension(360, 300));
		
		Dimension labelDim = new Dimension(100, 30);
		Dimension textDim = new Dimension(150, 30);
		
		JLabel labelCodigo = new JLabel("Cod");
		labelCodigo.setBounds(10, 0 * labelDim.height + 10, labelDim.width, labelDim.height);
		labelCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(labelCodigo);
		
		JLabel labelNome  = new JLabel("Nome");
		labelNome.setBounds(10, 1 * labelDim.height + 10, labelDim.width, labelDim.height);
		labelNome.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(labelNome);
		
		JLabel labelSalario  = new JLabel("Salario");
		labelSalario.setBounds(10, 2 * labelDim.height + 10, labelDim.width, labelDim.height);
		labelSalario.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(labelSalario);
		
		JLabel labelHabilidade  = new JLabel("Habilidade");
		labelHabilidade.setBounds(10, 3 * labelDim.height + 10, labelDim.width, labelDim.height);
		labelHabilidade.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(labelHabilidade);
		
		JLabel labelMaturidade  = new JLabel("Maturidade");
		labelMaturidade.setBounds(10, 4 * labelDim.height + 10, labelDim.width, labelDim.height);
		labelMaturidade.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(labelMaturidade);
		
		JLabel labelTexto  = new JLabel("Texto");
		labelTexto.setBounds(10, 5 * labelDim.height + 10, labelDim.width, labelDim.height);
		labelTexto.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(labelTexto);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(textDim.width + 50, 0 * textDim.height + 10, textDim.width,
				textDim.height);
		textCodigo.addActionListener(this);
		textCodigo.setActionCommand(Integer.toString(0));
		panel.add(textCodigo);
		
		textNome = new JTextField();
		textNome.setBounds(textDim.width + 50, 1 * textDim.height + 10, textDim.width,
				textDim.height);
		textNome.addActionListener(this);
		textNome.setActionCommand(Integer.toString(1));
		panel.add(textNome);
				
		textSalario = new JTextField();
		textSalario.setBounds(textDim.width + 50, 2 * textDim.height + 10, textDim.width,
				textDim.height);
		textSalario.addActionListener(this);
		textSalario.setActionCommand(Integer.toString(2));
		panel.add(textSalario);
				
		textHabilidade = new JTextField();
		textHabilidade.setBounds(textDim.width + 50, 3 * textDim.height + 10, textDim.width,
				textDim.height);
		textHabilidade.addActionListener(this);
		textHabilidade.setActionCommand(Integer.toString(3));
		panel.add(textHabilidade);
		
		textMaturidade = new JTextField();
		textMaturidade.setBounds(textDim.width + 50, 4 * textDim.height + 10, textDim.width,
				textDim.height);
		textMaturidade.addActionListener(this);
		textMaturidade.setActionCommand(Integer.toString(4));
		panel.add(textMaturidade);
		
		textTexto = new JTextArea();
		textTexto.setBounds(textDim.width + 50, 5 * textDim.height + 10, textDim.width,
				textDim.height+25);
		panel.add(textTexto);
		
		
		JButton buttonOk = new JButton("OK");
		buttonOk.addActionListener(this);
		buttonOk.setBounds(250, 8 * 30 + 10, 80, 25);
		panel.add(buttonOk);
			
		add(panel, BorderLayout.CENTER);
				
		getRootPane().setDefaultButton(buttonOk);
		
		setResizable(false);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "OK") {
			createCartaEngenheiro();
			ScreenNewSECard.this.dispose();
		}		
	}
	
	public void createCartaEngenheiro() {
		String codigo = textCodigo.getText();
		String nome = textNome.getText();
		String texto = textTexto.getText();
		int salario = Integer.parseInt(textSalario.getText());
		int habilidade = Integer.parseInt(textHabilidade.getText());
		int maturidade = Integer.parseInt(textMaturidade.getText());
		
		CartaEngenheiro card = new CartaEngenheiro(codigo, texto, nome, salario, habilidade, maturidade);
		
		UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
		
        card.dumpProperties("online/" + randomUUIDString + "-SE.properties");
		
		System.out.println(card);
	}
	
	//=====================================================================================//
	/**
	 * Cria a tela e a faz visível. Por segurança é o método chamado pela Thread
	 * para construção da GUI
	 * @param tabuleiro - tabueliro do jogo atual
	 */
	public static ScreenNewSECard createAndShowNewCard(ScreenTabuleiro tabuleiro) {

		// Cria e configura a tela.
		ScreenNewSECard scr = new ScreenNewSECard(tabuleiro);
		scr.rootPane.setOpaque(true);		
		scr.pack();
		scr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		scr.addWindowListener(ScreenInteraction.getScreenInteraction().windowsExitGame());
		scr.setModal(true);
		scr.setLocationRelativeTo(null);
		scr.setVisible(true);

		return scr;
	}

}


