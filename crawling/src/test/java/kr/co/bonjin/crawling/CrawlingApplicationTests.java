package kr.co.bonjin.crawling;

import kr.co.bonjin.crawling.provider.JsoupProvider;
import kr.co.bonjin.crawling.provider.SeleniumProvider;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CrawlingApplicationTests {

    @Test
    void contextLoads() {

        JsoupProvider.run("https://www.bizinfo.go.kr/web/lay1/bbs/S1T122C128/AS/74/list.do");
//        SeleniumProvider.run("https://www.bizinfo.go.kr/web/lay1/bbs/S1T122C128/AS/74/list.do");
    }

}
