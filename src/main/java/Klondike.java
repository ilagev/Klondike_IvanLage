
public class Klondike {
    
    private Tableau tableau;
    
    private MoveController moveController;
    
    private GameView gameView;
    
    private Klondike() {
        this.tableau = new Tableau();
        this.moveController = new MoveController(tableau);
        this.gameView = new GameView(moveController);
    }
    
    public void play() {
        tableau.setup();
        gameView.play();
    }
    
    public static void main(String[] args) {
        new Klondike().play();
    }

}
