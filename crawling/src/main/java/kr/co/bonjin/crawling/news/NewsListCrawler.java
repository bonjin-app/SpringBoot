package kr.co.bonjin.crawling.news;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NewsListCrawler {

    public static boolean isEmpty(Document document) {
        Elements selects = document.select(".gallery_Type_1 ul li");
        return selects.size() == 0;
    }

    public static List<List<Map<String, String>>> getBody(Document document) {
        List<List<Map<String, String>>> items = new ArrayList<>();
        Elements selects = document.select(".gallery_Type_1 ul li");

        for (Element select : selects) {
            List<Map<String, String>> _items = new ArrayList<>();

            var href = select.select(".img_area a").attr("href");
            var image = select.select(".img_area img").attr("src");
            var title = select.select(".txt_area").text();
            var date = select.select(".btm_info .date").text();
            var source = select.select(".btm_info p span").text();

            // 상세

            System.out.println("href: " + href);
            System.out.println("image: " + image);
            System.out.println("title: " + title);
            System.out.println("date: " + date);
            System.out.println("source: " + source);

        }
        return items;
    }
}
