package com.tugba;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static com.tugba.SehirDatabase.iller;

public class SehirManager {


    public static List<Sehir> sehirOlustur() {

        Random random = new Random();

        List<Sehir> sehirListesi = new ArrayList<>();

        for (int i = 0; i < SehirDatabase.getIller().length; i++) {  //for ( String sehirDatabase : SehirDatabase.getIller()){}
            String sehirIsimleri = SehirDatabase.getIller()[i];
            int nufus = ThreadLocalRandom.current().nextInt(1_000_000, 5_000_001); // Burada 1 milyon-5 milyon arasında nufüs belirledim.
            String plaka = String.format("%02d",sehirListesi.size() + 1); // Burada 1-9 arasında olan şehirlerin başına Sıfır yazdırarak ve iki haneli şehirleri de index+1 işlemi ile plaka ataması yaptırdım.
            EBolge bolge = EBolge.values()[random.nextInt(4)]; // Enumda bulunan 4 farklı bölgenin rastgele atanması
            Sehir sehir = new Sehir(sehirIsimleri, nufus, plaka, bolge); // yukarıda tanımlanan şehir değişkenlerini soyutlama ile constructorda parametreli olarak tanımladım.
            sehirListesi.add(sehir); // sehirlistesine soyutlanmış olan sehir add metodu ile ekledim.
        }

        return sehirListesi;
    }
}
