package com.poseidon.iotest;

public class IOTest1 {
/*�ڹ��� ����� input output
 * �ܺο���
 * � ��η� ����
 * 
 * 
 * 
 */

	public static void main(String[] args) {
/*����Ʈ �迭 �����... �б�
 * 1,3,4,5,6,7,8,9
        byte[] intput ={1,3,4,5,6,7,8,9};
        byte[] output =
 * �ƹ��͵� ���� ��, ��ü->�ʱⰪ���� 
 * 0!= null;
 * (//System.out.print(output);
 * 
 * (//��ǲ ��� ����� 
 * ByteArrayInputStream
 * bais = new ByteArrayInputStream(input);
 * 
 * (//�ƿ�ǲ ��� �����
 * ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
 * int data=0;
 * -1: ���ߴ� ����� ����
 * -�аų� ���� ����Ʈ�� ���� �����Դϴ�.
 * �о�� data�� �˻��Ͽ� -1d�̸� read()�� �����ϱ� -1
 * ���̻� ���� ���� ������ ���մϴ�. ��Ʈ������ �� ����Ʈ�� ���� ��ǥ���� �żҵ�
 * read() = ��
 * -��Ʈ��
 * while((data = bais.read()) 1=-1){
 * -��ǲ���� �о�� ���� data�� �ְ� -1���� �ƴϸ� ���� �ݺ�)
 * baos.write(data); 
 * }
 * while(true){
 * data = bais.read();
 * if(data = -1){
 * break; 
 * }
 * baos.write(data);
 * }
 * }*
 * 
 * ------------------------
 * System.out.println(Arrays.toString(input));
 * output = baos.toByteArray();
 * toByteArray(): ����Ʈ �迭�� �ٲ��ִ� �޼ҵ�
 * System.out.println(Arrays.toString(output))
 * Arrays: �迭�� ���� ����ϵ��� �����ִ� �޼ҵ���� ���� 
 * toString() : �迭�� ���ڿ��� ��ȯ�Ͽ� ����� �����ִ� �޼ҵ�
 * 
 * 
 * 
 * 
 */
	}

}
