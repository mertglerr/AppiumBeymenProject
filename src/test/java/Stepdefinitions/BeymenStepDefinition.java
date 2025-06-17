package Stepdefinitions;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductPage;
import Utilities.ExcelUtil;
import Utilities.FileUtil;
import Utilities.Methods;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Utilities.Methods.*;
import org.junit.Assert;
import org.junit.Assert.*;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;
import java.util.Random;

import static Utilities.Driver.driver;
import static Utilities.Driver.getDriver;
import static Utilities.Methods.*;


public class BeymenStepDefinition {

    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage= new CartPage();

    private static final Logger logger = LoggerFactory.getLogger(BeymenStepDefinition.class);
    @Given("kullanici Beymen uygulamasini acar")
    public void kullanici_beymen_uygulamasini_acar() {

        swipe(getDriver(),homePage.mainpageswipeup,"up",1,5000);
        Methods.wait(5);
        logger.info("Telefondan uygulamalar açıldı");
        clickGesture(getDriver(),homePage.beymenappclick);
        logger.info("Uygulamalardan Beymen App açıldı");
        Methods.wait(5);
        Assert.assertTrue(homePage.beymenlogokontrol.isEnabled());
        logger.info("Uygulamanın Beymen App olduğu anlaşıldı");


    }
    @When("arama kutucuguna excelden alinan {int}. sutun {int}. satirdaki veri girilir")
    public void arama_kutucuguna_excelden_alinan_sutun_satirdaki_veri_girilir(Integer int1, Integer int2) {
        clickGesture(getDriver(),homePage.searchboxclick);
        Methods.wait(2);
        logger.info("Beymen Anasayfasındaki Seacrhbox tıklanıldı.");
       String  keyword1 = ExcelUtil.getCellData(0,0);
       homePage.searchboxclick.sendKeys(keyword1);
       logger.info("excel 1.kelime alındı ve searchbox veri girildi.");
    }
    @When("arama kutucugu temizlenir sonra {int}. sutun {int}. satirdaki veri girilir")
    public void arama_kutucugu_temizlenir_sonra_sutun_satirdaki_veri_girilir(Integer int1, Integer int2) {
        homePage.searchboxclick2.clear();
        Methods.wait(2);
        String keyword2 = ExcelUtil.getCellData(1,0);
        homePage.searchboxclick2.sendKeys(keyword2);
        logger.info("excel 1.kelime temizlendi ve 2. kelime searchbox veri girildi.");
    }
    @When("enter tusuna basilir")
    public void enter_tusuna_basilir() {
        getDriver().pressKey(new KeyEvent(AndroidKey.ENTER));
        getDriver().hideKeyboard();
        logger.info("enter tuşuna basıldı.");
    }
    @When("rastgele bir urun secilir")
    public void rastgele_bir_urun_secilir() {
//        int index = new Random().nextInt(productPage.productlist.size());
        clickGesture(getDriver(),productPage.productlist.get(0));
        logger.info("ilk ürün seçiliyor.");
    }
    @Then("secilen urun bilgisi ve fiyati txt dosyasina yazilir")
    public void secilen_urun_bilgisi_ve_fiyati_txt_dosyasina_yazilir() {
        Methods.wait(2);
        clickGesture(getDriver(),productPage.productimageclick);
        logger.info("resmin üzerine basıldı.");
        Methods.wait(2);
        clickGesture(getDriver(),productPage.productimagenext.get(1));
        logger.info("Bir sonraki resim geçildi.");
        Methods.wait(2);
        clickGesture(getDriver(),productPage.productimagenext.get(1));
        logger.info("Bir sonraki resim geçildi.");
        Methods.wait(2);
        pinchOpen(getDriver(),productPage.productimageclick,0.5,500);
        logger.info("resime zoom yapıldı.");
        Methods.wait(1);
        pinchClose(getDriver(),productPage.productimageclick,0.5,500);
        logger.info("resime zoom uzaklaşıldı.");
        Methods.wait(1);
        clickGesture(getDriver(),productPage.productimageclose);
        logger.info("resimden çıkıldı.");
        Methods.wait(2);

        String productName = productPage.productinfo.get(2).getText();
        String price       = productPage.productinfo.get(3).getText();
        FileUtil.writeToFile(productName,price);
        logger.info("Ürün bilgileri başarıyla dosyaya yazıldı.");
    }
    @Then("urun sepete eklenir")
    public void urun_sepete_eklenir() {
        swipe(getDriver(),productPage.productswipe,"up",0.8,3500);
        Methods.wait(2);
        logger.info("ekran yukarı kaydırıldı");
        clickGesture(getDriver(), productPage.productbeden);
        Methods.wait(2);
        logger.info("beden seçildi");
        clickGesture(getDriver(), productPage.productsepetekle);
        Methods.wait(2);
        logger.info("sepete eklendi");
        getDriver().pressKey(new KeyEvent(AndroidKey.BACK));
        clickGesture(getDriver(), productPage.productsepetgit);
        Methods.wait(2);
        logger.info("sepete gidildi.");
    }
    @Then("urun sayfasindaki fiyat ile sepetteki fiyat karsilastirilir")
    public void urun_sayfasindaki_fiyat_ile_sepetteki_fiyat_karsilastirilir() {
        double cart1 = normalizePrice(cartPage.productprice.getText());
        double pricetotal1 = normalizePrice(cartPage.producttotalprice.getText());
        Assert.assertEquals("fiyatlar uyuşmuyor",cart1,pricetotal1,0.001);
        logger.info("sepette ürün fiyatı ile total sepet karşılaşırıldı.");
    }
    @Then("adet arttirilir ve adet {int} oldugu dogrulanir")
    public void adet_arttirilir_ve_adet_oldugu_dogrulanir(Integer int1) {
        clickGesture(getDriver(),cartPage.cartdropdown);
        Methods.wait(2);
        clickGesture(getDriver(), cartPage.cartdropdown2sec);
        logger.info("ürün adeti 2 yapıldı");
    }
    @Then("urun silinir ve sepetin bos oldugu kontrol edilir")
    public void urun_silinir_ve_sepetin_bos_oldugu_kontrol_edilir() {
        clickGesture(getDriver(), cartPage.cartclear);
        Methods.wait(2);
        logger.info("sepet boşaltıldı.");
        boolean cartempty1 = cartPage.cartempty.isDisplayed();
        Assert.assertTrue("sepet boş değil",cartempty1);
        logger.info("Boş olduğu kontrol edildi.");
    }


}
