package com.poseidon.iotest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

//retry
public class IOTest3 {

	public static void main(String[] args) {

		byte[] in = {0,1,2,3,4,5,6,7,8,9};
		byte[] out = null;
		byte[] temp = new byte[3];
		
		ByteArrayInputStream bais = new ByteArrayInputStream(in);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		while(bais.available() > 0) {
		 System.out.println(bais.available() + "������ bais ����");
		 //�ѹ� �о���� �����Ǵ°� 
		 try {
			 int len = bais.read();
			 System.out.println(len + "temp ����");
		 baos.write(temp, 0, len);// temp�� ������, ����
		}catch (IOException e) {
			e.printStackTrace();
		}		
			
	}//while ��
	out = baos.toByteArray();
	System.out.println(Arrays.toString(in));
	System.out.println(Arrays.toString(temp));
	System.out.println(Arrays.toString(out));
	
	}
}
