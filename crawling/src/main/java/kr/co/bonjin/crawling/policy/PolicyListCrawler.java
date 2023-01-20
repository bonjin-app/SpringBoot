package kr.co.bonjin.crawling.policy;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class PolicyListCrawler {

    public static boolean isEmpty(Document document) {
        Elements selects = document.select(".page_wrap a");
        return selects.isEmpty();
    }

    public static List<String> getHead(Document document) {
        List<String> list = new ArrayList<>();
        Elements selects = document.select(".table_Type_1 thead tr");

        for (Element select : selects) {
            Elements e = select.select("th");
            for (Element v : e) {
                list.add(v.html());
            }
        }
        return list;
    }

    public static List<List<Map<String, String>>> getBody(Document document) {
        List<String> head = getHead(document);
        List<List<Map<String, String>>> items = new ArrayList<>();
        Elements selects = document.select(".table_Type_1 tbody tr");

        for (Element select : selects) {
            List<Map<String, String>> _items = new ArrayList<>();

            AtomicInteger index = new AtomicInteger();

            select.select("td").forEach(e -> {
                var map = new HashMap<String, String>();
                if (!e.select("a").isEmpty()) {
                    var href = e.select("a").attr("href");
                    var text = e.select("a").html();
                    map.put(head.get(index.get()), text);
                    _items.add(map);

                    map = new HashMap<>();
                    map.put("link", href);

                } else {
                    map.put(head.get(index.get()), e.html());
                }
                _items.add(map);

                index.getAndIncrement();
            });
            items.add(_items);
        }
        return items;
    }
}
