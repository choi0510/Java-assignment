import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class Check {
    private boolean idflag;
    private boolean passwordflag;
    private Map<String, String> m;

    public Check() {
        m = new HashMap<String, String>();
        m.put("myId", "myPass");
        m.put("myId2", "myPass2");
        m.put("myId3", "myPass3");
        this.idflag = false;
        this.passwordflag = false;
    }

    public boolean getIdFlag() { return idflag; }
    public boolean getPasswordFlag() { return passwordflag; }
    public void setIdflag(boolean changedFlag) { this.idflag = changedFlag; }
    public void setPasswordflag(boolean changedFlag) { this.passwordflag = changedFlag; }
    public void testisId(String idString) {
        for(Map.Entry<String, String> entry : m.entrySet()) {
            if(idString.equals(entry.getKey())) {
               setIdflag(true);
                break;
            }
        }
        if(!this.idflag) {
            System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.\n");
        }
    }
    public void testisPassword(String passwordString) {
        for(Map.Entry<String, String> entry : m.entrySet()) {
            if(passwordString.equals(entry.getValue())) {
                setPasswordflag(true);
                System.out.println("id와 비밀번호가 일치합니다.\n");
                break;
            }
        }
        if(!this.passwordflag) {
            System.out.println("입력하신 password는 존재하지 않습니다. 다시 입력해주세요.\n");
        }
    }
    public void print() {
        for (Map.Entry<String, String> entry : this.m.entrySet()) {
            System.out.printf("key = %s, value = %s\n", entry.getKey(), entry.getValue());
        }

    }
}

public class Homework8 {
    public static void main(String[] args) {
        Check c = new Check();
        Scanner sc = new Scanner(System.in);
        while(!c.getIdFlag() && !c.getPasswordFlag()) {
            System.out.print("id와 password를 입력해주세요.\n");
            System.out.print("id: ");
            String id = sc.next();
            c.testisId(id.trim());
            if(c.getIdFlag()) {
                System.out.print("password: ");
                String password = sc.next();
                c.testisPassword(password.trim());
                if(!c.getPasswordFlag()) {
                    c.setIdflag(false);
                }
            }
        }
    }
}
