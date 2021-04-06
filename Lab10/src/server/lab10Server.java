package server;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class lab10Server extends Application {
    static TextArea textBox;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("SimpleBBS Server v1.0");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(40, 40, 40, 40));

        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);

        textBox = new TextArea();
        grid.add(textBox, 0, 0, 1, 2);

        Button exitButton = new Button("Exit");
        grid.add(exitButton, 0, 2);
        exitButton.setOnAction(event -> {
            System.exit(0);
        });
        primaryStage.show();

        server server = new server(2525);
        Thread serverThread = new Thread(server);
        serverThread.start();
    }

    public static void displayMessage(String message){
        textBox.appendText(message);
    }

    public static void main(String[] args) {
        launch(args);
    }
}


