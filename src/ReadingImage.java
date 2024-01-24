import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import static org.opencv.imgcodecs.Imgcodecs.IMREAD_REDUCED_COLOR_2;

public class ReadingImage {
    public static void main(String args[]) {
//Loading the OpenCV core library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//Reading the Image from the file
        String file = "./test_images/Desert.jpg";
        Mat matrix = Imgcodecs.imread(file, IMREAD_REDUCED_COLOR_2);
        System.out.println("Image Loaded");

        Mat gray = new Mat();
        Mat binary = new Mat();
        Imgproc.cvtColor(matrix,gray,Imgproc.COLOR_BGR2GRAY);
        Imgproc.threshold(gray,binary,127,255,Imgproc.THRESH_BINARY);

        HighGui.imshow("Output",matrix);
        HighGui.imshow("Gray",gray);
        HighGui.imshow("Binary",binary);

        HighGui.waitKey();
        HighGui.destroyAllWindows();
        System.exit(0);
    }
}