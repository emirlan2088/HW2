public class LimitException extends Exception{
    private double remainingAmount;

    // Конструктор
    public LimitException(String message, double remainingAmount) {
        super(message);
        this.remainingAmount = remainingAmount;
    }

    // Метод для получения оставшейся суммы
    public double getRemainingAmount() {
        return remainingAmount;
    }
}

