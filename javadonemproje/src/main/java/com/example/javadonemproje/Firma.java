package com.example.javadonemproje;

import java.util.ArrayList;

public class Firma extends Musteri {

    private String firmaAdi;
    private ArrayList<FaturaKalemi> firmaFatura=new ArrayList<>();
    public Firma(String firmaAdi,long telefonNo, long vergiKimlikNo) {
        super(telefonNo, vergiKimlikNo);
        this.firmaAdi=firmaAdi;
    }


    @Override
    public void faturaEkle(FaturaKalemi fatura) {
        firmaFatura.add(fatura);
    }

    @Override
    public void faturaSil(FaturaKalemi fatura) {
        firmaFatura.remove(fatura);
    }

    @Override
    public double gelirHesapla() {
        double toplamGelir=0;
        int size=firmaFatura.size();
        for(int i=0;i<size;i++){
            if (firmaFatura.get(i).getFaturaTuru()=="Satış"){
                toplamGelir+=firmaFatura.get(i).getToplamFiyat();
            }
        }
        return toplamGelir;
    }

    @Override
    public double giderHesapla() {
        double toplamGider=0;
        int size= firmaFatura.size();
        for (int i=0;i<size;i++){
            if (firmaFatura.get(i).getFaturaTuru()=="Alış"){
                toplamGider+=firmaFatura.get(i).getToplamFiyat();

            }
        }
        return toplamGider;
    }

    @Override
    public double kdvHesapla(int kdvOran) {
        double kdvOran1=(float)kdvOran/100;
        double odenecekKdv;
        double netKar=gelirHesapla()-giderHesapla();
        System.out.println("kdv oran: "+kdvOran1);
        if (netKar>0){
            odenecekKdv=netKar*kdvOran1;
            return odenecekKdv;
        }
        else {
            odenecekKdv=0;
            return odenecekKdv;
        }



    }



    public String getFirmaAdi() {
        return firmaAdi;
    }

    public void setFirmaAdi(String firmaAdi) {
        this.firmaAdi = firmaAdi;
    }

    public ArrayList<FaturaKalemi> getFirmaFatura() {
        return firmaFatura;
    }

    public void setFirmaFatura(ArrayList<FaturaKalemi> firmaFatura) {
        this.firmaFatura = firmaFatura;
    }
}
