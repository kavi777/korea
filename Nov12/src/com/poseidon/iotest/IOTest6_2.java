package com.poseidon.iotest;

import java.util.Map;

public class IOTest6_2 {

	public static void main(String[] args) {
String line =null;
Map<String,Integer>total =new HashMap<String,Integer>();
		if(line.subString(0,3).equals(("win"));
	total.put("win", Integer.parseInt(line.subString(line.indextOf("win:")+6,line.length())));
		}else if(line.substring(0, 3).equals("dra"));
		total.put("draw", Integer.parseInt(line.substring(line.indexOf("draw : + ")+7, line.length())));
	}else if(line.substring(0, 3).equals("los"));
	total.put("lose", Integer.parseInt(line.substring(line.indexOf("lose : + ")+7, line.length())));
}else if(line.substring(0, 3).equals("tot"));
total.put("total", Integer.parseInt(line.substring(line.indexOf("total : + ")+7, line.length())));
total.put("")
}
	}

}
