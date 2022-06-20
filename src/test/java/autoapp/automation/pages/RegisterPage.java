package autoapp.automation.pages;

import autoapp.automation.utility.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;


public class RegisterPage extends BasePage{

    public static String signIn_xpath = "//a[@title='Log in to your customer account']";
    public static String email_id = "email_create";
    public static String createAccount_xpath = "//form[@id='create-account_form']//span[1]";
    public static String dressesMain_xpath = "//div/ul/li/a[@title='Dresses']";
    public static String summerDressesMain_xpath = "//div/ul/li[2]//ul/li/a[@title='Summer Dresses']";
    public static String summerDressHead_xpath = "//span[@class='category-name']";
    public static String firstSummerDress_xpath = "//a[@title='Printed Summer Dress']//img[@src='http://automationpractice.com/img/p/1/2/12-home_default.jpg']";
    public static String printedSummerDress_xpath = "//div[@class='primary_block row']//div//h1[@itemprop='name']";
    public static String colourBlue_xpath = "//a[@id='color_14']";
    public static String addToCart_xpath = "//button[@class='exclusive']";
    public static String summaryProductName_xpath = "//span[@id='layer_cart_product_title']";
    public static String summaryColour_xpath = "//span[@id='layer_cart_product_attributes']";
    public static String summaryQuantity_xpath = "//span[@id='layer_cart_product_quantity']";

    public RegisterPage(BrowserDriver driver) {
        super(driver);
    }

    public static void openApplicaiton() {
        driver.navigate().to("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    public static void clickSignIn() {
        driver.findElement(By.xpath(signIn_xpath)).click();
    }

    public static void createAccount(String emailid) {
        emailid= emailid.replaceAll("Random", Integer.toString(generateRandomIntIntRange(00000, 99999)));
        driver.findElement(By.id(email_id)).sendKeys(emailid);
        driver.findElement(By.xpath(createAccount_xpath)).click();
    }

    public static void clickSummerDresses() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(dressesMain_xpath))).perform();
        driver.findElement(By.xpath(summerDressesMain_xpath)).click();
    }

    public static void checkSDHeading() {
        String pageHead = (driver.findElement(By.xpath(summerDressHead_xpath)).getText());
        Assert.assertEquals(pageHead,"Summer Dresses");
    }

    public static void clickFirstDress() {
        driver.findElement(By.xpath(firstSummerDress_xpath)).click();
    }

    public static void checkPSDHeading() {
        driver.switchTo().frame(0);
        String pageHead = (driver.findElement(By.xpath(printedSummerDress_xpath)).getText());
        Assert.assertEquals(pageHead,"Printed Summer Dress");
    }

    public static void clickBlue() {
        driver.findElement(By.xpath(colourBlue_xpath)).click();
    }

    public static void clickAddToCart() {
        driver.findElement(By.xpath(addToCart_xpath)).click();
    }

    public static void checkDressDetails() {
        driver.switchTo().defaultContent();
        String productName = (driver.findElement(By.xpath(summaryProductName_xpath)).getText());
        String colour = (driver.findElement(By.xpath(summaryColour_xpath)).getText());
        colour = colour.substring(0,colour.length()-3);
        String quantity = (driver.findElement(By.xpath(summaryQuantity_xpath)).getText());
        Assert.assertEquals(productName,"Printed Summer Dress");
        Assert.assertEquals(colour,"Blue");
        Assert.assertEquals(quantity,"1");
    }
}
