package com.poseidon.iotest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import sun.tools.tree.WhileStatement;

public class IOTest6 {

	public static void main(String[] args) {
		// FileReader :������ ���������� ������
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("c:\\JSP\\readme.txt");
			br = new BufferedReader(fr);
			String line = null;
			// ���ڿ��� �̾ �� ��ü�� �־�ΰ� ����ϱ� ����
			// ��Ʈ�����۸� ����
			StringBuffer sb = new StringBuffer();
			try {
				while ((line = br.readLine()) != null) {
					System.out.println(line) win:12; lose : 50;
					
					System.out.println(sb.);
					System.out.println(sb);
					
					//�÷���
					
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
