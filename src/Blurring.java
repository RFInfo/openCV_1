import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Blurring {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    int MAX_KERNEL_SIZE = 51;
    int DELAY_DISPLAY = 2000;
    int DELAY_BLUR = 200;
    Mat src = new Mat();
    Mat dst = new Mat();

    void blurIt() {
        String fineName = "./test_images/Desert.jpg";
        src = Imgcodecs.imread(fineName);
        dst = src.clone();
        displayText("Original");
        HighGui.imshow("Bluring", src);
        HighGui.waitKey(DELAY_DISPLAY);
        displayText("Homogeneous blur");
        for (int i = 1; i < MAX_KERNEL_SIZE; i += 2) {
            Imgproc.blur(src, dst, new Size(i, i), new Point(-1, -1));
            HighGui.imshow("Bluring", dst);
            HighGui.waitKey(DELAY_BLUR);
        }
        displayText("Gaussian blur");
        for (int i = 1; i < MAX_KERNEL_SIZE; i += 2) {
            Imgproc.GaussianBlur(src, dst, new Size(i, i), 0, 0);
            HighGui.imshow("Bluring", dst);
            HighGui.waitKey(DELAY_BLUR);
        }
        displayText("Median blur");
        for (int i = 1; i < MAX_KERNEL_SIZE; i += 2) {
            Imgproc.medianBlur(src, dst, i);
            HighGui.imshow("Bluring", dst);
            HighGui.waitKey(DELAY_BLUR);
        }
        displayText("Bilateral filter");
        for (int i = 1; i < MAX_KERNEL_SIZE; i += 2) {
            Imgproc.bilateralFilter(src, dst, i, i * 2, i / 2);
            HighGui.imshow("Bluring", dst);
            HighGui.waitKey(DELAY_BLUR);
        }
        displayText("Done");
        HighGui.destroyAllWindows();
        System.exit(0);
    }

    void displayText(String txt) {
        dst = Mat.zeros(src.size(), src.type());
        Imgproc.putText(dst, txt, new Point(src.cols() / 4, src.rows() / 2),
                Imgproc.FONT_HERSHEY_PLAIN, 3, new Scalar(255, 255, 255), 2);
        HighGui.imshow("Bluring", dst);
        HighGui.waitKey();
    }

    public static void main(String[] args) {
        new Blurring().blurIt();
    }
}