import java.util.LinkedHashSet;
import java.util.Set;

class PalindromeProcessor {

    /**
     * Метод для пошуку всіх найдовших підрядків-паліндромів.
     * Використовує StringBuilder для роботи з текстом.
     */
    public String[] findAllLongestPalindromes(String text) {
        try {
            StringBuilder sb = new StringBuilder(text);
            int n = sb.length();
            if (n == 0) return new String[]{};

            boolean[][] dp = new boolean[n][n];
            int maxLength = 1;

            // Кожен символ є паліндромом
            for (int i = 0; i < n; i++) {
                dp[i][i] = true;
            }

            // Перевірка підрядків довжини 2
            for (int i = 0; i < n - 1; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    dp[i][i + 1] = true;
                    maxLength = 2;
                }
            }

            // Перевірка підрядків довжини > 2
            for (int len = 3; len <= n; len++) {
                for (int i = 0; i < n - len + 1; i++) {
                    int j = i + len - 1;
                    if (sb.charAt(i) == sb.charAt(j) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        maxLength = len;
                    }
                }
            }

            // Збір усіх найдовших паліндромів без дублікатів
            Set<String> longestPalindromes = new LinkedHashSet<>();
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    if (dp[i][j] && (j - i + 1) == maxLength) {
                        longestPalindromes.add(sb.substring(i, j + 1));
                    }
                }
            }

            return longestPalindromes.toArray(new String[0]);
        } catch (Exception e) {
            throw new RuntimeException("Помилка під час пошуку паліндромів: " + e.getMessage());
        }
    }
}
