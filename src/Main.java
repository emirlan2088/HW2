import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws LimitException {
        BankAccount account = new BankAccount();
        account.deposit(15000);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Сколько вы хотите снять");
            int a = scanner.nextInt();
            try {
                account.withDraw(a);
                System.out.println("Снято " + a + " сом "+ " Остаток на счете: " + account.getAmount());
            } catch (LimitException e) {
                System.out.println(e.getMessage());
                System.out.println("Оставшаяся сумма: " + e.getRemainingAmount());
                try {
                    account.withDraw(e.getRemainingAmount());
                    System.out.println("Оставшаяся сумма снята. Вас счет: " + account.getAmount());
                } catch (LimitException ex){
                    System.out.println("Ошибка: " + ex.getMessage());
                }
                break;
            }
        }
    }
}