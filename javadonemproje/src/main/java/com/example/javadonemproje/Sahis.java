package com.example.javadonemproje;

import java.util.ArrayList;

public class Sahis extends Musteri {
    private ArrayList<FaturaKalemi> sahisFatura=new ArrayList<>();
    private String ad;
    private String soyad;
    public Sahis(String ad,String soyad,long telefonNo, long vergiKimlikNo) {
        super(telefonNo, vergiKimlikNo);
        this.ad=ad;
        this.soyad=soyad;
    }



    @Override
    public void faturaEkle(FaturaKalemi fatura) {
        sahisFatura.add(fatura);
    }

    @Override
    public void faturaSil(FaturaKalemi fatura) {
        sahisFatura.remove(fatura);
    }

    @Override
    public double gelirHesapla() {
        double   toplamGelir=0;
        int size=sahisFatura.size();
        for(int i=0;i<size;i++){
            if (sahisFatura.get(i).getFaturaTuru()=="Satış"){
                toplamGelir+=sahisFatura.get(i).getToplamFiyat();
            }
        }
        return toplamGelir;
    }

    @Override
    public double giderHesapla() {
        double toplamGider=0;
        int size= sahisFatura.size();
        for(int i=0;i<size;i++){
            if (sahisFatura.get(i).getFaturaTuru()=="Alış"){
                toplamGider+=sahisFatura.get(i).getToplamFiyat();


            }
        }
        return toplamGider;
    }

    @Override
    public double kdvHesapla(int kdvOran) {
        double kdvOran1=(float)kdvOran/100;
        System.out.println("kdv oran :"+ kdvOran1);
        double odenecekKdv;
        double netKar=gelirHesapla()-giderHesapla();
        if (netKar>0){
            odenecekKdv=netKar*kdvOran1;
            return odenecekKdv;
        }
        else {
            odenecekKdv=0;
            return odenecekKdv;
        }


    }



    public ArrayList<FaturaKalemi> getSahisFatura() {
        return sahisFatura;
    }

    public void setSahisFatura(ArrayList<FaturaKalemi> sahisFatura) {
        this.sahisFatura = sahisFatura;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }
}
