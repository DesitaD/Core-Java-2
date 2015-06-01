import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


public class fileDownloader {
    public static void downloadFile(String fileURL, String saveDir) throws IOException{
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();
 
        // always check HTTP response code first
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = "";
            String disposition = httpConn.getHeaderField("Content-Disposition");
            String contentType = httpConn.getContentType();
            int contentLength = httpConn.getContentLength();
 
            if (disposition != null) {
                // extracts file name from header field
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    fileName = disposition.substring(index + 10,
                            disposition.length() - 1);
                }
            } else {
                // extracts file name from URL
                fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1,
                        fileURL.length());
            }
 
            System.out.println("Content-Type = " + contentType);
            System.out.println("Content-Disposition = " + disposition);
            System.out.println("Content-Length = " + contentLength);
            System.out.println("fileName = " + fileName);
 
            // opens input stream from the HTTP connection
            InputStream inputStream = httpConn.getInputStream();
            String saveFilePath = saveDir + File.separator + fileName;
             
            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);
 
            int bytesRead = -1;
            byte[] buffer = new byte[4096];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
 
            outputStream.close();
            inputStream.close();
 
            System.out.println("File downloaded");
        } else {
            System.out.println("No file to download. Server replied HTTP code: " + responseCode);
        }
            httpConn.disconnect();
        }     
    
    public static void downloadFromUrl(String fileURL,
            String saveDirPath) throws MalformedURLException, IOException
    {
//        URL url = new URL(fileURL);
//
//        Files.copy(url.openStream(), new File(saveDirPath).toPath(),
//                StandardCopyOption.REPLACE_EXISTING);
        
        try {
            URL website = new URL(fileURL);
            ReadableByteChannel rbc;
            rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(saveDirPath);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        /*GetMethod method = new GetMethod(resource_url);
try {
    int statusCode = client.executeMethod(method);
    if (statusCode != HttpStatus.SC_OK) {
        logger.error("Get method failed: " + method.getStatusLine());
    }       
    org.apache.commons.io.FileUtils.copyInputStreamToFile(
        method.getResponseBodyAsStream(), new File(resource_file));
    } catch (HttpException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
    method.releaseConnection();
}*/
    }

    public static void main(String[] args) throws MalformedURLException, IOException {
       downloadFromUrl("http://d3dsacqprgcsqh.cloudfront.net/photo/aozrdx0_700b.jpg","D:/test.jpg");
       downloadFromUrl("http://www.hdwallpapers.in/walls/burj_al_arab_hotel_dubai-normal.jpg","D:/dubai.jpg");
       downloadFromUrl("http://d3dsacqprgcsqh.cloudfront.net/photo/aozrdx0_700b.jpg","D:/PRPRRR.jpg");

    }

}
