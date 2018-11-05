package br.ufmg.reuso.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *         A caixa de diálogo intermediária que define a
 *         configuração do jogo ou início do jogo com configuração padrão.
 * 
 *         String Retorno = createAndShowGetModo().getReturn() ;
 * 
 *         Ou instanciando a classe ScreenModo como uma janela de diálogo.
 * 
 */
public class ScreenStart extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;

	static String startString = "Start";
	static String configString = "config";
	static String criarProjetoString = "Projeto";
	static String criarCartaESString = "Nova carta ES";
	static String criarCartaProblemaString = "Nova carta Problema";
	static String criarCartaConceitoString = "Nova carta Conceito";
	private String stringReturn;

	// =====================================================================================//
	/**
	 * Construtor da janela de seleção início ou configuração
	 */
	public ScreenStart(ScreenTabuleiro tabuleiro) {
		super(tabuleiro);

		this.setLayout(new BorderLayout());

		// Cria os botões de acesso.

		JPanel Tpanel = new JPanel();
		Tpanel.setLayout(null);

		Dimension dimensionPanel = new Dimension(300, 150);
		Tpanel.setPreferredSize(new Dimension(300, 260));

		Dimension dimensionButton = new Dimension(250, 30);

		//Cálculo da posição dos botões na tela (centralizados)
		
		int posX = (dimensionPanel.width / 2) - (dimensionButton.width / 2);
		int posY = (dimensionPanel.height / 5);

		JButton buttonStart = new JButton("Start");
		buttonStart.setMnemonic(KeyEvent.VK_S);

		buttonStart.setActionCommand(startString);
		buttonStart.setPreferredSize(dimensionButton);
		buttonStart.setBounds(posX, posY, dimensionButton.width,
				dimensionButton.height);

		posY = (3 * (dimensionPanel.height / 5)) - (dimensionButton.height);

		JButton buttonConfig = new JButton("Configurações");
		buttonConfig.setMnemonic(KeyEvent.VK_C);
		buttonConfig.setActionCommand(configString);
		buttonConfig.setPreferredSize(dimensionButton);
		buttonConfig.setBounds(posX, posY, dimensionButton.width,
				dimensionButton.height);

		posY = (4 * (dimensionPanel.height / 5)) - (dimensionButton.height);
		
		JButton buttonProjeto = new JButton("Criar Projeto");
		buttonProjeto.setMnemonic(KeyEvent. VK_P);
		buttonProjeto.setActionCommand(criarProjetoString);
		buttonProjeto.setPreferredSize(dimensionButton);
		buttonProjeto.setBounds(posX, posY, dimensionButton.width,
				dimensionButton.height);
		
		
		
		//#ifdef createSECard		
		posY = (5 * (dimensionPanel.height / 5)) - (dimensionButton.height);
		
		JButton buttonNovaCartaSE = new JButton("Nova Carta Eng SW");
		//buttonNovaCartaSE.setMnemonic(KeyEvent. VK_P);
		buttonNovaCartaSE.setActionCommand(criarCartaESString);
		buttonNovaCartaSE.setPreferredSize(dimensionButton);
		buttonNovaCartaSE.setBounds(posX, posY, dimensionButton.width,
				dimensionButton.height);
		
		buttonNovaCartaSE.addActionListener(this);
		Tpanel.add(buttonNovaCartaSE);
		//#endif
		
		
		//#ifdef createProblemCard
//@		posY = (6 * (dimensionPanel.height / 5)) - (dimensionButton.height);
//@		
//@		JButton buttonNovaCartaProblema = new JButton("Nova Carta Problema");
//@		//buttonNovaCartaProblema.setMnemonic(KeyEvent. VK_P);
//@		buttonNovaCartaProblema.setActionCommand(criarCartaProblemaString);
//@		buttonNovaCartaProblema.setPreferredSize(dimensionButton);
//@		buttonNovaCartaProblema.setBounds(posX, posY, dimensionButton.width,
//@				dimensionButton.height);
//@		
//@		buttonNovaCartaProblema.addActionListener(this);
//@		Tpanel.add(buttonNovaCartaProblema);
		//#endif
		
		
		//#ifdef createConceptCard
//@		posY = (7 * (dimensionPanel.height / 5)) - (dimensionButton.height);
//@		
//@		JButton buttonNovaCartaConceito = new JButton("Nova Carta Conceito");
//@		//buttonNovaCartaConceito.setMnemonic(KeyEvent. VK_P);
//@		buttonNovaCartaConceito.setActionCommand(criarCartaConceitoString);
//@		buttonNovaCartaConceito.setPreferredSize(dimensionButton);
//@		buttonNovaCartaConceito.setBounds(posX, posY, dimensionButton.width,
//@				dimensionButton.height);		
//@		
//@		buttonNovaCartaConceito.addActionListener(this);
//@		Tpanel.add(buttonNovaCartaConceito);
		//#endif

		// Registra os objetos no controle de eventos.
		
		buttonStart.addActionListener(this);
		buttonConfig.addActionListener(this);
		buttonProjeto.addActionListener(this);
		
		Tpanel.add(buttonStart);
		Tpanel.add(buttonConfig);
		Tpanel.add(buttonProjeto);
				
		add(Tpanel);

		getRootPane().setDefaultButton(buttonStart);

		setResizable(false);

	}

	// =====================================================================================//
	/** Controlador de eventos dos botões. */
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand() == "config") {			
			stringReturn = e.getActionCommand();
			ScreenTabuleiro tabuleiro = ScreenTabuleiro.createAndShowTabuleiro(null, null);
			ScreenModo.createAndShowGetModo(tabuleiro).getModeGame();
			
		} else if (e.getActionCommand() == "Start") {
			ScreenStart.this.dispose();	
			stringReturn = e.getActionCommand();
			
		} else if (e.getActionCommand() == "Projeto") {
			ScreenTabuleiro tabuleiro = ScreenTabuleiro.createAndShowTabuleiro(null, null);
			ScreenCreateProject.createAndShowGetCProject(tabuleiro);
			ScreenStart.this.dispose();	
			stringReturn = e.getActionCommand();
			
		} else if (e.getActionCommand() == "Nova carta ES") {
			stringReturn = e.getActionCommand();
			ScreenTabuleiro tabuleiro = ScreenTabuleiro.createAndShowTabuleiro(null, null);
			ScreenNewSECard.createAndShowNewCard(tabuleiro);
		}
	}

	// =====================================================================================//
	/**
	 * Retorna o modo do jogo selecionado na tela
	 */
	public String getReturn() {
		return stringReturn;
	}

	// =====================================================================================//
	/**
	 * Retorna um ImageIcon ou null se o caminho for inválido.
	 * 
	 * @param path
	 *            - String com o caminho da imagem
	 * @return - ImageIcon para ser inserido em um JLabel
	 */
	
	protected static ImageIcon createImageIcon(String path) {
		File fl = new File(path);
		if (fl.isFile()) {
			return new ImageIcon(path);
		} else {
			return null;
		}
	}

	/**
	 * Cria a tela e a faz visível. Por segurança é o método chamado pela Thread
	 * para construção da GUI
	 * 
	 * @param tabuleiro
	 *            - tabuleiro atual
	 * @return - tela com as opções.
	 */
	
	public static ScreenStart createAndShowGetModo(ScreenTabuleiro tabuleiro) {

		// Cria e configura a tela.
		ScreenStart scr = new ScreenStart(tabuleiro);
		scr.rootPane.setOpaque(true);
		scr.pack();		
		scr.setModal(true);
		scr.setLocationRelativeTo(null);
		scr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		scr.addWindowListener(ScreenInteraction.getScreenInteraction().windowsExitGame());
		scr.setVisible(true);
		return scr;
	}
	
	public static void main(String[] args) {

		final ScreenTabuleiro tabuleiro = ScreenTabuleiro
				.createAndShowTabuleiro(null, null);
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				createAndShowGetModo(tabuleiro);
			}
		});
	}

}
