package kr.co.bonjin.crawling.provider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Path;
import java.nio.file.Paths;

public class SeleniumProvider {

    public static void run(String url) {
        WebDriver driver = init();
        int rows = 15;
        int page = 1;

        // 4. 웹페이지 요청
        driver.get(url + "?rows=" + rows + "&cpage=" + page);

    }

    public static WebDriver init() {
        // 1. WebDriver 경로 설정
        Path path = Paths.get(System.getProperty("user.dir"), "src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", path.toString());

        // 2. WebDriver 옵션 설정
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");          // 최대크기로
        options.addArguments("--headless");                 // Browser를 띄우지 않음
        options.addArguments("--disable-gpu");              // GPU를 사용하지 않음, Linux에서 headless를 사용하는 경우 필요함.
        options.addArguments("--no-sandbox");               // Sandbox 프로세스를 사용하지 않음, Linux에서 headless를 사용하는 경우 필요함.

        // 3. WebDriver 객체 생성
        ChromeDriver driver = new ChromeDriver( options );
        return driver;
    }
}
