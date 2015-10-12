
public class MovementDiscover extends Movement {

    public MovementDiscover(MoveController moveController) {
        super(moveController);
    }

    @Override
    public String name() {
        return "Voltear una carta";
    }

    @Override
    public void execute() {
        LimitedIntDialog dialog =
                new LimitedIntDialog("De que escalera? ", 1, Tableau.PILES_NUMBER);
        int pile = dialog.read();
        if (moveController.isPossibleMoveDiscover(pile)) {
            moveController.moveDiscover(pile);
        } else {
            IO.writeln("[ERROR] La primera carta de la escalera " + pile + " ya esta destapada");
        }
    }

}
