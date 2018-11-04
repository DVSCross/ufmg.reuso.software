package br.ufmg.reuso.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import br.ufmg.reuso.negocio.questao.Questao;

@SuppressWarnings("serial")
public class ScreenRescueQuestion extends JDialog implements ActionListener{
	
	private Questao questao;
	private JPanel panelQuestao;
	private boolean acertou = false;

	private Dimension dim = new Dimension(800, 600);

	public ScreenRescueQuestion(ScreenTabuleiro tabuleiro, Questao questao) {
		this.questao = questao;		
		this.panelQuestao = criarPanelQuestao();
		this.setContentPane(this.panelQuestao);
	}
	
	private JPanel criarPanelQuestao() {
		JPanel panel = new JPanel();

		Font font = new Font("Default", Font.PLAIN, 24);
		Border border = BorderFactory.createLineBorder(Color.black, 1);		

		panel.setLayout(null);

		int y;

		JLabel labelQuestao = new JLabel("Questão de Resgate");
		labelQuestao.setBounds(10, y = 10, 400, 30);
		labelQuestao.setFont(font);
		panel.add(labelQuestao);	

		JLabel labelTitulo = new JLabel("Enunciado", JLabel.CENTER);
		labelTitulo.setBounds(10, y += 40, dim.width - 20, 30);
		labelTitulo.setBorder(border);
		labelTitulo.setFont(font);
		panel.add(labelTitulo);

		JPanel aux = new JPanel(new BorderLayout());
		aux.setBorder(border);		
		aux.setBounds(10, y += 40, dim.width - 20, 220);
		aux.setPreferredSize(new Dimension(dim.width - 7, 50));
		JTextArea textArea = new JTextArea(this.questao.getEnunciado());
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 5));
		textArea.setFont(new Font("Serif", Font.PLAIN, 24));
		textArea.setAlignmentX(CENTER_ALIGNMENT);

		JScrollPane paneScrollPane = new JScrollPane(textArea);
		paneScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		textArea.setFont(font);
		textArea.setEditable(false);
		aux.add(textArea, BorderLayout.CENTER);
		panel.add(aux);	

		JLabel lblRef = new JLabel("Selecione uma resposta", JLabel.CENTER);
		lblRef.setBounds(10, y += 220, dim.width - 20, 30);
		lblRef.setBorder(border);
		lblRef.setFont(font);
		panel.add(lblRef);

		y = y + 40;
		
		Font font12 = new Font("Default", Font.PLAIN, 12);
		
		List<String> alternativas = this.questao.getAlternativas(); 
		
		ActionListener listener = new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		        JRadioButton button = (JRadioButton)e.getSource();		        
		        setAcertou(button.getText().equalsIgnoreCase(questao.getResposta()));
		    }
		};	
		
		JRadioButton button;
		ButtonGroup group = new ButtonGroup(); 

		int i;
		for (i = 0; i < alternativas.size(); i++) {
			button = new JRadioButton(alternativas.get(i), false);			
			button.setBorder(border);
			button.setBounds(10, y + i * 30, 280, 30);
			button.setFont(font12);
			button.addActionListener(listener);
			group.add(button);
			panel.add(button);
			y = y + 20;
		}

		y = y + i * 30;
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(dim.width - 90, y - 15, 80, 30);
		
		btnOk.setFont(font);
		btnOk.addActionListener(this);
		panel.add(btnOk);
		getRootPane().setDefaultButton(btnOk);
		return panel;		
	}
	
	public static ScreenRescueQuestion exibirQuestao(ScreenTabuleiro tabuleiro, Questao questao) {
		ScreenRescueQuestion scr = new ScreenRescueQuestion(tabuleiro, questao);	
		scr.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		scr.setDim(new Dimension(820, 750));
		scr.setAlwaysOnTop(true);
		scr.pack();
		scr.setModal(true);
		scr.setLocationRelativeTo(null);
		scr.setVisible(true);
		scr.setResizable(false);
		return scr;
	}
	
	public boolean getAcertou() {
		return acertou;
	}

	public void setAcertou(boolean acertou) {
		this.acertou = acertou;
	}
	
	public void setDim(Dimension dim) {
		this.dim = dim;
		setSize(dim.width, dim.height);
		setPreferredSize(dim);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		ScreenRescueQuestion.this.dispose();		
	}
}
