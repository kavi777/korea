package com.poseidon.iotest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IOTest04 {

	public static void main(String[] args) {
		// FileReader :파일을 직접적으로 가져옴
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("c:\\JSP\\magi.txt");
			br = new BufferedReader(fr);
			String line = null;
			// 문자열을 이어서 한 객체를 넣어두고 출력하기 위해
			// 스트링버퍼를 만듬
			StringBuffer sb = new StringBuffer();
			try {
				while ((line = br.readLine()) != null) {
					//system.out.println(line); win:12 ; lose : 50
					System.out.println(line);
					sb.append(line + "\n");
					System.out.println(sb);
					
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
