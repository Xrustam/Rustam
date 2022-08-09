package xrustglazov;

import java.util.InputMismatchException;
import java.util.Scanner;

class calcrustam {


    public static class StringCalc {
        static Scanner scanner = new Scanner(System.in);
        static int number1, number2;
        static char operation;
        static int result;

        public static void main (String[] args) {
            // Вводим запрос на консоль
            System.out.println("Enter the expression using the arithmetic operator two Arabic numbers from 1 to 10 or two Roman numbers from I to X + Enter ");
//      Считываем строку userInput которую ввёл пользователь
            String userInput = scanner.nextLine();
//      Создаём пустой символьный массив длиной 10 символов:  under_char
            char[] under_char = new char[10];
//      Заполняем символьный массив символами строки которую ввел пользователь и по ходу ловим знак операции
            for (int i = 0; i < userInput.length(); i++) {
                under_char[i] = userInput.charAt(i);
                if (under_char[i] == '+') {
                    operation = '+';
                }
                if (under_char[i] == '-') {
                    operation = '-';
                }
                if (under_char[i] == '*') {
                    operation = '*';
                }
                if (under_char[i] == '/') {
                    operation = '/';
                }
            }
            String under_charString = String.valueOf(under_char);// преобразование в нужный тип данных
            String[] blacks = under_charString.split("[+-/*]");//разделяет строки на подстроки при действиях.
            String stable00 = blacks[0];//
            String stable01 = blacks[1];
            String string03 = stable01.trim();
            number1 = romanToNumber(stable00);
            number2 = romanToNumber(string03);
            // прописываем условие арифметических действий для римских чисел
            if ((number1 < 0) && (number2 < 0)) {
                result = 0;
            } else {
                result = calculated(number1, number2, operation);
                System.out.println("---Result for Roman numerals----");
                String resultRoman = convertNumToRoman(result);
                System.out.println(stable00 + " " + operation + " " + string03 + " = " + resultRoman);
            }
            // прописываем условие арифметических действий для арабских чисел
            number1 = Integer.parseInt(stable00);
            number2 = Integer.parseInt(string03);
            result = calculated(number1, number2, operation);
            System.out.println("Result for Arabic numerals");
            System.out.println(number1 + " " + operation + " " + number2 + " = " + result);
        }

        private static String convertNumToRoman (int numArabian) {
            String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                    "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                    "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                    "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                    "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                    "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                    "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
            };
            return roman[numArabian];
        }

        // приравнивание римских чисел к массиву roman
        private static int romanToNumber (String roman) {
            try {
                switch (roman) {
                    case "I":
                        return 1;
                    case "II":
                        return 2;
                    case "III":
                        return 3;
                    case "IV":
                        return 4;
                    case "V":
                        return 5;
                    case "VI":
                        return 6;
                    case "VII":
                        return 7;
                    case "VIII":
                        return 8;
                    case "IX":
                        return 9;
                    case "X":
                        return 10;
                }
            } catch (InputMismatchException e) {
                throw new InputMismatchException("Неверный формат данных");
            }
            return -1;
        }

        public static int calculated (int num1, int num2, char op) {
            int result = 0;
            switch (op) { // условия для арифметических операций
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    try {
                        result = num1 / num2;
                    } catch (ArithmeticException | InputMismatchException e) {
                        System.out.println("throws Exception" + e);
                        System.out.println("Only integer non-zero parameters allowed");

                        break;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Не верный знак операции");
            }
            return result;
        }
    }
}