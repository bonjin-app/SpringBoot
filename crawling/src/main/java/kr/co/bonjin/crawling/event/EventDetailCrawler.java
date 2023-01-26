package kr.co.bonjin.crawling.event;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventDetailCrawler {

    public static void get(String url) {
        Connection conn = Jsoup.connect(url);

        Document document;
        try {
            document = conn.get();

            getHead(document);
            getImages(document);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

    public static Map<String, String> getHead(Document document) {
        Elements selects = document.select(".view_cont ul li");
        var map = new HashMap<String, String>();

        for (Element select : selects) {
            var title = select.select("span.s_title").html();
            StringBuilder items = new StringBuilder();

            for (Element e : select.select("div.txt")) {
                if(title.equals("행사개요")) {
                    if(e.children().size() > 0) {
                        for(Element j: e.children()) {
                            items.append(j.text()).append('\n');
                        }
                        continue;
                    }
                }
                items.append(e.text());
            }
            map.put(title, items.toString());
        }

        System.out.println(map);

        return map;
    }

    public static List<String> getImages(Document document) {
        Elements selects = document.select("#iframe");
        var list = new ArrayList<String>();

        for (Element select : selects) {
            System.out.println(select.attr("href"));
        }
        return list;
    }

}
