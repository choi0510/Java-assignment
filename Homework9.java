import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CheckIdAndPw {
    private boolean idflag;
    private boolean passwordflag;
    private Map<String, String> m;

    public CheckIdAndPw(Map<String, String> data) {
        m = new HashMap<>(data);
        this.idflag = false;
        this.passwordflag = false;
    }

    public boolean getIdFlag() {
        return idflag;
    }

    public boolean getPasswordFlag() {
        return passwordflag;
    }

    public void setIdflag(boolean changedFlag) {
        this.idflag = changedFlag;
    }

    public void setPasswordflag(boolean changedFlag) {
        this.passwordflag = changedFlag;
    }

    public void testisId(String idString) {
        if (m.containsKey(idString)) {
            setIdflag(true);
        } else {
            System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.\n");
        }
    }

    public void testisPassword(String passwordString, String idString) {
        String storedPassword = m.get(idString);
        if(storedPassword != null && passwordString.equals(storedPassword)) {
            setPasswordflag(true);
            System.out.println("id와 비밀번호가 일치합니다.\n");
        }
        else {
            System.out.println("입력하신 password는 존재하지 않습니다. 다시 입력해주세요.\n");
        }
    }

    public void print() {
        for (Map.Entry<String, String> entry : this.m.entrySet()) {
            System.out.printf("key = %s, value = %s\n", entry.getKey(), entry.getValue());
        }
    }
}

public class Homework9 {
    public static void main(String[] args) {
        // Read ID and password pairs from db.txt
        Map<String, String> data = readDataFromFile("db.txt");

        CheckIdAndPw c = new CheckIdAndPw(data);
        Scanner sc = new Scanner(System.in);

        while (!c.getIdFlag() || !c.getPasswordFlag()) {
            System.out.print("id와 password를 입력해주세요.\n");
            System.out.print("id: ");
            String id = sc.next();
            c.testisId(id.trim());

            if (c.getIdFlag()) {
                System.out.print("password: ");
                String password = sc.next();
                c.testisPassword(password.trim(), id.trim());
                if (!c.getPasswordFlag()) {
                    c.setIdflag(false);
                }
            }
        }
    }

    private static Map<String, String> readDataFromFile(String fileName) {
        Map<String, String> data = new HashMap<>();
        try {
            Scanner scanner = new Scanner(new File("db.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\s+");
                if (parts.length == 2) {
                    data.put(parts[0], parts[1]);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }
}
