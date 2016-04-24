package Control.extData;


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
public class LoadImages {
    private String[] url = {"http://polarportal.dk/fileadmin/polarportal/sea/Map_IST_LA_EN_",
            "http://polarportal.dk/fileadmin/polarportal/sea/SICE_map_extent_LA_EN_",
            "http://polarportal.dk/fileadmin/polarportal/sea/SICE_curve_extent_LA_EN_",
            "http://polarportal.dk/fileadmin/polarportal/sea/CICE_map_thick_LA_EN_",
            "http://polarportal.dk/fileadmin/polarportal/sea/CICE_curve_thick_LA_EN_",
            "http://polarportal.dk/fileadmin/polarportal/weather/Wthr_Raw_LA_EN_",
            "http://polarportal.dk/fileadmin/polarportal/weather/Wthr_Anom_LA_EN_",
            "http://polarportal.dk/fileadmin/polarportal/weather/Wthr_Prec_LA_EN_"};
    private String img[] = {"icetemp.png", "icefrac1.png", "icefrac2.png",
            "icethick1.png", "icethink2.png", "tempwind.png", "anamoly.png", "percipitation.png"};
    private String dates[] = null;
    private static LoadImages loadImages = null;
    private URL[] urls = new URL[16];

    /**
     * private constructor to init the object
     */
    private LoadImages(){
        dates = DateCalc.getDate();
        loadUrls();
    }

    /**
     * private method to load the URL objects
     */
    private void loadUrls(){
        for(int a = 0; a < urls.length; a++){
            //System.out.println(urls[a]);
            String url1 = url[a/2] + dates[0]+".png";
            //System.out.println(urls[a+1]);
            String url2 = url[a/2] + dates[1]+".png";
            try {
                urls[a] = new URL(url1);
                urls[++a] = new URL(url2);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Static method for getting instance of Loader
     *
     * @return LoadImages
     */
    public static LoadImages getInstance(){
        if(loadImages == null){
            loadImages = new LoadImages();
        }
        return loadImages;
    }

    /**
     * Method to load all the images
     */
    public void loadData(){
        for(int a = 0; a < urls.length; a++){
            try {
                getImage(urls[a], img[a/2]);
                a++;
            } catch (IOException e) {
            }
        }
    }

    /**
     * Method for loading image into data/img directory
     */
    private void getImage(URL urlObj, String img) throws IOException {
        //RenderedImage image = null;

        System.out.println(urlObj.getPath());

        //image = ImageIO.read(urlObj);
        InputStream inputStream = urlObj.openStream();
        //System.out.println(this.getClass() + " --> class of image: " + image.getClass());

        String path = System.getProperty("user.dir") + "/data/img";
        File file = new File(path);

        if(!file.exists()){
            System.out.println("creating /data/img/");
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

        FileOutputStream fileOutputStream = new FileOutputStream(path + "/" + img);
        fileOutputStream.write(response);
        fileOutputStream.close();
    }

}
