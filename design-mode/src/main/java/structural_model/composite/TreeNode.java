package structural_model.composite;

import lombok.Data;

import java.util.Enumeration;
import java.util.Vector;

@Data
public class TreeNode {
	private String name;
	private TreeNode parent;
	/* 可以实现自动增长的对象数组,但Vector是同步的 */
	private Vector<TreeNode> children = new Vector<TreeNode>();

	public TreeNode(String name) {
		super();
		this.name = name;
	}

	/**
	 * 添加孩子节点
	 * @param node
	 */
	public void add(TreeNode node) {
		children.add(node);
	}

	/**
	 * 删除孩子节点
	 * @param node
	 */
	public void remove(TreeNode node) {
		children.remove(node);
	}
	
	/**
	 * 取得孩子节点  
	 * @return
	 */
    public Enumeration<TreeNode> getChildren(){  
        return children.elements();  
    }  

}
