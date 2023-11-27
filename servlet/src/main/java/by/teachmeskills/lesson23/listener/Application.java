package by.teachmeskills.lesson23.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Application implements ServletContextListener
{
    /**
     * Написать приложение, которое при запуске будет сообщать в консоль что оно
     * работает. На любой запрос в консоли должна отображаться запись со временем этого
     * запроса.
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce);
        System.out.println("Running");
    }
}
