package BruteForce;

import java.util.*;

public class Square {
    public int solution(int[][] sizes) {
        PriorityQueue<Integer> length = new PriorityQueue<>((a, b) -> b.compareTo(a));
        PriorityQueue<Integer> width = new PriorityQueue<>((a, b) -> b.compareTo(a));

        for(int[] size : sizes){
            if(size[0] > size[1]){
                length.add(size[0]);
                width.add(size[1]);
            }else{
                length.add(size[1]);
                width.add(size[0]);
            }
        }

        return length.poll()*width.poll();
    }
}
