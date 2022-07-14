package com.stellagosa.leetcode.leetcode100_999.leetcode_558;

/**
 * @Author: Stellagosa
 * @Date: 2022/7/15 6:45
 * @Description: 四叉树交集
 */
public class Solution {

    public static void main(String[] args) {
        Node quadTree1 = new Node(false, false,
                new Node(true, true, null, null, null, null),
                new Node(false, true, null, null, null, null),
                new Node(true, true, null, null, null, null),
                new Node(true, true, null, null, null, null));

        Node quadTree2 = new Node(false, false,
                new Node(true, true, null, null, null, null),
                new Node(true, false,
                        new Node(true, true, null, null, null, null),
                        new Node(false, true, null, null, null, null),
                        new Node(false, true, null, null, null, null),
                        new Node(true, true, null, null, null, null)),
                new Node(true, true, null, null, null, null),
                new Node(true, true, null, null, null, null));


        Solution solution = new Solution();
        Node node = solution.intersect(quadTree1, quadTree2);
    }

    // 0|x=x 1|x=1
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf) {
            if (quadTree1.val) {
                return new Node(true, true, null, null, null, null);
            }
            return new Node(quadTree2.val, quadTree2.isLeaf, quadTree2.topLeft, quadTree2.topRight, quadTree2.bottomLeft, quadTree2.bottomRight);
        }
        if (quadTree2.isLeaf) {
            return intersect(quadTree2, quadTree1);
        }

        Node topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        Node bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true, null, null, null, null);
        }
        return new Node(topLeft.val, false, topLeft, topRight, bottomLeft, bottomRight);
    }


    // public Node intersect(Node quadTree1, Node quadTree2) {
    //     if (quadTree1.isLeaf && quadTree2.isLeaf) {
    //         return new Node(quadTree1.val | quadTree2.val, true, null, null, null, null);
    //     }
    //     if (quadTree1.isLeaf) {
    //         return intersect(quadTree1, quadTree1, quadTree1, quadTree1, quadTree2.topLeft, quadTree2.topRight, quadTree2.bottomLeft, quadTree2.bottomRight);
    //     }
    //     if (quadTree2.isLeaf) {
    //         return intersect(quadTree1.topLeft, quadTree1.topRight, quadTree1.bottomLeft, quadTree1.bottomRight, quadTree2, quadTree2, quadTree2, quadTree2);
    //     }
    //     return intersect(quadTree1.topLeft, quadTree1.topRight, quadTree1.bottomLeft, quadTree1.bottomRight, quadTree2.topLeft, quadTree2.topRight, quadTree2.bottomLeft, quadTree2.bottomRight);
    // }
    //
    // private Node intersect(Node topLeft1, Node topRight1, Node bottomLeft1, Node bottomRight1, Node topLeft2, Node topRight2, Node bottomLeft2, Node bottomRight2) {
    //     Node topLeft = intersect(topLeft1, topLeft2);
    //     Node topRight = intersect(topRight1, topRight2);
    //     Node bottomLeft = intersect(bottomLeft1, bottomLeft2);
    //     Node bottomRight = intersect(bottomRight1, bottomRight2);
    //     if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val) {
    //         return new Node(topLeft.val, true, null, null, null, null);
    //     }
    //     return new Node(topLeft.val, false, topLeft, topRight, bottomLeft, bottomRight);
    // }

}

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
    }

    public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};