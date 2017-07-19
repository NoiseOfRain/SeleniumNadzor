package Selenium;

import org.openqa.selenium.By;

/**
 * Created by noise on 02.06.17.
 *
 * В переменные добавил только те, которые можно менять
 *
 */
public class variablesNadzor {
    /**
     * Глобальные переменные
     */

//URL куда переходить
    public static String URL = "https://security.gibdd.local:8282/cas/login?service=http%3A%2F%2Fnadzor.gibdd.local%2Fais_eip_nadzor";
//путь сохранения cкриншотов падения
    public static String fallWay = "/home/noise/Документы/TestNadzor/src/main/resources/screenshots/";
//путь сохранения скриншотов
    public static String screenshotsWay = "/home/noise/Документы/TestNadzor/src/main/resources/screenshots/";
//путь сохранеия номеров акта
    public static String documentWay = "/home/noise/Документы/TestNadzor/src/main/resources/logs/savedActs.txt";

    /**
     * Авторизация
     */
//данные для авторизации
    public static String login = "dps_sev";
    public static String passworld = "Qwerty123";
    public static By subdivizionID = By.xpath("//li/a[contains(text(), '45612')]");//Подразделение

//локатор ожидания загрузки старницы
    public static By progressTime = By.xpath("//div[@id='ProgressTimeout']");

    /**
     * Акт проверки
     */
//локаторы для перехода на экран актов
    public static By linkLimitations = By.xpath("//tbody//td//div[contains(text(), 'Учет недостатков')]");//кнопка учет недостатков
    public static By linkTestingSertificate = By.linkText("Акты выявленных недостатков");//кнопка акты проверки

//локатор списка актов, для ожидания загрузки страницы со списком актов
    public static By listOfTestSertificaite= By.xpath("//div[@id='TableResultSearch']//tbody");

//локаторы для загрузки шаблона документов
    public static By testSertificaiteFerstElement = By.xpath("//div[@id='TableResultSearch']");
    public static By testSertificaiteSecondElement = By.xpath("//div[@id='LeftSplitPanel']");

//локаторы для создания акта проверки

    public static By choiceVerification = By.xpath("//div[contains(@id, 'DropPanel')]//tr[@id='736']");//выбор Вида проверки
    public static By choiceODH = By.xpath("//div[contains(@id, 'DropPanel')]//tr[@id='10002045']");//выбор ОДХ

    public static By choiceObjectControl = By.xpath("//div[contains(@id, 'DropPanel')]//tr[@id='903']");//выбор Тип объекта надзора
    public static By choiceTypeViolation = By.xpath("//div[contains(@id, 'DropPanel')]//tr[@id='977']");//выбор Тип нарушения Зависит от объекта!!!


    public static String findTerritory = "Москва";//выбор Территории
    public static String findDistrict = "Вороновское";//выбор Территории

    public static By choiceAdress = By.xpath("//div[@class='Content']/div/div[2]/div//tr[5]/td/div/div/div");//выбор нужного адреса

    public static By choiceKindDocument = By.xpath("//span[contains(text(),'Фотография')]");//выбор вида документа

    public static String testPicture = "/home/noise/Изображения/selenium.jpeg";//фотография для добавления


}
