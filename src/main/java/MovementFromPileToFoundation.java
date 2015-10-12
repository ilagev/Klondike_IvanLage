
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
        // TODO Auto-generated method stub
        IO.write("Pile to foundation: coming soon...");
        moveController.moveFromPileToFoundation();
    }

}
