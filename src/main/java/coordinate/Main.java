package coordinate;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();

        while (true) {
            try {
                input.inputCoordinate();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
    }
}
