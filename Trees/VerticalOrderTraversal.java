import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class VerticalOrderTraversal {
    private class Pair implements Comparable<Pair>{
        TreeNode node;
        int level;
        int vLevel;
        Pair(TreeNode node, int level, int vLevel){
            this.node = node;
            this.level = level;
            this.vLevel =  vLevel;
        }
        public int compareTo(Pair o){
            if(o.level != this.level){
                return this.level - o.level;
            }else{
                return this.node.val - o.node.val;
            }
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer, PriorityQueue<Pair>> map = new HashMap<>();
        LinkedList<Pair> q = new LinkedList<>();
        q.addLast(new Pair(root, 0, 0));
        int minVertLevel = 0;
        int maxVertLevel = 0;
        while(q.size() != 0){
            int size = q.size();
            while(size-- != 0){
                Pair rem = q.removeFirst();
                minVertLevel = Math.min(rem.vLevel, minVertLevel);
                maxVertLevel = Math.max(rem.vLevel, maxVertLevel);
                PriorityQueue<Pair> levelPq = map.getOrDefault(rem.vLevel, new PriorityQueue<>());
                levelPq.add(rem);
                map.put(rem.vLevel, levelPq);
                if(rem.node.left != null){
                    q.addLast(new Pair(rem.node.left, rem.level + 1, rem.vLevel - 1));
                }
                if(rem.node.right != null){
                    q.addLast(new Pair(rem.node.right, rem.level + 1, rem.vLevel + 1));
                }
            }
        } 

        List<List<Integer>> ans = new ArrayList<>();

        while(minVertLevel <= maxVertLevel){
            PriorityQueue<Pair> levelPq = map.get(minVertLevel);
            List<Integer> li= new ArrayList<>();
            while(levelPq.size() != 0){
                Pair rem = levelPq.remove();
                li.add(rem.node.val);
            }
            ans.add(li);
        }

        return ans;
    }
}
