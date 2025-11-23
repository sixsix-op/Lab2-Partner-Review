import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution9 {

    /**
     * 判断是否可以将n个人分成两组，使得互相不喜欢的人不在同一组
     * 使用并查集数据结构实现
     * @param n 人数
     * @param dislikes 不喜欢关系数组
     * @return 是否可以二分
     */
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] fa = new int[n + 1]; // 并查集数组，记录父节点和集合大小
        Arrays.fill(fa, -1); // 初始每个节点独立，大小为-1
        List<Integer>[] g = new List[n + 1]; // 邻接表存储不喜欢关系
        
        // 初始化邻接表
        for (int i = 0; i <= n; ++i) {
            g[i] = new ArrayList<Integer>();
        }
        
        // 构建无向图：如果不喜欢是双向的
        for (int[] p : dislikes) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }
        
        // 核心算法：检查是否存在奇环
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < g[i].size(); ++j) {
                // 将i的所有不喜欢节点连接在一起
                unit(g[i].get(0), g[i].get(j), fa);
                // 如果i与不喜欢节点在同一集合，说明冲突
                if (isconnect(i, g[i].get(j), fa)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 并查集：合并两个集合
     * 使用按秩合并优化
     */
    public void unit(int x, int y, int[] fa) {
        x = findFa(x, fa);
        y = findFa(y, fa);
        if (x == y) {
            return;
        }
        // 按秩合并：小树合并到大树
        if (fa[x] <= fa[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        fa[x] += fa[y];
        fa[y] = x;
    }

    /**
     * 检查两个元素是否属于同一集合
     */
    public boolean isconnect(int x, int y, int[] fa) {
        x = findFa(x, fa);
        y = findFa(y, fa);
        return x == y;
    }

    /**
     * 并查集：查找根节点（带路径压缩）
     * 路径压缩优化查找效率
     */
    public int findFa(int x, int[] fa) {
        if (fa[x] < 0) {
            return x;
        }
        fa[x] = findFa(fa[x], fa);
        return fa[x];
    }
}