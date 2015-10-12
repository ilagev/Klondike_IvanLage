
public class MovementFromDeckToWaste extends Movement {

    public MovementFromDeckToWaste(MoveController moveController) {
        super(moveController);
    }

    @Override
    public String name() {
        return "Mover de baraja a descarte";
    }

    @Override
    public void execute() {
        this.moveController.moveFromDeckToWaste();
    }

}
