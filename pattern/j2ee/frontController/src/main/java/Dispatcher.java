/**
 * Created by luwb on 2020/05/22.
 */
public class Dispatcher {

    private HomeView homeView;
    private StudentView studentView;

    public Dispatcher() {
        homeView = new HomeView();
        studentView = new StudentView();
    }

    public void dispatch(String request) {
        if ("STUDENT".equalsIgnoreCase(request)) {
            studentView.show();
        } else {
            homeView.show();
        }
    }
}
