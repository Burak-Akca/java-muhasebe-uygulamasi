package com.example.javadonemproje;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class kayıtController {
    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
    private HelloController helloController;
    @FXML
    private TextField kayitText;
    @FXML
    private PasswordField kayitText1,kayitText2;
    @FXML
    private Stage stage;
    @FXML
    public void helloControllerAyarla(HelloController helloController) {
        this.helloController = helloController;
    }

    public void stageAyarla(Stage stage1){
        stage=stage1;
    }
    @FXML
    public void  iptal(){
        stage.close();
//kayıt ol sayfasında iptal butonuna basınca gerçekleşen event
    }


    @FXML
    public void kayıtTamam() {//kayıt ol ekranında tamam butonuna basılınca textfield değerleri alınıyor hellocontroller
        //sınıfına yollanıyor.(bu bilgiler hellocontroller sınıfında kullanılacağı için)
     String kullanici=kayitText.getText();
     String sifre=kayitText1.getText();
     String sifreDogrulama=kayitText2.getText();
     if (kullanici.isEmpty() && sifre.isEmpty() && sifreDogrulama.isEmpty()){
         errorAlert.setHeaderText("Input not valid");
         errorAlert.setContentText("Kullanıcı Adı Ve Şifre Bilgilerini Eksiksiz Giriniz");
         errorAlert.showAndWait();
     } else if (!(sifre.equals(sifreDogrulama))) {
         errorAlert.setHeaderText("Input not valid");
         errorAlert.setContentText("Şifreler Eşleşmiyor");
         errorAlert.showAndWait();


     } else {
         helloController.kayitTamam(kullanici,sifre);
         kayitText1.getScene().getWindow().hide();//kayıtText1 id li passwordFieldın bulunduğu scene kapatılıyor.
     }

    }

}
