package FilmTahmini;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FilmTahminRunner {
    /*
     TASK :
      yukarıdaki film listinde bulunan filmlerden herhangi birisini kullanıcının film ismini  görmeden
      filmin index nosuna göre sectiriniz
      seçilen filmin  ismini filmin harf saysının 2 katı kadar hak tanıyarak tahmin etmesini
      sağlayan method create ediniz...
    
      kullanıcının sectiği filmin harf sayısını  console yazdırınız.
      kullanıcının sectiği film için tahmin hakkını  console yazdırınız.
      kullanıcının her tahmininde kalan hak sayısını console yazdırınız.
      kullanıcının her tahmininde doğru ve yanlış tahmin  sayısını console yazdırınız.
      kullanıcının kaybedip veya kazandığını ve tahmin etmesi gereken filmin ismini  console yazdırınız.
     */

    static List<String> filmler = new ArrayList<>(Arrays.asList("JOKER", "INCEPTION", "PIYANIST", "GREENMILE", "LEON", "GODFATHER", "JURASSICPARK", "TITANIC"));
    static Scanner input = new Scanner(System.in);
    static boolean flag=false;

    public static void main(String[] args) {
        System.out.println("1 ile 8 arasinda bir rakam giriniz");
        int tercih = input.nextInt();
        filmTahmin(tercih);
    }

    public static void filmTahmin(int tercih){
      System.out.println("Sectiginiz film "+filmler.get(tercih-1).length()+" harfli");
      int counter=2*filmler.get(tercih-1).length();
        
        System.out.println("\nTahmin icin kalan hakkiniz: "+counter);
        System.out.println("Film tahmininde bulununuz");
        

        filmDongu(counter, tercih);

      if(flag==false){
      System.out.println("\nTahmin hakkiniz kalmadi ve Oyun Bitti");
      System.out.println("Tahmin etmeniz gereken film :"+filmler.get(tercih-1));
      }

    }

    public static void filmDongu(int counter , int tercih){
      input = new Scanner(System.in);
      String tahmin = input.nextLine();

      if(tahmin.equalsIgnoreCase(filmler.get(tercih-1))){
        System.out.println("\nTebrikler bildiniz: "+filmler.get(tercih-1));
        flag=true;
      }else {
        System.out.println("\nMaalesef bilemediniz");
        counter--;
        System.out.println("Tahmin icin kalan hakkiniz: "+counter);

        if(counter>0){
          harfTahmin(tercih, counter);
        }
      }
    }

    public static void harfTahmin(int tercih, int counter){
      System.out.println("\nBir harf tahmininde bulunun");
      input=new Scanner(System.in);
      String harf=input.nextLine();
       
      if(filmler.get(tercih-1).contains(harf.toUpperCase())) System.out.println("girdiginiz harf mevcut");
      else System.out.println("girdiginiz harf yok");
      
      if(counter>0){
        System.out.println("\nFilm tahmininde bulununuz");
        filmDongu(counter, tercih);
      }

    }


}
