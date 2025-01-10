package stack_queue;


public class CorrectParentheses {
    boolean solution(String s) {
        int count = 0;
        if(s.charAt(0) == '(' && s.charAt(s.length() - 1) == ')' ){
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '('){
                    count++;
                }else{
                    count--;
                }
                if(count < 0){
                    return false;
                }
            }
            if(count == 0){
                return true;
            }
        }
        return false;
    }
}