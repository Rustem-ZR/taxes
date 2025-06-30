import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int earnings = 0;
        int spendings = 0;

        while (true) {

            System.out.println(" ");
            System.out.println("Выберите операцию и введите её номер: ");
            System.out.println("1. Добавить новый доход ");
            System.out.println("2. Добавить новый расход ");
            System.out.println("3. Выбрать систему налогообложения ");
            System.out.println(" ");

            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            int operation = Integer.parseInt(input);

            switch (operation) {

                case 1:
                    System.out.println("Введите сумму дохода: ");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;

                case 2:
                    System.out.println("Введите сумму расхода: ");
                    String moneyMns = scanner.nextLine();
                    int expense = Integer.parseInt(moneyMns);
                    spendings += expense;
                    break;

                case 3:
                    chooseTaxSystem(earnings, spendings);
                    break;
                default:
                    System.out.println("Такой операции нет");

            }

        }
        System.out.println("Программа завершена!");
    }

    private static void chooseTaxSystem(int earnings, int spendings) {
        int simpleTax = taxEarningsSpendings(earnings);
        int complexTax = taxEarningsMinusSpendings(earnings, spendings);

        int minTax = Math.min(simpleTax, complexTax);
        int maxTax = Math.max(simpleTax, complexTax);
        String taxSystem = simpleTax < complexTax ? "УСН доходы" : "УСН доходы минус расходы";

        if (minTax == maxTax) {
            System.out.println("Можете выбрать любую систему налогообложения ");
            System.out.printf("Ваш налог составит: %d рублей\n", minTax);
        } else {
            System.out.printf("Мы советуем вам %s\n", taxSystem);
            System.out.printf("Ваш налог составит: %d рублей\n", minTax);
            System.out.printf("Налог на другой системе: %d рублей\n", maxTax);
            System.out.printf("Экономия: %d рублей\n", maxTax - minTax);
        }
    }

    private static int taxEarningsSpendings(int earnings) {
        int dohod = (earnings * 6 / 100);
        if (dohod >= 0) {
            return dohod;
        } else {
            return 0;
        }
    }

    private static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }


}