/**
 * Created by luwb on 2020/05/21.
 */
public class ProxyImage implements Image {

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }

    public static void main(String[] args) {
        Image image = new ProxyImage("test.jpg");
        // 图像从磁盘加载
        image.display();
        // 图像不用从磁盘加载
        image.display();
    }

}
