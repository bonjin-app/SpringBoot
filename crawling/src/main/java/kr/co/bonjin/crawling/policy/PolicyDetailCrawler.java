package kr.co.bonjin.crawling.policy;

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

public class PolicyDetailCrawler {

    public static void get(String url) {
        Connection conn = Jsoup.connect("https://www.bizinfo.go.kr/web/lay1/bbs/S1T122C128/AS/74/view.do?pblancId=PBLN_000000000081563");

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
                if(title.equals("사업개요")) {
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
        return map;
    }

    public static List<String> getImages(Document document) {
        Elements selects = document.select("#iframe");
        var list = new ArrayList<String>();

        System.out.println(selects);

        for (Element select : selects) {
            System.out.println(select.attr("href"));
        }
        return list;
    }

}
