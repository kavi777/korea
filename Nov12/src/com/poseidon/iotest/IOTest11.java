package com.poseidon.iotest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class IOTest11 {

	public static void main(String[] args) throws FileNotFoundException {
Scanner sc = new Scanner(System.in);
System.out.print("ID �Է�:_");
String id = sc.nextLine();

File f = new File("c:\\JSP\\" + id + ".data");
if(!f.exists()) {
	System.out.println("ID�� �����ϴ�.");
	System.out.println("���� ����ڽ��ϱ�");
}else {
	BufferedReader br = new BufferedReader(new FileReader(f));
	
}
	}

}
