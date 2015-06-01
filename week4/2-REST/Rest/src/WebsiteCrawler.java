import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.norconex.commons.lang.url.URLNormalizer;





public class WebsiteCrawler {
    
    public static URL crawler(URL current, String needle) throws ClientProtocolException, URISyntaxException, IOException{
        Set<URL> visitedURLs= new HashSet<URL>();
        String contentOfTheURL= getContent(current);
        visitedURLs.add(current);
        if(contentOfTheURL.contains(needle)){
            return current;
        }
        else{
            List<String> allLinks= getAllLinks(contentOfTheURL);
            for(String link: allLinks){
                URL url= new URL(link);
                URL normalizedURL = new URLNormalizer(url)
                .lowerCaseSchemeHost()
                .removeDefaultPort()
                .removeDuplicateSlashes()
                .removeDirectoryIndex()
                .addWWW()
                .toURL();
                
                if(!visitedURLs.contains(normalizedURL) && current.getHost().equals(normalizedURL.getHost())){
                    URL craw=crawler(normalizedURL,needle);
                    if(craw!=null)
                        return craw;
                }
        }
            return null;
        }
        
    }
    
    public static String getContent(URL url) throws URISyntaxException, ClientProtocolException, IOException{
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url.toURI());
        HttpResponse response = client.execute(request);

        Reader reader = null;
        try {
            reader = new InputStreamReader(response.getEntity().getContent());

            StringBuffer sb = new StringBuffer();
            {
                int read;
                char[] cbuf = new char[1024];
                while ((read = reader.read(cbuf)) != -1)
                    sb.append(cbuf, 0, read);
            }

            return sb.toString();

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
    
    
    private static List<String> getAllLinks(String content) {
        ArrayList<String> resultList = new ArrayList<>();
        String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            resultList.add(matcher.group(1));
        }
        return resultList;
    }

    public static void main(String[] args) throws IOException {
      

        }

}
