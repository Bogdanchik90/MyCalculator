import java.util.Scanner;

//Calculator
public class Main {

    public static int transformation(String str){
        int number = 0;

        switch (str){
            case "I":
                number = 1;
                break;
            case "II":
                number = 2;
                break;
            case "III":
                number = 3;
                break;
            case "IV":
                number = 4;
                break;
            case "V":
                number = 5;
                break;
            case "VI":
                number = 6;
                break;
            case "VII":
                number = 7;
                break;
            case "VIII":
                number = 8;
                break;
            case "IX":
                number = 9;
                break;
            case "X":
                number = 10;
                break;
        }
        return number;
    }

    public static String getRoman(int number) {

        String roman[] = {"M", "XM", "CM", "D", "XD", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int arab[] = {1000, 990, 900, 500, 490, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (number > 0 || arab.length == (i - 1)) {
            while ((number - arab[i]) >= 0) {
                number -= arab[i];
                result.append(roman[i]);
            }
            i++;
        }
        return result.toString();
    }


    public static String calc(String str) {
        boolean on = true;
        boolean roman = false;
        boolean check = false;
        int result = 0, value1 = 0, value2 = 0;
        String val1 = "", val2 = "", res = "";

        String[] strs = str.split(" ");

        try {
            if (strs.length != 3)
                throw new Exception();
        } catch (Exception e){
            System.out.println("строка не соответствует правилам А + В");
            on = false;
        }


        try {

            value1 = Integer.parseInt(strs[0]);
        } catch (Exception e) {
            check = true;
        }

        try {
            value2 = Integer.parseInt(strs[2]);
        } catch (Exception e){
            check = true;
        }

        if (check) {
            try {
                val1 = strs[0];
                val2 = strs[2];
                if (value1 != 0 || value2 != 0)
                    System.out.println("Системы счисления должна быть одна");
            } catch (Exception e) {
            }
            roman = true;
            value1 = transformation(val1);
            value2 = transformation(val2);
        }



        if (value1 < 1 || value1 > 10 || value2 < 1 || value2 > 10) {
            on = false;
        }


        if (on) {
            switch (strs[1]) {
                case ("+"):
                    result = value1 + value2;
                    break;
                case ("-"):
                    result = value1 - value2;
                    break;
                case ("*"):
                    result = value1 * value2;
                    break;
                case ("/"):
                    result = value1 / value2;
                    break;
            }
            if (roman){
                if (result <= 0)
                    System.out.println("В римской системе счисления нет отрицательных чисел");
                res = getRoman(result);
            } else
                res = Integer.toString(result);
        }
        else
            res = "что то пошло не так";

        return res;
    }
    public static void main(String[] args) {

        System.out.print("Введите выражение: ");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(calc(str));
    }
}