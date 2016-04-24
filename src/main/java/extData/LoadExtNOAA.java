package extData;

import Util.JsonReceiver;
import org.json.JSONException;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Jaya Kasa
 * @verion 1.0
 */
@Deprecated
public class LoadExtNOAA {
    String url = "http://www.ncdc.noaa.gov/cdo-web/api/v2";
    private URL urlObj = null;
    private static LoadExtNOAA loadExtNOAA;

    private LoadExtNOAA(){
    }

    public static LoadExtNOAA getInstance(){
        if(loadExtNOAA == null){
            loadExtNOAA = new LoadExtNOAA();
        }
        return loadExtNOAA;
    }


    public Object getData(String param) throws JSONException {
        JsonReceiver jsonReceiver = JsonReceiver.getReceiver();
        try {
            urlObj = new URL(url + param);
            jsonReceiver.setUrl(urlObj);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return jsonReceiver.executeGETCall();
    }
}