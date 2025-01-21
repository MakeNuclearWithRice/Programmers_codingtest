package bruteforce;

import java.util.HashSet;
import java.util.Set;

public class PrimeNumber {
    Set<Integer> numberSet = new HashSet<>();
    boolean[] visited;

    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        dfs(numbers, "");
        int answer = 0;

        for (Integer i : numberSet) {
            if (isPrime(i)) {
                answer++;
            }
        }

        return answer;
    }

    public void dfs(String numbers, String s) {
        if (!s.isEmpty()) {
            numberSet.add(Integer.parseInt(s));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true; // 현재 문자 사용 표시
                dfs(numbers, s + numbers.charAt(i)); // 재귀 호출
                visited[i] = false; // 백트래킹
            }
        }
    }

    public boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
