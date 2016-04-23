import extData.LoadExtNOAA;
import org.json.JSONException;

/**
 * @author Jaya Kasa
 * @version 1.0
 */
public class NOAATest {
    public static void main(String[] args){
        LoadExtNOAA noaa = LoadExtNOAA.getInstance();
        try {
            System.out.println(noaa.getData("/datasets"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}