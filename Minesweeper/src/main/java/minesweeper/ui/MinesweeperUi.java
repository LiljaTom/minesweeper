package minesweeper.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import minesweeper.domain.GameService;

/**
 *
 * @author lilja
 */
public class MinesweeperUi extends Application {
    
    @Override
    public void start(Stage stage) {
        
        int screenWidth = 400;
        int screenHeight = 400;
        
        GameService game = new GameService("easy");
        GameBoard board = new GameBoard(game, screenHeight, screenWidth);
        
        Scene scene = new Scene(board.getBoard());
        stage.setScene(scene);

        stage.setTitle("Minesweeper");
        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
