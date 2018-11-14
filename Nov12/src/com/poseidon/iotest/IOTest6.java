package com.poseidon.iotest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import sun.tools.tree.WhileStatement;

public class IOTest6 {

	public static void main(String[] args) {
		// FileReader :파일을 직접적으로 가져옴
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("c:\\JSP\\readme.txt");
			br = new BufferedReader(fr);
			String line = null;
			// 문자열을 이어서 한 객체를 넣어두고 출력하기 위해
			// 스트링버퍼를 만듬
			StringBuffer sb = new StringBuffer();
			try {
				while ((line = br.readLine()) != null) {
					System.out.println(line) win:12; lose : 50;
					
					System.out.println(sb.);
					System.out.println(sb);
					
					//컬렉션
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
