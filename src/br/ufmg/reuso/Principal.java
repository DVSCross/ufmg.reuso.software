package br.ufmg.reuso;

/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Michael David
 * Date: 16/07/2011
 */

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

import br.ufmg.reuso.dados.carta.RepositorioOnline;
import br.ufmg.reuso.negocio.jogo.Jogo;

/**
 * @author MichaelDavid
 * 
 * Classe que Inicia o a execu??o do programa.
 */
public class Principal {
	
	/**
	 * @param args
	 * M?todo principal que cria um objeto da classe jogo e inicia o jogo com este objeto.
	 */ 
	public static void main(String[] args) {		
	    try {
	      //#ifdef Ocean
//@	      MetalLookAndFeel.setCurrentTheme(new OceanTheme());
//@	      UIManager.setLookAndFeel(new MetalLookAndFeel());
	      //#endif
	      
	      //#ifdef Metal
	      MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
	      UIManager.setLookAndFeel(new MetalLookAndFeel());
	      //#endif
	
	      //#ifdef Nimbus
	//@      UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
	      //#endif
	      
	      //#ifdef Motif
	//@      UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
	      //#endif
	      
	      //#ifdef GTK
	//@      UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
	      //#endif	      

	      // RepositorioOnline repo = new RepositorioOnline();	     
	    }
	    catch (UnsupportedLookAndFeelException e) {
	    	System.out.println("O sistema não conseguiu definir a interface de jogo desejada. Iniciando no modo padrão.");
	    }
	   
	    Jogo jogo = Jogo.getJogo();	//instanciando um objeto da classe jogo ou chamando o existente.
		jogo.start(jogo);			//iniciando a parte din?mica do jogo	
	}
}
