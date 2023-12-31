package Appium;

import BaseClass.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.AssertJUnit.*;

public class Appium01 extends BaseClass {
    @Test
    public void test1() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2); // optinal
        options.setDeviceName("RealDevice");
        options.setPlatformVersion("13");
        options.setApp(System.getProperty("user.dir")+"/src/Apps/Gesture_Tool_1.3_Apkpure.apk");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
        Thread.sleep(3000);
        WebElement addGesture = driver.findElement(By.id("com.davemac327.gesture.tool:id/addButton"));
        addGesture.click();
        WebElement addGestureInput = driver.findElement(By.id("com.davemac327.gesture.tool:id/gesture_name"));
        addGestureInput.sendKeys("denemeJava");
        driver.findElement(By.id("com.davemac327.gesture.tool:id/gestures_overlay")).click();
        Thread.sleep(1000);
        WebElement doneButton = driver.findElement(By.id("com.davemac327.gesture.tool:id/done"));
        doneButton.click();
    }

    @Test
    public void test2() throws MalformedURLException, InterruptedException {
        AndroidDriver driver= getDriver_RealDevice();



        // Wait for the app to load
        ReusableMethods.bekle(3);

        // Navigate to Amazon.com.tr
        driver.get("https://www.amazon.com.tr");

        WebElement signIn=driver.findElement(By.xpath("//android.widget.TextView[@text='Giriş Yap ›']"));
        signIn.click();

        WebElement hosGeldiniz=driver.findElement(By.xpath("//android.widget.TextView[@text='Hoş Geldiniz']"));
        assertTrue((hosGeldiniz.isDisplayed()) == false);



    }
}
