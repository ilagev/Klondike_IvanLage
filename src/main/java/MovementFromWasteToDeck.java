
public class MovementFromWasteToDeck extends Movement {

    public MovementFromWasteToDeck(MoveController moveController) {
        super(moveController);
    }

    @Override
    public String name() {
        return "Mover de descarte a baraja";
    }

    @Override
    public void execute() {
        this.moveController.moveFromWasteToDeck();
    }

}
