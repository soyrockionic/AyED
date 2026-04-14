package tp1.ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList {
    
   public static void main (String[] args) {
       
       List<Integer> a = new ArrayList<>();
       
       if (args.length == 0) {
            args = new String[] { "10", "P0", "30", "40", "50" };
        }
       
       for (String arg : args) {
           try {
               int n = Integer.parseInt(arg);
               a.add(n);
           }catch(NumberFormatException e) {
               System.out.println(arg + " No es un nro valido");
           }
        }
       
      for (int i=0; i<a.size(); i++) {
           System.out.println(a.get(i));
      }
       
      a.stream().forEach(System.out::println);
   } 
    
}
