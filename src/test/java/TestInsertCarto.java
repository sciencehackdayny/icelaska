import Control.CartoDB.InsertCarto;

/**
 * @author Jaya Kasa
 * @version 1.0
 */
public class TestInsertCarto {
    public static void main(String[] arfgs){
        InsertCarto insertCarto = new InsertCarto();
        insertCarto.insertCarto(2, (float)-45.2344, (float)38.1834);
    }
}
