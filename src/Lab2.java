import java.util.*;

public class Lab2 {

    public static void main(String[] args) {

        // Номер залікової книжки
        int studentNumber = 13;
        // Обчислення C₃ та C₁₇
        int C3 = studentNumber % 3; // C₃ = 1
        int C17 = studentNumber % 17; // C₁₇ = 13

        System.out.println("C₃ = " + C3);
        System.out.println("C₁₇ = " + C17);

        // Тип текстової змінної: String, оскільки C₃ = 1


        Scanner scanner = new Scanner(System.in);

        boolean continueProgram = true;

        while (continueProgram) {
            try {
                // Вибір способу заповнення тексту
                System.out.println("Оберіть спосіб заповнення тексту:");
                System.out.println("1 - Автоматичне заповнення");
                System.out.println("2 - Ручне заповнення");
                int choice;

                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Невірний вибір. Введіть число 1 або 2.");
                    continue;
                }

                String text = "";
                if (choice == 1) {
                    // Автоматичне заповнення тексту
                    text = "а бо об а абоб абоба обо абабабаба"; // Рандомний текст
                    System.out.println("Автоматично заповнений текст: " + text);
                } else if (choice == 2) {
                    // Ручне заповнення тексту
                    System.out.println("Введіть текст:");
                    text = scanner.nextLine();

                    // Перевірка порожнього тексту
                    if (text.trim().isEmpty()) {
                        System.out.println("Текст не може бути порожнім. Спробуйте знову.");
                        continue;
                    }
                } else {
                    System.out.println("Невірний вибір. Введіть число 1 або 2.");
                    continue;
                }

                // Виклик виконавчого методу
                PalindromeProcessor processor = new PalindromeProcessor();
                String[] longestPalindromes = processor.findAllLongestPalindromes(text);

                System.out.println("Найдовші підрядки-паліндроми:");
                for (String palindrome : longestPalindromes) {
                    System.out.println(palindrome);
                }

                // Запит на повторний запуск програми
                System.out.println("\nБажаєте повторити? (y/n):");
                String repeat = scanner.nextLine().trim().toLowerCase();
                if (!repeat.equals("y")) {
                    continueProgram = false;
                }
            } catch (Exception e) {
                System.out.println("Сталася помилка: " + e.getMessage());
            }
        }

        System.out.println("Програма завершена.");
    }
}

