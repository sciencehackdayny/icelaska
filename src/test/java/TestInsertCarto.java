import icelaska.Control.CartoDB.InsertCarto;

/**
 * @author Jaya Kasa
 * @version 1.0
 */
public class TestInsertCarto {
    public static void main(String[] arfgs){
        InsertCarto insertCarto = new InsertCarto();
        insertCarto.insertCarto(0, "-44.2344", "32.1234");
        insertCarto.insertCarto(0, "-44.2334", "32.1334");
        insertCarto.insertCarto(0, "-44.2324", "32.1434");
        insertCarto.insertCarto(0, "-44.2314", "32.1534");
        insertCarto.insertCarto(0, "-44.2304", "32.1634");
        insertCarto.insertCarto(0, "-41.2344", "32.1734");
        insertCarto.insertCarto(0, "-41.2344", "32.1834");
        insertCarto.insertCarto(0, "-41.2344", "32.1804");
        insertCarto.insertCarto(0, "-41.2344", "32.1814");
        insertCarto.insertCarto(0, "-41.2344", "32.1824");
        insertCarto.insertCarto(0, "-41.2344", "32.1844");
    }
}
