package structural_model.composite;

/**
 * 组合模式
 * <p>使用场景：将多个对象组合在一起进行操作，常用于表示树形结构中，
 * <p>例如二叉树，数等。
 * @author smilesnake
 *
 */
public class Tree {
	TreeNode root = null;

	public Tree(String name) {
		super();
		this.root = new TreeNode(name);
	}
	public static void main(String[] args) {
		Tree tree = new Tree("A");
		TreeNode nodeB = new TreeNode("B");
		TreeNode nodec = new TreeNode("C");
		nodeB.add(nodec);
		tree.root.add(nodeB);
		System.out.println("buid the tree finished !");
	 }
	
}
