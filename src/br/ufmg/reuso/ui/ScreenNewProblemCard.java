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

import br.ufmg.reuso.negocio.carta.CartaPenalizacao;

public class ScreenNewProblemCard extends JDialog implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField textCodigo;
	JTextField textTitulo;
	JTextArea textTexto;
	JTextField textReferencia;
	JTextField textDuracao;
	JTextField textCondicao;
	JTextField textCusto;
	JTextField textQtdePrimeiroEfeito;
	JTextField textQtdeSegundoEfeito;
	JTextField textTipoPrimeiroEfeito;
	JTextField textTipoSegundoEfeito;
	JTextField textEfeito;
	JTextField textQtdePrimeiraCondicao;
	JTextField textQtdeSegundaCondicao;
	JTextField textTipoPrimeiraCondicao;
	JTextField textTipoSegundaCondicao;
	
	public ScreenNewProblemCard(ScreenTabuleiro tabuleiro) {
		super(tabuleiro);

		this.setLocationRelativeTo(tabuleiro);
		this.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setLayout(null);

		panel.setPreferredSize(new Dimension(360, 600));
		
		Dimension labelDim = new Dimension(100, 30);
		Dimension textDim = new Dimension(150, 30);
		
		// Labels
		
		JLabel labelCodigo = new JLabel("Cod");
		labelCodigo.setBounds(10, 0 * labelDim.height + 10, labelDim.width, labelDim.height);
		labelCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(labelCodigo);
		
		JLabel labelTitulo  = new JLabel("Título");
		labelTitulo.setBounds(10, 1 * labelDim.height + 10, labelDim.width, labelDim.height);
		labelTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(labelTitulo);		
		
		JLabel labelReferencia  = new JLabel("Referência");
		labelReferencia.setBounds(10, 2 * labelDim.height + 10, labelDim.width, labelDim.height);
		labelReferencia.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(labelReferencia);
		
		JLabel labelDuracao  = new JLabel("Duração");
		labelDuracao.setBounds(10, 3 * labelDim.height + 10, labelDim.width, labelDim.height);
		labelDuracao.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(labelDuracao);
		
		JLabel labelCondicao  = new JLabel("Condição");
		labelCondicao.setBounds(10, 4 * labelDim.height + 10, labelDim.width, labelDim.height);
		labelCondicao.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(labelCondicao);
		
		JLabel labelEfeito  = new JLabel("Duração Efeito");
		labelEfeito.setBounds(10, 5 * labelDim.height + 10, labelDim.width, labelDim.height);
		labelEfeito.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(labelEfeito);
		
		JLabel labelCusto  = new JLabel("Custo");
		labelCusto.setBounds(10, 6 * labelDim.height + 10, labelDim.width, labelDim.height);
		labelCusto.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(labelCusto);
		
		JLabel labelQtdePrimeiroEfeito  = new JLabel("Qtde 1º efeito");
		labelQtdePrimeiroEfeito.setBounds(10, 7 * labelDim.height + 10, labelDim.width, labelDim.height);
		labelQtdePrimeiroEfeito.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(labelQtdePrimeiroEfeito);
		
		JLabel labelQtdeSegundoEfeito  = new JLabel("Qtde 2º efeito");
		labelQtdeSegundoEfeito.setBounds(10, 8 * labelDim.height + 10, labelDim.width, labelDim.height);
		labelQtdeSegundoEfeito.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(labelQtdeSegundoEfeito);
		
		JLabel labelTipoPrimeiroEfeito  = new JLabel("Tipo 1º efeito");
		labelTipoPrimeiroEfeito.setBounds(10, 9 * labelDim.height + 10, labelDim.width, labelDim.height);
		labelTipoPrimeiroEfeito.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(labelTipoPrimeiroEfeito);
		
		JLabel labelTipoSegundoEfeito  = new JLabel("Tipo 2º efeito");
		labelTipoSegundoEfeito.setBounds(10, 10 * labelDim.height + 10, labelDim.width, labelDim.height);
		labelTipoSegundoEfeito.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(labelTipoSegundoEfeito);
		
		JLabel labelQuantidadePrimeiraCondicao  = new JLabel("Quantidade 1ª condiçao");
		labelQuantidadePrimeiraCondicao.setBounds(10, 11 * labelDim.height + 10, labelDim.width, labelDim.height);
		labelQuantidadePrimeiraCondicao.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(labelQuantidadePrimeiraCondicao);
		
		JLabel labelQuantidadeSegundaCondicao  = new JLabel("Quantidade 2ª condiçao");
		labelQuantidadeSegundaCondicao.setBounds(10, 12 * labelDim.height + 10, labelDim.width, labelDim.height);
		labelQuantidadeSegundaCondicao.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(labelQuantidadeSegundaCondicao);
		
		JLabel labelTipoPrimeiraCondicao  = new JLabel("Tipo 1ª condiçao");
		labelTipoPrimeiraCondicao.setBounds(10, 13 * labelDim.height + 10, labelDim.width, labelDim.height);
		labelTipoPrimeiraCondicao.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(labelTipoPrimeiraCondicao);
		
		JLabel labelTipoSegundaCondicao  = new JLabel("Tipo 2ª condiçao");
		labelTipoSegundaCondicao.setBounds(10, 14 * labelDim.height + 10, labelDim.width, labelDim.height);
		labelTipoSegundaCondicao.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(labelTipoSegundaCondicao);
		
		JLabel labelTexto  = new JLabel("Texto");
		labelTexto.setBounds(10, 15 * labelDim.height + 15, labelDim.width, labelDim.height);
		labelTexto.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(labelTexto);
		
		// Text fields
		
		textCodigo = new JTextField();
		textCodigo.setBounds(textDim.width + 50, 0 * textDim.height + 10, textDim.width,
				textDim.height);
		textCodigo.addActionListener(this);
		textCodigo.setActionCommand(Integer.toString(0));
		panel.add(textCodigo);
		
		textTitulo = new JTextField();
		textTitulo.setBounds(textDim.width + 50, 1 * textDim.height + 10, textDim.width,
				textDim.height);
		textTitulo.addActionListener(this);
		textTitulo.setActionCommand(Integer.toString(1));
		panel.add(textTitulo);
		
				
		textReferencia = new JTextField();
		textReferencia.setBounds(textDim.width + 50, 2 * textDim.height + 10, textDim.width,
				textDim.height);
		textReferencia.addActionListener(this);
		textReferencia.setActionCommand(Integer.toString(2));
		panel.add(textReferencia);
				
		textDuracao = new JTextField();
		textDuracao.setBounds(textDim.width + 50, 3 * textDim.height + 10, textDim.width,
				textDim.height);
		textDuracao.addActionListener(this);
		textDuracao.setActionCommand(Integer.toString(3));
		panel.add(textDuracao);
						
		textCondicao = new JTextField();
		textCondicao.setBounds(textDim.width + 50, 4 * textDim.height + 10, textDim.width,
				textDim.height);
		textCondicao.addActionListener(this);
		textCondicao.setActionCommand(Integer.toString(4));
		panel.add(textCondicao);
		
		textEfeito = new JTextField();
		textEfeito.setBounds(textDim.width + 50, 5 * textDim.height + 10, textDim.width,
				textDim.height);
		textEfeito.addActionListener(this);
		textEfeito.setActionCommand(Integer.toString(4));
		panel.add(textEfeito);
		
		textCusto = new JTextField();
		textCusto.setBounds(textDim.width + 50, 6 * textDim.height + 10, textDim.width,
				textDim.height);
		textCusto.addActionListener(this);
		textCusto.setActionCommand(Integer.toString(4));
		panel.add(textCusto);
		
		
		textQtdePrimeiroEfeito = new JTextField();
		textQtdePrimeiroEfeito.setBounds(textDim.width + 50, 7 * textDim.height + 10, textDim.width,
				textDim.height);
		textQtdePrimeiroEfeito.addActionListener(this);
		textQtdePrimeiroEfeito.setActionCommand(Integer.toString(4));
		panel.add(textQtdePrimeiroEfeito);
		
		textQtdeSegundoEfeito = new JTextField();
		textQtdeSegundoEfeito.setBounds(textDim.width + 50, 8 * textDim.height + 10, textDim.width,
				textDim.height);
		textQtdeSegundoEfeito.addActionListener(this);
		textQtdeSegundoEfeito.setActionCommand(Integer.toString(4));
		panel.add(textQtdeSegundoEfeito);
		
		textTipoPrimeiroEfeito = new JTextField();
		textTipoPrimeiroEfeito.setBounds(textDim.width + 50, 9 * textDim.height + 10, textDim.width,
				textDim.height);
		textTipoPrimeiroEfeito.addActionListener(this);
		textTipoPrimeiroEfeito.setActionCommand(Integer.toString(4));
		panel.add(textTipoPrimeiroEfeito);
		
		textTipoSegundoEfeito = new JTextField();
		textTipoSegundoEfeito.setBounds(textDim.width + 50, 10 * textDim.height + 10, textDim.width,
				textDim.height);
		textTipoSegundoEfeito.addActionListener(this);
		textTipoSegundoEfeito.setActionCommand(Integer.toString(4));
		panel.add(textTipoSegundoEfeito);
						
		textQtdePrimeiraCondicao = new JTextField();
		textQtdePrimeiraCondicao.setBounds(textDim.width + 50, 11 * textDim.height + 10, textDim.width,
				textDim.height);
		textQtdePrimeiraCondicao.addActionListener(this);
		textQtdePrimeiraCondicao.setActionCommand(Integer.toString(4));
		panel.add(textQtdePrimeiraCondicao);
		
		textQtdeSegundaCondicao = new JTextField();
		textQtdeSegundaCondicao.setBounds(textDim.width + 50, 12 * textDim.height + 10, textDim.width,
				textDim.height);
		textQtdeSegundaCondicao.addActionListener(this);
		textQtdeSegundaCondicao.setActionCommand(Integer.toString(4));
		panel.add(textQtdeSegundaCondicao);		
		
		textTipoPrimeiraCondicao = new JTextField();
		textTipoPrimeiraCondicao.setBounds(textDim.width + 50, 13 * textDim.height + 10, textDim.width,
				textDim.height);
		textTipoPrimeiraCondicao.addActionListener(this);
		textTipoPrimeiraCondicao.setActionCommand(Integer.toString(4));
		panel.add(textTipoPrimeiraCondicao);
		
		textTipoSegundaCondicao = new JTextField();
		textTipoSegundaCondicao.setBounds(textDim.width + 50, 14 * textDim.height + 10, textDim.width,
				textDim.height);
		textTipoSegundaCondicao.addActionListener(this);
		textTipoSegundaCondicao.setActionCommand(Integer.toString(4));
		panel.add(textTipoSegundaCondicao);		
				
		textTexto = new JTextArea();
		textTexto.setBounds(textDim.width + 50, 15 * textDim.height + 10, textDim.width,
				textDim.height+25);
		panel.add(textTexto);
		
		
		JButton buttonOk = new JButton("OK");
		buttonOk.addActionListener(this);
		buttonOk.setBounds(250, 17 * 30 + 10, 80, 25);
		panel.add(buttonOk);
			
		add(panel, BorderLayout.CENTER);
				
		getRootPane().setDefaultButton(buttonOk);
		
		setResizable(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "OK") {
			createCartaProblema();
			ScreenNewProblemCard.this.dispose();
		}		
	}
	
	public void createCartaProblema() {
		String titulo = textTitulo.getText();
		String codigo = textCodigo.getText();
		String texto = textTexto.getText();
		String referencia = textReferencia.getText();
		String condicao = textCondicao.getText();
		int duracao = Integer.parseInt(textDuracao.getText());
		int custo = Integer.parseInt(textCusto.getText());
		int qtdePrimeiroEfeito = Integer.parseInt(textQtdePrimeiroEfeito.getText());
		int qtdeSegundoEfeito = Integer.parseInt(textQtdeSegundoEfeito.getText());
		int tipoPrimeiroEfeito = Integer.parseInt(textTipoPrimeiroEfeito.getText());
		int tipoSegundoEfeito = Integer.parseInt(textTipoSegundoEfeito.getText());
		int qtdePrimeiraCondicao = Integer.parseInt(textQtdePrimeiraCondicao.getText());
		int qtdeSegundaCondicao = Integer.parseInt(textQtdeSegundaCondicao.getText());
		int tipoPrimeiraCondicao = Integer.parseInt(textTipoPrimeiraCondicao.getText());
		int tipoSegundaCondicao = Integer.parseInt(textTipoSegundaCondicao.getText());
		
		CartaPenalizacao card = new CartaPenalizacao(titulo, codigo, texto, referencia, duracao, condicao, 
				tipoPrimeiroEfeito, tipoSegundoEfeito, qtdePrimeiroEfeito, qtdeSegundoEfeito, tipoPrimeiraCondicao, 
				tipoSegundaCondicao, qtdePrimeiraCondicao, qtdeSegundaCondicao);
		
		UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        
		card.dumpProperties("online/" + randomUUIDString + "-Problem.properties");
		
	}
	
	//=====================================================================================//
	/**
	 * Cria a tela e a faz visível. Por segurança é o método chamado pela Thread
	 * para construção da GUI
	 * @param tabuleiro - tabueliro do jogo atual
	 */
	public static ScreenNewProblemCard createAndShowProblemCard(ScreenTabuleiro tabuleiro) {

		// Cria e configura a tela.
		ScreenNewProblemCard scr = new ScreenNewProblemCard(tabuleiro);
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
