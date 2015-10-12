
public class MovementFromWasteToPile extends Movement {

    public MovementFromWasteToPile(MoveController moveController) {
        super(moveController);
    }

    @Override
    public String name() {
        return "Mover de descarte a escalera";
    }

    @Override
    public void execute() {
        LimitedIntDialog dialog = new LimitedIntDialog("Numero de escalera? ", 1, Tableau.PILES_NUMBER);
        int pile = dialog.read();
        if (moveController.isPossibleMoveFromWasteToPile(pile)) {
            moveController.moveFromWasteToPile(pile);
        } else {
            IO.writeln("[ERROR] No se puede mover a la escalera " + pile);
        }
    }
    
}
