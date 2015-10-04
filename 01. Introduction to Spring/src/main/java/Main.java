import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
        Performer performer = (Performer) ctx.getBean("vasya");
        performer.perform();

        Performer performer1 = (Performer) ctx.getBean("petr");
        performer1.perform();

        Stage stage = (Stage) ctx.getBean("stage");
        System.out.println(stage.location);
    }

}
