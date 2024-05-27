package GUIProject.hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class PainterController {
    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton Pen;

    @FXML
    private RadioButton Delete;

    @FXML
    private ToggleGroup drawTools;


    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Rectangle clipArea = new Rectangle(0, 0, drawingAreaPane.getWidth(), drawingAreaPane.getHeight());
        drawingAreaPane.setClip(clipArea);
        if (Pen.isSelected() || Delete.isSelected()) {
            Color inkColor;
            if (Pen.isSelected()) {
                inkColor = Color.BLACK;
            } else {
                inkColor = Color.WHITE;
            }
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, inkColor);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }
}