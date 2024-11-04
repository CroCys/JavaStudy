package Spring.config;

import Spring.bean.Printer;
import Spring.bean.Toner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringAppConfig {

    @Bean
    public Toner toner() {
        return new Toner("Black", 100);
    }

    @Bean
    public Printer printer() {
        return new Printer(toner());
    }
}
