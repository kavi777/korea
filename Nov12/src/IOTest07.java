import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest07 {
//���� ����
	public static void main(String[] args) {
/*������ �����ϱ� ���ؼ� fileOutStream
 * ��ü ����ȭ �Բ� ������ �̸��� ������ 
 * 
 * 
 */
		FileOutputStream fos = null;
	try {
		//IO������ ���� �� ���� ó�� �Դϴ�.
		//������ ���ų�, ������ ������ (����) ó���ϱ� ����
		fos = new FileOutputStream("C:\\JSP\\t2.txt");
		for (int i = 0; i < args.length; i++) {
			String data = i + "�� �� \r\n";
			fos.write(data.getBytes()); //fos��Ʈ���� ���� ���� ����
			//���� ���� �ݵ�� byte�� ��� �� 
			//String ->byte ��ȯ�ϴ� getbyte()�޼ҵ尡 ����  
			// \r \n ..... �����쿡�� �� 2�� \n ���н� ���� ��
			//filewriter��� �༮�� ����ϸ� byte �迭 ��� �ٷ� ���Ⱑ ����
		}		//��δ� �ݵ�� \\�ΰ� ��ȭ�� ã���� ����
		// ./src/bin/saveFile.txt
		//����� .... ���� ��� .....
		fos.close();		
		//���� ��ü�� �ݴ� �޼ҵ�
		//�ڹٴ� ����ɶ� ���� ������ �ڵ����� �ݾ���
		//���� �ݴ°� �߿�
		//���� ������ �ٽ� ������ ���� 
	}catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}
	}

}
