package ADT.List;

public class Test {
	public static void main(String[] args) {
		ListUsingArray <Integer> list = new ListUsingArray <Integer>();
		
		list.addFirst(3);   // addFirst nha chu ko phai add. Cac phan tu trong mang se duoc don len
		list.addFirst(2);
		list.addFirst(1);
		list.print();

		

		System.out.println("\nTien hanh xoa phan tu dau tien") ;
		list.removeFirst() ;
		list.print() ;
		
		System.out.println("\nTien hanh xoa phan tu tai vi tri thu 1") ;
		list.remove(1) ;
		list.print() ;
		

        System.out.println("\nTien hanh them so 4 vao vi tri dau tien trong mang") ;
			list.addFirst(4) ; 
		list.print();

		System.out.println("\nTien hanh them so 4 vao vi tri thu 2 trong mang") ;
		list.add(2,4) ; 
	list.print();
	
	if (list.contains(1)) 
        System.out.println("\nTim thay so 1 trong mang") ;
    else
        System.out.println("\nKhong tim thay so 1 trong mang") ;

	
	}
}
