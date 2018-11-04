package br.ufmg.reuso.negocio.questao;

import java.util.List;

public class Questao {
	private String enunciado;	
	private String resposta;
	private List<String> alternativas;
	private String topico;		
	public static final String DIRETORIO = "Questoes";
	
	public Questao() {
	}
	
	public String getEnunciado() {
		return enunciado;
	}
	
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public List<String> getAlternativas() {
		return alternativas;
	}
	public void setAlternativas(List<String> alternativas) {
		this.alternativas = alternativas;
	}
	
	public String getTopico() {
		return topico;
	}

	public void setTopico(String topico) {
		this.topico = topico;
	}
}
