//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int limit = 10;
        int currentGoti = 0;

        while (limit > 0) {
            currentGoti = 1 - currentGoti;
            System.out.println("current goti is: " + currentGoti);
            limit--;
        }
    }
}