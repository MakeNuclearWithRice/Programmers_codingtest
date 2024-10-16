package sort;

import java.util.Arrays;
import java.util.Collections;

public class HIndex {
    public int solution(int[] citations) {
        int hIndex = 0;

        citations = Arrays
                .stream(citations)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        for(int index : citations) {
            if(index > hIndex){
                hIndex++;
            }else{
                break;
            }
        }

        return hIndex;
    }
}
