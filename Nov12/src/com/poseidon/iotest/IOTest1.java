package com.poseidon.iotest;

public class IOTest1 {
/*자바의 입출력 input output
 * 외부연결
 * 어떤 통로로 연결
 * 
 * 
 * 
 */

	public static void main(String[] args) {
/*바이트 배열 만들기... 읽기
 * 1,3,4,5,6,7,8,9
        byte[] intput ={1,3,4,5,6,7,8,9};
        byte[] output =
 * 아무것도 없는 값, 객체->초기값으로 
 * 0!= null;
 * (//System.out.print(output);
 * 
 * (//인풋 통로 만들기 
 * ByteArrayInputStream
 * bais = new ByteArrayInputStream(input);
 * 
 * (//아웃풋 통로 만들기
 * ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
 * int data=0;
 * -1: 멈추는 명령을 지시
 * -읽거나 쓰는 바이트를 담을 변수입니다.
 * 읽어온 data를 검사하여 -1d이면 read()를 중지하기 -1
 * 더이상 읽을 값이 없음을 말합니다. 스트림에서 한 바이트를 읽은 대표적인 매소드
 * read() = 읽
 * -스트림
 * while((data = bais.read()) 1=-1){
 * -인풋에서 읽어온 값을 data에 넣고 -1값이 아니면 무한 반복)
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
 * toByteArray(): 바이트 배열로 바꿔주는 메소드
 * System.out.println(Arrays.toString(output))
 * Arrays: 배열을 쉽게 사용하도록 도와주는 메소드들이 있음 
 * toString() : 배열을 문자열로 변환하여 출력을 도와주는 메소드
 * 
 * 
 * 
 * 
 */
	}

}
