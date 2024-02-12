import javax.swing.*;

public class ErrorHandler implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        JOptionPane.showMessageDialog(null, "Нельзя создать больше 15 шариков");
    }
}
