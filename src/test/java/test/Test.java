package test;

public class Test {
    public static void main(String[] args) {
        int amount = 1570;
        int hundredsNeeded = amount / 100;
        int fiftiesNeeded = (amount % 100) / 50;
        int twentiesNeeded = (amount % 50) / 20;
        System.out.println(hundredsNeeded);
        System.out.println(fiftiesNeeded);
        System.out.println(twentiesNeeded);

    }
}
