package Map;

public class Main {
	
	public static void main(String[] args) {
		  MyMap<Integer, String> map = new MyMap<>() ;
		  
		  map.put(1, "Peter") ;
	        map.put(2, "John") ;
	        map.put(3, "Anna") ;
	        
	        System.out.println(map.get(1)) ;
	        System.out.println(map.get(2)) ;
	        System.out.println(map.get(3)) ;
		  
	}

}
