package ru.morning;

public class ATM {
    /**
     * Константы, номиналы купюр
     */
    private final static int TWENTY = 20;
    private final static int FIFTY = 50;
    private final static int HUNDRED = 100;
    /**
     * Переменные, количество купюр в банкомате соответствующим константам
     */
    private int qtyTwenty;
    private int qtyFifty;
    private int qtyHundred;

    /**
     * Конструктор Банкомата, принимает количество купюр
     */
    public ATM(int qtyTwenty, int qtyFifty, int qtyHundred) {
        this.qtyTwenty = qtyTwenty;
        this.qtyFifty = qtyFifty;
        this.qtyHundred = qtyHundred;
    }

    /**
     * Метод для внесения средств в банкомат, принимает количество купюр
     */
    public void addMoney(int qtyTwenty, int qtyFifty, int qtyHundred) {
        this.qtyTwenty += qtyTwenty;
        this.qtyFifty += qtyFifty;
        this.qtyHundred += qtyHundred;
    }

    /**
     * Метод для получения значения количества купюр в банкомате
     */
    public void getBalanse() {
        System.out.println("Наличие купюр в банкомате:" +
                "\nНоминалом 20: " + this.qtyTwenty +
                "\nНоминалом 50: " + this.qtyFifty +
                "\nНоминалом 100: " + this.qtyHundred);
    }

    /**
     * Снятие денежных средств, в приоритете выдача крупными 100, затем 50 и 20, учитывается кол-во всех купюр в банкомате
     * Выдача осуществялется следующих сумм: 20, далее от 40 и выше кратно 10
     */
    public Boolean getMoney(int money) { // возвращаемое логическое значение данной ф-ции негде не реализовал,
        // по условиям задачи и не требовалось как я понял)
        if (money <= 0) {
            System.out.println("Не возможно снять отрицательное или нулевое значение");
            return false;
        }
        if (money > (TWENTY * qtyTwenty + FIFTY * qtyFifty + HUNDRED * qtyHundred)) {
            System.out.println("Недостаточно средств в банкомате для выдачи наличных");
            return false;
        }
        int remainingAmount = money;    // переменная для расчёта оставшегося количества денежных средств
        int hundredsNeeded = Math.min(remainingAmount / HUNDRED, qtyHundred);   // выбираем мин. кол-во 100 купюр
        int fiftiesNeeded;
        if (money > HUNDRED && (money % HUNDRED == 10 || money % HUNDRED == 30)) { //проверяем 10 и 30 в сотках
            hundredsNeeded -= 1;
            remainingAmount -= hundredsNeeded * HUNDRED + FIFTY;
            fiftiesNeeded = Math.min(remainingAmount / FIFTY, qtyFifty);
            remainingAmount -= fiftiesNeeded * FIFTY - FIFTY;
        } else {
            remainingAmount -= hundredsNeeded * HUNDRED;

            fiftiesNeeded = Math.min(remainingAmount / FIFTY, qtyFifty);

            if (money % HUNDRED == 60 || money % HUNDRED == 80) { // проверяем 60 и 80 в остатках
                fiftiesNeeded -= 1;
            }
            remainingAmount -= fiftiesNeeded * FIFTY;
        }
        int twentiesNeeded = remainingAmount / TWENTY;  // делим остаток на 20 для получения нужного количества 20 купюр
        if (remainingAmount % TWENTY != 0) {     // проверяем, если конечный остаток суммы при делении на 20 даёт остаток
            System.out.println("Не возможно выдать: " + money + "\nДоступые к выдаче суммы: 20 или от 40 и выше кратно 10");
            return false;
        }
        if (qtyTwenty >= twentiesNeeded && qtyFifty >= fiftiesNeeded && qtyHundred >= hundredsNeeded) {   //проверяем есть ли деньги в кассе)
            qtyHundred -= hundredsNeeded;     //
            qtyFifty -= fiftiesNeeded;        // снижаем количество оставшихся купюр в банкомате к выданным
            qtyTwenty -= twentiesNeeded;      //
            System.out.println("Выдано наличных: " + money +
                    "\nВыдано купюр номиналом 20: " + twentiesNeeded +
                    "\nВыдано купюр номиналом 50: " + fiftiesNeeded +
                    "\nВыдано купюр номиналом 100: " + hundredsNeeded);
        } else {
            System.out.println("Недостаточно необходимых купюр в банкомате для выдачи наличных");
            return false;
        }
        return true;
    }
}

