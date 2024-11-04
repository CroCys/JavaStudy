package Spring;

import Spring.bean.Printer;
import Spring.config.SpringAppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {
    public static void main(String[] args) {
        SpringApp app = new SpringApp();
        app.firstConfigOption();
        app.secondConfigOption();
    }

    // Конфигурация через файл applicationContext.xml
    public void firstConfigOption() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Printer printer = context.getBean("printer", Printer.class);
        printer.print("Hello World");
    }

    // Конфигурация через класс SpringAppConfig который аннотирован @Configuration и @Bean
    public void secondConfigOption() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringAppConfig.class);

        Printer printer = context.getBean("printer", Printer.class);
        printer.print("Hello World");
    }
}
