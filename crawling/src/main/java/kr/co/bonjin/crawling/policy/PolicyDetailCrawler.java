package kr.co.bonjin.crawling.policy;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class PolicyDetailCrawler {

    public static void get(String url) {
        Connection conn = Jsoup.connect(url);

        Document document;
        try {
            document = conn.get();

            System.out.println(document);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

}
