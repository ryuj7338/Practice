package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Content> contents = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("== 명언 앱 실행 ==");
        Scanner sc = new Scanner(System.in);

        int lastId = 0;
        while (true) {
            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();

            if (cmd.length() == 0) {
                System.out.println("명령어를 입력하세요");
                continue;
            }
            if (cmd.equals("종료")) {
                System.out.println("== 명언 앱 종료 ==");
                break;
            }
            if (cmd.equals("등록")) {
                int id = lastId + 1;

                String regDate = Util.getNowStr();
                String upDateDate = Util.getNowStr();
                System.out.print("명언: ");
                String content = sc.nextLine().trim();
                System.out.print("작가: ");
                String writer = sc.nextLine().trim();

                Content save = new Content(id, regDate, upDateDate, content, writer);
                contents.add(save);

                System.out.println(id + "번 명언이 등록되었습니다.");
                lastId++;
            } else if (cmd.equals("목록")) {
                System.out.println("   번호   /   명언   /   작가   ");
                System.out.println("================================");

                if (contents.size() == 0) {
                    System.out.println("해당 명언이 없습니다.");
                }
                for (int i = contents.size() - 1; i >= 0; i--) {
                    Content save = contents.get(i);

                    System.out.printf("   %d   /   %s   /   %s   \n", save.getId(), save.getContent(), save.getWriter());
                }
            } else if (cmd.startsWith("상세보기?id=")) {
                int id = Integer.parseInt(cmd.substring(8));

                Content foundId = founById(id);

                if (foundId == null) {
                    System.out.println(id + "번 명언이 없습니다.");
                    continue;
                }

                System.out.printf("번호: %d\n", foundId.getId());
                System.out.printf("명언: %s\n", foundId.getContent());
                System.out.printf("작가: %s\n", foundId.getWriter());
                System.out.println("등록 날짜: " + foundId.getRegDate());
                System.out.println("수정 날짜: " + foundId.getUpDateDate());
            } else if (cmd.startsWith("수정?id=")) {
                int id = Integer.parseInt(cmd.substring(6));

                Content foundId = founById(id);
                if (foundId == null) {
                    System.out.println(id + "번 명언이 없습니다.");
                    continue;
                }

                System.out.println("기존 명언: " + foundId.getContent());
                System.out.println("기존 작가: " + foundId.getWriter());

                for (int i = 0; i < contents.size(); i++) {
                    Content save = contents.get(i);
                    if (save.getId() == id) {
                        foundId = save;
                    }
                }
                String newContent;
                String newWriter;

                while (true) {
                    System.out.print("새 명언: ");
                    newContent = sc.nextLine().trim();

                    if (newContent.length() != 0) {
                        break;
                    }
                    System.out.println("수정할 명언을 입력하세요");
                }
                while (true) {
                    System.out.print("새 작가: ");
                    newWriter = sc.nextLine().trim();

                    if (newWriter.length() != 0) {
                        break;
                    }
                    System.out.println("수정할 작가를 입력하세요");
                }




                foundId.setContent(newContent);
                foundId.setWriter(newWriter);
                foundId.setUpDateDate(Util.getNowStr());

                System.out.println(id + "번 명언이 수정되었습니다.");
            } else if (cmd.startsWith("삭제?id=")) {
                int id = Integer.parseInt(cmd.substring(6));
                Content foundId = founById(id);
                int foundNum = 0;
                if (foundId == null) {
                    System.out.println(id + "번 명언이 없습니다.");
                    continue;
                }
                for (int i = 0; i < contents.size(); i++) {
                    Content save = contents.get(i);
                    if (save.getId() == id) {
                        foundId = save;
                        foundNum = i;
                    }
                }
                contents.remove(foundNum);
                System.out.println(id + "번 명언이 삭제되었습니다.");
            }
        }
        sc.close();
    }

    private static Content founById(int id) {
        for (Content save : contents) {
            if (save.getId() == id) {
                return save;
            }
        }
        return null;
    }
}

class Content {
    int id;
    String regDate;
    String upDateDate;
    String content;
    String writer;

    public Content(int id, String regDate, String upDateDate, String content, String writer) {
        this.id = id;
        this.regDate = regDate;
        this.upDateDate = upDateDate;
        this.content = content;
        this.writer = writer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getUpDateDate() {
        return upDateDate;
    }

    public void setUpDateDate(String upDateDate) {
        this.upDateDate = upDateDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}


