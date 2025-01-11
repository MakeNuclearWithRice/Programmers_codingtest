package hash;

import java.util.HashMap;

public class Clothes {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clothMap = new HashMap<>();
        for (String[] cloth : clothes) {
            clothMap.put(cloth[1], clothMap.getOrDefault(cloth[1], 0) + 1);
        }

        int[] clothesArray = clothMap.values().stream().mapToInt(i -> i).toArray();
        for(int i = 0; i < clothesArray.length; i++) {
            answer *= (clothesArray[i] + 1);

        }

        return answer-1;
    }
}
