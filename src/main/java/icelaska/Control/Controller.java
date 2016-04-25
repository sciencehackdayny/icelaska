package icelaska.Control;

import icelaska.Control.Data.UserData;
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
    public Object input(@RequestParam(value = "coordinates", defaultValue = "") String coodinates,
                          @RequestParam(value = "message", defaultValue = "") String message,
                          @RequestParam(value="image", defaultValue = "false") boolean image){
        //todo this is where i need to implement a way to store data and send info back and forth
        UserData user = new UserData(coodinates, message);
        return user;
    }
}
