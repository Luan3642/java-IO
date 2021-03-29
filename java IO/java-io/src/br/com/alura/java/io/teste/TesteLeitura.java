package br.com.alura.java.io.teste;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;



public class TesteLeitura {

	public static void main(String[] args) throws IOException {
		
//		...estamos usando padr�o de projeto decorator, cada objeto esta decorando a funcionalidade de outro objeto
		
//		criando o fluxo completo com o arquivo
		FileInputStream fis = new FileInputStream("lorem.txt"); 
		
//		lendo os bin�rios e transformando em texto
		Reader isr = new InputStreamReader(fis);
		
//		junta v�rios caracteres que est�o numa linha e os l�
		BufferedReader br = new BufferedReader(isr);
		
		String linha = br.readLine();
		
		
		while(linha != null) {
			System.out.println(linha);
			linha = br.readLine();
		}
		
		
		
		br.close();
		
		
	}

}
