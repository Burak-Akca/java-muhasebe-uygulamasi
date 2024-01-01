package com.example.javadonemproje;

public class FaturaKalemi {
    private String faturaSahibi;
    private String faturaTuru;

    private String urunAdi;
    private int miktar;
    private double birimFiyat;
    private double toplamFiyat;

    public FaturaKalemi(String faturaSahibi,String faturaTuru,String urunAdi, int miktar, double birimFiyat, double toplamFiyat) {
        this.urunAdi = urunAdi;
        this.miktar = miktar;
        this.birimFiyat = birimFiyat;
        this.toplamFiyat = toplamFiyat;
        this.faturaTuru=faturaTuru;
        this.faturaSahibi=faturaSahibi;
    }

    public String getFaturaTuru() {
        return faturaTuru;
    }

    public void setFaturaTuru(String faturaTuru) {
        this.faturaTuru = faturaTuru;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public double getBirimFiyat() {
        return birimFiyat;
    }

    public void setBirimFiyat(int birimFiyat) {
        this.birimFiyat = birimFiyat;
    }

    public double getToplamFiyat() {
        return toplamFiyat;
    }

    public void setToplamFiyat(int toplamFiyat) {
        this.toplamFiyat = toplamFiyat;
    }

    public String getFaturaSahibi() {
        return faturaSahibi;
    }

    public void setFaturaSahibi(String faturaSahibi) {
        this.faturaSahibi = faturaSahibi;
    }
}
