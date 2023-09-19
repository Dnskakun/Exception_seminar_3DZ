public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException() {
        super("На вход метода должен подаваться массив размером 4х4.");
    }
}