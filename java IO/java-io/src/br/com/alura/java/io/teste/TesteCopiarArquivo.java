package br.com.alura.java.io.teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

public class TesteCopiarArquivo {

	public static void main(String[] args) throws IOException {

		Socket s = new Socket();
		
//		...estamos usando padr�o de projeto decorator, cada objeto esta decorando a funcionalidade de outro objeto
//		criando o fluxo completo com o arquivo
		InputStream fis = s.getInputStream();  //System.in;//new FileInputStream("Lorem.txt");
//		lendo os bin�rios e transformando em texto
		Reader isr = new InputStreamReader(fis);
//		junta v�rios caracteres que est�o numa linha e os l�
		BufferedReader br = new BufferedReader(isr);

		OutputStream fos = s.getOutputStream();//System.out;// new FileOutputStream("lorem2.txt");
		Writer osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		
		String linha = br.readLine();
		
		
		while (linha != null && !linha.isEmpty()) {
			bw.write(linha);
			bw.newLine();
			bw.flush();
			linha = br.readLine();
		}

		br.close();
		bw.close();

	}

}
