package ShoppingCartApp;/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import ShoppingCartApp.controller.ShoppingCartController;
import ShoppingCartApp.model.ShoppingItems;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {


    public static void main(String[] args) {

        App app = new App();

        ApplicationContext context = app.init();
        ShoppingCartController controller = context.getBean("controller", ShoppingCartController.class);
        controller.run();

    }

    private ApplicationContext init() {
        return new AnnotationConfigApplicationContext(AppConfig.class);
    }
}