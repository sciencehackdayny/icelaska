package Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Class for receiving JSON documents from a specific URL.
 * Class has been modified to work with Android
 * Will mark the modifications for later reusability
 *
 * @author Jaya Kasa
 * @version 1.2
 */
public final class JsonReceiver {
    private static JsonReceiver receiver = null;
    private static URL url = null;
    private static final String USER_AGENT = "Icelaska";
    private String key = null;



    /**
     * Private Constructor
     */
    private JsonReceiver(){
    }

    /**
     * Static method for getting JsonReceiver object
     * @return JsonReceiver
     */
    public static JsonReceiver getReceiver(){
        if(receiver == null){
            receiver = new JsonReceiver();
        }
        return receiver;
    }

    /**
     * Method for setting the url for the receiver.
     *
     * @param url
     * @throws MalformedURLException
     */
    public void setUrl(URL url) throws MalformedURLException {
        this.url = url;
    }

    public void setKey(String key){
        this.key = key; //"GrdEtYCFlGGKPnVUdmHOcAwjIyfiQUCS"
    }

    public Object executeGETCall() throws JSONException {
        Object json = null;
        HttpURLConnection httpURLConnection = null;
        try {
            //this is the url object which defines the http connection to be made

            //System.out.println("THIS IS THE URL NEED TO FIND HOW ITS BEING DOUBLE CONCATENATED " + url+command);

            //System.out.println(JsonReceiver.class + urlObj.getHost());

            //http connection is being made and it will be a get request
            httpURLConnection = (HttpURLConnection)url.openConnection();
            //System.out.println(JsonReceiver.class + " HTTPURLCONNECTION " + httpURLConnection.getURL().getHost());
            httpURLConnection.setRequestMethod("GET");

            //add request header
            httpURLConnection.setRequestProperty("User-Agent", USER_AGENT);
            if(key!=null){
                httpURLConnection.setRequestProperty("token", key);
            }

            int responseCode = httpURLConnection.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

            //if(!url.getHost().equals(httpURLConnection.getURL().getHost())){
                //the user has to sign into his current network before proceeding
                //TODO handle redirection by network
            //}

            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            //System.out.println(response);
            //JSONArray json = new JSONArray(response.toString());
            if (response.charAt(0) == '{') {
                json = new JSONObject(response.toString());
                //System.out.println("JsonObject");
            }
            else{
                //JSONArray
                json = new JSONArray(response.toString());
            }
            //System.out.println(json);

            //System.out.println(json.getJSONObject("routes").getJSONObject("lx").getJSONArray("stops")); //gets the stops for the lx bus
            /*
            JSONArray arr = json.getJSONArray("stops");
            System.out.println("ARR " + arr.length());
            int count = 0;
            while(count != json.length()){
                System.out.println(json.getString(count));
                count++;
            }
            */
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            throw e;
        }
        finally {
            httpURLConnection.disconnect();
        }

        return json;
    }

}