
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IO {
    
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
            System.in));
    
    public static String readString(String title) {
        String input = null;
        boolean ok = false;
        do {
            write(title);
            try {
                input = bufferedReader.readLine();
                ok = true;
            } catch (Exception ex) {
                writeError("de cadena de caracteres");
            }
        } while (!ok);
        return input;
    }
    
    public static int readInt(String title) {
        int input = 0;
        boolean ok = false;
        do {
            try {
                input = Integer.parseInt(readString(title));
                ok = true;
            } catch (Exception ex) {
                writeError("entero");
            }
        } while (!ok);
        return input;
    }
    
    public static void write(String string) {
        System.out.print(string);
    }
    
    public static void writeln(String string) {
        System.out.println(string);
    }
    
    private static void writeError(String formato) {
        System.out.println("ERROR DE FORMATO! "
                + "Introduzca un valor con formato " + formato + ".");
    }

}
