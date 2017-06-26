import Developer.Developer;
import DeveloperController.DeveloperController;
import DeveloperDAO.DeveloperDAO;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        DeveloperController developerController=new DeveloperController();
        DeveloperDAO developerDAO=new DeveloperDAO();
        Developer developer =new Developer();
        developerController.add();
         //developerController.getByID();
       // developerController.getAll();
 developerController.update();
        //developerController.remove();

    }
}
