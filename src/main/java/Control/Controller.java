package Control;


import Control.Data.UserData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jaya Kasa
 * @version 1.0
 */
@RestController
public class Controller {

    @RequestMapping
    public UserData input(@RequestParam(value = "coordinates", defaultValue = "") String coodinates, @RequestParam(value = "message", defaultValue = "") String message){
        return new UserData(coodinates, message);
    }
}
