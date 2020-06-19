
import java.util.*;

public class IntTree2 {
	
	private IntTreeNode overallRoot;
	
	// pre : max > 0
	// post:constructs a sequential tree with given number of 
	//		nodes
	
	public IntTree2(int max) {
		if (max <= 0) {
			throw new IllegalArgumentException("max: " + max);
		}
		overallRoot = buildTree(1,max);
	}
	
	// post: returns a sequential tree with n as its root unless 
	// 		n is greater than max, in which case it returns an 
	//	empty tree
	private  IntTreeNode buildTree(int n, int max) {
		if (n > max) {
			return null;
		} else {
			return new IntTreeNode (n,buildTree(2*n,max),
									buildTree(2*n+1,max));
		}
	}
	
	public static void main(String[] args) {
		IntTree2 tree =new IntTree2(18);
		System.out.println((tree).countEmpty());
	}
	
	public int countEmpty() {
	    return countEmpty(overallRoot);
	}

	private int countEmpty (IntTreeNode root) {
	    if (root == null) {
	        return 1;
	    }
	    
	    return countEmpty(root.left) + countEmpty(root.right);
	}

}
