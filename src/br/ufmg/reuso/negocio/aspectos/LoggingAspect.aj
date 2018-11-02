/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Charles / Pedro / Salatiel / Suelen
 * Date: 14/11/2014
 */

package br.ufmg.reuso.negocio.aspectos;

/*
 * Aspecto responsável pelas mensagens exibidas (logging)
 */

import br.ufmg.reuso.negocio.carta.*;
import br.ufmg.reuso.negocio.baralho.BaralhoCartas;
import br.ufmg.reuso.negocio.dado.Dado;
import br.ufmg.reuso.negocio.jogo.Jogo;
import br.ufmg.reuso.negocio.jogador.Jogador;
import br.ufmg.reuso.negocio.mesa.Mesa;

public privileged aspect LoggingAspect{
  // ***** pointcut mostrarBaralho ******************************************************* //
  pointcut mostrarBaralho() : call(void BaralhoCartas.mostrarBaralho(..) );
	
  before() : mostrarBaralho() {
    System.out.println();
  }
  // ***** pointcut mostrarArtefato ****************************************************** //
  pointcut mostrarArtefato(Artefato a) : call(void  Artefato.mostrarArtefato(..) ) && within(Artefato)
    && target(a);
	
  after(Artefato a) : mostrarArtefato(a) {
    System.out.printf("QualidadeRuim: %s\nBugExistente: %s\n",a.getQualidadeArtefatoRuim(),a.getBug());
  }
  		
  // ***** pointcut mostrarCartaEngenheiro************************************************ //
  pointcut mostrarCartaEng(CartaEngenheiro carta) : call(void  CartaEngenheiro.mostrarCarta() )
    && target(carta);
	
  after(CartaEngenheiro carta) : mostrarCartaEng(carta) {
    System.out.printf("%s\t%s\t%s\n%s\nSalário: %d\nHabilidade: %d\nMaturidade: %d\n\n\n", carta.getTituloCarta(), 
                      carta.getCodigoCarta(), carta.getNomeEngenheiro(),carta.getTextoCarta(), carta.getSalarioEngenheiro(), 
                      carta.getHabilidadeEngenheiro(), carta.getMaturidadeEngenheiro());
  }
  // ***** pointcut mostrarCartaBonificação*********************************************** //
  pointcut mostrarCartaBon(CartaBonificacao carta) : call(void  CartaBonificacao.mostrarCarta() )
    && target(carta);
	
  after(CartaBonificacao carta) : mostrarCartaBon(carta) {
		System.out.printf("%s\t%s\n%s\nCusto: %d\n", carta.getTituloCarta(),
                      carta.getCodigoCarta(), carta.getTextoCarta(), carta.getCustoEfeito());
		System.out.printf("TipoEfeito1: %d\tQuantitdadeEfeito1: %d\nTipoEfeito2: %d\tQuantidadeEfeito2: %d\n\n",
                      carta.getTipoPrimeiroEfeito(), carta.getQuantidadePrimeiroEfeito(), carta.getTipoSegundoEfeito(), carta.getQuantidadeSegundoEfeito());
  }

  // ***** pointcut mostrarCartaPen ****************************************************** //
  pointcut mostrarCartaPen(CartaPenalizacao carta): call(void CartaPenalizacao.mostrarCarta())
    && target(carta);
  after(CartaPenalizacao carta) : mostrarCartaPen(carta) {
    System.out.printf("%s\t%s\n%s\nCondicao: %s\n\n\n", carta.getTituloCarta(),
                      carta.getCodigoCarta(), carta.getTextoCarta(), carta.getCondicaoProblema());
  }
  
  // ***** pointcut mostrarCartaMao ****************************************************** //
  pointcut mostrarCartaMao(Jogador carta): call(void Jogador.mostrarCartaMao())
    && target(carta);
  after(Jogador jogador) : mostrarCartaMao(jogador) {

    System.out.printf("Cartas do jogador %s:\n",jogador.getNome());
		for (int i=0;i<Jogador.NUMERO_MAX_CARTAS_MAO;i++)
		{
			if (jogador.getCartas()[i]==null)
				continue;
			System.out.println("iteracao: "+i);
			jogador.getCartas()[i].mostrarCarta();
		}
  }

  // ***** pointcut alocado ************************************************************* //
  pointcut alocado(): call(void Tabuleiro.setCartaMesa(..));    
  after() : alocado() {
    System.out.printf("engenheiro alocado:\n");				// TODO teste
  }

  // ***** exibe habilidade ************************************************************* //
  pointcut exibe(): call(void ScreenInteraction.exibirHabilidadeInsuficiente());    
   before() :exibe() {
    System.out
      .printf("\nEngenheiro deve ter habilidade >=1 para integrar módulo do projeto escolhido");
  }

  // ***** pointcut criando jogo********************************************************* //
  pointcut criarJogo(): call(void Jogo.getJogo());    
   before() :criarJogo() {
    System.out.println("criando jogo");
  }

  // ***** pointcut retirar************************************************************** //
  pointcut retirar(): call(void Jogo.mostrarCartaMao());    
   before() :retirar() {
    System.out.printf("\nMetodo retirarCarta\n"); // TODO so pra teste
  }
   after() :retirar(){
    System.out.printf("\nbaralho auxiliar:\n"); // TODO teste para ver
  }

  // ***** pointcut mostrarCartasMesa**************************************************** //
  pointcut mostrarCartasMesa(): call(void Jogo.mostrarCartasDasMesasDoTabuleiro(..));    
   before() :mostrarCartasMesa() {
    System.out.printf("engenheiro ainda contratados, demitidos nao consta na lista:\n");// TODO
  }

  // ***** pointcut engContratados******************************************************* //
    pointcut engContratados(): call(void Jogo.mostrarCarta());    
   before() :engContratados() {
    System.out.printf("engenheiros contratados:\n");// TODO teste
  }

  // ***** pointcut habilidade*******f*************************************************** //
  pointcut habilidade(Jogo jogo): call(void Jogo.compareTo(..)) && target(jogo);    
   before(Jogo jogo) :habilidade(jogo) {
    System.out.println("habilidade do engenheiro que vai trabalhar: " + jogo.habilidadeTemporaria);
  }

  // ***** pointcut habilidadeConfere**************************************************** //
  pointcut habilidadeConfere(Jogo jogo): call(void Jogo.compareTo(..)) && target(jogo);    
   after(Jogo jogo) :habilidadeConfere(jogo) {
    		System.out.println(
				"habilidade do engenheiro que vai trabalhar(confere qual mesa trabalhara): " + jogo.habilidadeTemporaria);
  }
  // ***** pointcut pedidoValido********************************************************* //
  pointcut pedidoValido(): call(int Jogo.somatorioModulo());
   after() :pedidoValido() {
    System.out.printf("tem pedido valido\n");
  }
  // ***** pointcut moduloEsc************************************************************ //
  pointcut moduloEsc(Jogo jogo, int moduloEscolhido): call(boolean Jogo.conferirQuantidadeArtefatosSuficiente(..)) && target(jogo)
  && args(moduloEscolhido);
   before(Jogo jogo, int moduloEscolhido) :moduloEsc(jogo, moduloEscolhido) {
    System.out.println("modulo escolhido = " + moduloEscolhido);
  }
  // ***** pointcut getAjuda************************************************************* //
  pointcut getAjuda(Jogo jogo, int moduloEscolhido): call(int Jogo.getAjuda()) && target(jogo) && args(moduloEscolhido);;
   after(Jogo jogo, int moduloEscolhido) :getAjuda(jogo, moduloEscolhido) {
    System.out.println(
      "contador = " + jogo.contador + "\tprojeto Ajuda = " + jogo.getProjeto().getModulos()[moduloEscolhido].getAjudas());
  }
  // ***** pointcut getCod*************************************************************** //
  pointcut getCod(Jogo jogo, int moduloEscolhido): call(int Jogo.getCodigos()) && target(jogo) && args(moduloEscolhido);;
   after(Jogo jogo, int moduloEscolhido) :getCod(jogo, moduloEscolhido) {
		System.out.println(
      "contador = " + jogo.contador + "\tprojeto Codigo = " + jogo.getProjeto().getModulos()[moduloEscolhido].getCodigos());
  }
  // ***** pointcut getDes*************************************************************** //
  pointcut getDes(Jogo jogo, int moduloEscolhido): call(int Jogo.getDesenhos()) && target(jogo) && args(moduloEscolhido);;
   after(Jogo jogo, int moduloEscolhido) :getCod(jogo, moduloEscolhido) {
		System.out.println("contador = " + jogo.contador + "\tprojeto Desenhos = "
                       + jogo.getProjeto().getModulos()[moduloEscolhido].getDesenhos());
  }
  // ***** pointcut getRas*************************************************************** //
  pointcut getRas(Jogo jogo, int moduloEscolhido): call(int Jogo.getRastros()) && target(jogo) && args(moduloEscolhido);;
   after(Jogo jogo, int moduloEscolhido) :getRas(jogo, moduloEscolhido) {
		System.out.println("contador = " + jogo.contador + "\tprojeto Rastros = "
                       + jogo.getProjeto().getModulos()[moduloEscolhido].getRastros());
  }
  // ***** pointcut getReq*************************************************************** //
  pointcut getReq(Jogo jogo, int moduloEscolhido): call(int Jogo.getRequisitos()) && target(jogo) && args(moduloEscolhido);;
   after(Jogo jogo, int moduloEscolhido) :getReq(jogo, moduloEscolhido) {
		System.out.println("contador = " + jogo.contador + "\tprojeto Requisitos = "
                       + jogo.getProjeto().getModulos()[moduloEscolhido].getRequisitos());
  }
  // ***** pointcut escolherMesa*************************************************************** //
  pointcut escolherMesa(): call(int escolherMesadeTrabalho());
   before(): escolherMesa(){
    System.out.println("\nEscolhe mesa valida para inserir efeito");
  }
}
