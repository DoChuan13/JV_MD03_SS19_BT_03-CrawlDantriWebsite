package app.config;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlWebsite {

    public static void main(String[] args) {

        try {
            URL url = new URL("https://dantri.com.vn/the-gioi.htm");
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            content = content.replaceAll("\\n+", "");
            Pattern p = Pattern.compile("article-title\">(.*?)</h3>");
            Matcher m = p.matcher(content);
            while (m.find()) {
                String text = m.group(1);
                String[] textArr = text.split(".htm\">");
                String finalText = "";
                for (int i = 0; i < textArr[1].length()-4; i++) {
                    finalText += textArr[1].charAt(i);
                }
                System.out.println(finalText);
//                System.out.println(m.group(1));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}