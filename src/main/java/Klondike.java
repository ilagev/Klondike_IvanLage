
public class Klondike {
    
    private StartController startController;
    
    private Tableau tableau;
    
    private GameView gameView;
    
    private Klondike() {
        this.startController = new StartController();
        this.tableau = new Tableau();
        this.gameView = new GameView();
    }
    
    public void play() {
        startController.setup();
        gameView.play();
    }
    
    public Tableau getTableau() {
        return this.tableau;
    }
    
    public static void main(String[] args) {
        new Klondike().play();
    }

}
