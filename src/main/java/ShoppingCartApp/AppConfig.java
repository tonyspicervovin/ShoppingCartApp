package ShoppingCartApp;


import ShoppingCartApp.controller.ShoppingCartController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackageClasses = ShoppingCartController.class)
public class AppConfig {

}
