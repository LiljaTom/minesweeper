
package minesweeper.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import minesweeper.domain.Board;

/**
 *
 * @author lilja
 */
public class MinesweeperUi extends Application {
    
    @Override
    public void start(Stage stage) {
        
        int height = 10;
        int width = 10;
        int mines = 30;
        
        Board board = new Board(height, width, mines);
        board.buildBoard();
        
        
        GridPane gp = new GridPane();
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Button button = new Button(board.getStatus(y, x));
                
                gp.add(button, x, y);
            }
        }
        
        
        Scene scene = new Scene(gp);
        
        stage.setScene(scene);
        stage.setTitle("Minesweeper");
        stage.show();
        
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
