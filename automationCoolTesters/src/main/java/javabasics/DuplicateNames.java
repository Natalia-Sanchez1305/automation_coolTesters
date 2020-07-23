package javabasics;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;



public class DuplicateNames {
			public static void main(String[] args) {
	
		//ordena de menor a mayor cambios para ver en el github
		
		 List<Integer> numeros = new ArrayList<>();
		    numeros.add(1);
		    numeros.add(29);
		    numeros.add(3);
		    numeros.add(8);
		    numeros.add(1);
		    numeros.add(1);
		    numeros.add(1);
		    
		   
		    System.out.println("Original list: " + numeros );
		    System.out.println("The Major Number : " + Collections.max(numeros));
		    System.out.println("The Minor Number : " + Collections.min(numeros)+"\n");
		    
		    // Ordenando los numeros menor a mayor   
		    Collections.sort(numeros);
		    System.out.println("short minor to major: " + numeros);
		    
		    //ordenar de mayor a menor
		    Collections.sort(numeros, Collections.reverseOrder());
		    System.out.println("Short major to Minor: "+ numeros+"\n");
		    
		    
		   //removiendo duplicados
		    Object last = null;
			
			int numCount=0;
		       Iterator<Integer> i = numeros.iterator();
		       while(i.hasNext()) {
		           Object temp = i.next();
			           if (temp.equals(last)) {
			               i.remove();
			               numCount++;
			           } else {
			               last = temp;
			           }
		          }
		    Collections.sort(numeros);
		    System.out.println("Remove repeated numbers: " + numeros);
		    System.out.println("Amount of times that elemet is reapeated: "+ numCount +"\n");
		//comparar strings iguales y removerlos    
		List<String> nombre = new ArrayList<>();
	    nombre.add("Persona 1");
	    nombre.add("Persona 1");
	    nombre.add("Persona 1");
	    nombre.add("Persona 2");
	    nombre.add("Persona 3");
	    nombre.add("Persona 3");
	    nombre.add("Persona 3");
	    System.out.println("Original list: " + nombre);
	    
	    List<String> nombreSinDuplicados = nombre
	       .stream()
	       .distinct()
	       .collect(Collectors.toList());	    
	    
	    Collections.sort(nombreSinDuplicados, Collections.reverseOrder());
	    
	    
	    int count = 0;
	    int count2 = 0;
	    System.out.println("Remove Repeated names:  "+ nombreSinDuplicados+"\n");
	    for(String names:  nombreSinDuplicados) {
	    	
	    	if(names.equals("Persona 1")) {
	    		count++;
	    	} 
	    }
	    System.out.println("Amount of times that elemet is reapeated in list without duplicates numbers: " + count);
	   
	    for(String names:  nombre) {
	    	
	    	if(names.equals("Persona 1")) {
	    		count2++;
	    	}
	    }
	    System.out.println("Amount of times that elemet is reapeated in list with duplicates: " + count2);
	    
	    
	    
	    
	    

	}//end main

}
