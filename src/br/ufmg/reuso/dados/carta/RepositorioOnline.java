package br.ufmg.reuso.dados.carta;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;


public class RepositorioOnline {
	
	// Builder para obter acesso ao cliente j? configurado com as credenciais e regi?o de acesso	
	final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion("sa-east-1").build();
	
	// Reposit?rio de Cartas compartilhadas online
	final static String REPOSITORIO = "shared-cards-repository";
	
	public RepositorioOnline() {
		ListObjectsV2Result resultado = s3.listObjectsV2(REPOSITORIO);
		List<S3ObjectSummary> objetos = resultado.getObjectSummaries();
		for (S3ObjectSummary os: objetos) {
			String chave = os.getKey();
			if (chave.toLowerCase().contains(".properties")) {
				if (chave.startsWith("ConceptCards")) {
					// #ifdef OnlineConceptCard
//@					this.baixarCarta(chave);				
					// #endif
				}
				if (chave.startsWith("ProblemCard")) {
					// #ifdef OnlineProblemCard//	
//@					this.baixarCarta(chave);				
					// #endif
				}
				if (chave.startsWith("SoftwareEngineerCard")) {
					// #ifdef OnlineSoftwareEngineerCard								
//@					this.baixarCarta(chave);				
					// #endif
				}				
			}        
		}
	}
	
	public void baixarCarta(String nome) {
		try {
		    S3Object o = s3.getObject(REPOSITORIO, nome);		    
		    S3ObjectInputStream s3is = o.getObjectContent();
		    FileOutputStream stream = new FileOutputStream(new File(nome));
		    byte[] buffer = new byte[1024];
		    int tamanho = 0;
		    while ((tamanho = s3is.read(buffer)) > 0) {
		    	stream.write(buffer, 0, tamanho);
		    }
		    s3is.close();
		    stream.close();
		} catch (AmazonServiceException e) {
		  // printa exceção
		} catch (FileNotFoundException e) {
	    // printa exceção
		} catch (IOException e) {
	    // printa exceção
		}
	}
}
