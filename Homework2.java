import java.util.Scanner;

class Student {
    int schoolNum;
    String name;
    String major;
    long phoneNum;
//    생성자 작성
    Student(int schoolNum, String name, String major, long phoneNum) {
        this.schoolNum = schoolNum;
        this.name = name;
        this.major = major;
        this.phoneNum = phoneNum;
    }
//    phoneNum의 새로운 값을 설정하는 setPhoneNum()
    String setPhoneNum(long phoneNum) {
        String newPhoneNum = Long.toString(phoneNum);
        newPhoneNum = String.format("%11s", newPhoneNum).replace(" ", "0");
        String regEx = "(\\d{3})(\\d{4})(\\d{4})";
        newPhoneNum = newPhoneNum.replaceAll(regEx, "$1-$2-$3");
        return schoolNum + " " + name + " " + major + " " + newPhoneNum;
    }
}

public class Homework2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 3; i++) {
            System.out.println("학생의 학번, 이름, 전공, 전화번호를 입력하세요: ");
            int schoolNum = sc.nextInt();
            String name = sc.next();
            String major = sc.next();
            long phoneNumber = sc.nextLong();
            Student person1 = new Student(schoolNum, name, major, phoneNumber);
            System.out.println(person1.setPhoneNum(phoneNumber));
        }
    }
}
