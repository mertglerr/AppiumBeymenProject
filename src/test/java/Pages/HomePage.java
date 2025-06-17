package Pages;

import Utilities.Driver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Utilities.Driver.driver;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }

    @AndroidFindBy(id = "com.google.android.apps.nexuslauncher:id/page_indicator")
    public WebElement mainpageswipeup;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Beymen\")")
    public WebElement beymenappclick;
    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]")
    public WebElement beymenlogokontrol;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Marka, ürün adı, kategori arayın\")")
    public WebElement searchboxclick;
    @AndroidFindBy(id = "com.mobisoft.beymen:id/search_bar_text")
    public WebElement searchboxclick2;



}
