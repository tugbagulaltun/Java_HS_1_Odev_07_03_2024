package com.tugba;

import com.sun.source.doctree.SeeTree;

import java.awt.*;
import java.net.SocketTimeoutException;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;


public class Runner {
    public static void main(String[] args) {

        List<Sehir> cities= SehirManager.sehirOlustur();        // Burada bir liste oluşturuldu ve bu listenin içine SehirManagerdaki sehiroluştur() metodu eklendi.
                                                                // Böylelikle yeni oluşturulan liste ile Stream metotları kullanılabilir.
        System.out.println(SehirManager.sehirOlustur());        // Metodu çalıştırmak için sout ile oluşturulan şehirleri yazdırma.

        System.out.println();

        System.out.println( "------------------------------------ A N S W E R ------------------------------------------------");
        // Question1
        System.out.println(" *********** ANSWER1.A *********");    // Burada Seçilen Bolgeye göre Sehirleri Filtreledim (Liste Halinde).
        List<Sehir> citiesFilteredByLocation = cities.stream().filter(city-> city.getBolge()==EBolge.BOLGE_1).toList();
        System.out.println(citiesFilteredByLocation);

        System.out.println( "--------------------------------------------------------------------------------------");

        // Question1
        System.out.println(" *********** ANSWER1.B *********");    // Burada Seçilen Bölgeye göre Sehirlerin İsimlerini Filtreleyip yeni bir liste oluşturdum.
        List<String> citiesName= cities.stream().filter(city-> city.getBolge()==EBolge.BOLGE_2).map(Sehir::getIsim).toList();
        System.out.println(citiesName);


        System.out.println( "--------------------------------------------------------------------------------------");
        // Question2 --> Belirli bir nüfus aralığına sahip şehirlerin plaka numaralarını içeren bir Set elde etmek
        System.out.println(" *********** ANSWER2 ***********");
        Set<String> setListByCityPopulationListCityPlate = cities.stream().filter(sehir-> sehir.getNufus()>3_000_000 && sehir.getNufus()<5_000_000)
                .map(city -> {String cityPlate= city.getPlakaNo(); return cityPlate;}).collect(Collectors.toSet());
        System.out.println(setListByCityPopulationListCityPlate);

        System.out.println( "--------------------------------------------------------------------------------------");

        // Question3 --> Belirli bir harf ile başlayan şehirlerin listesi
        System.out.println(" *********** ANSWER3.A *********");
        List<String> cityNameStartWithT= cities.stream().filter(city-> city.getIsim().startsWith("T")).map(Sehir::getIsim).toList();
        System.out.println(cityNameStartWithT);

        System.out.println( "--------------------------------------------------------------------------------------");

        // Question3 --> Belirli bir harf ile başlayan şehirlerin ad uzunluklarının toplamı
        System.out.println(" *********** ANSWER3.B *********");
        List<Integer> cityNameLengthSum = (List<Integer>) cities.stream().filter(city-> city.getIsim().startsWith("T")).map(y-> y.getIsim().length()).collect(Collectors.toList());
        System.out.println(cityNameLengthSum);
        System.out.println( "--------------------------------------------------------------------------------------");

        // Question4 --> Butun sehirlerin nufus toplamını bulmak
        System.out.println(" *********** ANSWER4 **********");

        long citiesPopSum= cities.stream().mapToLong(Sehir::getNufus).sum();
        System.out.println(citiesPopSum);
        System.out.println( "--------------------------------------------------------------------------------------");

        // Question5 --> Belirli bir bölgedeki nufus toplamı,ortalaması,en büyük nüfusu
        System.out.println(" *********** ANSWER5 **********");
        System.out.print("Average ---> ");
        double citiesPopAvr= cities.stream().filter(city-> city.getBolge()==EBolge.BOLGE_2).mapToLong(Sehir::getNufus).average().orElse(0);
        System.out.println(citiesPopAvr);
        System.out.print("SUM ---> ");
        long citiesLoPopSum= cities.stream().filter(city-> city.getBolge()==EBolge.BOLGE_1).mapToLong(Sehir::getNufus).sum();
        System.out.println(citiesLoPopSum);
        System.out.print("MAX ---> ");
        int citiesMaxPop= cities.stream().filter(city-> city.getBolge()==EBolge.BOLGE_4).mapToInt(city-> Math.toIntExact(city.getNufus())).max().orElse(0);
        System.out.println(citiesMaxPop);
        System.out.println( "--------------------------------------------------------------------------------------");

        // Question6 --> belirli bir nüfus aralığındaki şehirlerin ortalama nüfusu
        System.out.println(" *********** ANSWER6 *********");
        double selectedCityPopAvr= cities.stream().filter(city -> city.getNufus()>3_000_005 && city.getNufus()<3_500_001).mapToDouble(Sehir::getNufus).average().orElse(0);
        System.out.println(selectedCityPopAvr);
        System.out.println( "--------------------------------------------------------------------------------------");

        // Question7 --> nüfusu 1milyondan fazla olan şehirleri içerecek şekilde filtreleyin
        System.out.println(" *********** ANSWER7 *********");
        cities.stream().filter(city-> city.getNufus()>1_000_000).forEach(System.out::println);
        System.out.println( "--------------------------------------------------------------------------------------");

        // Question8 --> şehir adlarını büyük harfe dönüştürecek şekilde map işlemine tabi tutun.
        System.out.println(" *********** ANSWER8 *********");
        cities.stream().map(city-> city.getIsim().toUpperCase()).forEach(System.out::println);
        System.out.println( "--------------------------------------------------------------------------------------");

        // Question9 --> belirli bir bölgedeki şehirlerin plaka numaralarının tek olanları
        System.out.println(" *********** ANSWER9 *********");
        List<Sehir> cityPlate= cities.stream().filter(city-> city.getBolge()==EBolge.BOLGE_2 && Integer.parseInt(city.getPlakaNo()) % 2 != 0).collect(Collectors.toList());
        System.out.println(cityPlate);
        System.out.println( "--------------------------------------------------------------------------------------");

        // Question10 --> belirli bir bölgedeki şehirlerin adlarının ilk 3 harfini ve plaka numaralarını aralarında - birleştirerek yeni bir liste
        System.out.println(" *********** ANSWER10 *********");
        List<String> plateAndFisrtTreeAlp= cities.stream().filter(city-> city.getBolge()==EBolge.BOLGE_1).map(x-> {
           String cityName= x.getIsim().substring(0, 3);
           String cityPlateNo= x.getPlakaNo();
            return cityPlateNo+"-"+cityName;
        }).collect(Collectors.toList());
        System.out.println(plateAndFisrtTreeAlp);

        System.out.println( "--------------------------------------------------------------------------------------");
    }
}
