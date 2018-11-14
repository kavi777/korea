package com.poseidon.iotest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class IOTest11 {

	public static void main(String[] args) throws FileNotFoundException {
Scanner sc = new Scanner(System.in);
System.out.print("ID 입력:_");
String id = sc.nextLine();

File f = new File("c:\\JSP\\" + id + ".data");
if(!f.exists()) {
	System.out.println("ID가 없습니다.");
	System.out.println("새로 만들겠습니까");
}else {
	BufferedReader br = new BufferedReader(new FileReader(f));
	
}
	}

}
