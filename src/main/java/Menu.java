
import java.util.HashMap;
import java.util.Map;

public class Menu {

    private Map<String, Action> options;

    public Menu() {
        this.options = new HashMap<>();
    }

    public void add(Action action) {
        this.options.put(action.name(), action);
    }

    public void execute(String key) {
        this.options.get(key).execute();
    }

    public String[] keys() {
        return this.options.keySet().toArray(new String[0]);
    }

}
