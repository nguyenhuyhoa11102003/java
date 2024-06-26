package Map;

import java.util.Arrays;

public class MyMap<K , V> {
	
	private int size;
    private MyEntry<K, V>[] map = new MyEntry[100];
    

    public V get(K key) 
    {
        for (int i = 0; i < size; i++) 
            if (map[i] != null) 
                if (map[i].getKey().equals(key)) 
                    return map[i].getValue();
            
        return null;
    }
    
    
    public void put(K key, V value) 
    {
        boolean insert = true;

        for (int i = 0; i < size; i++) 
            if (map[i].getKey().equals(key)) 
            {
                map[i].setValue(value);
                insert = false;
            }

        if (insert) 
        {
            getMoreSpace();
            map[size++] = new MyEntry<K, V>(key, value);
        }
    }
    
    private void getMoreSpace() 
    {
        if (size == map.length)
        {
            int newSize = map.length * 2;
            map = Arrays.copyOf(map, newSize);
        }
    }

    
    
    
    

    
    

}
