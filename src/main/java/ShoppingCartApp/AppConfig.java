package ShoppingCartApp;


import ShoppingCartApp.controller.ShoppingCartController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackageClasses = ShoppingCartApp.controller.ShoppingCartController.class)
public class AppConfig {

}
