import java.util.Random;
import java.util.Scanner;

/**
 * Тут, короче, наскоряк накиданная клёвая игра в угадайку.
 * Оно число загадывает, а пользователь потом угадывает.
 * Есть подсказки, на сколько далеко.
 * todo: DRY, KISS, SOLID (точно можно на ООП-шить), и опечатки по мелочи
 */
public class Guessing {

    public static void main(String[] args) {
        System.out.println("Привет!\nБудешь угадывать? (да/нет)");
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        if (answer.equals("нет")) {
            System.out.println("(×﹏×)");
            return;
        } else if (!answer.equals("да")) {
            System.out.println("(︶︹︺)\n непонятно, давай до свидания");
            return;
        }
        System.out.println("(⌒‿⌒)");
        while (true) {
            int rand = new Random().nextInt(0, 10) + 1;
            System.out.println("угадай число от 1 до 10");
            while (true) {
                int number = sc.nextInt();
                if (number == rand) {
                    System.out.println("╰(▔∀▔)╯");
                    System.out.println("Будешь угадывать? (да/нет)");
                    sc = new Scanner(System.in);
                    answer = sc.nextLine();
                    if (answer.equals("нет")) {
                        System.out.println("(¬_¬ )");
                        return;
                    } else if (!answer.equals("да")) {
                        System.out.println("(︶︹︺)\n непонятно. Давай, до свидания!");
                        return;
                    }
                    System.out.println("(⌒‿⌒)");
                    break;
                } else {
                    if (number < 1 || number > 10) {
                        System.out.println("Читать не умеешь?");
                    } else if (Math.abs(number - rand) > 5) {
                        System.out.println("Холодно");
                    } else if (Math.abs(number - rand) > 2) {
                        System.out.println("Тепло");
                    } else {
                        System.out.println("Жгётся!");
                    }
                }
            }
        }
    }

}