package Tree.BST;

public class Main {
	public static void main(String[] args) {
		BST tree = new BST();
		
		System.out.println("Testing add()") ;
        tree.add(40);
        tree.add(32);
        tree.add(65);
        tree.add(36);
        tree.add(24);
        tree.add(25);
        tree.add(30);
        tree.add(75);
        tree.add(70);
        tree.NLR(tree.root);
        
        
        System.out.println("\nTesting removeMax()") ;
        tree.removeMax() ;
        tree.NLR(tree.root);

        System.out.println("\nTesting removeMin()") ;
        tree.removeMin(tree.root) ;
        tree.NLR(tree.root);

        
        System.out.println("\nTestting findMaxValue()") ;
        System.out.println(tree.findMaxNode(tree.root).value) ;

        
        System.out.println("Testting findMinValue()") ;
        System.out.println(tree.findMinNode(tree.root).value) ;
        
        System.out.println("Print in ascending order") ;
        tree.LNR(tree.root);

        System.out.println("\nPrint in descending order") ;
        tree.RNL(tree.root);

        System.out.println("\nTesting getHeight()") ;
        System.out.println(tree.getHeight()) ;

        System.out.println("Testing sum()") ;
        System.out.println(tree.sum()) ;
        
        
        
        
        
        
        
        
        
		
        
        
        

        
	}
}
