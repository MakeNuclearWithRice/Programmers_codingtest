package lv1.pccp;

class FoldBill {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        if(wallet[1]>wallet[0]){
            int temp = wallet[1];
            wallet[1] = wallet[0];
            wallet[0] = temp;
        }
        while(!put(wallet, bill)){
            answer++;
            fold(bill);
        }

        return answer;
    }

    public int[] fold(int[] bill){
        if(bill[1]>bill[0]){
            int temp = bill[1];
            bill[1] = bill[0];
            bill[0] = temp;
        }
        bill[0] /= 2;
        return bill;
    }

    public boolean put(int[] wallet, int[] bill){
        if(bill[1]>bill[0]){
            int temp = bill[1];
            bill[1] = bill[0];
            bill[0] = temp;
        }

        if(bill[0]<=wallet[0]&&bill[1]<=wallet[1]){
            return true;
        }
        return false;
    }
}
