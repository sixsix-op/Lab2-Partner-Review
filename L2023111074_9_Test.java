
import org.junit.Test;
import static org.junit.Assert.*;

public class L2023111074_9_Test {
    
    @Test
    public void testExample1() {
        Solution9 solution = new Solution9();
        int n = 4;
        int[][] dislikes = {{1,2}, {1,3}, {2,4}};
        assertTrue("示例1应该返回true", solution.possibleBipartition(n, dislikes));
    }
    
    @Test
    public void testExample2() {
        Solution9 solution = new Solution9();
        int n = 3;
        int[][] dislikes = {{1,2}, {1,3}, {2,3}};
        assertFalse("示例2应该返回false", solution.possibleBipartition(n, dislikes));
    }
    
    @Test
    public void testExample3() {
        Solution9 solution = new Solution9();
        int n = 5;
        int[][] dislikes = {{1,2}, {2,3}, {3,4}, {4,5}, {1,5}};
        assertFalse("示例3应该返回false", solution.possibleBipartition(n, dislikes));
    }
    
    @Test
    public void testSinglePerson() {
        Solution9 solution = new Solution9();
        int n = 1;
        int[][] dislikes = {};
        assertTrue("单个人应该可以分组", solution.possibleBipartition(n, dislikes));
    }
    
    @Test
    public void testNoDislikes() {
        Solution9 solution = new Solution9();
        int n = 3;
        int[][] dislikes = {};
        assertTrue("没有不喜欢关系应该可以分组", solution.possibleBipartition(n, dislikes));
    }
}
