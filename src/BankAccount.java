public class BankAccount {
    private double amount;  // Остаток на счете

    // Конструктор для создания счета с начальным балансом
    public BankAccount(double initialAmount) {
        this.amount = initialAmount;
    }

    // Метод для получения текущего остатка на счете
    public double getAmount() {
        return amount;
    }

    // Метод для пополнения счета
    public void deposit(double sum) {
        if (sum > 0) {
            amount += sum;
        }
    }

    // Метод для снятия суммы с счета
    public void withDraw(double sum) throws LimitException {
        if (sum > amount) {
            throw new LimitException("Недостаточно средств на счете!", amount);
        } else {
            amount -= sum;
        }
    }
}