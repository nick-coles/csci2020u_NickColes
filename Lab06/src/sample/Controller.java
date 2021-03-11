package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Controller {

    //For Bar Chart
    private static double[] avgHousingPricesByYear =
            { 247381.0,264171.4,287715.3,294736.1, 308431.4,322635.9,340253.0,363153.7};
    private static double[] avgCommercialPricesByYear =
            { 1121585.3,1219479.5,1246354.2,1295364.8, 1335932.6,1472362.0,1583521.9,1613246.3};

    //For Pie Chart
    private static String[] ageGroups = { "18-25", "26-35", "36-45", "46-55", "56-65", "65+"};
    private static int[] purchasesByAgeGroup = { 648, 1021, 2453, 3173, 1868, 2247};
    private static Color[] pieColours = { Color.AQUA, Color.GOLD, Color.DARKORANGE, Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM};



    @FXML
    private Canvas canvas;

    @FXML
    private void initialize() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawPieChart(gc);
        drawBarChart(100,300,avgHousingPricesByYear,Color.RED,50,gc);
        drawBarChart(100,300,avgCommercialPricesByYear,Color.BLUE,100/avgCommercialPricesByYear.length+55,gc);
    }

    private void drawBarChart(int w, int h, double[] data, Color colour,int startX,GraphicsContext gc){
        gc.setFill(colour);
        double xInc = 2*(w/data.length);

        double maxVal = 1613246.3;
        double minVal = 0;
        double x = startX;
        for(double val: data){
            double height = ((val-minVal) / (maxVal - minVal)) * h;
            gc.fillRect(x,(h-height)+150,xInc,height);
            //added "2 *" to fit another graph between the graph later
            x += 2 * xInc;
        }

    }
    private void drawPieChart(GraphicsContext gc) {
        int numOfAgeGroups = 0;
        for (int ageGroups: purchasesByAgeGroup)
            numOfAgeGroups += ageGroups;

        double startAngle = 0.0;
        for (int i = 0; i < purchasesByAgeGroup.length; i++) {
            double slicePercentage = (double) purchasesByAgeGroup[i] / (double) numOfAgeGroups;
            double sweepAngle = slicePercentage * 360.0;

            gc.setFill(pieColours[i]);
            gc.fillArc(500, 150, 300, 300, startAngle, sweepAngle, ArcType.ROUND);

            startAngle += sweepAngle;
        }
    }
}
