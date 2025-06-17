package Pages;

import Utilities.Driver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {

    public CartPage(){
        PageFactory.initElements(
                new AppiumFieldDecorator(Driver.getDriver()),this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"6,950.00 TL\"]")
    public WebElement productprice;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"6.950,00 TL\"]")
    public WebElement producttotalprice;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Dropdown menu\"]/android.view.View")
    public WebElement cartdropdown;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[2]")
    public WebElement cartdropdown2sec;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sil\"]")
    public WebElement cartclear;
@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"SEPETİNİZDE ÜRÜN BULUNMAMAKTADIR.\"]")
    public WebElement cartempty;


}
