package com.lu.btree;

/**
 * 
 * @author lu
 * 
 * @description 根据后序数组重建搜索二叉树。
 *
 */
public class RebuildBSTreeByPosArr {

    // 首先判断该数组是否为搜索二叉树的后序结果。其一定满足，比后序数组最后一个元素小的在数组的左边，相反的在右边，不断递归划分，一旦不满足条件则不为搜索二叉树。
    public boolean isBSTreeByArr(int[] arr) {
        if (arr == null || arr.length < 1) {
            return false;
        }
        
        return isBSTree(arr, 0, arr.length - 1);
    }
    
    public boolean isBSTree(int[] arr, int start, int end) {
        if (start == end) {
            return true;
        }
        
        int less = -1;
        int more = end;
        
        for (int i = start; i < end; i++) {
            if (arr[end] > arr[i]) {
                less = i;
            } else {
                more = more == end ? i :more;
            }
        }
        
        if (less == -1 || more == end) {
            return isBSTree(arr, start, end - 1);
        }
        
        if (less != more - 1) {
            return false;
        }
        
        return isBSTree(arr, start, less) && isBSTree(arr, more, end - 1);
    }
    
    
    public static void main(String[] args) {
        int[] arr1 = {4,1,5,3,2};
        int[] arr2 = {2,1,3,6,5,7,4};

        RebuildBSTreeByPosArr main = new RebuildBSTreeByPosArr();
        boolean res1 = main.isBSTreeByArr(arr1);
        boolean res2 = main.isBSTreeByArr(arr2);
        System.out.println(res1);
        System.out.println(res2);
    }
    
}
