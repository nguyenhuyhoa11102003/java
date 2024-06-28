package Tree.AVL;

public class Main {
	public static void main(String[] args) {
		AVL  tree =  new AVL();
		
        System.out.println("Testing add()") ;
        tree.root = tree.add(tree.root, 10);
        tree.root = tree.add(tree.root, 20);
        tree.root = tree.add(tree.root, 30);
        tree.root = tree.add(tree.root, 40);
        tree.root = tree.add(tree.root, 50);
        tree.root = tree.add(tree.root, 25);
        tree.root = tree.add(tree.root, 35);
        tree.print(tree.root);
        System.out.println();
        

        /* The constructed AVL Tree would be
                    30
                   /  \
                 20    40
                /  \   /  \
               10  25 35  50

        */
        
        System.out.println("Testing remove()") ;
        
        tree.root = tree.remove(tree.root, 35);
        tree.root = tree.remove(tree.root, 50);
        tree.root = tree.remove(tree.root, 40);
        
        /* The constructed AVL Tree would be
			        20
			       /   \
			      10   30
			           /
			          25

        */

        tree.print(tree.root);
        
        
        

        
	}
}
