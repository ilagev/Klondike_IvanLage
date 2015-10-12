
import cards.Value;

public class MovementFromPileToPile extends Movement{

    public MovementFromPileToPile(MoveController moveController) {
        super(moveController);
    }

    @Override
    public String name() {
        return "Mover de escalera a escalera";
    }

    @Override
    public void execute() {
        LimitedIntDialog dialogFrom =
                new LimitedIntDialog("Numero de escalera origen? ", 1, Tableau.PILES_NUMBER);
        LimitedIntDialog dialogTo =
                new LimitedIntDialog("Numero de escalera destino? ", 1, Tableau.PILES_NUMBER);
        LimitedIntDialog dialogHowManyCards =
                new LimitedIntDialog("Cuantas cartas? ", 1, Value.values().length);
        int pileFrom = dialogFrom.read();
        int pileTo = dialogTo.read();
        int cards = dialogHowManyCards.read();
        if (moveController.isPossibleMoveFromPileToPile(pileFrom, pileTo, cards)) {
            moveController.moveFromPileToPile(pileFrom, pileTo, cards);
        } else {
            IO.writeln("[ERROR] No se pueden mover " + cards + " cartas de la escalera "
                        + pileFrom + " a escalera " + pileTo);
        }
    }

}
