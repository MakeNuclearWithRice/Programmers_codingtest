package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class RemoveDuplicateNum {
    public int[] solution(int []arr) {
        int[] answer = {};

        Queue<Integer> queue = new LinkedList<>();
        queue.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1]){
                queue.add(arr[i]);
            }

        }
        return queue.stream().mapToInt(i->i).toArray();
    }

}
