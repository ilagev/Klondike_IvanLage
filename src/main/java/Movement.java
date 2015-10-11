
public abstract class Movement implements Action {

    MoveController moveController;

    public Movement(MoveController moveController) {
        this.moveController = moveController;
    }

}
