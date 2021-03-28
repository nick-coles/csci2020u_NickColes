package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.*;

public class Controller {
    private ArrayList<String> date = new ArrayList<>();
    private ArrayList<String> open = new ArrayList<>();
    private ArrayList<String> high = new ArrayList<>();
    private ArrayList<String> low = new ArrayList<>();
    private ArrayList<String> close = new ArrayList<>();
    private ArrayList<String> adjClose = new ArrayList<>();
    private ArrayList<String> volume = new ArrayList<>();

    @FXML
    private Canvas canvas;

    @FXML
    private void initialize() throws IOException {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawLinePlot(gc);
    }

    public void readData(String sURL) throws IOException {
        URL netURL = new URL(sURL);

        URLConnection conn = netURL.openConnection();
        conn.setDoOutput(false);
        conn.setDoInput(true);

        InputStream inStream = conn.getInputStream();
        Scanner s = new Scanner(inStream);
        while (s.hasNextLine()) {
            StringTokenizer info = new StringTokenizer(s.nextLine(), ",");
            while (info.hasMoreElements()) {
                date.add(info.nextToken());
                open.add(info.nextToken());
                high.add(info.nextToken());
                low.add(info.nextToken());
                close.add(info.nextToken());
                adjClose.add(info.nextToken());
                volume.add(info.nextToken());
            }
        }
    }

    public void drawLinePlot(GraphicsContext gc) throws IOException {
        gc.strokeLine(50,50,50,850);
        gc.strokeLine(50,850,950,850);
        readData("https://query1.finance.yahoo.com/v7/finance/download/AAPL?period1=1262322000&period2=1451538000&interval=1mo&events=history&includeAdjustedClose=true");
        plotLine(gc,close,Color.BLUE,40,850);
        close.clear();
        readData("https://query1.finance.yahoo.com/v7/finance/download/GOOG?period1=1262322000&period2=1451538000&interval=1mo&events=history&includeAdjustedClose=true");
        plotLine(gc,close,Color.RED,40,850);
    }

    public void plotLine(GraphicsContext gc, ArrayList<String> data, Color colour, int startX, int startY){
        gc.setFill(colour);
        double x = startX;
        double y = startY;
        for(int i = 1; i < data.size()-1; i++){
            //double val: data
            System.out.println(data.get(i));
            gc.setStroke(colour);
            gc.strokeLine(x+(i*10),y - Double.parseDouble(data.get(i)),x+((i+1)*10),y - Double.parseDouble(data.get(i+1)));

        }
    }
}