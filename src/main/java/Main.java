import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configuration.AppConfig;
import beans.Game;


public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// bean name, 'baseballGame' comes from the component class name
		Game game = context.getBean("baseballGame", Game.class);
		System.out.println(game.playGame());
		
		System.out.println(context.getBeanDefinitionCount());
		for(String beanName: context.getBeanDefinitionNames())
			System.out.println(beanName);
	}

}
