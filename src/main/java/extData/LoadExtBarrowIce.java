package extData;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Class pulls up an radar image for Sea Ice for Barrow Alaska
 *
 * @author Jaya Kasa
 * @version 1.0
 */
public class LoadExtBarrowIce{
    private String url = "http://feeder.gina.alaska.edu/radar-uaf-barrow-seaice-images/current/image.png";
    private static LoadExtBarrowIce loadExtBarrowIce = null;
    private URL urlObj= null;

    private LoadExtBarrowIce(){
        try {
            urlObj = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Static method for getting instace of Loader
     *
     * @return LoadExtBarrowIce
     */
    public static LoadExtBarrowIce getInstance(){
        if(loadExtBarrowIce == null){
            loadExtBarrowIce = new LoadExtBarrowIce();
        }
        return loadExtBarrowIce;
    }

    /**
     * Method for loading image into data/img directory
     */
    public void getData(){
        RenderedImage image = null;

        try {
            //image = ImageIO.read(urlObj);
            InputStream inputStream = urlObj.openStream();
            //System.out.println(this.getClass() + " --> class of image: " + image.getClass());

            String path = System.getProperty("user.dir") + "/data/img";
            File file = new File(path);

            if(!file.exists()){
                System.out.println("creating /data/img/radar.img");
                file.mkdirs();
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            byte[] b = new byte[2048];
            int length;

            while ((length = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, length);
            }

            inputStream.close();
            outputStream.close();

            byte[] response = outputStream.toByteArray();

            FileOutputStream fileOutputStream = new FileOutputStream(path + "/radar.png");
            fileOutputStream.write(response);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
