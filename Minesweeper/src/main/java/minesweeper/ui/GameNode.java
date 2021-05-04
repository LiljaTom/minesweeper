package minesweeper.ui;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author lilja
 */
public class GameNode {

    private StackPane stack;
    private Rectangle rect;
    private Text text;
    private String status;

    public GameNode(String status, double y, double x, double width, double height) {
        this.stack = new StackPane();
        this.stack.setTranslateY(height * y);
        this.stack.setTranslateX(width * x);

        this.rect = new Rectangle(width, height);
        this.rect.setStroke(Color.WHITE);
        this.rect.setFill(Color.GREY);

        this.status = status;
        this.text = new Text(status);
        this.text.setFont(Font.font(20));
        this.text.setVisible(false);

        stack.getChildren().addAll(rect, text);
    }

    public void open() {
        if (this.text.isVisible()) {
            return;
        }

        if (this.text.getText().equals("0")) {
            this.text.setText("");
        }

        this.text.setVisible(true);
        this.rect.setFill(Color.WHITE);
        this.rect.setStroke(Color.GREY);
    }
    
    public void setText(String text) {
        this.text.setText(text);
    }
    
    public String getText() {
        return this.text.getText();
    }
    
    public void toggleVisibility() {
        this.text.setVisible(!this.text.isVisible());
    }

    public StackPane getStack() {
        return this.stack;
    }

    public String status() {
        return this.status;
    }

}
