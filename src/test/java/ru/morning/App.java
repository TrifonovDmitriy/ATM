package ru.morning;

public class App {
    public static void main(String[] args) {
        // проверка методов пополения и получения баланса
        ATM atm = new ATM(10, 10, 10);
        atm.addMoney(20, 5, 10);
        atm.getBalanse();
        System.out.println("************************************");

        //проверяем метод снятия средств (успешно)
        atm.getMoney(1330);
        atm.getBalanse();
        System.out.println("************************************");

        //Проверка отрицательного числа
        atm.getMoney(-100);
        System.out.println("************************************");

        //Проверка суммы больше чем в банкомате
        atm.getMoney(1000000000);
        System.out.println("************************************");

        //Проверка не кратности номинала 20
        atm.getMoney(105);
        System.out.println("************************************");

        //проверка недостаточности купюр в банкомате
        ATM atm2 = new ATM(1, 5, 100);
        atm2.getMoney(290);
    }
}
