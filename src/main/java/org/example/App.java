package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }
    public static void run() {
        System.out.println("== motivation 실행 ==");

        Scanner sc = new Scanner(System.in);

        int lastId = 1;

        List<Motivation> motivations = new ArrayList<>();   // Motivation class에 담겨져 있는 정보들을
        // motivations 리스트에 담기
        // 생성 이유? 내가 입력한 것들을 추가,제거,수정 등 하기 위해서

        while (true) {
            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();

            if (cmd.length() == 0) {    // 명령어를 입력하지 않고 스페이스바만 눌렀을때 경고문을 만들어줌
                System.out.println("명령어를 입력하세요");
                continue;   // continue를 사용해서 다시 명령어 입력하는 곳으로 이동
            }

            if (cmd.equals("add")) {
                System.out.print("motivation: ");
                String motivation = sc.nextLine().trim();   // trim() 사용 이유? 스페이스만 누르고 엔터를 하면
                // 공백이어도 다음으로 넘어가기 떄문에 공백 방지용!
                System.out.print("source: ");
                String source = sc.nextLine().trim();


                Motivation save = new Motivation(lastId, motivation, source);   // Motivation과 연결할 객체를 생성후, 생성자 안에 매개변수 담아 호출

                motivations.add(save);  // motivation 리스트에 save객체 추가

                System.out.printf("%d번 motivation이 등록되었습니다.\n",lastId);
                lastId++;

            } else if (cmd.equals("list")) {

                System.out.println("=====================================");
                System.out.println("   번호   /   source   /   motivation");

                if (motivations.size() == 0) {  // motivation에 등록된게 없을시 알려주기
                    System.out.println("등록된 목록이 없습니다.");
                    continue;   // continue를 사용하여 다시 입력할 수 있게 하기
                }

                for (int i = motivations.size() - 1; i >= 0; i--) { // 번호를 역순으로 출력하기 위해 i를 moivaions의 크기 - 1을 선언 후 0까지 감소시키기
                    Motivation save = motivations.get(i);   // i가 0까지 돌 동안 해당 i들을 motivations에서 가져오고 그것을 save에 담기

                    if (save.getSource().length() > 7) {    // save에서 가져온 source에 길이가 7보다 크다면 source부분을 substring 을 사용하여 원하는 부분만 나오게 하고 나머지는 ...으로 표현
                        // 이떄, 길이 범위 정하는거는 7이 아니어도 됨!
                        System.out.printf("   %d   /   %s   /   %s   \n",save.getId(),save.getSource().substring(0, 5)+ "...",save.getMotivation());
                        continue;
                    }
                    System.out.printf("   %d   /   %s   /   %s   \n",save.getId(),save.getSource(),save.getMotivation());   // 가져온 것들을 출력

                }


            }else if (cmd.equals("delete")){

            }
            else if (cmd.equals("exit")) {
                System.out.println("== motivation 종료 ==");
                sc.close();
                break;
            }
            else {  // 이상한 명령어를 입력할 떄 그냥 넘어가기때문에 경고문 작성
                System.out.println("사용할 수 없는 명령어입니다.");
                continue;
            }

        }
    }
}
