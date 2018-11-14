package com.poseidon.iotest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class IOTest10 {

	public static void main(String[] args) throws IOException {
		
		String text="c:\\JSP\\info.txt";
		BufferedReader br = new BufferedReader(new FileReader(text));
while(true) {
	String line = br.readLine();
	System.out.println(line);
	String[] info =line.split("/");
	
	for (int i = 0; i < info.length; i++) {
		System.out.println(info[i]);
	}
	HashMap<String,String>infoMap = new HashMap<String, String>();
	if(info[i].equals("이름"))
		infoMap.put("이름", info[1]);
}else if(info[2].equals("나이")) {
	
	infoMap.put("나이":, info[3]);
}
line == null break;
	}

}
