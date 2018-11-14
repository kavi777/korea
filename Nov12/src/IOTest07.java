import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest07 {
//이제 정리
	public static void main(String[] args) {
/*파일을 생성하기 위해서 fileOutStream
 * 객체 생성화 함께 파일의 이름을 기입함 
 * 
 * 
 */
		FileOutputStream fos = null;
	try {
		//IO에서는 자주 볼 예외 처리 입니다.
		//파일이 없거나, 파일을 못쓸때 (예외) 처리하기 위함
		fos = new FileOutputStream("C:\\JSP\\t2.txt");
		for (int i = 0; i < args.length; i++) {
			String data = i + "번 줄 \r\n";
			fos.write(data.getBytes()); //fos스트림을 통해 파일 쓰기
			//값을 슬땐 반드시 byte를 써야 함 
			//String ->byte 변환하는 getbyte()메소드가 있음  
			// \r \n ..... 윈도우에는 이 2개 \n 유닉스 같은 것
			//filewriter라는 녀석을 사용하면 byte 배열 대신 바로 쓰기가 가능
		}		//경로는 반드시 \\두개 정화히 찾을수 있음
		// ./src/bin/saveFile.txt
		//상대경로 .... 절대 경로 .....
		fos.close();		
		//열린 객체를 닫는 메소드
		//자바는 종료될때 열린 파일을 자동으로 닫아줌
		//직접 닫는게 중요
		//닫지 않으면 다시 못쓸수 있음 
	}catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}
	}

}
