package Selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


import static Selenium.waitForTimeout.isElementPresent;
import static org.junit.Assert.fail;


/**
 * Created by noise on 30.05.17.
 */
public class Sampler {

    static protected WebDriver driver;

//создание переменной акта проверки
    static public String ackNumber;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
//указываю где лежит драйвер для браузера
        System.setProperty(variablesNadzor.browserFirefox, variablesNadzor.geckodriver);
//указываю путь к профилю с настройками браузера
        FirefoxProfile profile = new FirefoxProfile(variablesNadzor.profile);
//запуск браузера
        driver = new FirefoxDriver(profile);
//развернуть во весб экран
        driver.manage().window().maximize();
//устанавливаю время ожидания для окон
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//уточнить
//переход на нужную ссылку
        driver.get(variablesNadzor.URL);


        screenShot.screen(new Exception().getStackTrace()[0].getMethodName());

        /*
        * Необходимо отключить скачивание адднонов
        * addons.productaddons
        */
    }

    @Test(priority = 1)
    public void authorization() throws Exception {
//нажатие кнопки подтверждения при заходе на экран авторизации
        driver.findElement(By.id("userAgreementFormSubmit")).click();
//ввод логина и пароля
        driver.findElement(By.id("username")).sendKeys(variablesNadzor.login);
        driver.findElement(By.id("password")).sendKeys(variablesNadzor.passworld);
//нажатие кнопки Вход
        driver.findElement(By.id("loginFormSubmit")).click();
//ожидание загрузки подразделений

        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout to wait Subdivizion");
            try {
                if (isElementPresent(variablesNadzor.subdivizionID)) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
//выбор подразделения
        driver.findElement(variablesNadzor.subdivizionID).click();
//ожидание загрузки ЕИС
        new waitForTimeout();

        screenShot.screen(new Exception().getStackTrace()[0].getMethodName());
    }

    @Test (priority = 2, dependsOnMethods = {"authorization"})
    public void goToTestingSertificates() throws Exception {
//нажатие на кнопку "Учет недостатков"
        driver.findElement(variablesNadzor.linkLimitations).click();
//ожидание появления ссылки "Акты выявленных недостатков"
        new waitForTimeout(variablesNadzor.linkTestingSertificate, variablesNadzor.linkTestingSertificate);
//нажатие на кнопку "Акты проверки"
        driver.findElement(variablesNadzor.linkTestingSertificate).click();
//ожидание загрузки списка Актов
        new waitForTimeout(variablesNadzor.listOfTestSertificaite, variablesNadzor.listOfTestSertificaite);

        screenShot.screen(new Exception().getStackTrace()[0].getMethodName());
    }

    @Test (priority = 3, dependsOnMethods = {"goToTestingSertificates"})
    public void createTestingSertificateLimitations() throws Exception {
//нажать кнопку "Создать"
        driver.findElement(By.xpath("//div[@id='ButtonCreate']")).click();
//ожидание загрузки шаблона документа
        new waitForTimeout(variablesNadzor.testSertificaiteFerstElement, variablesNadzor.testSertificaiteSecondElement);

//нажать кнопку "Вид проверки"
        driver.findElement(By.xpath("//div[contains(text(), 'Вид проверки')]/../div[2]")).click();
//ожидание появления видов проверок
        new waitForTimeout(variablesNadzor.choiceVerification);
//нажать на нужный вид проверки
        driver.findElement(variablesNadzor.choiceVerification).click();
//нажать на "Вид проверки"
        driver.findElement(By.xpath("//div[contains(text(), 'Вид проверки')]/../div[2]")).click();

//нажать кнопку "ОДХ"
        driver.findElement(By.xpath("//div[contains(text(), 'ОДХ')]/../div[2]")).click();
//нажать на нужный ОДХ
        driver.findElement(variablesNadzor.choiceODH).click();
//нажать кнопку "ОДХ"
        driver.findElement(By.xpath("//div[contains(text(), 'ОДХ')]/../div[2]")).click();

//нажать кнопку "Тип объекта надзора"
        driver.findElement(By.xpath("//div[contains(text(), 'Тип объекта надзора')]/../div[2]")).click();
//нажать на нужный тип объекта надзора
        driver.findElement(variablesNadzor.choiceObjectControl).click();
//нажать кнопку "Тип объекта надзора"
        driver.findElement(By.xpath("//div[contains(text(), 'Тип объекта надзора')]/../div[2]")).click();

//Ожидание загрузки "Тип нарушений"
        new waitForTimeout();
//нажать кнопку "Тип нарушений"
        driver.findElement(By.xpath("//div[contains(text(), 'Тип нарушения')]/../div[2]")).click();
//нажать на нужный тип нарушения
        driver.findElement(variablesNadzor.choiceTypeViolation).click();
//нажать кнопку "Тип нарушений"
        driver.findElement(By.xpath("//div[contains(text(), 'Тип нарушения')]/../div[2]")).click();

        screenShot.screen(new Exception().getStackTrace()[0].getMethodName());
    }

    @Test (priority = 4, dependsOnMethods = {"createTestingSertificateLimitations"})
    public void createTestingSertificateTotalInformation() throws Exception {

//нажать кнопку "Общие данные"
        driver.findElement(By.xpath("//div[@class='data']//tr[@id='1']")).click();

//ожидание перехода на вкладку "Общие данные"
        new waitForTimeout(By.xpath("//div[@id='MainAddressHolder_num']"));

//Добавление адреса
//нажать кнопку "Выбрать"
        driver.findElement(By.xpath("//div[@id='MainAddressHolder_num']/div[2]")).click();

//ожидание загрузки окна выбора адреса
        new waitForTimeout();

//заполнение графы "Территория"
//нажать на поиск поля "Территория"
        driver.findElement(By.xpath("//div[@id='contractSearchHolder_Content']/div/div[2]//div[contains(@class, 'FindImage')]")).click();
//ввести нужной территории
        driver.findElement(By.xpath("//div[@id='contractSearchHolder_Content']/div/div[2]//div[contains(@class, 'TextBox')]"))
                .sendKeys(variablesNadzor.findTerritory);
//ожадание появления нужной территории
        new waitForTimeout(By.xpath("//span[contains(text(), '" + variablesNadzor.findTerritory + "')]"));
//нажать на нужную территорию
        driver.findElement(By.xpath("//span[contains(text(), '" + variablesNadzor.findTerritory + "')]")).click();
//закрыть поле "Территория"
        driver.findElement(By.xpath("//div[@id='contractSearchHolder_Content']/div/div[2]")).click();

//заполнение графы "Округ и район"
//нажать на поиск поля "Округ и район"
        driver.findElement(By.xpath("//div[@id='contractSearchHolder_Content']/div[2]/div[2]//div[contains(@class, 'FindImage')]")).click();
//ввести нужный оруг
        driver.findElement(By.xpath("//div[@id='contractSearchHolder_Content']/div[2]/div[2]//div[contains(@class, 'TextBox')]"))
                .sendKeys(variablesNadzor.findDistrict);
//ожадание появления округа
        new waitForTimeout(By.xpath("//span[contains(text(), '" + variablesNadzor.findDistrict + "')]"));
//нажать на нужный округ
        driver.findElement(By.xpath("//span[contains(text(), '" + variablesNadzor.findDistrict + "')]")).click();
//закрыть поле "Округ и район"
        driver.findElement(By.xpath("//table[@class='WindowTable']//div[@id='contractSearchHolder_Content']/div[2]/div[2]")).click();

//нажать кнопку "Поиск"
        driver.findElement(By.xpath("//table[@class='WindowTable']//div[@id='StartButtonAddress']")).click();
//ожидание появления адресов
        new waitForTimeout();

//нажать на нужный адрес по ID
        driver.findElement(variablesNadzor.choiceAdress).click();

        screenShot.screen(new Exception().getStackTrace()[0].getMethodName());
    }

    @Test (priority = 5, dependsOnMethods = {"createTestingSertificateTotalInformation"})
    public void createTestingSertificateDocuments() throws Exception {

//нажать на кнопку "Документы"
        driver.findElement(By.xpath("//div[@class='data']//tr[@id='3']")).click();
//ожидание загрузка документов
        new waitForTimeout(By.xpath("//div[contains(text(),'Добавить документ')]"));

//нажать кнопку "Добавить документ"
        driver.findElement(By.xpath("//div[contains(text(),'Добавить документ')]")).click();
//ожидание загрузки окна добавления документов
        new waitForTimeout(By.xpath("//div[@class='Content']//div[contains(text(),'Вид документа')]/../div[2]"));


//нажать на поле "Вид документа"
        driver.findElement(By.xpath("//div[@class='Content']//div[contains(text(),'Вид документа')]/../div[2]")).click();
//ожидание загрузки списка документов
        new waitForTimeout(variablesNadzor.choiceKindDocument);
//нажать на вид документа "Фотография"
        driver.findElement(variablesNadzor.choiceKindDocument).click();
//закрыть список "Вид документа"
        driver.findElement(By.xpath("//div[@class='Content']//div[contains(text(),'Вид документа')]/../div[2]")).click();

//добавление фотографии в поле
        try {
            driver.findElement(By.xpath("//form[@id='uploadForm']/div/input")).sendKeys(variablesNadzor.testPicture);
        } catch (Exception e) {
            System.out.println(e);
            driver.quit();
        }
//ожидание загрузки фотографии
        new waitForTimeout(By.xpath("//div[@class='fuLabel']"));

//нажать кнопку "Сохранить" документ
        driver.findElement(By.xpath("//div[@class='Content']//div[contains(text(),'Сохранить')]")).click();

//ожидание появления сообщения об сохранении фото
        new waitForTimeout(By.xpath("//div[@class='Content']//div[contains(@id, 'Button')]"));
//клик по кнопке "сохранить"  фото
        driver.findElement(By.xpath("//div[@class='Content']//div[contains(@id,'Button')]")).click();

//ожидание закрытия окна сохранения фото
        new waitForTimeout();

        screenShot.screen(new Exception().getStackTrace()[0].getMethodName());
    }

    @Test (priority = 6, dependsOnMethods = {"createTestingSertificateDocuments"})
    public void createTestingSertificateClose() throws Exception {
//нажать кнопку "Закрыть"
        driver.findElement(By.xpath("//div[@id='ButtonsAction']//div[contains(text(),'Закрыть')]")).click();
//ожидание появления окна подтверждения закрытия документа
        new waitForTimeout(By.xpath("//table[@class='WindowTable']//div[contains(text(),'Нет')]"));

/**нажать на кнопку "Да" или "Нет"*/
        driver.findElement(By.xpath("//table[@class='WindowTable']//div[contains(text(),'Да')]")).click();

//ожидание загрузки списка актов
        new waitForTimeout(By.xpath("//div[@id='TableResultSearch']/div"));

//сохранение номера акта проверки
        if (isElementPresent(By.xpath("//div[@class='MessageText']/div/div"))){
            ackNumber = driver.findElement(By.xpath("//div[@class='MessageText']/div/div")).getText();
            driver.findElement(By.xpath("//table[@class = 'WindowTable']//div[contains(text(),'OK')]"));//кнопка ОК английскими буквами
        }
        else
            ackNumber = "Акт не сохранен";

        System.out.println(ackNumber);

        saveFile.saveTest();

        screenShot.screen(new Exception().getStackTrace()[0].getMethodName());
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }
}
