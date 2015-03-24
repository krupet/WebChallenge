package ua.com.krupet.service.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ua.com.krupet.common.ParsingServiceException;
import ua.com.krupet.service.ParsingService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krupet on 24.03.2015.
 */
public class ParseServiceImpl implements ParsingService {
    @Override
    public List<String> parsePage(String url) throws ParsingServiceException {
        Document doc;
        List<String> hrefList;

        try{
            hrefList = new ArrayList<>();
            doc = Jsoup.connect(url).get();

            // get all links
            Elements links = doc.select("a[href]");

            for (Element link : links) {

                String href = link.attr("href");
                if (href.contains(url)) {
                    System.out.println("\nContains!"  + "\t\t" + href);
                    hrefList.add(link.attr("href"));
                }
                if (!(href.contains("http://") | href.contains("https://"))) {
                    System.out.println("\nINNER!"  + "\t\t" + href);
                    hrefList.add(link.attr("href"));
                } else {
                    System.out.println("\nOUTER!!" + "\t\t" + href + "\t\t" + url);
                }
//                hrefList.add(link.attr("href"));
            }
        } catch (Exception ex) {
            throw new ParsingServiceException();
        }

        return hrefList;
    }

    public static void main(String[] args) throws ParsingServiceException {
        ParseServiceImpl parseService = new ParseServiceImpl();
        List<String> refs = parseService.parsePage("http://twitter.com");

        for (String reference : refs) {
            System.out.println(reference);
        }
    }
}
