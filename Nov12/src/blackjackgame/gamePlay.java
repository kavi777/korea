package blackjackgame;


import java.util.ArrayList;
import java.util.Scanner;
 
public class gamePlay {
    
    private int minBetChip;
    private int maxBetChip;
    
    public gamePlay() {}
    
    ///// 게임 반복 루프
    public gamePlay(ArrayList<memDTO> arrlist, String playID[]) {
        
        Scanner sc = new Scanner(System.in);
        minBetChip = 10;        // 베팅 최소 개수
        maxBetChip = 100;        // 베팅 최대 개수
        
        System.out.println("[게임 시작]");
        System.out.println();
        
        ////////// TODO 초기화, 기본셋팅
 
        // 베팅
        memDTO loginID = loginIDInfo(arrlist, playID);
        
        System.out.println("베팅을 받겠습니다.");
        System.out.println("현재 " + playID[0] + "님의 칩 개수는 " + loginID.getChip() + "개");
        
        int betChip = 0;
        while (true) {
            System.out.print("칩 개수 입력(10~100): ");
            betChip = sc.nextInt();
            
            if (betChip >= 10 && betChip <= 100 && betChip <= loginID.getChip()) {
                break;
            } else {
                System.out.println("다시 입력해주세요.");
            }
        }
        System.out.println();
        
        boolean gameWin = true;                    // 게임 결과 판단. 승리로 초기화
        int comCardSet[] = new int[52];            // 무작위로 결정된 숫자를 저장
        
        comCardSetInit(comCardSet);                // 공용 카드set 생성 및 초기화 
 
        // 테스트: 공용 카드set 출력 //
//        comCardSetPrint(comCardSet);
        
        boolean uBJWin = false;                    // 유저의 블랙잭 승리 상태 초기화
        boolean dBJWin = false;                    // 딜러의 블랙잭 승리 상태 초기화
        String uCardSet[] = new String[11];        // 유저의 카드set 준비
        String dCardSet[] = new String[3];        // 딜러의 카드set 준비
        cardSetInit(uCardSet, dCardSet);        // 유저과 딜러의 카드set 생성
        
        // 각자 기본카드 2개 배분
        drawCardOne(comCardSet, uCardSet);
        drawCardOne(comCardSet, uCardSet);
        drawCardOne(comCardSet, dCardSet);
        drawCardOne(comCardSet, dCardSet);
        
        // 테스트: 기본카드 블랙잭 셋팅 //
        // '0 = A, 1 = K || 0 = K, 1 = A'만 블랙잭 승리로 판단
//        uCardSet[0] = "A"; uCardSet[1] = "K";
//        dCardSet[0] = "A"; dCardSet[1] = "K";
        
        // 각자 기본카드의 블랙잭 판단  ※ 'A'와 'K' 1장씩 보유하고 있으면 블랙잭 승리로 판단
        uBJWin = chekBJ(uCardSet);
        dBJWin = chekBJ(dCardSet);
                
        // 최초에 배분된 기본 카드 2장을 각각 공개
        System.out.println("유저에게 배분된 카드");
        cardSetNum(uCardSet, 1);
        
        System.out.println("딜러에게 배분된 카드");
        cardSetNum(dCardSet, 2);
        System.out.println();
        
        
        ////////// TODO 반복진행 시작
        
        while (true) {
            // 버스트: 카드를 뽑은 후 유저의 점수가 '21'을 초과하면 즉시 게임 패배
            if (pointResult(uCardSet) > 21) {
                gameWin = false;
                break;
            }
            
            // 유저 or 딜러가 '블랙잭'이면 즉시 게임 종료
            if (uBJWin || dBJWin) {
                break;
            } else if (!gameWin) {
                break;
            } else {
                ///// 계속 진행 or 카드 오픈
                System.out.print("무엇을 하시겠습니까? Hit(1), Stay(2): ");
                int decision = sc.nextInt();
                System.out.println();
        
                // 'Hit' 결정 시 추가 카드 1장 받음            
                if (decision == 1) {
 
                // 대상의 카드set이 비어있으면 카드 뽑기
                if (!cardFull(uCardSet)) {
                    drawCardOne(comCardSet, uCardSet);
                } else {
                    // 카드가 꽉 찾을 경우 강제로 'Stay'로 판단
                    System.out.println("더 이상 카드를 받을 수 없습니다. 강제로 'Stay'됩니다.");
                    decision = 2;
                }
 
                // 각 점수 비교 후 딜러의 점수가 유저보다 낮으면, 딜러 추가 카드 1장  ※ 현재 3장이면 받지 않음
                if (pointResult(dCardSet) < pointResult(uCardSet) && !cardFull(dCardSet)) {        
                    drawCardOne(comCardSet, dCardSet);
                }
 
                // 카드를 뽑은 후 유저의 점수가 '21'을 초과하면 즉시 게임 패배
                if (pointResult(uCardSet) > 21) {
                    gameWin = false;
                    break;
                }
 
                System.out.println("유저에게 배분된 카드 숫자");
                cardSetNum(uCardSet, 1);
                
                System.out.println("딜러에게 배분된 카드 숫자");
                cardSetNum(dCardSet, 2);
 
                // 'Stay' 결정 시 반복 종료           
                } else if (decision == 2) {
                    // 각 점수 비교 후 딜러의 점수가 유저보다 낮으면, 딜러 추가 카드 1장  ※ 현재 3장이면 받지 않음
                    if (pointResult(dCardSet) < pointResult(uCardSet) && !cardFull(dCardSet)) {        
                        drawCardOne(comCardSet, dCardSet);
                    }
                    break;
                } else {
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
                    System.out.println();
                }
            }
        }
        
        System.out.println("출력 전 베팅 개수 = " + betChip);
        
        ///// 결과 출력
        gameResult(uCardSet, dCardSet, uBJWin, dBJWin, gameWin, arrlist, playID, betChip);
        
        // 테스트: 공용 카드set 출력 //
//        comCardSetPrint(comCardSet);
    }
 
 
    ////////// TODO 기타 메소드
    
    ///// 로그인된 ID에 저장된 정보를 반환(ID, 칩 개수)
    public memDTO loginIDInfo(ArrayList<memDTO> arrlist, String playID[]) {
        memDTO selLoginID = new memDTO();        
        int idIdx = 0;
        
        // 배열 리스트에 저장된 현재 로그인된 ID의 인덱스 위치 찾기
        for (int i = 0; i < arrlist.size(); i++) {
            if (playID[0].equals(arrlist.get(i).getId())) {
                idIdx = i;
                break;
            }
        }
        selLoginID = arrlist.get(idIdx);
        
        return selLoginID;
    }
    
    ///// 로그인된 ID가 배열 리스트에 저장된 인덱스 번호를 반환
    public int loginidIdx(ArrayList<memDTO> arrlist, String playID[]) {    
        int idIdx = 0;
        
        // 배열 리스트에 저장된 현재 로그인된 ID의 인덱스 위치 찾기
        for (int i = 0; i < arrlist.size(); i++) {
            if (playID[0].equals(arrlist.get(i).getId())) {
                idIdx = i;
                break;
            }
        }
        
        return idIdx;
    }
    
/*
 * 52장이 들어있는 트럼프 공용 카드set을 생성 및 초기화
 * 동일한 카드는 중복불가(스페이드,다이아몬드,하트,클로버 13장씩 4쌍 존재)
 * 순서 상관없이 무작위로 섞음
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
    
    ///// 각자의 카드set 초기화
    public void cardSetInit(String uCardSet[], String dCardSet[]) {
        
        for (int i = 0; i < uCardSet.length; i++) {
            uCardSet[i] = "0";
        }
        for (int i = 0; i < dCardSet.length; i++) {
            dCardSet[i] = "0";
        }
    }
 
    ///// 특정 카드 번호를 영문자로 변환
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
    
    ///// 블랙잭 승리 판단
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
 
    ///// 카드 1장 뽑기
    public void drawCardOne(int comCardSet[], String cardSet[]) {
        
        int drawLoop = 0;
        int cardSetIdx = 0;
        int drawCard = 0;
        String drawCardStr = "";
        
        while (drawLoop < 1) {
            cardSetIdx = (int)(Math.random() * 52);
            drawCard = comCardSet[cardSetIdx];
            
            if (drawCard != 0) {
                // 테스트: 공용 카드set에서 뽑은 카드의 위치 확인
                // System.out.println("뽑은 카드의 배열 인덱스 = " + cardSetPos);
                
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
 * [배분된 카드를 출력]
 * - 'index' 값이 1이면 카드set 공개
 * - 'index' 값이 2면 카드set에서 카드 1개 숨김
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
                if (i == 0) {        // 첫 번째 자리의 카드 숨김
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
            // 예외 처리
            System.out.println("디버그. 인덱스 값이 잘못되었습니다.");
        }
    }
 
    ///// 카드set이 꽉 찬 상태인지 체크
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
 * [점수 구하기]
 * - 1차 점수 합산: 알파벳 카드는 종류에 따라 점수를 다르게 합산
 * - 2차 점수 합산: 1차 점수 합산이 끝난 뒤 카드set에 'A'가 존재할 경우,
 *               10점을 추가한 점수가 '21점 이하'면 10점 추가(= 'A'는 '11점'과 같은 의미)
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
 * 승패
 * 1.유저 승리
 *  - 유저의 기본 카드 2장이 블랙잭(A, K)이고, 딜러는 해당되지 않을 경우
 *  - 각자 점수가 '21점 이하'이고, 유저의 점수가 더 높을 경우
 *  - 유저의 점수가 '21점 이하'이고, 딜러의 점수는 '21점을 초과'할 경우
 *  
 * 2.유저 패배
 *  - 딜러의 기본 카드 2장이 블랙잭(A, K)이고, 유저는 해당되지 않을 경우
 *  - 각자 점수가 '21점 이하'이고, 딜러의 점수가 더 높을 경우
 *  - 유저의 점수가 '21점을 초과'할 경우
 *  
 * 3.무승부
 *  - 각자 기본 카드 2장이 블랙잭(A, K)일 경우 
 *  - 각자 점수가 동일한 경우 
 */
    
    ///// 결과 출력
    public void gameResult(String uCardSet[], String dCardSet[], 
                            boolean uBJWin, boolean dBJWin, boolean gameWin,
                            ArrayList<memDTO> arrlist, String playID[], int betChip) {
        
        System.out.println("카드를 오픈합니다.");
        System.out.println();
        
        System.out.println("유저에게 배분된 카드");
        cardSetNum(uCardSet, 1);
        
        System.out.println("유저의 점수 = " + pointResult(uCardSet));
        System.out.println();
        
        System.out.println("딜러에게 배분된 카드");
        cardSetNum(dCardSet, 1);
        
        System.out.println("딜러의 점수 = " + pointResult(dCardSet));
        System.out.println();
        
        int resultNum = 0;
        
        // 결과 메시지 - 블랙잭 유무
        if (uBJWin && !dBJWin) {
            System.out.println("대박! ★ 축하합니다 ★ '블랙잭'으로 승리!!");
            resultNum = 1;
        } else if (!uBJWin && dBJWin) {
            System.out.println("헐... '블랙잭'으로 패배!");
            resultNum = 2;
        } else if (uBJWin && dBJWin) {
            System.out.println("이럴수가!! '블랙잭'으로 무승부!!!");
        }
        // 결과 메시지 - 점수 비교
        else {
            if (gameWin && pointResult(uCardSet) > pointResult(dCardSet) 
                    && pointResult(uCardSet) <= 21
                    || gameWin && pointResult(uCardSet) < pointResult(dCardSet)
                    && pointResult(dCardSet) > 21) {
                System.out.println("★ 축하합니다 ★ 승리하셨습니다!!");
                resultNum = 3;
            } else if (gameWin && pointResult(uCardSet) == pointResult(dCardSet)
                    && pointResult(uCardSet) <= 21) {
                System.out.println("이럴수가... 무승부입니다!");
            }
            else {
                System.out.println("패배!");
                resultNum = 4;
            }
        }
        System.out.println();
        
        // 칩 개수 갱신
        chipRec(resultNum, arrlist, playID, betChip);
    }
    
    ///// 칩 개수 갱신
    public void chipRec(int resultNum, ArrayList<memDTO> arrlist, String playID[], int betChip) {
        
        memDTO loginID = loginIDInfo(arrlist, playID);
        int idIdx = loginidIdx(arrlist, playID);
        
        int myChip = loginID.getChip();
        switch (resultNum) {
            case 1:        // 승리: 블랙잭
                myChip += betChip * 1.5;
                break;
                
            case 2:        // 패배: 블랙잭
                myChip -= betChip;
                break;
                
            case 3:        // 승리: 점수 비교
                myChip += betChip * 2;
                break;
                
            case 4:        // 패배: 점수 비교
                myChip -= betChip;
                if (myChip < 0) {    // 칩 개수가 0점 이하가 되면 0점으로 고정
                    myChip = 0;
                }
                break;
                
            default:
                System.out.println("무승부는 점수 변화가 없습니다.");
                break;
        }
        
/*
 * [기록 갱신]
 * - 배열 리스트에 기존 정보를 지우고 지운 위치에 변경된 정보를 다시 저장
 */
        arrlist.remove(idIdx);
        arrlist.add(idIdx, loginID);
        loginID.setChip(myChip);
    }
    
    ///// 게임 재시작 유무
    public boolean reGame() {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("[게임 종료]");
        
        while (true) {
            System.out.println("무엇을 하시겠습니까?");
            System.out.print("재시작(1), 종료(2): ");
            
            int input = sc.nextInt();
            
            switch (input) {
                case 1:
                    System.out.println();
                    return true;
                    
                case 2:
                    System.out.println("게임을 종료합니다.");
                    return false;
                    
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }
    
    ///////////// TODO 테스트용 메소드
    
    // 공용 카드set을 출력
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


출처: http://yahma.tistory.com/80 [목표가 생기면 무작정 달려들어야지. 실패를 두려워 할 여유같은 건 없을 때니까]
