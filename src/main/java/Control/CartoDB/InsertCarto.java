package Control.CartoDB;

import Util.PostViaURL;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author Jaya Kasa
 * @verion 1.0
 */
public class InsertCarto {
    private String urlString = "https://kasa288.cartodb.com/api/v2/sql?q=";
    private String insert = "INSERT INTO trails (danger, date, the_geom) VALUES (";
    private String date = ", NOW(), ";
    private String location = "ST_SetSRID(ST_Point(";
    private String terminal = "),4326))";
    private String api = "&api_key=";
    private String key = "7e8d8026db79882178dab9b026a6022f67fb282e";
    private URL url = null;
    private HttpURLConnection httpURLConnection = null;
    private final String USER_AGENT = "Icelaska";

    public InsertCarto(){
    }

    public void insertCarto(int danger, float lon,float lat)throws IllegalArgumentException{
        if(danger > 2 | danger < 0){
            throw new IllegalArgumentException("danger level must be between 0-2");
        }
        String query =  insert + danger + date + location + lon + ", " + lat + terminal+ api + key;
        System.out.println(urlString + query);
        try {
            url = new URL(urlString + URLEncoder.encode(query, "UTF-8"));
            //url = new URL(urlString + query);

            PostViaURL postViaURL = new PostViaURL(urlString, query);

            postViaURL.postData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
