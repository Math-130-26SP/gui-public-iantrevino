package com.janos.gui-public-iantrevino;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private char[] equation; // store it so we can pass it

    @Override
    public void init() {
        TestProject.generateEquation();

        equation = TestProject.equation; // grab the filled array
        System.out.println(new String(equation));
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 400);

        HelloController controller = fxmlLoader.getController();
        controller.setEquation(equation);

        stage.setTitle("Nerdle by Ian Trevino");
        stage.setScene(scene);
        stage.show();
    }
}
