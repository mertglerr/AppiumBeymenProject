package Pages;

import Utilities.Driver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage {

    public ProductPage(){
        PageFactory.initElements(
                new AppiumFieldDecorator(Driver.getDriver()),this);
    }

    @AndroidFindBy(id = "com.mobisoft.beymen:id/ivProductImage")
    public List<WebElement> productlist;
    @AndroidFindBy(className = "android.widget.TextView")
    public List<WebElement> productinfo;
    @AndroidFindBy(className = "android.widget.ScrollView")
    public WebElement productswipe;
    @AndroidFindBy(className = "android.widget.ImageView")
    public WebElement productimageclick;
    @AndroidFindBy(className = "android.view.View")
    public List<WebElement> productimagenext;
    @AndroidFindBy(className = "android.widget.Button")
    public WebElement productimageclose;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"S\"]")
    public WebElement productbeden;
    @AndroidFindBy(className = "android.widget.Button")
    public WebElement productsepetekle;
    @AndroidFindBy(id = "com.mobisoft.beymen:id/navigation_cart")
    public WebElement productsepetgit;





}
