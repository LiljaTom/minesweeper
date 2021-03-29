
package minesweeper.ui;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author lilja
 */
public class MinesweeperUi extends Application {
    
    @Override
    public void start(Stage stage) {
        
        stage.setTitle("Minesweeper");
        stage.show();
        
    }
    
    
    public static void main(String[] args) {
        launch(MinesweeperUi.class);
    }
}
