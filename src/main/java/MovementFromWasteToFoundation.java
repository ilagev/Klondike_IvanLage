
public class MovementFromWasteToFoundation extends Movement {

    public MovementFromWasteToFoundation(MoveController moveController) {
        super(moveController);
    }

    @Override
    public String name() {
        return "Mover de descarte a palo";
    }

    @Override
    public void execute() {
        LimitedIntDialog dialog = new LimitedIntDialog("Numero de palo? ", 1, Tableau.FOUNDATIONS_NUMBER);
        int foundation = dialog.read();
        if (moveController.isPossibleMoveFromWasteToFoundation(foundation)) {
            moveController.moveFromWasteToFoundation(foundation);
        } else {
            IO.writeln("[ERROR] No se puede mover al palo " + foundation);
        }
    }

}
