package coordinate;

import java.util.Scanner;

public class Input {
    public void inputCoordinate() throws IllegalArgumentException{
        System.out.println("좌표를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        validInput(line);
    }

    private void validInput(String line) {
        InputConverter inputConverter = new InputConverter(line);
        inputConverter.something();
    }
}
