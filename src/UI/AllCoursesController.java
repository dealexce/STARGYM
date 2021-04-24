package UI;

import javafx.event.ActionEvent;
/**
 * @description: Controller of AllCoursesPage
 * @author: Haopu Chen
 **/
public class AllCoursesController extends ManagedPage{
    public static final String path = Path.ALLCOURSES;
    public void goHome(ActionEvent actionEvent) {
        this.stageManager.stageRedirect(path,Path.HOME);
    }
}
