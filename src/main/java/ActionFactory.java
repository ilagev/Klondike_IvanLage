
public class ActionFactory {

    public static Movement getMovementFromDeckToWaste(MoveController moveController) {
        return new MovementFromDeckToWaste(moveController);
    }

    public static Movement getMovementFromFoundationToPile(MoveController moveController) {
        return new MovementFromFoundationToPile(moveController);
    }

    public static Movement getMovementFromPileToFoundation(MoveController moveController) {
        return new MovementFromPileToFoundation(moveController);
    }

    public static Movement getMovementFromPileToPile(MoveController moveController) {
        return new MovementFromPileToPile(moveController);
    }

    public static Movement getMovementFromWasteToDeck(MoveController moveController) {
        return new MovementFromWasteToDeck(moveController);
    }

    public static Movement getMovementFromWasteToFoundation(MoveController moveController) {
        return new MovementFromWasteToFoundation(moveController);
    }
    
    public static Movement getMovementFromWasteToPile(MoveController moveController) {
        return new MovementFromWasteToPile(moveController);
    }
    
    public static Movement getMovementDiscover(MoveController moveController) {
        return new MovementDiscover(moveController);
    }

}
