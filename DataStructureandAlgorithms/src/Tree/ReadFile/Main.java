package Tree.ReadFile;

import java.io.File;
import java.util.Scanner;

public class Main {

	static AVL readFile() {
		AVL tree = new AVL();

		try {
			File reader = new File("demo.txt");
			Scanner sc = new Scanner(reader);

			int n = Integer.parseInt(sc.nextLine());
			String[] keys = sc.nextLine().split(" ");

			for (String i : keys)
				tree.root = tree.add(tree.root, Integer.parseInt(i));

			System.out.println("Read file success !");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Read file fail ! :"  + e.getMessage() );
		}

		return tree;

	}

	public static void main(String[] args) {

		AVL tree = new AVL();
		Scanner sc = new Scanner(System.in);
		int choose, key;

		do {

			System.out.println();
			System.out.println("     AVL TREE");
			System.out.println();
			System.out.println("1. Add from FILE");
			System.out.println("2. Delete");
			System.out.println("3. Search");
			System.out.println("4. Show tree");
			System.out.println("0. End program");
			System.out.print("Your choice: ");
			choose = sc.nextInt();

			switch (choose) {
			case 0:
				System.out.println("End program success !");
				break;

			case 1:
				tree = readFile();
				break;

			case 2:
				System.out.print("Enter the key you want to delete: ");
				key = sc.nextInt();
				tree.root = tree.remove(tree.root, key);
				break;

			case 3:
				System.out.print("Enter the key you want to search: ");
				key = sc.nextInt();

				if (tree.search(tree.root, key))
					System.out.println("Find success !");
				else
					System.out.println("Not found !");

				break;

			case 4:
				tree.print(tree.root);
				break;

			default:
				System.out.println("Your choice is invalid ! Please try again !");
				break;
			}

		} while (choose != 0);

	}
}
