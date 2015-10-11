
public class GameView {
    
    MoveController moveController;
    
    TableauView tableauView;
    
    Menu menu;
    
    public GameView(MoveController moveController) {
        this.moveController = moveController;
        this.tableauView = new TableauView(moveController.getTableau());
    }
    
    public void play() {
        
        do {
            tableauView.show();
            // recorrer opciones de menu y display
            // leer opcion
            // ejecutar
        } while (!moveController.endOfTheGame() || !moveController.EXIT_FLAG);
        
    }

}
