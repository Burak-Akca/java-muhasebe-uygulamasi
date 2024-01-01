package com.example.javadonemproje;

public class Test {
    public static void main(String[] args) {
        Muhasebe m1=new Muhasebe();
Sahis s1=new Sahis("ali","ucak",5364578888L,1111111111L);
        m1.sahisMusteriOlustur(s1.getAd(),s1.getSoyad(),s1.getTelefonNo(),s1.getVergiKimlikNo());
        FaturaKalemi f1=new FaturaKalemi("ali","Satış","masa",5,4,200);
        FaturaKalemi f2=new FaturaKalemi("ali","Alış","kitap",10,15,100);
m1.faturaOlustur(m1.getSahisMusteri().get(0),f1);
m1.faturaOlustur(m1.getSahisMusteri().get(0),f2);
       m1.gelirHesapla(m1.getSahisMusteri().get(0));
        m1.giderHesapla(m1.getSahisMusteri().get(0));
        m1.kdvHesapla(m1.getSahisMusteri().get(0),20);
        m1.faturaSil(m1.getSahisMusteri().get(0),m1.getSahisMusteri().get(0).getSahisFatura().get(0));
        m1.gelirHesapla(m1.getSahisMusteri().get(0));
        m1.giderHesapla(m1.getSahisMusteri().get(0));
        m1.MusteriSil(m1.getSahisMusteri().get(0));
        System.out.println(m1.getSahisMusteri().size());

        //aynı şeyler firma müsterisi içinde geçerli




    }
}
