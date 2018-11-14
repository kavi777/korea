import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOTest8 {

	public static void main(String[] args) {
try {
	FileWriter fw = new FileWriter("c:\\JSP\\save.save");

	for (int i = 0; i<5; i++) {
		String data = i + "번 줄 작업\r\n";
		fw.write(data);
	}
	fw.close();
	//이어쓰기
	FileWriter fw2 =new FileWriter("c\\JSP\\save.save",true);
	//같은 파일 이어쓰기를 하겠다는 의미
	fw2.write(data);
	}
	fw2.close();
	}catch(IOException e) {
		e.printStackTrace();
}
	//FileReader로 파일을 char단위로 읽도록 변경한 후에 BufferedReader로 감싸면
	//ReadLine()메소드를 사용하여 라인단위로 읽을 수 있음.
	BufferedReader br = null;
	br = new BufferedReader(new FileReader("파일명"));
	
	}

}
