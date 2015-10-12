
public class GameView {
    
    MoveController moveController;

    TableauView tableauView;

    Menu menu;
    
    private static final int EXIT_OPTION = 9;  

    public GameView(MoveController moveController) {
        this.moveController = moveController;
        this.tableauView = new TableauView(moveController.getTableau());
        this.menu = new Menu();
        this.setupMenu();
    }

    private void setupMenu() {
        menu.add(ActionFactory.getMovementFromDeckToWaste(moveController));
        menu.add(ActionFactory.getMovementFromFoundationToPile(moveController));
        menu.add(ActionFactory.getMovementFromPileToFoundation(moveController));
        menu.add(ActionFactory.getMovementFromPileToPile(moveController));
        menu.add(ActionFactory.getMovementFromWasteToDeck(moveController));
        menu.add(ActionFactory.getMovementFromWasteToFoundation(moveController));
        menu.add(ActionFactory.getMovementFromWasteToPile(moveController));
        menu.add(ActionFactory.getMovementDiscover(moveController));
    }

    public void play() {
        String[] keys;
        int option = -1;
        LimitedIntDialog optionDialog = new LimitedIntDialog("Opcion: ", 1, 9);

        do {
            tableauView.show();
            
            keys = this.menu.keys();
            this.showMenu(keys);
            option = optionDialog.read();
            
            if (option == EXIT_OPTION) {
                MoveController.EXIT_FLAG = true;
                IO.write("Thanks for playing!!");
            } else {
                menu.execute(keys[option - 1]); // index 0..N-1 vs 1..N
            }
        } while (!moveController.endOfTheGame() && !MoveController.EXIT_FLAG);
    }
    
    private void showMenu(String[] keys) {
        int optionNumber = 1;
        for (String key : keys) {
            IO.writeln("[" + optionNumber + ".]" + key);
            optionNumber++;
        }
        IO.writeln("[" + optionNumber + ".] Salir");
    }

}
