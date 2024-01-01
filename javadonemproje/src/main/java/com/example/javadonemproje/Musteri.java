package com.example.javadonemproje;

public abstract class Musteri {    private long telefonNo;
    private long vergiKimlikNo;
    public Musteri(long telefonNo, long vergiKimlikNo){
        this.telefonNo=telefonNo;
        this.vergiKimlikNo=vergiKimlikNo;
    }

    public abstract void faturaEkle(FaturaKalemi fatura);
    public abstract void faturaSil(FaturaKalemi fatura);
    public abstract  double gelirHesapla();
    public abstract  double giderHesapla();
    public  abstract  double kdvHesapla(int kdvOran);



    public long getTelefonNo() {
        return telefonNo;
    }

    public void setTelefonNo(int telefonNo) {
        this.telefonNo = telefonNo;
    }

    public long getVergiKimlikNo() {
        return vergiKimlikNo;
    }

    public void setVergiKimlikNo(int vergiKimlikNo) {
        this.vergiKimlikNo = vergiKimlikNo;
    }
}
