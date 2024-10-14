package hash;


import java.util.*;

public class Marathon {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> participantMap = new HashMap<>();
        Map<String, Integer> completionMap = new HashMap<>();

        for(String member : participant){
            participantMap.put(member, participantMap.getOrDefault(member, 0)+1);
        }
        for(String member : completion){
            completionMap.put(member, completionMap.getOrDefault(member, 0)+1);
        }

        for(String member : participantMap.keySet()){
            if(!Objects.equals(participantMap.get(member), completionMap.get(member))){
                answer = member;
                break;
            }
        }

        return answer;
    }
}
