package com.example.javadonemproje;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloController {

    ArrayList<FaturaKalemi> sahislar = new ArrayList<>();
    ArrayList<FaturaKalemi> firmalar = new ArrayList<>();
    Muhasebe muhasebeci = new Muhasebe();
    private ObservableList Data = FXCollections.observableArrayList();


    @FXML
    private Stage stage;
    @FXML
    private ComboBox<String> faturaCombo, musteriCombo;
    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
    @FXML
    private Scene scene;

    @FXML
    private RadioButton sahis, firma;
    @FXML
    private TextField kdvOranText,kullaniciAdiGiris,text1,text2, text3, text4, musteriText1, musteriText3, musteriText2, musteriText4,giderText,kdvText;
  @FXML
  private PasswordField kullaniciSifre;
    @FXML
    private TableView<FaturaKalemi> table;
    @FXML
    private TableColumn<FaturaKalemi, Integer> miktar;
    @FXML
    private TableColumn<FaturaKalemi, String> faturaSahibi;
    @FXML
    private TableColumn<FaturaKalemi, String> urunAdi;
    @FXML
    private TableColumn<FaturaKalemi, Double> birimFiyat;

    @FXML
    private TextField gelirText;

    @FXML
    private Button girisbutton;
    @FXML
    private TableColumn<FaturaKalemi, String> faturaTuru;
    @FXML
    private TableColumn<FaturaKalemi, Double> toplamFiyat;

@FXML
private String kullanici,sifre;
    @FXML
    protected void secondStageGecis(ActionEvent e) throws IOException {
        System.out.println(kullanici+" "+sifre);
        if (kullaniciAdiGiris.getText().equals(kullanici) &&kullaniciSifre.getText().equals(sifre)){

            Parent root = FXMLLoader.load(getClass().getResource("secondStage.fxml"));
        stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        stage.setResizable(false);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();}
        else {
            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText("Kullanıcı Adı Veya Şifre Yanlış");
            errorAlert.showAndWait();
        }  }

@FXML
protected  void  kayıtOl(ActionEvent event) throws IOException {//kayıt ol butonuna basınca çalışır kayıt ol sayfasını açar

    FXMLLoader loader = new FXMLLoader(getClass().getResource("kayıt.fxml"));
    AnchorPane secondStageLayout = loader.load();


    kayıtController secondStageController = loader.getController();
    secondStageController.helloControllerAyarla(this);

    Stage secondStage = new Stage();
    secondStageController.stageAyarla(secondStage);

    secondStage.setTitle("Kayıt Ol");
    secondStage.initModality(Modality.WINDOW_MODAL);
    secondStage.initOwner(girisbutton.getScene().getWindow());

    // İkinci aşamayı göster
    secondStage.setScene(new Scene(secondStageLayout));
    secondStage.show();



}@FXML
    protected void kayitTamam(String kullanici1,String sifre1){
         kullanici=kullanici1;

        sifre=sifre1;//kayıt ol sayfasında girilen bilgiler bu fonksiyon aracılığıyla helloControllera aktarılır


        System.out.println(kullanici+"  "+sifre);
    }

    @FXML
    protected void engel() {
        text2.setDisable(true);//firma radio buttonu seçilirse soyad textfieldını kapatır
    }

    @FXML
    protected void engelKaldır() {
        text2.setDisable(false);
    }

    @FXML
    protected void musteriEkle(ActionEvent event) throws IOException {//müşteri ekle butonuna basınca çalışır

        if (sahis.isSelected() == false && firma.isSelected() == false) {

            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText("Bütün Alanları Doldurun");
            errorAlert.showAndWait();
//
        } else if (sahis.isSelected()) {
            if (!(text1.getText().isEmpty()) && !(text2.getText().isEmpty()) &&   !(text3.getText().isEmpty()) &&   !(text4.getText().isEmpty()) ){

            try {String ad = text1.getText();
                String soyad = text2.getText();
                long telefonNo = Long.parseLong(text3.getText());
                long vergiKimlikNo = Long.parseLong(text4.getText());
                int telefonNoUzunluk=text3.getText().length();
                int vergiKimliNoUzunluk=text4.getText().length();
                uzunlukKarsilastirma(telefonNoUzunluk,vergiKimliNoUzunluk);

                muhasebeci.sahisMusteriOlustur(ad, soyad, telefonNo, vergiKimlikNo);
                musteriCombo.getItems().add(ad);
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
//
                errorAlert.setHeaderText("Input not valid");
                errorAlert.setContentText("Telefon No ve Vergi Kimlik No Yerlerine Nümerik Değer Giriniz");
                errorAlert.showAndWait();

            }
            catch (telefonNoException | vergiNoException e){
                System.out.println(e.getMessage());

                errorAlert.setHeaderText("Input not valid");
                errorAlert.setContentText("Telefon Numarası 11 Haneli Vergi Kimlik Numarası 10 Haneli olacak şekilde girin");
                errorAlert.showAndWait();

            }

            }
else {
                errorAlert.setHeaderText("Input not valid");
                errorAlert.setContentText("Bütün Alanları Doldurun");
                errorAlert.showAndWait();
            }
        } else if (firma.isSelected()) {
            if (!(text1.getText().isEmpty()) && !(text3.getText().isEmpty()) && !(text4.getText().isEmpty())) {
              try {
                  String ad = text1.getText();

                  long telefonNo = Long.parseLong(text3.getText());
                  long vergiKimlikNo = Long.parseLong(text4.getText());
                  int telefonNoUzunluk=text3.getText().length();
                  int vergiKimliNoUzunluk=text4.getText().length();
                  uzunlukKarsilastirma(telefonNoUzunluk,vergiKimliNoUzunluk);
                  muhasebeci.firmaMusteriOlustur(ad, telefonNo, vergiKimlikNo);
                  musteriCombo.getItems().add(ad);
              }
                catch (NumberFormatException e){
                    System.out.println(e.getMessage());

                    errorAlert.setHeaderText("Input not valid");
                    errorAlert.setContentText("Telefon No ve Vergi Kimlik No Yerlerine Nümerik Değer Giriniz");
                    errorAlert.showAndWait();
                }
              catch (telefonNoException | vergiNoException e){
                  System.out.println(e.getMessage());
                  errorAlert.setHeaderText("Input not valid");
                  errorAlert.setContentText("Telefon Numarası 11 Haneli Vergi Kimlik Numarası 10 Haneli olacak şekilde girin");
                  errorAlert.showAndWait();


              }
            }
            else {
                errorAlert.setHeaderText("Input not valid");
                errorAlert.setContentText("Bütün Alanları Doldurun");
                errorAlert.showAndWait();
            }

        }
        text1.clear();
        text2.clear();
        text3.clear();
        text4.clear();
    }
protected void uzunlukKarsilastirma(int telefonNo,int vergiKimlikNo) throws telefonNoException, vergiNoException {
        if (telefonNo!=11){//telefon no ve vergi kimlik no ya girilen sayıların uzunluğu standartlara uygunmu diye kontrol edilir.
            throw new telefonNoException("Lütfen 11 Haneli Telefon Numarası Giriniz");
        } else if (vergiKimlikNo!=10) {
            throw new vergiNoException("Lütfen 10 Haneli Vergi Kimlik Numarası Giriniz");

        }
    {

    }

}


    int sayac=0;
    @FXML
    protected void comboEvent() {


        if (sayac==0){ObservableList<String> faturaCesit = FXCollections.observableArrayList("Satış", "Alış");
        faturaCombo.getItems().addAll(faturaCesit);}
        //faturaComboya ilk kez tıkladığımız zaman alış ve satış değerlerini comboboxa atar sayac değişkeninin kullanılmasının sebebi
        //bu işlemin bir kez yapılması istenmesi kullanılmadığı zaman her müşteri seçiminde at alta sonsuza kadar alış satış değerlerini ekliyor
        sayac+=1;
    }

    @FXML
    protected  void toplamFiyatDüzenle(){//bu fonksiyon birim fiyat ve ürün miktarına değer girildiği zaman çalışır ve toplam fiyat
        //textFieldına bu iki ifadenin çarpımını ekler
        String text1 = musteriText2.getText();
        String text2 = musteriText3.getText();
        if (text2.endsWith(".")){
            return;

        }
            int urunMiktar=0;
            double urunBirimFiyat=0;

        if (!text1.isEmpty() && !text2.isEmpty()) {
            try {
                urunMiktar=Integer.parseInt(text1);

                String gecici=text2;
                if (gecici.contains(".")){
                    urunBirimFiyat= doubleSayiDuzenle(gecici);
                }
                else{
                    urunBirimFiyat=Double.parseDouble(gecici);
                }


                double toplamFiyat = doubleSayiDuzenle(String.valueOf(urunBirimFiyat*urunMiktar));



                musteriText4.setText(String.valueOf(toplamFiyat));
            } catch (NumberFormatException e) {
                System.out.println("Geçersiz sayı formatı");
            }
        } else {
            musteriText4.clear();
        }


    }

    protected double doubleSayiDuzenle(String sayi){//parametre olarak verilen double ama stringe çevrilmiş sayıyı
        //  . dan sonra bir basamak olacak şekilde sayıyı  döndürür.
try{
    int noktaİndis;


    noktaİndis =sayi.indexOf(".");
    noktaİndis=noktaİndis+2;
    String yeniString= sayi.substring(0,noktaİndis);//verilen indisler arasındaki ifadeyi döndürür
    Double yeniSayi=Double.parseDouble(yeniString);
    System.out.println("yeni sayi "+yeniSayi);


    return yeniSayi;
}catch (Exception e){
    System.out.println(e.getMessage());

}


  return 0;  }


    @FXML
    protected void faturaEkle(ActionEvent event) throws IOException {
//seçili olan müşteriye fatura ekler(fatura ekle butonuna basınca çalışır)
try {
    String faturaSahibi = musteriCombo.getValue();
    if (faturaSahibi==null){
        errorAlert.setHeaderText("Input not valid");
        errorAlert.setContentText("Lütfen İşlem Yapılacak Müşteriyi Seçin");
        errorAlert.showAndWait();
        return;
    }
    String faturaTip = faturaCombo.getValue();
    if (faturaTip==null){
        errorAlert.setHeaderText("Input not valid");
        errorAlert.setContentText("Lütfen Fatura Tipi Seçiniz");
        errorAlert.showAndWait();

    }
   else {
        String urunAdi = musteriText1.getText();
        int  urunMiktar=Integer.parseInt(musteriText2.getText());
        double urunBirimFiyat;
       String gecici=musteriText3.getText();
       if (gecici.contains(".")){
           urunBirimFiyat= doubleSayiDuzenle(gecici);
       }
         else{
             urunBirimFiyat=Double.parseDouble(gecici);
       }

        double toplamFiyat = doubleSayiDuzenle(String.valueOf(urunBirimFiyat*urunMiktar));


         for (Sahis müsteri : muhasebeci.getSahisMusteri()) {
            if (müsteri.getAd().equals(faturaSahibi)) {
                FaturaKalemi fatura = new FaturaKalemi(faturaSahibi, faturaTip, urunAdi, urunMiktar, urunBirimFiyat, toplamFiyat);
                sahislar.add(fatura);
                muhasebeci.faturaOlustur(müsteri, fatura);
                Data.add(fatura);//müşteri sahıs müsteriyse bu işlemler yapılır
            }

        }
        for (Firma müsteri : muhasebeci.getFirmasMusteri()) {
            if (müsteri.getFirmaAdi().equals(faturaSahibi)) {
                FaturaKalemi fatura = new FaturaKalemi(faturaSahibi, faturaTip, urunAdi, urunMiktar, urunBirimFiyat, toplamFiyat);
                firmalar.add(fatura);
                muhasebeci.faturaOlustur(müsteri, fatura);
                Data.add(fatura);//firma müşterisi ise bu işlemler yapılır
            }

        }
    }


}catch (Exception e){

    System.out.println(e.toString());

    errorAlert.setHeaderText("Input not valid");
    errorAlert.setContentText("Fatura Bilgilerini Eksiksiz Ve Doğru Giriniz");
    errorAlert.showAndWait();
}

finally {
    musteriText1.clear();
    musteriText2.clear();
    musteriText3.clear();
    musteriText4.clear();

}



    }

    @FXML
    protected void gelirHesapla() {//seçili olan müşterinin satış faturalarının toplam tutarını textfieda yazar
        String str= musteriCombo.getValue();
        if (str==null){

            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText("Lütfen İşlem Yapılacak Müşteriyi Seçin");
            errorAlert.showAndWait();

        }
        else {
            gelirText.clear();
            String value = musteriCombo.getValue();
            for (Sahis müsteri : muhasebeci.getSahisMusteri()) {
                if (müsteri.getAd().equals(value)) {
                    double gelir = muhasebeci.gelirHesapla(müsteri);
                    gelir= doubleSayiDuzenle(String.valueOf(gelir));
                    gelirText.setText(String.valueOf(gelir));


                }

            }
            for (Firma müsteri : muhasebeci.getFirmasMusteri()) {
                if (müsteri.getFirmaAdi().equals(value)) {
                    double gelir = muhasebeci.gelirHesapla(müsteri);
                    gelir= doubleSayiDuzenle(String.valueOf(gelir));
                    gelirText.setText(String.valueOf(gelir));

                }

            }
        }

    }
    @FXML
    protected void musteriSil(){//seçili olan müşteri comboboxdan kaldırır,bütün faturalarınıda siler
        Sahis temp=null;
        String value= musteriCombo.getValue();
        if (value==null){
            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText("Lütfen İşlem Yapılacak Müşteriyi Seçin");
            errorAlert.showAndWait();
        }

        else {

            musteriCombo.getItems().remove(value);
            for (Sahis müsteri: muhasebeci.getSahisMusteri()) {
                if (müsteri.getAd().equals(value)){
                    temp=müsteri;
                    for (FaturaKalemi fatura:müsteri.getSahisFatura()) {
                        for (FaturaKalemi faturaKalemi:sahislar){
                            if (fatura==faturaKalemi){
                                Data.remove(faturaKalemi);
                            }
                        }
                    }

                }

            }
            if (temp!=null){
                muhasebeci.MusteriSil(temp);}
            Firma temp1=null;
            for (Firma müsteri: muhasebeci.getFirmasMusteri()) {
                if (müsteri.getFirmaAdi().equals(value)){
                    temp1=müsteri;
                    for (FaturaKalemi fatura:müsteri.getFirmaFatura()) {
                        for (FaturaKalemi faturaKalemi:firmalar){
                            if (fatura==faturaKalemi){
                                Data.remove(faturaKalemi);
                            }
                        }
                    }

                }

            }
            if (temp1!=null){
                muhasebeci.MusteriSil(temp1);}
        }

    }





@FXML

protected  void giderHesapla(){//secili olan müsterinin alış faturalarının toplam tutarını textfielda yazdırır
          String str= musteriCombo.getValue();
    if (str==null){

        errorAlert.setHeaderText("Input not valid");
        errorAlert.setContentText("Lütfen İşlem Yapılacak Müşteriyi Seçin");
        errorAlert.showAndWait();

    }
    else {
        giderText.clear();
        String value = musteriCombo.getValue();
        for (Sahis müsteri : muhasebeci.getSahisMusteri()) {
            if (müsteri.getAd().equals(value)) {

                double gider = muhasebeci.giderHesapla(müsteri);
                gider= doubleSayiDuzenle(String.valueOf(gider));
                giderText.setText(String.valueOf(gider));

            }

        }
        for (Firma müsteri : muhasebeci.getFirmasMusteri()) {
            if (müsteri.getFirmaAdi().equals(value)) {
                double gider = muhasebeci.giderHesapla(müsteri);
                gider= doubleSayiDuzenle(String.valueOf(gider));
                giderText.setText(String.valueOf(gider));

            }

        }
    }

}
@FXML
protected void kdvHesapla(){//müsterinin ödemesi gereken kdv yi kdv oranı üzerinden hesaplar
        String str= musteriCombo.getValue();
        if (str==null){

            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText("Lütfen İşlem Yapılacak Müşteriyi Seçin");
            errorAlert.showAndWait();

        }

        else {
            if (kdvOranText.getText().isEmpty()){
                errorAlert.setHeaderText("Input not valid");
                errorAlert.setContentText("Kdv Oranına Değer Giriniz");
                errorAlert.showAndWait();
            }
            else {int kdvOran = 0;
                try {
                    System.out.println(kdvOranText.getText());
                    kdvOran = Integer.parseInt(kdvOranText.getText());
                    kdvText.clear();
                    kdvOranText.clear();
                    String value = musteriCombo.getValue();
                    for (Sahis müsteri : muhasebeci.getSahisMusteri()) {
                        if (müsteri.getAd().equals(value)) {
                            Double kdv = muhasebeci.kdvHesapla(müsteri, kdvOran);
                            kdv= doubleSayiDuzenle(String.valueOf(kdv));
                            kdvText.setText(String.valueOf(kdv));

                        }

                    }
                    for (Firma müsteri : muhasebeci.getFirmasMusteri()) {
                        if (müsteri.getFirmaAdi().equals(value)) {
                            Double kdv = muhasebeci.kdvHesapla(müsteri, kdvOran);
                            kdv= doubleSayiDuzenle(String.valueOf(kdv));
                            kdvText.setText(String.valueOf(kdv));
                        }

                    }

                }
                catch (Exception e){
                    errorAlert.setHeaderText("Input not valid");
                    errorAlert.setContentText("Kdv oranına  Tam Sayı  değer giriniz");
                    errorAlert.showAndWait();
                }




            }
        }

}

    @FXML
    protected void faturaGoster() {//binding işlemi yapar data observable listinin içeriği değiştkçe tabloda değişir
        faturaSahibi.setCellValueFactory(new PropertyValueFactory<FaturaKalemi, String>("faturaSahibi"));
        faturaTuru.setCellValueFactory(new PropertyValueFactory<FaturaKalemi, String>("faturaTuru"));
        urunAdi.setCellValueFactory(new PropertyValueFactory<FaturaKalemi, String>("urunAdi"));
        miktar.setCellValueFactory(new PropertyValueFactory<FaturaKalemi, Integer>("miktar"));
        birimFiyat.setCellValueFactory(new PropertyValueFactory<FaturaKalemi, Double>("birimFiyat"));
        toplamFiyat.setCellValueFactory(new PropertyValueFactory<FaturaKalemi, Double>("toplamFiyat"));
        table.setItems(Data);
    }

    @FXML
    protected void faturaSil() {//tablodaki seçili oolan faturayı siler


    TableView.TableViewSelectionModel<FaturaKalemi> secilenSatir = table.getSelectionModel();
    if (secilenSatir.isEmpty()){


        errorAlert.setHeaderText("Input not valid");
        errorAlert.setContentText("Lütfen İşlem Yapılacak Faturayı Seçiniz");
        errorAlert.showAndWait();




    }
    else {



        FaturaKalemi nesne=secilenSatir.getSelectedItem();//secilen satırdaki nesneyi nesne değişkenine atar
        if (nesne != null) {//null değilse muhasebeci nesnesi üzerinden fatura silinir.


            String faturaSahibi = nesne.getFaturaSahibi();
            String faturaTip = nesne.getFaturaTuru();

            String urunAdi = nesne.getUrunAdi();
            int urunMiktar = nesne.getMiktar();
            double urunBirimFiyat = nesne.getBirimFiyat();
            double toplamFiyat = nesne.getToplamFiyat();

            for (Sahis müsteri : muhasebeci.getSahisMusteri()) {
                if (müsteri.getAd().equals(faturaSahibi)) {
                    for (FaturaKalemi fatura : sahislar) {
                        if (fatura.getFaturaSahibi() == faturaSahibi && fatura.getFaturaTuru() == faturaTip && fatura.getUrunAdi() == urunAdi && fatura.getMiktar() == urunMiktar && fatura.getToplamFiyat() == toplamFiyat && fatura.getBirimFiyat() == urunBirimFiyat) {
                            muhasebeci.faturaSil(müsteri, fatura);
                        }
                    }


                }
            }

            for (Firma müsteri : muhasebeci.getFirmasMusteri()) {
                if (müsteri.getFirmaAdi().equals(faturaSahibi)) {
                    for (FaturaKalemi fatura : firmalar) {
                        if (fatura.getFaturaSahibi() == faturaSahibi && fatura.getFaturaTuru() == faturaTip && fatura.getUrunAdi() == urunAdi && fatura.getMiktar() == urunMiktar && fatura.getToplamFiyat() == toplamFiyat && fatura.getBirimFiyat() == urunBirimFiyat) {
                            muhasebeci.faturaSil(müsteri,fatura);
                        }


                    }
                }
            }


        } else {
            System.out.println("bos deger");
        }



        int silinecekİndis = secilenSatir.getSelectedIndex();//secilen satırının indisini döner
        secilenSatir.clearSelection(silinecekİndis);//seçilen ifade mavi bir renk alır bu ifade onu kaldırır
            table.getItems().remove(silinecekİndis);//tabledan satır silinir


}
}}
