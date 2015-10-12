
public class MovementFromFoundationToPile extends Movement {

    public MovementFromFoundationToPile(MoveController moveController) {
        super(moveController);
    }

    @Override
    public String name() {
        return "Mover de palo a escalera";
    }

    @Override
    public void execute() {
        LimitedIntDialog dialogFoundation =
                new LimitedIntDialog("Numero de palo? ", 1, Tableau.FOUNDATIONS_NUMBER);
        LimitedIntDialog dialogPile =
                new LimitedIntDialog("Numero de escalera? ", 1, Tableau.PILES_NUMBER);
        int foundation = dialogFoundation.read();
        int pile = dialogPile.read();
        if (moveController.isPossibleMoveFromFoundationToPile(foundation, pile)) {
            moveController.moveFromFoundationToPile(foundation, pile);
        } else {
            IO.writeln("[ERROR] No se puede mover del palo " + foundation + " a escalera " + pile);
        }
    }

}
