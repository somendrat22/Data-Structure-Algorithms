package Trees;

public class BinaryTreeFromInorderAndPostOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return genrateBT(0, postorder.length - 1,0, postorder.length - 1, postorder, map);
    }

    public TreeNode genrateBT(int st, int en, int is, int ie , int [] postorder, HashMap<Integer, Integer> map){
        if(st > en || is > ie){
            return null;
        }
        TreeNode root = new TreeNode(postorder[en]);
        int inIdx = map.get(postorder[en]);
        int count = ie - inIdx;
        root.left = genrateBT(st, en - count - 1,is, inIdx - 1, postorder, map);
        root.right = genrateBT(en - count, en - 1, inIdx + 1, ie, postorder, map);
        return root;
    }
}
