/**
 * Created by luwb on 2020/05/22.
 */
public class MVCPatternDemo {
    public static void main(String[] args) {
        // 获取学生记录
        Student model = retrieveStudentFromDatabase();
        // 创建一个视图：把学生信息输出到控制台
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);
        controller.updateView();
        // 更新模型数据
        controller.setStudentName("Luweibin");
        controller.updateView();
    }

    /**
     * 模拟从数据库中取数据
     */
    private static Student retrieveStudentFromDatabase() {
        Student student = new Student();
        student.setRollNo("10");
        student.setName("Luwb");
        return student;
    }
}
