package icelaska.Control.CartoDB;

import Util.PostViaURL;
import com.cartodb.CartoDBClientIF;
import com.cartodb.CartoDBException;
import com.cartodb.impl.ApiKeyCartoDBClient;

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
    private String key = "7e8d8026db79882178dab9b026a6022f67fb282e";
    private URL url = null;
    private HttpURLConnection httpURLConnection = null;
    private final String USER_AGENT = "Icelaska";

    public InsertCarto(){
    }

    public void insertCarto(int danger, String longitude, String latitude)throws IllegalArgumentException{
        if(danger > 2 | danger < 0){
            throw new IllegalArgumentException("danger level must be between 0-2; 0 = safe; 1 = warn; 2 = danger");
        }
        String query =  insert + danger + date + location + longitude + ", " + latitude + terminal;
        System.out.println("Query " + query);

        try {
            CartoDBClientIF cartoDBCLient= new ApiKeyCartoDBClient("kasa288", key);
            System.out.println(cartoDBCLient.executeQuery(query));
        } catch (CartoDBException e) {
            e.printStackTrace();
        }

    }
}
