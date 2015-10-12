
public class MovementFromPileToFoundation extends Movement {

    public MovementFromPileToFoundation(MoveController moveController) {
        super(moveController);
    }

    @Override
    public String name() {
        return "Mover de escalera a palo";
    }

    @Override
    public void execute() {
        LimitedIntDialog dialogFoundation =
                new LimitedIntDialog("Numero de palo? ", 1, Tableau.FOUNDATIONS_NUMBER);
        LimitedIntDialog dialogPile =
                new LimitedIntDialog("Numero de escalera? ", 1, Tableau.PILES_NUMBER);
        int foundation = dialogFoundation.read();
        int pile = dialogPile.read();
        if (moveController.isPossibleMoveFromPileToFoundation(pile, foundation)) {
            moveController.moveFromPileToFoundation(pile, foundation);
        } else {
            IO.writeln("[ERROR] No se puede mover de la escalera " + pile + " a palo " + foundation);
        }
    }

}
