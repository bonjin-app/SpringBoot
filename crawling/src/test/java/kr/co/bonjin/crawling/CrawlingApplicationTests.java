package kr.co.bonjin.crawling;

import kr.co.bonjin.crawling.provider.JsoupProvider;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CrawlingApplicationTests {

    @Test
    void contextLoads() {

        // 보도자료
//        JsoupProvider.runNews("https://www.bizinfo.go.kr/web/lay1/bbs/S1T157C158/AU/112");
        // 카드뉴스
        JsoupProvider.runNews("https://www.bizinfo.go.kr/web/lay1/bbs/S1T157C163/AE/117");
        // 영상
//        JsoupProvider.runNews("https://www.bizinfo.go.kr/web/lay1/bbs/S1T157C164/AF/118");

        // 이벤트
//        JsoupProvider.runEvent("https://www.bizinfo.go.kr/web/lay1/bbs/S1T122C127/AX/210");

        // 정책
//        JsoupProvider.runPolicy("https://www.bizinfo.go.kr/web/lay1/bbs/S1T122C128/AS/74");
    }

}
