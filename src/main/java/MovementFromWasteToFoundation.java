
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
        // TODO Auto-generated method stub
        IO.write("Waste to foundation: coming soon...");
        moveController.moveFromWasteToFoundation();
    }

}
