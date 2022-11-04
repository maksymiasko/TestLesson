import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class YamaxTest {
//  TC_1_1 Test Case:
//  //1. Открыть страницу http://openweathermap.org/
//  //2. Набрать в строке поиска город Paris
//  //3. Нажать пункт меню Search
//  //4. Из выпадающего списка выбрать Paris, FR
//  //5. Подтвердить, что заголовок изменился на "Paris, FR"


    @Test
    // Что, Где, Когда
    public void testH2TestTeg_WhenSearchingCityCountry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "http://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);
        Thread.sleep(2000);
        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//input[@placeholder = 'Search city']"));
        Thread.sleep(2000);
        searchCityField.click();
        searchCityField.sendKeys(cityName);

        WebElement searchButton = driver.findElement(
                By.xpath("//button[@type = 'submit']"));
        searchButton.click();
        Thread.sleep(3000);

        WebElement parisFRChoiceInDropDownMenu = driver.findElement(
                By.xpath("//ul[@class = 'search-dropdown-menu']/li/span[text() = 'Paris, FR ']"));
        parisFRChoiceInDropDownMenu.click();
        Thread.sleep(2000);

        WebElement h2CityCountryHeader = driver.findElement(
                By.xpath("//div[@id = 'weather-widget'] //h2"));

        String actualResult = h2CityCountryHeader.getText();
        Thread.sleep(2000);

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //    TC_11_01
//1.  Открыть базовую ссылку
//2.  Нажать на пункт меню Guide
//3.  Подтвердить, что вы перешли на страницу со ссылкой https://openweathermap.org/guide
//    и что title этой страницы OpenWeatherMap API guide - OpenWeatherMap
    @Test
    // Что, Где, Когда
    public void testH1Teg_WhenRedirectingToGuidePage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult0 = "Guide";
        String expectedResult1 = "https://openweathermap.org/guide";
        String expectedResult2 = "OpenWeatherMap API guide - OpenWeatherMap";

        driver.get(url);
        Thread.sleep(2000);
        WebElement searchGuideElement = driver.findElement(
                By.xpath("//div[@id = 'desktop-menu']//li/a[@href='/guide']"));
        Thread.sleep(2000);

        searchGuideElement.click();
        Thread.sleep(2000);

        WebElement h1GuideHeader = driver.findElement(By.xpath("//h1[@class = 'breadcrumb-title']"));

        String actualResult0 = h1GuideHeader.getText();
        String actualResult1 = driver.getCurrentUrl();
        String actualResult2 = driver.getTitle();

        Assert.assertEquals(actualResult0, expectedResult0);
        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);

        driver.quit();
    }

    //    TC_11_02
//1.  Открыть базовую ссылку
//2.  Нажать на единицы измерения Imperial: °F, mph
//3.  Подтвердить, что температура для города показана в Фаренгейтах
    @Test
    // Что, Где, Когда
    public void testH2_confirmWhenPressingImperialF() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "http://openweathermap.org/";
        String expectedResult0 = "Imperial: °F, mph";
        String expectedResult1 = "F";

        driver.get(url);
        Thread.sleep(2000);

        WebElement searchImperialField = driver.findElement(
                By.xpath("//div[@class = 'switch-container']/div[3]"));
        Thread.sleep(2000);
        searchImperialField.click();
        String actualResult0 = searchImperialField.getText();

        WebElement searchFahrenheitSign = driver.findElement(
                By.xpath("//div[@id='weather-widget']//span[@class = 'heading']"));
        Thread.sleep(2000);
        String actualResult1 = searchFahrenheitSign.getText();
        actualResult1 = actualResult1.substring(actualResult1.length() - 1);

        Assert.assertEquals(actualResult0, expectedResult0);
        Assert.assertEquals(actualResult1, expectedResult1);

        driver.quit();
    }

    //    TC_11_03
//1. Открыть базовую ссылку
//2. Подтвердить, что внизу страницы есть панель с текстом
//3. Подтвердить, что на панели внизу страницы есть 2 кнопки “Allow all” и “Manage cookies”
    @Test
// Что, Где, Когда
    public void testConfirmationFooterInfo() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "http://openweathermap.org/";
        String expectedResult0 = "We use cookies which are essential for the site to work. " +
                "We also use non-essential cookies to help us improve our services. " +
                "Any data collected is anonymised. You can allow all cookies or manage them individually.";
        String expectedResult1 = "Allow all";
        String expectedResult2 = "Manage cookies";

        driver.get(url);
        Thread.sleep(2000);

        WebElement searchStickFooterPanelText = driver.findElement(
                By.xpath("//p[@class ='stick-footer-panel__description']"));
        Thread.sleep(2000);
        String actualResult0 = searchStickFooterPanelText.getText();

        WebElement searchButtonAllowAll = driver.findElement(
                By.xpath("//button[@class = 'stick-footer-panel__link']"));
        Thread.sleep(2000);
        String actualResult1 = searchButtonAllowAll.getText();

        WebElement searchButtonManageCookies = driver.findElement(
                By.xpath("//a[@href ='/cookies-settings']"));
        Thread.sleep(2000);
        String actualResult2 = searchButtonManageCookies.getText();

        Assert.assertEquals(actualResult0, expectedResult0);
        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);

        driver.quit();
    }

    //    TC_11_04
//1.  Открыть базовую ссылку
//2.  Подтвердить, что в меню Support есть 3 подменю с названиями “FAQ”, “How to start” и “Ask a question”
    @Test
// Что, Где, Когда
    public void testConfirmSupportSubMenu() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "http://openweathermap.org/";
        String expectedResult0 = "FAQ";
        String expectedResult1 = "How to start";
        String expectedResult2 = "Ask a question";

        driver.get(url);
        Thread.sleep(2000);

        WebElement searchSupportMenu = driver.findElement(
                By.xpath("//div[@id ='support-dropdown']"));
        Thread.sleep(2000);
        searchSupportMenu.click();

        WebElement searchFaqSubmenu = driver.findElement(
                By.xpath("//ul[@id='support-dropdown-menu']/li/a[@href = '/faq']"));
        Thread.sleep(2000);
        String actualResult0 = searchFaqSubmenu.getText();

        WebElement searchHowToStartSubmenu = driver.findElement(
                By.xpath("//ul[@id='support-dropdown-menu']/li/a[@href = '/appid']"));
        Thread.sleep(2000);
        String actualResult1 = searchHowToStartSubmenu.getText();

        WebElement searchAskAQuestSubmenu = driver.findElement(
                By.xpath("//ul[@id='support-dropdown-menu']" +
                        "/li/a[@href = 'https://home.openweathermap.org/questions']"));
        Thread.sleep(2000);
        String actualResult2 = searchAskAQuestSubmenu.getText();

        Assert.assertEquals(actualResult0, expectedResult0);
        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);

        driver.quit();
    }

    //    TC_11_05
//1.  Открыть базовую ссылку
//2.  Нажать пункт меню Support → Ask a question
//3.  Заполнить поля Email, Subject, Message
//4.  Не подтвердив CAPTCHA, нажать кнопку Submit
//5.  Подтвердить, что пользователю будет показана ошибка “reCAPTCHA verification failed, please try again.”
    @Test
// Что, Где, Когда
    public void testConfirmCaptchaVerificationFailed() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "http://openweathermap.org/";
        String email = "putin@huilo.com";
        String message = "test massage";
        String expectedResult = "reCAPTCHA verification failed, please try again.";

        driver.get(url);
        Thread.sleep(2000);

        WebElement searchSupportMenu = driver.findElement(
                By.xpath("//div[@id ='support-dropdown']"));
        Thread.sleep(2000);
        searchSupportMenu.click();

        WebElement searchAskAQuestSubmenu = driver.findElement(
                By.xpath("//ul[@id='support-dropdown-menu']" +
                        "/li/a[@href = 'https://home.openweathermap.org/questions']"));
        Thread.sleep(2000);
        searchAskAQuestSubmenu.click();

        String mainWindows = driver.getWindowHandle(); // getting Id of mainWindows
        for (String windowsHandle : driver.getWindowHandles()) {
            if (!mainWindows.contentEquals(windowsHandle)) {
                driver.switchTo().window(windowsHandle);
                break;
            }
        }
        WebElement searchEmailField = driver.findElement(
                By.xpath("//div[@class = 'col-sm-8']//input[@id='question_form_email']"));
        Thread.sleep(2000);
        searchEmailField.click();
        searchEmailField.sendKeys("putin@huilo.com");

        WebElement searchSubjectField = driver.findElement(
                By.xpath("//div[@class = 'col-sm-8']/select[@id='question_form_subject']"));
        Thread.sleep(2000);
        searchSubjectField.click();

        WebElement searchSubjectFieldText = driver.findElement(
                By.xpath("//div[@class = 'col-sm-8']/select[@id='question_form_subject']//option[7]"));
        Thread.sleep(2000);
        searchSubjectFieldText.click();
        Thread.sleep(2000);
        searchSubjectField.click();

        WebElement searchMassageField = driver.findElement(
              By.xpath("//textarea[@class = 'form-control text required']"));
        Thread.sleep(2000);
        searchMassageField.click();
        searchMassageField.sendKeys(message);

        WebElement searchSubmitButton = driver.findElement(
                By.xpath("//div[@class = 'col-sm-8']//input[@type ='submit']"));
        Thread.sleep(2000);
        searchSubmitButton.click();


        WebElement searchCaptchaMassage = driver.findElement(
                By.xpath("//div[@class = 'help-block']"));
        String actualResult = searchCaptchaMassage.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //    TC_11_06
//1.  Открыть базовую ссылку
//2.  Нажать пункт меню Support → Ask a question
//3.  Оставить значение по умолчанию в checkbox Are you an OpenWeather user?
//4.  Оставить пустым поле Email
//5.  Заполнить поля  Subject, Message
//6.  Подтвердить CAPTCHA
//7.  Нажать кнопку Submit
//8.  Подтвердить, что в поле Email пользователю будет показана ошибка “can't be blank”
    @Test
// Что, Где, Когда
    public void testConfirmErrorInEmailField() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "http://openweathermap.org/";
        String message = "another test message";
        String expectedResult = "can't be blank";

        driver.get(url);
        Thread.sleep(2000);

        WebElement searchSupportMenu = driver.findElement(
                By.xpath("//div[@id ='support-dropdown']"));
        Thread.sleep(2000);
        searchSupportMenu.click();

        WebElement searchAskAQuestSubmenu = driver.findElement(
                By.xpath("//ul[@id='support-dropdown-menu']" +
                        "/li/a[@href = 'https://home.openweathermap.org/questions']"));
        Thread.sleep(2000);
        searchAskAQuestSubmenu.click();

        String mainWindows = driver.getWindowHandle(); // getting Id of mainWindows
        for (String windowsHandle : driver.getWindowHandles()) {
            if (!mainWindows.contentEquals(windowsHandle)) {
                driver.switchTo().window(windowsHandle);
                break;
            }
        }

        WebElement searchSubjectField = driver.findElement(
                By.xpath("//div[@class = 'col-sm-8']/select[@id='question_form_subject']"));
        Thread.sleep(2000);
        searchSubjectField.click();

        WebElement searchSubjectFieldText = driver.findElement(
                By.xpath("//div[@class = 'col-sm-8']/select[@id='question_form_subject']//option[6]"));
        Thread.sleep(2000);
        searchSubjectFieldText.click();
        searchSubjectField.click();

        WebElement searchMessageField = driver.findElement(
                By.xpath("//textarea[@class = 'form-control text required']"));
        Thread.sleep(2000);
        searchMessageField.click();
        searchMessageField.sendKeys(message);

        String askQuestionWindow = driver.getWindowHandle();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        Thread.sleep(2000);
        WebElement searchCaptchaElement = driver.findElement(
                By.xpath("//div[@class='rc-anchor-center-container']"));
        searchCaptchaElement.click();
        Thread.sleep(7000);

        driver.switchTo().window(askQuestionWindow);

        WebElement searchSubmitButton = driver.findElement(
                By.xpath("//div[@class = 'col-sm-8']//input[@type ='submit']"));
        Thread.sleep(2000);
        searchSubmitButton.click();

        WebElement searchCantBeBlankMessage = driver.findElement(
                By.xpath("//span[@class = 'help-block']"));
        Thread.sleep(2000);
        String actualResult = searchCantBeBlankMessage.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

//    TC_11_07
//1.  Открыть базовую ссылку
//2.  Нажать на единицы измерения Imperial: °F, mph
//3.  Нажать на единицы измерения Metric: °C, m/s
//4.  Подтвердить, что в результате этих действий, единицы измерения температуры изменились с F на С
    @Test
    // Что, Где, Когда
    public void testConfirmImperialToMetricChange() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "http://openweathermap.org/";
        String expectedResult = "Metric: °C, m/s";

        driver.get(url);
        Thread.sleep(2000);

        WebElement searchImperialField = driver.findElement(
                By.xpath("//div[@class = 'switch-container']/div[3]"));
        Thread.sleep(2000);
        searchImperialField.click();

        WebElement searchMetricField = driver.findElement(
                By.xpath("//div[@class = 'switch-container']/div[2]"));
        Thread.sleep(2000);
        searchMetricField.click();
        Thread.sleep(2000);
        String actualResult = searchMetricField.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}
