package code._9斐波那契数列;

public class RectCover {


    public int RectCover(int target) {
        if (target == 0){
            return 0;
        }
        if (target == 1){
            return 1;
        }
        if (target == 2){
            return 2;
        }
        int pre1 = 2;
        int pre2 = 1;
        int result = 0;
        for (int i = 3;i<=target;i++){
            result = pre1 + pre2;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }
}
