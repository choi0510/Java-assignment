import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("몇 개의 수를 입력할 예정인가요? ");
        int n = scanner.nextInt();
        int arr[] = new int[n];   // n 크기의 배열 선언

        System.out.print("수를 입력하세요: ");
        for(int i = 0; i<n;i++) {
            arr[i] = scanner.nextInt();  // 입력받은 수를 배열에 저장
        }

        int big = arr[0];   // 변수 big을 배열의 첫번째 값으로 초기화
        int small = arr[0];  // 변수 small을 배열의 첫번째 값으로 초기화

        for(int i = 1; i < n; i++) {
            big = (big > arr[i]) ? big : arr[i];   // 변수 big과 배열의 index를 증가시키면서 크기 비교
        }
        for(int i = 1; i < n; i++) {
            small = (small < arr[i]) ? small : arr[i];   // 변수 small과 배열의 index를 증가시키면서 크기 비교
        }
        System.out.printf("최대값: %d\n", big);
        System.out.printf("최소값: %d", small);
    }
}
