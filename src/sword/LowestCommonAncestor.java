package sword;

/**
 * title :https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先
 *
 * 百度百科中最近公共祖先的定义为：对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 * 示例 1:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 *
 * 示例 2:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身
 *
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中
 *
 * Description :
 * Created by jiangjunchi on 2020/6/11 11:00
 **/
public class LowestCommonAncestor {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 时间复杂度 O(N)： 其中 N 为二叉树节点数；每循环一轮排除一层，二叉搜索树的层数最小为 logN （满二叉树），最大为 N （退化为链表）
     * 空间复杂度 O(1)： 使用常数大小的额外空间
     */
    private static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if(root.val<p.val && root.val<q.val){
                root=root.right;
            }else if(root.val>p.val && root.val>q.val){
                root=root.left;
            }else{
                break;
            }
        }
        return root;
    }

    private static TreeNode lowestCommonAncestor1P(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val>q.val){
            TreeNode tmp=p;
            p=q;
            q=tmp;
        }
        while(root!=null){
            if(root.val<p.val){
                root=root.right;
            }else if(root.val>q.val){
                root=root.left;
            }else{
                break;
            }
        }
        return root;
    }

    /**
     * 时间复杂度 O(N) ： 其中 N 为二叉树节点数；每循环一轮排除一层，二叉搜索树的层数最小为 logN （满二叉树），最大为 N （退化为链表）
     * 空间复杂度 O(N) ： 最差情况下，即树退化为链表时，递归深度达到树的层数 N
     */
    private static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val<p.val && root.val<q.val){
            return lowestCommonAncestor2(root.right,p,q);
        }
        if(root.val>p.val && root.val>q.val){
            return lowestCommonAncestor2(root.left,p,q);
        }
        return root;
    }

    public static void main(String[] args) {

    }

}
