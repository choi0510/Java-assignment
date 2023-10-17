import java.util.Scanner;

public class Homework4 {
    int gcd(int m, int n) { // 재귀함수로 만든 gcd함수
        if(m == 0) { // m이 0 이면 m을 반환
            return m;
        } else if(m % n == 0) { // m이 n으로 나눠지면 n을 반환
            return n;
        } else {
            m = m % n; // m을 n으로 나눈 나머지를 새로 m에 저장
            return gcd(n, m); // m과 n을 바꾼 후 다시 gcd함수 호출
        }
    }
   /* int gcd(int m, int n) { // 반복문으로 변환
        while (n != 0) {
            int temp = n;
            n = m % n;
            m = temp;
        }
        return m;
    }*/

    public static void main(String[] args) {
        Homework4 home = new Homework4();
        Scanner sc = new Scanner(System.in);
        System.out.print("두 수를 입력하세요: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        System.out.printf("두 수의 최대공약수는 %d입니다.", home.gcd(num1, num2));
    }
}
