package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 공백 생성
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            // 숫자 출력
            for (int k = n - i; k > 0; k--) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
        
    }
}
