package blackjackgame;


import java.util.ArrayList;
import java.util.Scanner;
 
public class gamePlay {
    
    private int minBetChip;
    private int maxBetChip;
    
    public gamePlay() {}
    
    ///// ���� �ݺ� ����
    public gamePlay(ArrayList<memDTO> arrlist, String playID[]) {
        
        Scanner sc = new Scanner(System.in);
        minBetChip = 10;        // ���� �ּ� ����
        maxBetChip = 100;        // ���� �ִ� ����
        
        System.out.println("[���� ����]");
        System.out.println();
        
        ////////// TODO �ʱ�ȭ, �⺻����
 
        // ����
        memDTO loginID = loginIDInfo(arrlist, playID);
        
        System.out.println("������ �ްڽ��ϴ�.");
        System.out.println("���� " + playID[0] + "���� Ĩ ������ " + loginID.getChip() + "��");
        
        int betChip = 0;
        while (true) {
            System.out.print("Ĩ ���� �Է�(10~100): ");
            betChip = sc.nextInt();
            
            if (betChip >= 10 && betChip <= 100 && betChip <= loginID.getChip()) {
                break;
            } else {
                System.out.println("�ٽ� �Է����ּ���.");
            }
        }
        System.out.println();
        
        boolean gameWin = true;                    // ���� ��� �Ǵ�. �¸��� �ʱ�ȭ
        int comCardSet[] = new int[52];            // �������� ������ ���ڸ� ����
        
        comCardSetInit(comCardSet);                // ���� ī��set ���� �� �ʱ�ȭ 
 
        // �׽�Ʈ: ���� ī��set ��� //
//        comCardSetPrint(comCardSet);
        
        boolean uBJWin = false;                    // ������ ���� �¸� ���� �ʱ�ȭ
        boolean dBJWin = false;                    // ������ ���� �¸� ���� �ʱ�ȭ
        String uCardSet[] = new String[11];        // ������ ī��set �غ�
        String dCardSet[] = new String[3];        // ������ ī��set �غ�
        cardSetInit(uCardSet, dCardSet);        // ������ ������ ī��set ����
        
        // ���� �⺻ī�� 2�� ���
        drawCardOne(comCardSet, uCardSet);
        drawCardOne(comCardSet, uCardSet);
        drawCardOne(comCardSet, dCardSet);
        drawCardOne(comCardSet, dCardSet);
        
        // �׽�Ʈ: �⺻ī�� ���� ���� //
        // '0 = A, 1 = K || 0 = K, 1 = A'�� ���� �¸��� �Ǵ�
//        uCardSet[0] = "A"; uCardSet[1] = "K";
//        dCardSet[0] = "A"; dCardSet[1] = "K";
        
        // ���� �⺻ī���� ���� �Ǵ�  �� 'A'�� 'K' 1�徿 �����ϰ� ������ ���� �¸��� �Ǵ�
        uBJWin = chekBJ(uCardSet);
        dBJWin = chekBJ(dCardSet);
                
        // ���ʿ� ��е� �⺻ ī�� 2���� ���� ����
        System.out.println("�������� ��е� ī��");
        cardSetNum(uCardSet, 1);
        
        System.out.println("�������� ��е� ī��");
        cardSetNum(dCardSet, 2);
        System.out.println();
        
        
        ////////// TODO �ݺ����� ����
        
        while (true) {
            // ����Ʈ: ī�带 ���� �� ������ ������ '21'�� �ʰ��ϸ� ��� ���� �й�
            if (pointResult(uCardSet) > 21) {
                gameWin = false;
                break;
            }
            
            // ���� or ������ '����'�̸� ��� ���� ����
            if (uBJWin || dBJWin) {
                break;
            } else if (!gameWin) {
                break;
            } else {
                ///// ��� ���� or ī�� ����
                System.out.print("������ �Ͻðڽ��ϱ�? Hit(1), Stay(2): ");
                int decision = sc.nextInt();
                System.out.println();
        
                // 'Hit' ���� �� �߰� ī�� 1�� ����            
                if (decision == 1) {
 
                // ����� ī��set�� ��������� ī�� �̱�
                if (!cardFull(uCardSet)) {
                    drawCardOne(comCardSet, uCardSet);
                } else {
                    // ī�尡 �� ã�� ��� ������ 'Stay'�� �Ǵ�
                    System.out.println("�� �̻� ī�带 ���� �� �����ϴ�. ������ 'Stay'�˴ϴ�.");
                    decision = 2;
                }
 
                // �� ���� �� �� ������ ������ �������� ������, ���� �߰� ī�� 1��  �� ���� 3���̸� ���� ����
                if (pointResult(dCardSet) < pointResult(uCardSet) && !cardFull(dCardSet)) {        
                    drawCardOne(comCardSet, dCardSet);
                }
 
                // ī�带 ���� �� ������ ������ '21'�� �ʰ��ϸ� ��� ���� �й�
                if (pointResult(uCardSet) > 21) {
                    gameWin = false;
                    break;
                }
 
                System.out.println("�������� ��е� ī�� ����");
                cardSetNum(uCardSet, 1);
                
                System.out.println("�������� ��е� ī�� ����");
                cardSetNum(dCardSet, 2);
 
                // 'Stay' ���� �� �ݺ� ����           
                } else if (decision == 2) {
                    // �� ���� �� �� ������ ������ �������� ������, ���� �߰� ī�� 1��  �� ���� 3���̸� ���� ����
                    if (pointResult(dCardSet) < pointResult(uCardSet) && !cardFull(dCardSet)) {        
                        drawCardOne(comCardSet, dCardSet);
                    }
                    break;
                } else {
                    System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���");
                    System.out.println();
                }
            }
        }
        
        System.out.println("��� �� ���� ���� = " + betChip);
        
        ///// ��� ���
        gameResult(uCardSet, dCardSet, uBJWin, dBJWin, gameWin, arrlist, playID, betChip);
        
        // �׽�Ʈ: ���� ī��set ��� //
//        comCardSetPrint(comCardSet);
    }
 
 
    ////////// TODO ��Ÿ �޼ҵ�
    
    ///// �α��ε� ID�� ����� ������ ��ȯ(ID, Ĩ ����)
    public memDTO loginIDInfo(ArrayList<memDTO> arrlist, String playID[]) {
        memDTO selLoginID = new memDTO();        
        int idIdx = 0;
        
        // �迭 ����Ʈ�� ����� ���� �α��ε� ID�� �ε��� ��ġ ã��
        for (int i = 0; i < arrlist.size(); i++) {
            if (playID[0].equals(arrlist.get(i).getId())) {
                idIdx = i;
                break;
            }
        }
        selLoginID = arrlist.get(idIdx);
        
        return selLoginID;
    }
    
    ///// �α��ε� ID�� �迭 ����Ʈ�� ����� �ε��� ��ȣ�� ��ȯ
    public int loginidIdx(ArrayList<memDTO> arrlist, String playID[]) {    
        int idIdx = 0;
        
        // �迭 ����Ʈ�� ����� ���� �α��ε� ID�� �ε��� ��ġ ã��
        for (int i = 0; i < arrlist.size(); i++) {
            if (playID[0].equals(arrlist.get(i).getId())) {
                idIdx = i;
                break;
            }
        }
        
        return idIdx;
    }
    
/*
 * 52���� ����ִ� Ʈ���� ���� ī��set�� ���� �� �ʱ�ȭ
 * ������ ī��� �ߺ��Ұ�(�����̵�,���̾Ƹ��,��Ʈ,Ŭ�ι� 13�徿 4�� ����)
 * ���� ������� �������� ����
 */
    public void comCardSetInit(int comCardSet[]) {
        
        boolean noSame[] = new boolean[52];
        
        for(int i = 0; i < noSame.length ; i++) {
            noSame[i] = false;
        }
        
        int rLoop = 0;
        int rIdx;
        while(rLoop < 52) {
            rIdx = (int)(Math.random() * 52);
            if(noSame[rIdx] == false) {
                noSame[rIdx] = true;
                comCardSet[rLoop] = rIdx + 1;
                rLoop++;
            }
        }
    }
    
    ///// ������ ī��set �ʱ�ȭ
    public void cardSetInit(String uCardSet[], String dCardSet[]) {
        
        for (int i = 0; i < uCardSet.length; i++) {
            uCardSet[i] = "0";
        }
        for (int i = 0; i < dCardSet.length; i++) {
            dCardSet[i] = "0";
        }
    }
 
    ///// Ư�� ī�� ��ȣ�� �����ڷ� ��ȯ
    public String checkNum(int cardNum) {
        
        String result = "";
         
        if (cardNum % 13 == 0) {
            cardNum = 13;
        } else {
            cardNum = (cardNum % 13);
        }
 
        switch (cardNum) {
            case 1:
                result = "A";
                
                return result;
        
            case 11:
                result = "J";
                
                return result;
                
            case 12:
                result = "Q";
                
                return result;
                
            case 13:
                result = "K";
                
                return result;
        }
        result = Integer.toString(cardNum);
 
        return result;
    }
    
    ///// ���� �¸� �Ǵ�
    public boolean chekBJ(String CardSet[]) {
        
        boolean check[] = new boolean[2];
        
        for (int i = 0; i < CardSet.length; i++) {
            if (CardSet[i].equals("A")) {
                check[0] = true;
            }
        }
        
        for (int i = 0; i < CardSet.length; i++) {
            if (CardSet[i].equals("K")) {
                check[1] = true;
            }
        }
        
        if (check[0] && check[1]) {
            return true;
        } else {
            return false;
        }
    }
 
    ///// ī�� 1�� �̱�
    public void drawCardOne(int comCardSet[], String cardSet[]) {
        
        int drawLoop = 0;
        int cardSetIdx = 0;
        int drawCard = 0;
        String drawCardStr = "";
        
        while (drawLoop < 1) {
            cardSetIdx = (int)(Math.random() * 52);
            drawCard = comCardSet[cardSetIdx];
            
            if (drawCard != 0) {
                // �׽�Ʈ: ���� ī��set���� ���� ī���� ��ġ Ȯ��
                // System.out.println("���� ī���� �迭 �ε��� = " + cardSetPos);
                
                drawCardStr = checkNum(drawCard);
                for (int i = 0; i < cardSet.length; i++) {
                    if (cardSet[i] == "0") {
                        cardSet[i] = drawCardStr;
                        comCardSet[cardSetIdx] = 0;
                        drawLoop++;
                        break;
                    }
                }
            }
        }
    }
 
/*
 * [��е� ī�带 ���]
 * - 'index' ���� 1�̸� ī��set ����
 * - 'index' ���� 2�� ī��set���� ī�� 1�� ����
 */
    public void cardSetNum(String cardSet[], int index) {
        
        if (index == 1) {
            for (int i = 0; i < cardSet.length; i++) {
                if (cardSet[i] == "0") {
                    System.out.print(" ");
                }
                else {
                    System.out.print(cardSet[i] + " ");
                }
            }
            System.out.println();
        } else if (index == 2) {
            for (int i = 0; i < cardSet.length; i++) {
                if (i == 0) {        // ù ��° �ڸ��� ī�� ����
                    System.out.print("? ");
                }
                else {
                    if (cardSet[i] == "0") {
                        System.out.print(" ");
                    } else {
                        System.out.print(cardSet[i] + " ");
                    }
                }
            }
            System.out.println();
        } else {
            // ���� ó��
            System.out.println("�����. �ε��� ���� �߸��Ǿ����ϴ�.");
        }
    }
 
    ///// ī��set�� �� �� �������� üũ
    public boolean cardFull(String cardSet[]) {
        
        boolean cardSetFull = false;
        int count = 0;
        
        for (int i = 0; i < cardSet.length; i++) {
            if (cardSet[i] == "0") {
                count++;
            }
        }
        if (count == 0) {
            cardSetFull = true;
        }
 
        return cardSetFull;
    }
 
/*
 * [���� ���ϱ�]
 * - 1�� ���� �ջ�: ���ĺ� ī��� ������ ���� ������ �ٸ��� �ջ�
 * - 2�� ���� �ջ�: 1�� ���� �ջ��� ���� �� ī��set�� 'A'�� ������ ���,
 *               10���� �߰��� ������ '21�� ����'�� 10�� �߰�(= 'A'�� '11��'�� ���� �ǹ�)
 */
    public int pointResult(String cardSet[]) {
        
        int point = 0;
 
        for (int i = 0; i < cardSet.length; i++) {
            if (cardSet[i] == "A") {
                point += 1;
            } else if (cardSet[i] == "J") {
                point += 10;
            } else if (cardSet[i] == "Q") {
                point += 10;
            } else if (cardSet[i] == "K") {
                point += 10;
            } else if (Integer.parseInt(cardSet[i]) > 1 
                    && Integer.parseInt(cardSet[i]) <= 10) {
                point += Integer.parseInt(cardSet[i]);
            } else {
                point += 0;
            }
        }
 
        for (int i = 0; i < cardSet.length; i++) {
            if (cardSet[i] == "A" && point + 10 <= 21) {
                point += 10;
            } 
        }
 
        return point;
    }
 
/*
 * ����
 * 1.���� �¸�
 *  - ������ �⺻ ī�� 2���� ����(A, K)�̰�, ������ �ش���� ���� ���
 *  - ���� ������ '21�� ����'�̰�, ������ ������ �� ���� ���
 *  - ������ ������ '21�� ����'�̰�, ������ ������ '21���� �ʰ�'�� ���
 *  
 * 2.���� �й�
 *  - ������ �⺻ ī�� 2���� ����(A, K)�̰�, ������ �ش���� ���� ���
 *  - ���� ������ '21�� ����'�̰�, ������ ������ �� ���� ���
 *  - ������ ������ '21���� �ʰ�'�� ���
 *  
 * 3.���º�
 *  - ���� �⺻ ī�� 2���� ����(A, K)�� ��� 
 *  - ���� ������ ������ ��� 
 */
    
    ///// ��� ���
    public void gameResult(String uCardSet[], String dCardSet[], 
                            boolean uBJWin, boolean dBJWin, boolean gameWin,
                            ArrayList<memDTO> arrlist, String playID[], int betChip) {
        
        System.out.println("ī�带 �����մϴ�.");
        System.out.println();
        
        System.out.println("�������� ��е� ī��");
        cardSetNum(uCardSet, 1);
        
        System.out.println("������ ���� = " + pointResult(uCardSet));
        System.out.println();
        
        System.out.println("�������� ��е� ī��");
        cardSetNum(dCardSet, 1);
        
        System.out.println("������ ���� = " + pointResult(dCardSet));
        System.out.println();
        
        int resultNum = 0;
        
        // ��� �޽��� - ���� ����
        if (uBJWin && !dBJWin) {
            System.out.println("���! �� �����մϴ� �� '����'���� �¸�!!");
            resultNum = 1;
        } else if (!uBJWin && dBJWin) {
            System.out.println("��... '����'���� �й�!");
            resultNum = 2;
        } else if (uBJWin && dBJWin) {
            System.out.println("�̷�����!! '����'���� ���º�!!!");
        }
        // ��� �޽��� - ���� ��
        else {
            if (gameWin && pointResult(uCardSet) > pointResult(dCardSet) 
                    && pointResult(uCardSet) <= 21
                    || gameWin && pointResult(uCardSet) < pointResult(dCardSet)
                    && pointResult(dCardSet) > 21) {
                System.out.println("�� �����մϴ� �� �¸��ϼ̽��ϴ�!!");
                resultNum = 3;
            } else if (gameWin && pointResult(uCardSet) == pointResult(dCardSet)
                    && pointResult(uCardSet) <= 21) {
                System.out.println("�̷�����... ���º��Դϴ�!");
            }
            else {
                System.out.println("�й�!");
                resultNum = 4;
            }
        }
        System.out.println();
        
        // Ĩ ���� ����
        chipRec(resultNum, arrlist, playID, betChip);
    }
    
    ///// Ĩ ���� ����
    public void chipRec(int resultNum, ArrayList<memDTO> arrlist, String playID[], int betChip) {
        
        memDTO loginID = loginIDInfo(arrlist, playID);
        int idIdx = loginidIdx(arrlist, playID);
        
        int myChip = loginID.getChip();
        switch (resultNum) {
            case 1:        // �¸�: ����
                myChip += betChip * 1.5;
                break;
                
            case 2:        // �й�: ����
                myChip -= betChip;
                break;
                
            case 3:        // �¸�: ���� ��
                myChip += betChip * 2;
                break;
                
            case 4:        // �й�: ���� ��
                myChip -= betChip;
                if (myChip < 0) {    // Ĩ ������ 0�� ���ϰ� �Ǹ� 0������ ����
                    myChip = 0;
                }
                break;
                
            default:
                System.out.println("���ºδ� ���� ��ȭ�� �����ϴ�.");
                break;
        }
        
/*
 * [��� ����]
 * - �迭 ����Ʈ�� ���� ������ ����� ���� ��ġ�� ����� ������ �ٽ� ����
 */
        arrlist.remove(idIdx);
        arrlist.add(idIdx, loginID);
        loginID.setChip(myChip);
    }
    
    ///// ���� ����� ����
    public boolean reGame() {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("[���� ����]");
        
        while (true) {
            System.out.println("������ �Ͻðڽ��ϱ�?");
            System.out.print("�����(1), ����(2): ");
            
            int input = sc.nextInt();
            
            switch (input) {
                case 1:
                    System.out.println();
                    return true;
                    
                case 2:
                    System.out.println("������ �����մϴ�.");
                    return false;
                    
                default:
                    System.out.println("�߸� �Է��ϼ̽��ϴ�.");
            }
        }
    }
    
    ///////////// TODO �׽�Ʈ�� �޼ҵ�
    
    // ���� ī��set�� ���
    public void comCardSetPrint(int cardSet[]) {
        
        for(int i=0; i < cardSet.length; i++) {
            if (i % 3 == 0) {
                System.out.println();
            }
            System.out.print("cardSet[" + i + "] = " + cardSet[i] + "   ");
        }
        System.out.println("\n");
    }
}


��ó: http://yahma.tistory.com/80 [��ǥ�� ����� ������ �޷�������. ���и� �η��� �� �������� �� ���� ���ϱ�]
