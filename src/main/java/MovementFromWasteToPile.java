
public class MovementFromWasteToPile extends Movement {

    public MovementFromWasteToPile(MoveController moveController) {
        super(moveController);
    }

    @Override
    public String name() {
        return "Mover de descarte a escalera";
    }

    @Override
    /* cuando se invoca a su execute LEE LOS PARAMETROS (actua como vista)
     * despues los datos se los pasa al controller que curra (receptor/controlador)
     * APLICABLE A TODOS LOS HIJOS DE MOVEMENT!!!
     */
    public void execute() {
        // TODO Auto-generated method stub
        
    }
    
}
