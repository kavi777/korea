package com.poseidon.iotest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;

//파일을 읽고 쓰기
public class IOTest5 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("C:\\JSP\\readme.txt");
			fos = new FileOutputStream("C:\\JSP\\readme.txt");
			int data = 0;
			byte[] temp = new byte[5];
			while ((data = fis.read(temp)) != -1) {
				System.out.println(data + "수");
				System.out.println(Arrays.toString(temp));
				for (int i = 0; i < temp.length; i++) {
					System.out.print((char) temp[i] + ",");
				}
				fos.write(temp, 0, data);
			}
			System.out.println("쓰기완료");
			fis.close();// 파일 열면 꼭 닫기 표시
			fos.close();// 나중에 그 파일을 못 쓸수 있음 -연 순서대로 .
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
