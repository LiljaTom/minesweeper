
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
        
        String difficulty = "hard";
        
        Font font = Font.font("Monospaced", 15);
        
        GameService game = new GameService(difficulty);
        game.startGame();
        
        GridPane gp = new GridPane();
        
        for(int y = 0; y < game.getHeight(); y++) {
            for(int x = 0; x < game.getWidth(); x++) {
                Button button = new Button(" ");
                button.setFont(font);
                gp.add(button, x, y);
                
                int ry = y;
                int rx = x;
                
                
                button.setOnAction((event) -> {
                    button.setText(game.getStatus(ry, rx));
                });
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
