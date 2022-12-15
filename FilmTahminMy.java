package FilmTahmin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FilmTahminMy {
 static List<String> filmler = new ArrayList<>(Arrays.asList("JOKER", "INCEPTION", "PIYANIST", "GREENMILE", "LEON", "GODFATHER", "JURASSICPARK", "TITANIC"));
 static List<String> filmlerHarf = new ArrayList<>();
 static List<String> filmlerHarfTahmin = new ArrayList<>();
 static Scanner input = new Scanner(System.in);
 static int tercih;
 
public static void main(String[] args) {
	
	  
	System.out.println("1-8 arasi bir rakam giriniz");
	tercih=input.nextInt();
 
	int filmHarfiUz= filmler.get(tercih-1).length();
	System.out.println("Tahmin edeceginiz film "+filmHarfiUz+" harfli");
	  
	filmlerHarf = new ArrayList<>(Arrays.asList(filmler.get(tercih-1).split("")));
	
	filmHarfTahminListMethod();
	filmHarfTahminMethod();
	filmTahminMethod();
	  
  }


//-----------------------------------------------------
public static void filmHarfTahminListMethod() {
	int counter=0;
	  do {
		filmlerHarfTahmin.add("_");
		counter++;
	  } while (counter<tercih-1);  
}

//-----------------------------------------------------
public static void filmHarfTahminMethod() {
	  int counterDo=0;
	  int kalanHak=filmlerHarf.size()-1;
	  
	  do {	  
	  System.out.println("Bir harf tahmin ediniz");
	  input = new Scanner(System.in);
	  String filmHarfiTahmin=input.nextLine();
	  
	  int counter=0;
	  
		for (String w : filmlerHarf) {
		  if(w.equalsIgnoreCase(filmHarfiTahmin)) {
			  filmlerHarfTahmin.remove(filmlerHarf.indexOf(w));
			  filmlerHarfTahmin.add(filmlerHarf.indexOf(w),filmHarfiTahmin);
			  System.out.println(filmlerHarfTahmin);
		  }else {
			  counter++;
		  }
		  if(counter==filmlerHarf.size()) {
			  System.out.println(filmlerHarfTahmin);
		  }
	}
	 System.out.println("kalan hakkiniz :"+kalanHak--);
	 counterDo++;
	} while (counterDo<=filmlerHarf.size()-1);
	  

}

//-----------------------------------------------------
public static void filmTahminMethod() {
	System.out.println("\nFilmi tahmin ediniz");
	input = new Scanner(System.in);
	String filmTahmini=input.nextLine();
	
	if(filmler.get(tercih-1).equalsIgnoreCase(filmTahmini)){
		System.out.println("Tebrikler filmi bildiniz");
	}else System.out.println("\nMaalesef bilemediniz\nBilmeniz gereken film :"+filmler.get(tercih-1));
	  
}

}
