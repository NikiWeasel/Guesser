import java.util.Random;
import java.util.Scanner;

/**
 * Тут, короче, наскоряк накиданная клёвая игра в угадайку.
 * Оно число загадывает, а пользователь потом угадывает.
 * Есть подсказки, насколько далеко.
 * todo: DRY, KISS, SOLID (точно можно на ООП-шить), и опечатки по мелочи
 */
public class Guessing {

    public static int randomiser(int r1, int r2){
        return new Random().nextInt(r1, r2) + 1;
    }

    public static String getValidationMessage(int number, int rand){
        if (number < 1 || number > 10) {return ("Читать не умеешь?");}

        if (Math.abs(number - rand) > 5) {
            return ("Холодно");
        } else if (Math.abs(number - rand) > 2) {
            return ("Тепло");
        } else {
            return ("Жгётся!");
        }
    }

    public static void getAnswer(int rand){
        while (true) {
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();
            if (number == rand) {
                break;
            }
            else {
                System.out.println(getValidationMessage(number, rand));
            }
        }
    }

    public static boolean dialog(int rand){
        System.out.println("╰(▔∀▔)╯\nБудешь угадывать? (да/нет)");
        Scanner sc1 = new Scanner(System.in);
        String response = sc1.nextLine();
        switch (response) {
            case "нет": {
                System.out.println("(¬_¬ )");
                return false;
            }
            case "да": {
                while (true) {
                    System.out.println("(⌒‿⌒)\nугадай число от 1 до 10");
                    getAnswer(rand);
                    return true;
                }
            }
            default: {
                System.out.println("(︶︹︺)\n непонятно, давай до свидания");
                return false;
            }
        }
    }
    public static void main(String[] args) {

        System.out.println("Привет!");
        try {
            while (true){
                if (!dialog(randomiser(0, 10))){
                    break;
                }
            }
        }
        catch (Exception exception){
            System.out.println("Было введено что-то не то! "+exception);
        }

    }

}