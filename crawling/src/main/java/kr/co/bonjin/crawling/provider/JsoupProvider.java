package kr.co.bonjin.crawling.provider;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsoupProvider {
    public static void runNews(String url) {
    }

    public static void runEvent(String url) {
    }

    public static void runPolicy(String url) {
        int rows = 15;
        int page = 42;

        while (true) {
            Connection conn = Jsoup.connect(url + "?rows=" + rows + "&cpage=" + page);

            Document document;
            try {
                document = conn.get();

                if (isEmpty(document)) {
                    break;
                }

                page++;

                List<String> head = getHead(document);
                List<List<String>> body = getBody(document);

                for (List<String> items : body) {
                    System.out.println(items.toString());
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {

            }
        }
    }

    private static boolean isEmpty(Document document) {
        Elements selects = document.select(".page_wrap a");
        return selects.isEmpty();
    }

    private static List<String> getHead(Document document) {
        List<String> list = new ArrayList<>();
        Elements selects = document.select(".table_Type_1 thead tr");

        for (Element select : selects) {
            list.add(select.html());
        }
        return list;
    }

    private static List<List<String>> getBody(Document document) {
        List<List<String>> items = new ArrayList<>();
        Elements selects = document.select(".table_Type_1 tbody tr");

        for (Element select : selects) {
            List<String> _items = new ArrayList<>();
            select.select("td").forEach(e -> {
                if (!e.select("a").isEmpty()) {
                    var href = e.select("a").attr("href");
                    var text = e.select("a").html();
                    _items.add(text);
                } else {
                    _items.add(e.html());
                }
            });
            items.add(_items);
        }
        return items;
    }
}
