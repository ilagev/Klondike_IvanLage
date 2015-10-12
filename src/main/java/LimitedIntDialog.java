
public class LimitedIntDialog {

private String title;
    
    private ClosedInterval limits;
    
    public LimitedIntDialog(String title, int min, int max){
        this.limits = new ClosedInterval(min, max);
        this.title = title + " " + limits + ": ";
    }
    
    public LimitedIntDialog(String title, int max){
        this(title, 1, max);
    }
    
    public int read(){
        int value;
        boolean ok;
        do {
            value = IO.readInt(title);
            ok = limits.includes(value);
            if (!ok) {
                IO.writeln("El valor debe estar entre " + limits);
            }
        } while (!ok);
        return value;
    }
    
}
