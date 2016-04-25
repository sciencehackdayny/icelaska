import icelaska.Control.extData.DateCalc;

/**
 * @author Jaya Kasa
 * @version 1.0
 */
public class TestDateCalc {
    public static void main(String[] args){
        String[] dates = DateCalc.getDate();
        int total = 0;
        for(String s : dates){
            total++;
            System.out.println(total + " " + s);
        }
    }
}
