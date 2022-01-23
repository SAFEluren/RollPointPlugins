package safeluren.mcpl.roll.Utils;

public class Chat {

    public static String format(String text) {
        return (String) text.replaceAll("&","§");;
    }
}
