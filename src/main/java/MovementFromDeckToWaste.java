
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
        IO.write("Deck to waste: coming soon...");
        this.moveController.moveFromDeckToWaste();
        // TODO Auto-generated method stub
    }

}
