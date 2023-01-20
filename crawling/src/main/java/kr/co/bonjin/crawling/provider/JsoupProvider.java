package kr.co.bonjin.crawling.provider;

import kr.co.bonjin.crawling.policy.PolicyListCrawler;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsoupProvider {
    public static void runNews(String url) {
    }

    public static void runEvent(String url) {
    }

    public static void runPolicy(String url) {
        int rows = 15;
        int page = 52;

        while (true) {
            Connection conn = Jsoup.connect(url + "/list.do?rows=" + rows + "&cpage=" + page);

            Document document;
            try {
                document = conn.get();

                if (PolicyListCrawler.isEmpty(document)) {
                    break;
                }

                page++;

                List<String> head = PolicyListCrawler.getHead(document);
                List<List<Map<String, String>>> body = PolicyListCrawler.getBody(document);

                for (List<Map<String, String>> items : body) {
                    System.out.println(items);
                    for (Map<String, String> item: items) {
                        var link = item.get("상세주소");
                        if(link != null) {
                            System.out.println(url + "/" + item.get("상세주소"));
                        }
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {

            }
        }
    }

}
