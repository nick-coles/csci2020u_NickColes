package sample;

import javafx.fxml.FXML;
import javafx.scene.shape.ArcType;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import java.util.Map;

public class Controller {
    @FXML public Canvas canvas;
    private DataLoader file = new DataLoader("weatherwarnings-2015.csv");
    private static Color[] pieColours = { Color.AQUA, Color.GOLD, Color.DARKORANGE, Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM};

    @FXML public void initialize(){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        file.loadFile();
        drawPie(150, 50, pieColours, gc);
    }


    public void drawPie(int x, int y, Color[] colors,GraphicsContext gc){
        int i = 0;
        int a = 50;
        double startAngle = 0;
        for(Map.Entry<String, Double> entry : file.getPercentCount().entrySet()){
            gc.setFill(colors[i]);
            i++;
            double sweepAngle = startAngle + entry.getValue() * 360;
            System.out.println("start angle = " + startAngle + "\n sweep angle = " + sweepAngle);
            gc.fillArc(x+200, y,200,200,startAngle,sweepAngle - startAngle, ArcType.ROUND);
            startAngle = sweepAngle;
            gc.fillRect(x-30, a+10, 20, 10);
            gc.setFill(Color.BLACK);
            gc.fillText(entry.getKey(),x,a+20);
            a += 30;
        }
    }
}

