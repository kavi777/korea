package com.poseidon.iotest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ToString {
	public static void main(String[] args){
		byte[] out = {-1, 1, 2, 3, 4, 5, 6, 7, 8,9,10};
		
		byte[] in = null;
		byte[] temp = new byte[3];
		
		ByteArrayInputStream bais = new ByteArrayInputStream(out);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int data;
		//read
		try {
			data= bais.read(temp);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*try {
		    data =bais.read(temp);
		    System.out.println("data : " + data);
		    System.out.println("temp : " + Arrays.toString(temp));
		} catch(IOException) {
				  
		    e.printStackTrace(); 
		} */
		
			try {
				while((data = bais.read(temp)) != -1){
					System.out.println("¼ö : " + data);
					for(int i=0; i<temp.length; i++) {					
				
					System.out.println(temp[i] + ", ");
					baos.write(temp[i]);
					}
				System.out.println("");
			}
	}catch(IOException e) {
		e.printStackTrace();
	}
				
			System.out.println(Arrays.toString(out));
			in = baos.toByteArray();
			System.out.println(Arrays.toString(in));
	}
 
}
