package LeetCode.graph;

import java.util.*;

//https://leetcode.com/problems/web-crawler/
public class WebCrawler {

    //O(n) time and space
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Queue<String> queue = new LinkedList<>();
        Set<String> result = new HashSet<>();
        result.add(startUrl);
        String domain = startUrl.split("/")[2];
        queue.add(startUrl);
        while (!queue.isEmpty()) {
            String url = queue.poll();
            for (String s : htmlParser.getUrls(url)) {
                if (result.contains(s) || !(s.split("/")[2]).equals(domain)) continue;
                result.add(s);
                queue.add(s);
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        WebCrawler webCrawler = new WebCrawler();
        System.out.println(webCrawler.crawl("http://news.yahoo.com/news/topics/", new HtmlParser()));
    }


    // This is the HtmlParser's API interface.
    // You should not implement it, or speculate about its implementation
   static class HtmlParser {

        public HtmlParser() {
        }

        public List<String> getUrls(String url) {
           if (url.equals("http://news.yahoo.com/news/topics/")) return List.of("http://news.yahoo.com/news", "http://news.yahoo.com");
           else if (url.equals("http://news.yahoo.com")) return List.of("http://news.yahoo.com/us");
           else return Collections.emptyList();
        }
    }

}
