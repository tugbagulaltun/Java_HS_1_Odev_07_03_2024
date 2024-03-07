package com.tugba;

import java.util.Random;

public class SehirDatabase {

    static String[]iller={"Adana","Adıyaman","Afyon","Ağrı","Amasya","Ankara","Antalya","Artvin","Aydın","Balıkesir","Bilecik","Bingöl",
            "Bitlis","Bolu","Burdur","Bursa","Çanakkale","Çankırı","Çorum","Denizli","Diyarbakır","Edirne","Elazığ",
            "Erzincan","Erzurum","Eskişehir","Gaziantep","Giresun","Gümüşhane","Hakkari","Hatay","Isparta",
            "Mersin","Istanbul","Izmir","Kars","Kastamonu","Kayseri","Kırklareli","Kırşehir","Kocaeli","Konya",
            "Kütahya","Malatya","Manisa","Kahramanmaraş","Mardin","Muğla","Muş","Nevşehir","Niğde","Ordu","Rize",
            "Sakarya","Samsun","Siirt","Sinop","Sivas","Tekirdağ","Tokat","Trabzon","Tunceli","Sanlıurfa","Uşak",
            "Van","Yozgat","Zonguldak","Aksaray","Bayburt","Karaman","Kırıkkale","Batman","Sırnak","Bartın","Ardahan",
            "Iğdır","Yalova","Karabük","Kilis","Osmaniye","Düzce"};

    public static String[] getIller() {
        return iller;
    }

    public static void setIller(String[] iller) {
        SehirDatabase.iller = iller;
    }
}
