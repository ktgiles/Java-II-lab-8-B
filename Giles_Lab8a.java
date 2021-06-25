/*Kaitlin Giles, Lab 8 A, 04/21/21
Create color field with GUI
 */

package sample;

import javafx.application.Application;
import javafx.scene.control.ScrollBar;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Giles_Lab8a extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //create gridpane
        GridPane grid = new GridPane();
        grid.setMinSize(400, 400);

        //create rectangle that will display color
        final Rectangle rectangle = new Rectangle();
        rectangle.setX(100);
        rectangle.setY(100);
        rectangle.setWidth(200);
        rectangle.setHeight(200);
        grid.add(rectangle, 0, 0);

        //create red scrollbar
        final ScrollBar red = new ScrollBar();
        red.setMin(0);
        red.setMax(255);
        final int [] redInt = {0};
        red.setValue(redInt[0]);
        grid.add(red,0,2);
        Text t1 = new Text();
        t1.setText("Adjust Red");
        grid.add(t1,0,1);

        //display red scrollbar value
        final double redVal = red.getValue();
        Text t5 = new Text();
        t5.setText(String.valueOf(redVal));
        grid.add(t5,1,2);

        sbLabel(t5, red); //apply method to update scrollbar value when changed

        //create green scrollbar
        final ScrollBar green = new ScrollBar();
        green.setMin(0);
        green.setMax(255);
        final int [] greenInt = {0};
        green.setValue(greenInt[0]);
        grid.add(green, 0, 4);
        Text t2 = new Text();
        t2.setText("Adjust Green");
        grid.add(t2,0,3);

        //display green scrollbar value
        final double greenVal = green.getValue();
        Text t6 = new Text();
        t6.setText(String.valueOf(greenVal));
        grid.add(t6, 1,4);

        sbLabel(t6, green); //apply method to update scrollbar value when changed

        //create blue scrollbar
        final ScrollBar blue = new ScrollBar();
        blue.setMin(0);
        blue.setMax(255);
        final int [] blueInt = {0};
        blue.setValue(blueInt[0]);
        grid.add(blue, 0, 6);
        Text t3 = new Text();
        t3.setText("Adjust Blue");
        grid.add(t3, 0, 5);

        //display blue scrollbar value
        final double blueVal = blue.getValue();
        Text t7 = new Text();
        t7.setText(String.valueOf(blueVal));
        grid.add(t7, 1, 6);

        sbLabel(t7, blue); //apply method to update scrollbar value when changed

        //create opacity scrollbar
        final ScrollBar op = new ScrollBar();
        op.setMin(0);
        op.setMax(1);
        final double [] opDouble = {0};
        op.setValue(opDouble[0]);
        grid.add(op, 0, 8);
        Text t4 = new Text();
        t4.setText("Adjust Opacity");
        grid.add(t4, 0,7);

        //display opacity scrollbar value
        final double opVal = op.getValue();
        Text t8 = new Text();
        t8.setText(String.valueOf(opVal));
        grid.add(t8, 1, 8);

        sbLabel(t8, op); //apply method to update scrollbar value when changed

        //call listener methods for each scrollbar; update rectangle color as scrollbar values are changed
        listenRed(rectangle, red, redInt, blueInt, greenInt, opDouble);
        listenBlue(rectangle, blue, redInt, blueInt, greenInt, opDouble);
        listenGreen(rectangle, green, redInt, blueInt, greenInt, opDouble);
        listenOp(rectangle, op, redInt, blueInt, greenInt, opDouble);

        //create scene, place grid in scene, place scene in stage, show
        Scene scene = new Scene(grid);
        primaryStage.setTitle("Colorful Box");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //listen for changes to red scrollbar value, update fill color
    private void listenRed(Rectangle rectangle, ScrollBar red, int[] redInt, int[] blueInt, int[]greenInt, double[]opDouble) {
        red.valueProperty().addListener((observable, oldValue, newValue) -> {
            redInt[0] = (int) red.getValue();
            rectangle.setFill(Color.rgb(redInt[0], greenInt[0], blueInt[0], opDouble[0]));
        });
    }
    //listen for changes to blue scrollbar value, update fill color
    private void listenBlue(Rectangle rectangle, ScrollBar blue, int[] redInt, int[] blueInt, int[]greenInt, double[]opDouble) {
        blue.valueProperty().addListener((observable, oldValue, newValue) -> {
            blueInt[0] = (int) blue.getValue();
            rectangle.setFill(Color.rgb(redInt[0], greenInt[0], blueInt[0], opDouble[0]));
        });
    }
    //listen for changes to green scrollbar value, update fill color
    private void listenGreen(Rectangle rectangle, ScrollBar green, int[] redInt, int[] blueInt, int[]greenInt, double[]opDouble) {
        green.valueProperty().addListener((observable, oldValue, newValue) -> {
            greenInt[0] = (int) green.getValue();
            rectangle.setFill(Color.rgb(redInt[0], greenInt[0], blueInt[0], opDouble[0]));
        });
    }
    //listen for changes to opacity scrollbar value, update fill color
    private void listenOp(Rectangle rectangle, ScrollBar op, int[] redInt, int[] blueInt, int[]greenInt, double[]opDouble) {
        op.valueProperty().addListener((observable, oldValue, newValue) -> {
            opDouble[0] = op.getValue();
            rectangle.setFill(Color.rgb(redInt[0], greenInt[0], blueInt[0], opDouble[0]));
        });
    }

    //Update text field showing current value of scrollbar
    private void sbLabel(Text text, ScrollBar color) {
        color.valueProperty().addListener((obs) -> {
                String sColor = String.valueOf(color.getValue());
                text.setText(sColor);
        });
    }

    //launch method
    public static void main(String[] args) {
        launch(args);
    }
}
