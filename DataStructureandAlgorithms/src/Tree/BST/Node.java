package Tree.BST;

public class Node {

	public int value;
	public Node left;
	public Node right;
	public int height;

	public Node(int value) {
		this.value = value;
		this.height = 0;
		this.left = null;
		this.right = null;
	}

}
