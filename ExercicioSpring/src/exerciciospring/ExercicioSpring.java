package exerciciospring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExercicioSpring {
    
    private static ApplicationContext context;

    public static void main(String[] args) {
	context = new ClassPathXmlApplicationContext("/applicationContext.xml");
	
	Carro carro = (Carro) context.getBean("carro20");
	carro.imprimirCarro();
	carro = (Carro) context.getBean("carro10");
	carro.imprimirCarro();
    }
    
    
}
