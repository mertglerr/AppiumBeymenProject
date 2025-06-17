package Utilities;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

public class Methods {

    public static void wait(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickGesture(AndroidDriver driver, WebElement element){
        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }

    public static void swipe(AndroidDriver driver, WebElement element, String direction, double percent, int speed){
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", percent,
                "speed", speed
        ));
    }

    public static void pinchOpen(AndroidDriver driver, WebElement element, double percent,int speed ){

        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "percent", percent,
                "speed",speed
        ));
    }


    public static void pinchClose(AndroidDriver driver, WebElement element, double percent,int speed ){

        driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "percent", percent,
                "speed",speed
        ));
    }


    public static void isenablecontrol(List<WebElement> elements) {
        for (int i = 4; i < 8 ; i++) {
            if (elements.get(i).isEnabled()) {
                elements.get(i).click();
                break;
            }
        }
    }

    public static double parseFiyat(String price1) {
        // Örnek: "7.250,00 TL" → 7250.00
        price1 = price1.replace(" TL", "").replace(".", "").replace(",", ".");
        return Double.parseDouble(price1);
    }

    public static double normalizePrice(String priceText) {
        if (priceText == null || priceText.isEmpty()) {
            return 0.0;
        }

        priceText = priceText.trim().replaceAll("[^\\d.,]", ""); // TL, boşluk gibi karakterleri sil

        // Eğer hem nokta hem virgül varsa, bu US formatıdır: 6,950.00
        if (priceText.contains(",") && priceText.contains(".")) {
            if (priceText.lastIndexOf('.') > priceText.lastIndexOf(',')) {
                // 6,950.00 → binlik ayracı "," → kaldır
                priceText = priceText.replace(",", "");
            } else {
                // 6.950,00 → binlik "." → kaldır, "," → "."
                priceText = priceText.replace(".", "").replace(",", ".");
            }
        }
        // Sadece virgül varsa → 6950,00 → , ondalık ayırıcıdır
        else if (priceText.contains(",") && !priceText.contains(".")) {
            priceText = priceText.replace(",", ".");
        }

        return Double.parseDouble(priceText);
    }


}
