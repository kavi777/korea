import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOTest8 {

	public static void main(String[] args) {
try {
	FileWriter fw = new FileWriter("c:\\JSP\\save.save");

	for (int i = 0; i<5; i++) {
		String data = i + "�� �� �۾�\r\n";
		fw.write(data);
	}
	fw.close();
	//�̾��
	FileWriter fw2 =new FileWriter("c\\JSP\\save.save",true);
	//���� ���� �̾�⸦ �ϰڴٴ� �ǹ�
	fw2.write(data);
	}
	fw2.close();
	}catch(IOException e) {
		e.printStackTrace();
}
	//FileReader�� ������ char������ �е��� ������ �Ŀ� BufferedReader�� ���θ�
	//ReadLine()�޼ҵ带 ����Ͽ� ���δ����� ���� �� ����.
	BufferedReader br = null;
	br = new BufferedReader(new FileReader("���ϸ�"));
	
	}

}
