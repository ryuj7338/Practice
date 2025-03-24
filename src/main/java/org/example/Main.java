package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // num1, num2, num3 생성
        int num1, num2, sum;
        num1 = 0;   // 처음 값 넣음
        num2 = 1;   // 처음 값 넣음
        sum = 0;    // 초기값 세팅

        // 처음 값도 나와야 하기 때문에 먼저 num1, num2출력
        System.out.print(num1+ " " + num2);
        // 처음값 num1, num2 제외한 나머지 8개 출력
        for (int i = 0; i < n - 2; i++) {
            // num1 + num2를 sum에 저장
            sum = num1 + num2;
            // 더한 값을 출력
            System.out.print(" "+sum);
            // 출력 이후 다음 것도 출력하기 위해 설정
            num1 = num2;
            num2 = sum;
        }



    }
}
