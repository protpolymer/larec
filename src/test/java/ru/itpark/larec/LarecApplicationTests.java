package ru.itpark.larec;

//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
//import ru.itpark.larec.entity.ExperimentEntity;
//import ru.itpark.larec.repository.ExperimentRepository;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LarecApplicationTests {
//    private static WebDriver webDriver;
//
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private ExperimentRepository experimentRepository;
//
//    @BeforeAll
//    public static void beforeAll() {
//        WebDriverManager.firefoxdriver().setup();
//        FirefoxOptions options = new FirefoxOptions();
//        webDriver = new FirefoxDriver(options);
//    }
//
//    @Test
//    public void displaysMainPage() {
//        webDriver.get("http://localhost:" + port);
//        webDriver.findElement(By.className("no-experiments"));
//    }
//
//    @Test
//    @DirtiesContext
//    public void searchByName() {
//        experimentRepository.saveAll(List.of(
//                new ExperimentEntity(
//                        1,
//                        "C3H8O3 + CH4N2O = C4H6O4 + NH3",
//                        "Синтез глицеролкарбоната на цеолитах, модифицированных лантаном",
//                        "1.11.2016",
//                        null,
//                        null,
//                        "t = 423K; P = 1 bar",
//                        "Собрали установку.\n Загрузили реагенты.\n Подключили аргон.\n 12,30 - температура 150, присутствует запах аммиака\n",
//                        null,
//                        null,
//                        "Выход продукта 79%",
//                        "https://drive.google.com/open?id=0B5IpLUpjG6mKYjRKY1N2RkRYYkk"
//                ),
//                new ExperimentEntity(
//                        2,
//                        "C3H8O3 + CH4N2O = C4H6O4 + NH3",
//                        "Синтез глицеролкарбоната на аэросиле, модифицированным цинком (вакуум)",
//                        "04.04.2017",
//                        null,
//                        null,
//                        "t = 423K; P = 75 мм.рт.ст.",
//                        "Собрали установку.\n Загрузили реагенты.\n 9.00 - Т=140. Начало реакции\n 12.00 - установка выключена\n",
//                        null,
//                        null,
//                        "Показатели преломления:.\n - Реакционная масса = 1.9768\n - Этанол = 1.9838\n",
//                        "https://drive.google.com/open?id=1LMmKL1g3mX7UIj-FNa7_2DHhFpRkN4N_JuIjOEH1d-M"
//                )
//        ));
//
//        webDriver.get("http://localhost:" + port);
//        WebElement search = webDriver.findElement(By.className("item-search"));
//        search.sendKeys("лантан");
//        search.sendKeys(Keys.ENTER);
//
//        var wait = new WebDriverWait(webDriver, 5); // ожидание - max 5 сек
//
//        wait.until(ExpectedConditions.numberOfElementsToBe(
//                By.className("item"),
//                1
//        ));
//
//        assertTrue(
//                webDriver.findElement(By.className("item"))
//                        .getText().toLowerCase()
//                        .contains("лантан")
//        );
//    }
//
//    @Test
//    @DirtiesContext
//    public void searchByNameSecond() {
//        experimentRepository.saveAll(List.of(
//                new ExperimentEntity(
//                        1,
//                        "C3H8O3 + CH4N2O = C4H6O4 + NH3",
//                        "Синтез глицеролкарбоната на цеолитах, модифицированных лантаном",
//                        "1.11.2016",
//                        null,
//                        null,
//                        "t = 423K; P = 1 bar",
//                        "Собрали установку.\n Загрузили реагенты.\n Подключили аргон.\n 12,30 - температура 150, присутствует запах аммиака\n",
//                        null,
//                        null,
//                        "Выход продукта 79%",
//                        "https://drive.google.com/open?id=0B5IpLUpjG6mKYjRKY1N2RkRYYkk"
//                ),
//                new ExperimentEntity(
//                        2,
//                        "C3H8O3 + CH4N2O = C4H6O4 + NH3",
//                        "Синтез глицеролкарбоната на аэросиле, модифицированным цинком (вакуум)",
//                        "04.04.2017",
//                        null,
//                        null,
//                        "t = 423K; P = 75 мм.рт.ст.",
//                        "Собрали установку.\n Загрузили реагенты.\n 9.00 - Т=140. Начало реакции\n 12.00 - установка выключена\n",
//                        null,
//                        null,
//                        "Показатели преломления:.\n - Реакционная масса = 1.9768\n - Этанол = 1.9838\n",
//                        "https://drive.google.com/open?id=1LMmKL1g3mX7UIj-FNa7_2DHhFpRkN4N_JuIjOEH1d-M"
//                )
//        ));
//
//        webDriver.get("http://localhost:" + port);
//        WebElement search = webDriver.findElement(By.className("item-search"));
//        search.sendKeys("вакуум");
//        search.sendKeys(Keys.ENTER);
//
//        var wait = new WebDriverWait(webDriver, 5); // ожидание - max 5 сек
//
//        wait.until(ExpectedConditions.numberOfElementsToBe(
//                By.className("item"),
//                1
//        ));
//
//        assertTrue(
//                webDriver.findElement(By.className("item"))
//                        .getText().toLowerCase()
//                        .contains("вакуум")
//        );
//    }
//
//    @AfterAll
//    public static void afterAll() {
//        webDriver.quit();
//    }
}
