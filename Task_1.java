/*
 * 1. Напишите метод, на вход которого подаётся двумерный строковый массив
 * размером 4х4. При подаче массива другого размера необходимо бросить
 * исключение MyArraySizeException.
 * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в
 * int и просуммировать. Если в каком-то элементе массива преобразование
 * не удалось (например, в ячейке лежит символ или текст вместо числа),
 * должно быть брошено исключение MyArrayDataException с детализацией, в
 * какой именно ячейке лежат неверные данные.
 * 3. В методе main() вызвать полученный метод, обработать возможные
 * исключения MyArraySizeException и MyArrayDataException и вывести
 * результат расчета (сумму элементов, при условии что подали на вход
 * корректный массив)
 */

public class Task_1 {
    public static void main(String[] args) {
        String[][] array = {{"4", "3d", "6", "7"}, {"2", "5", "1", "9"},
                            {"12", "24s", "21", "16"}, {"11", "14", "13", "19"}};
        ArraySum(array);
    }

    public static void ArraySum(String[][] array) {
        System.out.println(array.length);
        System.out.println(array[0].length);
        if (array.length != array[0].length || array.length != 4) {
            throw new MyArraySizeException();
        }
        int sum = 0;
        int countErrors = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (isNumber(array[i][j])) {
                    sum += Integer.parseInt(array[i][j]);
                } else {
                    countErrors += 1;
                    try {
                        throw new MyArrayDataException(i, j);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (countErrors > 0) {
            System.out.println("Не удалось преобразовать в целое число " + countErrors +
            " элемент (-a, -ов) массива.");
            System.out.println("Сумма оставшихся целочисленных элементов массива равна: " + sum + ".");
        } else {
            System.out.println("Сумма всех элементов массива равна: " + sum + ".");
        }
    }
    
    public static boolean isNumber(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}