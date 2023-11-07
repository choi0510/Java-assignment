class PersonalComputer {
    private Moniter moniter;
    private Computer computer;

    PersonalComputer(Moniter moniter, Computer computer) {
        this.moniter = moniter;
        this.computer = computer;
    }

    public void turnOn() {
        System.out.print(computer.turnOn() + moniter.turnOn());
    }
    public void printInfo() {
        System.out.print(computer.printInfo() + moniter.printInfo());
    }
}

class Moniter {
    private String moniterSize;
    private String color;
    private String power;

    public Moniter(String moniterSize, String color, String power) {
        this.moniterSize = moniterSize;
        this.color = color;
        this.power = power;
    }

    public String getMoniterSize() {
        return moniterSize;
    }

    public String getColor() {
        return color;
    }

    public String getPower() {
        return power;
    }

    public String turnOn() {
        return "Turning on the monitor.\n";
    }

    public String printInfo() {
        return "The spec of the moniter\n" +
                " Size: " + this.getMoniterSize() + "\n" +
                " Color: " + this.getColor() + "\n" +
                " Power: " + this.getPower();
    }
}

class Computer {
    private String cpu;
    private String memory;
    private String hd;
    private String color;
    private String power;
    public  Computer(String cpu, String memory, String hd, String color, String power) {
        this.cpu = cpu;
        this.memory = memory;
        this.hd = hd;
        this.color = color;
        this.power = power;
    }

    public String getCpu() {
        return cpu;
    }

    public String getMemory() {
        return memory;
    }

    public String getHd() {
        return hd;
    }

    public String getColor() {
        return color;
    }

    public String getPower() {
        return power;
    }

    public String turnOn() {
        return "Turning on the computer.\n";
    }
    public String printInfo() {
        return "The spec of the computer\n" +
                " CPU: " + this.getCpu() + "\n" +
                " HDD: " + this.getHd() + "\n" +
                " Meomory: " + this.getMemory() + "\n" +
                " Color: " + this.getColor() + "\n" +
                " Power: " + this.getPower() + "\n";
    }
}

public class Homework5 {
    public static void main(String[] args) {
        PersonalComputer pc = new PersonalComputer(
                new Moniter("24 inch", "Black", "45W"),
                new Computer("Core i7", "16GB", "2TB", "White", "500W"));
        pc.turnOn();
        pc.printInfo();
    }
}
