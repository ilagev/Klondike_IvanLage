
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
        // TODO Auto-generated method stub
        IO.write("Waste to pile: coming soon...");
        moveController.moveFromWasteToFoundation();
    }
    
}
