package com.poseidon.iotest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;

//������ �а� ����
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
				System.out.println(data + "��");
				System.out.println(Arrays.toString(temp));
				for (int i = 0; i < temp.length; i++) {
					System.out.print((char) temp[i] + ",");
				}
				fos.write(temp, 0, data);
			}
			System.out.println("����Ϸ�");
			fis.close();// ���� ���� �� �ݱ� ǥ��
			fos.close();// ���߿� �� ������ �� ���� ���� -�� ������� .
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
