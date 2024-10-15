package sort;

import java.util.Arrays;

public class LargestNumber {
    public String solution(int[] numbers) {
        String[] array = new String[numbers.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(array, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (array[0].equals("0")) {
            return "0";
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            answer.append(array[i]);
        }

        return answer.toString();

        //return Arrays.stream(numbers).mapToObj(String::valueOf).reduce("", String::concat);
    }





}
