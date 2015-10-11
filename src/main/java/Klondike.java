
public class Klondike {
    
    private Tableau tableau;
    
    private GameView gameView;
    
    private Klondike() {
        this.tableau = new Tableau();
        this.gameView = new GameView();
    }
    
    public void play() {
        tableau.setup();
        gameView.play();
    }
    
    public Tableau getTableau() {
        return this.tableau;
    }
    
    public static void main(String[] args) {
        new Klondike().play();
    }

}
