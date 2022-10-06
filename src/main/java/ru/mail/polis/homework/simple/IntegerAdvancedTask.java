package ru.mail.polis.homework.simple;


/**
 * Возможно вам понадобится класс Math с его методами. Например, чтобы вычислить квадратный корень, достаточно написать
 * Math.sqrt(1.44)
 * Чтобы увидеть все методы класса Math, достаточно написать Math. и среда вам сама покажет возможные методы.
 * Для просмотра подробной документации по выбранному методу нажмите Ctrl + q
 */
public class IntegerAdvancedTask {

    private static final double EPS = 1e-10;

    /**
     * Сумма первых n-членов геометрической прогрессии с первым элементом a и множителем r
     * a + aq + aq^2 + ... + aq^(n-1)
     * <p>
     * Пример: (1, 2, 3) -> 7
     */
    public static long progression(int a, double q, int n) {
        if (q == 0) {
            return (long) a * n;
        }

        return (long) (a * (Math.pow(q, n) - 1) / (q - 1));
    }

    /**
     * Гусеница ползает по столу квадратами по часовой стрелке. За день она двигается следующим образом:
     * сначала наверх на up, потом направо на right. Ночью она двигается вниз на down и налево на left.
     * Сколько суток понадобится гусенице, чтобы доползти до поля с травой?
     * Считаем, что на каждой клетке с координатами >= grassX или >= grassY находится трава
     * Если она этого никогда не сможет сделать, верните число Integer.MAX_VALUE;
     * Пример: (10, 3, 5, 5, 20, 11) -> 2
     */
    public static int snake(int up, int right, int down, int left, int grassX, int grassY) {
        if (up <= down && grassY > up && right <= left && grassX > right) {
            return Integer.MAX_VALUE;
        }

        int dayCounter = 0;
        int currentX = 0;
        int currentY = 0;

        while (grassX > currentX || grassY > currentY) {
            dayCounter++;
            currentX += right;
            currentY += up;

            if (grassX <= currentX || grassY <= currentY) {
                break;
            }

            currentX -= left;
            currentY -= down;
        }

        return dayCounter;
    }

    /**
     * Дано число n в 10-ном формате и номер разряда order.
     * Выведите цифру стоящую на нужном разряде для числа n в 16-ом формате
     * Нельзя пользоваться String-ами
     * Пример: (454355, 2) -> D
     */
    public static char kDecimal(int n, int order) {
        int mod;
        char digit = 0;
        int number = n;
        int orderHex = 16;
        int shiftForAscii = 32;

        for (int i = 1; i <= order; i++) {
            mod = number % orderHex;
            number = number / orderHex;

            if (mod > 9 && i == order) {
                digit = (char) (Character.forDigit(mod, orderHex) - shiftForAscii);
                continue;
            }
            digit = Character.forDigit(mod, orderHex);
        }

        return digit;
    }

    /**
     * Дано число в 10-ном формате.
     * Нужно вывести номер минимальной цифры для числа в 16-ном формате. Счет начинается справа налево,
     * выводим номер первой минимальной цифры (если их несколько)
     * Нельзя пользоваться String-ами
     * (6726455) -> 2
     */
    public static byte minNumber(long a) {
        long number = a;
        int order = 16;
        if (number < order) {
            return 1;
        }

        int mod;
        byte counter = 1;
        byte minCounter = 1;
        int minInHexNumber = (int) (number % order);
        number = number / order;

        while (number != 0) {
            counter++;
            mod = (int) (number % order);
            number = number / order;

            if (mod < minInHexNumber) {
                minCounter = counter;
                minInHexNumber = mod;
            }
        }

        return minCounter;
    }

}
