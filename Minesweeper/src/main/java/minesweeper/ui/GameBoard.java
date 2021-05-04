package minesweeper.ui;

import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import minesweeper.domain.GameService;
import minesweeper.domain.Node;

/**
 *
 * @author lilja
 */
public class GameBoard {

    private Pane board;
    private GameService game;
    private GameNode[][] nodes;

    public GameBoard(GameService game, int height, int width) {
        this.board = new Pane();
        this.nodes = new GameNode[height][width];
        this.game = game;

        double nodeWidth = width / game.getWidth();
        double nodeHeight = height / game.getHeight();

        for (int y = 0; y < game.getHeight(); y++) {
            for (int x = 0; x < game.getWidth(); x++) {
                GameNode node = new GameNode(game.getStatus(y, x), y, x, nodeHeight, nodeWidth);
                nodes[y][x] = node;

                int ry = y;
                int rx = x;

                node.getStack().setOnMouseClicked(event -> {
                    if(event.getButton() == MouseButton.PRIMARY) {
                        leftClick(ry, rx);
                    } else if(event.getButton() == MouseButton.SECONDARY) {
                        rightClick(ry, rx);
                    }
                });

                board.getChildren().add(node.getStack());
            }
        }

    }
    
    public void rightClick(int y, int x) {
        if(this.nodes[y][x].getText().equals("F")) {
            this.nodes[y][x].setText("?");
        } else if(this.nodes[y][x].getText().equals("?")) {
            this.nodes[y][x].toggleVisibility();
            this.nodes[y][x].setText(this.game.getStatus(y, x));
        } else {
            this.nodes[y][x].toggleVisibility();
            this.nodes[y][x].setText("F");
        }
    }

    public void leftClick(int y, int x) {

        if (nodes[y][x].status().equals("0")) {
            for (Node node : game.adjacentEmpties(y, x)) {
                nodes[node.getY()][node.getX()].open();
            }
        }

        nodes[y][x].open();
    }

    public Pane getBoard() {
        return board;
    }

}
