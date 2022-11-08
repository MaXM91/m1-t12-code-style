import java.util.Scanner;

public class CalculateDeposit {                                  // Молодец! Понятные имена переменных написаны с соблюдением lowerCamelCase и название классов. 
    double calculateComplexPercent(double amount, double yearRate, int year) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * year);
        return round(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate   // В соответствии с code style 
            , int year) {                                          // при правильном переносе запятая остаётся в конце предыдущей строки
        return round(amount + amount * yearRate                    // В соответствии с code style если выражение умещается в лимит — его переносить не надо
                * year, 2);
    }

    double round(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void choosingTypeDeposit() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int depositAmount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        int periodInYear = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом"
                + ", 2 - вклад с капитализацией:");
        int typeDeposit = scanner.nextInt();

        double amountAfterIncome = 0;

        if (typeDeposit == 1) {
            amountAfterIncome = calculateSimplePercent(depositAmount, 0.06, periodInYear);
        } else if (typeDeposit == 2) {
            amountAfterIncome = calculateComplexPercent(depositAmount, 0.06, periodInYear);
        }
        System.out.println("Результат вклада: " + depositAmount + " за " + periodInYear
                + " лет превратятся в " + amountAfterIncome);
    }

    public static void main(String[] args) {
        new CalculateDeposit().choosingTypeDeposit();
    }

}
