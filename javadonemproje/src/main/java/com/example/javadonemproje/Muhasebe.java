package com.example.javadonemproje;

import java.util.ArrayList;

public class Muhasebe {
    private ArrayList<Sahis> sahisMusteri=new ArrayList<>();
    private  ArrayList<Firma> firmasMusteri=new ArrayList<>();
    public    void  sahisMusteriOlustur(String ad,String soyad,long telefonNo,long vergiKimlikNo){
        Sahis sahis=new Sahis(ad,soyad,telefonNo,vergiKimlikNo);
        sahisMusteri.add(sahis);
    }
    public   void firmaMusteriOlustur(String ad,long telefonNo,long vergiKimlikNo){
        Firma sahis=new Firma(ad,telefonNo,vergiKimlikNo);
        firmasMusteri.add(sahis);
    }
    public void MusteriSil(Firma müsteri){
        System.out.println(müsteri.getFirmaAdi()+" adli firma müsterisi silindi");
        getFirmasMusteri().remove(müsteri);
    }
    public void MusteriSil(Sahis müsteri){
        System.out.println(müsteri.getAd()+" adli sahis müsterisi silindi");
        getSahisMusteri().remove(müsteri);
    }


    public  void faturaOlustur(Musteri musteri, FaturaKalemi fatura){
        System.out.println("Fatura oluşturuldu.");

        musteri.faturaEkle(fatura);


    }
    public  void faturaSil(Musteri musteri, FaturaKalemi fatura){
        System.out.println("fatura silindi");
        musteri.faturaSil(fatura);
    }
    public  double gelirHesapla(Musteri musteri){
        double gelir=0;
        System.out.println("gelir hesaplandi");
        gelir= musteri.gelirHesapla();
        System.out.println("toplam gelir: "+gelir);
        return gelir;

    }
    public  double giderHesapla(Musteri musteri){
        double gider;
        System.out.println("gider hesaplandi");
        gider= musteri.giderHesapla();
        System.out.println("toplam gider: "+gider);
        return gider;

    }
    public  Double kdvHesapla(Musteri musteri, int kdvOran){
        double kdv;
        System.out.println("kdv hesaplandi");
        kdv= musteri.kdvHesapla(kdvOran);
        System.out.println("toplam kdv: "+kdv);
return kdv;
    }

    public ArrayList<Sahis> getSahisMusteri() {
        return sahisMusteri;
    }

    public void setSahisMusteri(ArrayList<Sahis> sahisMusteri) {
        this.sahisMusteri = sahisMusteri;
    }

    public ArrayList<Firma> getFirmasMusteri() {
        return firmasMusteri;
    }

    public void setFirmasMusteri(ArrayList<Firma> firmasMusteri) {
        this.firmasMusteri = firmasMusteri;
    }
}
