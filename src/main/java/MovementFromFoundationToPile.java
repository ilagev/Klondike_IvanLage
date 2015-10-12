
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
        // TODO Auto-generated method stub
        IO.write("Foundation to pile: coming soon...");
        moveController.moveFromFoundationToPile();
    }

}
