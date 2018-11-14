package com.poseidon.iotest;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class IOTest9 {

	public static void main(String[] args) {

		String line="";
		String text="c:\\JSP\\d2.txt";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			PrintWriter pw =
					new PrintWriter(new BufferedWriter(new FileWriter(text, true)));
		do {
			System.out.println("문장을 입력하세요. 마치려면 q를 입력하세요.");
			line = br.readLine();
			pw.println(line);
		}while(!line.equals("q"));
		br.close();pw.close();
		}catch(IOException e) {
			
		}
	}

}
