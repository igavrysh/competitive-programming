import java.util.*;
class SeatManagerArrayBased {
    int[] a;
    int p,ch;
    public SeatManagerArrayBased(int n) {
        this.a=new int[n];
    }
    public int reserve() {
        if (ch!=0) {
            int i=0;
            for(i=0;i<this.a.length;i++){
                if(a[i]==0){
                    this.a[i]=1;
                    break;
                }
            }
            ch-=1;
            return i+1;
        }
        else{
            this.a[this.p++]=1;
            return p;
        }
    }
    
    public void unreserve(int seatNumber) {
        this.a[seatNumber-1]=0;
        this.ch+=1;
    }
}