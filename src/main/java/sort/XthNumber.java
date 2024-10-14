package sort;

import java.util.Arrays;

public class XthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int i = 0;

        for(int[] command : commands) {


            int limit = command[1]-command[0]+1;
            int[] newArray = new int[limit];

            for(int j = 0; j<limit; j++) {
                newArray[j] = array[command[0]+j-1];
            }
            Arrays.sort(newArray);
            answer[i] = newArray[command[2]-1];
            i++;
        }

        return answer;
    }
}
