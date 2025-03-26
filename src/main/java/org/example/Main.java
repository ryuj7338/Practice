package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("== motivation 실행==");

        Scanner sc = new Scanner(System.in);

        int lastId = 0; // 등록할 때 번호가 필요하니까 생성 / 0으로 세팅

        List<Motivation> motivations = new ArrayList<>();   // Motivation을  motivations라는 객체에 리스트를 저장하기 위해 생성

        while (true) {
            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();      // trim 사용이유 -> 공백만 입력하면 그대로 실행되므로, 공백방지

            if (cmd.equals("exit")) {       // 사용자가 명령어에 exit를 입력하면 그 즉시 종료
                System.out.println("== motivation 종료 ==");
                break;
            } else if (cmd.length() == 0) {     // cmd의 길이가 0이라면 입력한 것이 없으므로 명령어 입력하라고 경고문 출력
                System.out.println("명령어가 입력되지 않았습니다.");
                continue;       // 명령어를 입력하지 않았으니 다시 입력하라고 while문 안 윗줄에 다시 보내기
            }

            if (cmd.equals("add")) {    // 명령어에 add라고 입력하면 등록 시작
                System.out.println("== motivation 등록 ==");
                int id = lastId + 1;     // 등록할 때 번호가 다 같을 수는 없으므로 id라는 변수를 만들고 lastId에 1을 더함 -> 더하는 이유? lastId가 0이니까

                System.out.print("motivation: ");
                String motivation = sc.nextLine();
                System.out.print("source: ");
                String source = sc.nextLine();

                Motivation save = new Motivation(id, motivation, source);       // Motivation이라는 생성자를 만들고 id, 정보(motivation, source)를 담기

                motivations.add(save);  // motivations 리스트에 저장하기 위해

                System.out.printf("%d번 motivation이 등록되었습니다.\n", id);
                lastId++;   // 등록될 때마다 증가 시켜야 하니까
            } else if (cmd.equals("list")) {
                System.out.println("== motivation 목록 ==");

                if (motivations.size() == 0) {      // motivation 리스트에 아무것도 등록된게 없을 수도 있으므로 없으면 없다고 알려주기
                    System.out.println("등록된 목록이 없습니다.");
                    continue;
                }

                System.out.println("======================================");
                System.out.println("   번호   /   source   /   motivation   ");

                for (int i = motivations.size() - 1; i >= 0; i--) {     // motivation 리스트 저장소 길이가 2라면 인덱스로 따져봤을때
                    // [0],[1],[2]니까 길이 - 1를 해줌으로써 현재 갖고있는 배열을 가져오게 함
                    Motivation save = motivations.get(i);   // motivations에 등록한게 들어 있으므로 가져오게 함으로써 save에 하나 하나 담음.

                    if (save.getSource().length() > 7) {        // source의 글자 수가 7이 넘으면 save에서 가져온 source를 인덱스 0부터 5까지만 출력시키고 나머지는 ...으로 출력
                        System.out.printf("   %d   /   %s   /   %s   \n", save.getId(), save.getSource().substring(0, 5) + "...", save.getMotivation());
                        continue;
                    }

                    System.out.printf("   %d   /   %s   /   %s   \n", save.getId(), save.getSource(), save.getMotivation());    // save에 담은걸 불러옴

                }


                System.out.println("======================================");
            }else if(cmd.startsWith("delete")) {
                int id = Integer.parseInt(cmd.split(" ")[1]);   // delete로 시작하는 명령어 뒤에 번호만을 추출하기 위해서

                Motivation foundId = null;      // Motivation과 연결될 객체 founId를 만들고 아무것도 안 들어있게 만듦
                int foundNum = 0;  //

                for (int i = 0; i < motivations.size(); i++) {
                    Motivation save = motivations.get(i);
                    if (save.getId() == id) {
                        foundId = save;
                        foundNum = i;
                        break;
                    }
                }

                if (foundId == null) {
                    System.out.println("해당 번호가 없습니다.");
                    return;
                }

                motivations.remove(foundNum);
                System.out.printf("%d번 motivation이 삭제되었습니다.\n", id);

            }

            else {     // 이상한 명령어를 입력시 사용할 수 없다고 알려주기
                System.out.println("사용할 수 없는 명령어입니다.");
                continue;
            }

        }


    }
}

class Motivation {
    private int id;
    private String motivation;
    private String source;

    public Motivation(int id, String motivation, String source) {
        this.id = id;
        this.motivation = motivation;
        this.source = source;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }
}