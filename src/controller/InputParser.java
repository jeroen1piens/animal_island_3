package controller;

public class InputParser {
    public static int parseInt(String input) {
        try {
            int number = Integer.parseInt(input);
            return number;
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }
}
