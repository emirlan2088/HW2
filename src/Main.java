public class Main {
    public static void main(String[] args) throws LimitException {
        // Создаем счет с начальной суммой 15 000 сом
        BankAccount account = new BankAccount(15000);

        // Попытка снять деньги в бесконечном цикле
        while (true) {
            try {
                account.withDraw(6000);  // Пытаемся снять 6000 сом
                System.out.println("Снято 6000 сом. Остаток на счете: " + account.getAmount());
            } catch (LimitException e) {
                // Если средств на счете недостаточно, снимаем оставшуюся сумму
                System.out.println("Недостаточно средств. Снимаем оставшиеся " + e.getRemainingAmount() + " сом.");
                account.withDraw(e.getRemainingAmount());  // Снимаем оставшиеся деньги
                System.out.println("Оставшийся остаток на счете: " + account.getAmount());
                break;  // Завершаем цикл
            }
        }
    }
}