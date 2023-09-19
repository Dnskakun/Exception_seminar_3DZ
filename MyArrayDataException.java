public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(int i, int j) {
        super("\nВ ячейке массива с индексом [" + i + "][" + j + "] находится не целое число!" +
        "\nДанная ячейка не учитывается в общей сумме элементов массива!");
    }
}
