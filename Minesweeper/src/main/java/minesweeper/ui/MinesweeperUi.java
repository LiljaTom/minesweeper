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

        
        //Difficulty setting components
        Button easy = new Button("Easy");
        Button medium = new Button("Medium");
        Button hard = new Button("Hard");

        GridPane difficultyPane = new GridPane();
        difficultyPane.add(easy, 0, 0);
        difficultyPane.add(medium, 0, 1);
        difficultyPane.add(hard, 0, 2);

        Scene difficultyScene = new Scene(difficultyPane);
        stage.setScene(difficultyScene);
        
        //Different games
        GridPane easyGrid = buildGame("easy");
        Scene easyScene = new Scene(easyGrid);
        
        GridPane mediumGrid = buildGame("medium");
        Scene mediumScene = new Scene(mediumGrid);
        
        GridPane hardGrid = buildGame("hard");
        Scene hardScene = new Scene(hardGrid);

        //Difficultybutton actions
        easy.setOnAction((event) -> {
            stage.setScene(easyScene);
        });

        medium.setOnAction((event) -> {
            stage.setScene(mediumScene);
        });

        hard.setOnAction((event) -> {
            stage.setScene(hardScene);
        });



        stage.setTitle("Minesweeper");
        stage.show();

    }

    public GridPane buildGame(String difficulty) {

        GameService game = new GameService(difficulty);
        game.startGame();

        Font font = Font.font("Monospaced", 15);
        GridPane grid = new GridPane();
        for (int y = 0; y < game.getHeight(); y++) {
            for (int x = 0; x < game.getWidth(); x++) {
                Button button = new Button(" ");
                button.setFont(font);
                grid.add(button, x, y);

                int ry = y;
                int rx = x;

                button.setOnAction((event) -> {
                    button.setText(game.getStatus(ry, rx));
                });
            }
        }

        return grid;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
