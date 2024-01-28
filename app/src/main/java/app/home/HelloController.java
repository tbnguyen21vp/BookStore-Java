package app.home;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class HelloController {


    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcomedd tosdfsdf JavaFX Application!");
        createPersion();
    }
    
    public void createPersion() {
        Persion persion = new Persion("John Doe", 30);
        persion.sayHello();
    }
}