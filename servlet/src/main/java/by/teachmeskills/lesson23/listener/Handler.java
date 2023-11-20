package by.teachmeskills.lesson23.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDate;
import java.time.LocalTime;

@WebListener
public class Handler implements ServletRequestListener
{
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        ServletRequestListener.super.requestDestroyed(sre);
    }
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ServletRequestListener.super.requestInitialized(sre);
        System.out.println("Data: " + LocalDate.now());
        System.out.println("Time: " + LocalTime.ofSecondOfDay(10000));
    }
}
