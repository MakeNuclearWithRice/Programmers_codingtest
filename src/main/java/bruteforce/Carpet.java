package bruteforce;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int w, h = 0;
        int all = brown + yellow;

        for(int i = 1; i*i<=yellow; i++){
            if(yellow%i==0){
                h = i;
                w = yellow/h;
                if(all%(h+2)==0 & 2*h + 2*w + 4 == brown){
                    answer[1] = h+2;
                    answer[0] = all/answer[1];
                    return answer;
                }
            }
        }
        return null;
    }
}
