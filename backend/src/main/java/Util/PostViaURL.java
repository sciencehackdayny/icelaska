package Util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author Jaya Kasa
 * @verion 1.0
 */
public class PostViaURL {
    private URL url = null;
    private String urlString = null;
    private String query = null;
    private HttpURLConnection httpURLConnection = null;
    private final String USER_AGENT = "Icelaska";
    //private byte[] postData = null;
    //private int postDataLength;

    public PostViaURL(URL url) throws IOException {
        this.url = url;
        httpURLConnection = (HttpURLConnection) this.url.openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "text/plain; charset=\"utf8\"");
    }

    public void setRequestMethod(String method) throws ProtocolException {
        httpURLConnection.setRequestMethod(method);
    }

    public void setProperty(String key, String value){
        httpURLConnection.setRequestProperty(key, value);
    }

    public void postData(){
        try {
            //TODO issue posting coordinates to carto
            OutputStream outputStream = httpURLConnection.getOutputStream();

            int responseCode = httpURLConnection.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
            System.out.println("Response Message : " + httpURLConnection.getResponseMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        postData = this.query.getBytes(Charset.forName("UTF-8"));
        postDataLength = postData.length;
        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);

            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("charset", "utf-8");
            httpURLConnection.setRequestProperty( "Content-Length", Integer.toString(postDataLength));
            httpURLConnection.setUseCaches(false);

            DataOutputStream wr = new DataOutputStream( httpURLConnection.getOutputStream());
            wr.write(postData);
            wr.close();

            int responseCode = httpURLConnection.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        */


    }

}
