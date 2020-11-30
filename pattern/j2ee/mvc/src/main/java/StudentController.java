import lombok.AllArgsConstructor;

/**
 * Created by luwb on 2020/05/22.
 */
@AllArgsConstructor
public class StudentController {

    private Student model;
    private StudentView view;

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentRollNo(String rollNo) {
        model.setRollNo(rollNo);
    }

    public String getStudentRollNo() {
        return model.getRollNo();
    }

    public void updateView() {
        view.printStudentDetails(model.getName(), model.getRollNo());
    }

}
