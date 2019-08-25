package code._24二叉搜索树的后序遍历;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {

    /**
     * 解题思路：最后一个数字为根节点，数组前面分为两部分，左子树和右子树
     * 左子树的值都比根节点要小，右子树的值都比根节点要大
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null||sequence.length==0) {
            return false;
        }
        return verify(sequence, 0, sequence.length-1);
    }

    private boolean verify(int[] sequence,int start,int end){
        if (start == end || end < start) {
            return true;
        }
        int root = sequence[end];
        int rightIndex = 0;
        boolean getRightIndex = false;
        for (int i = start; i < end; i++) {
            if (sequence[i] > root) {
                rightIndex = i;
                getRightIndex = true;
                break;
            }
        }
        if (getRightIndex) {
            for (int i = rightIndex; i < end; i++) {
                if (sequence[i] < root) {
                    return false;
                }
            }
            return verify(sequence, start, rightIndex - 1) && verify(sequence, rightIndex, end - 1);
        } else {
            return verify(sequence, start, end - 1);
        }
    }

    public static void main(String[] args){
        int[] a = {5,7,6,9,11,10,8};
        int[] b = {7,4,6,5};
        System.out.println(new VerifySquenceOfBST().VerifySquenceOfBST(a));
        System.out.println(new VerifySquenceOfBST().VerifySquenceOfBST(b));
    }
}
