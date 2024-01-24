import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

public class DrawingShapes {
    public static void main(String[] args) {
//Loading the OpenCV core library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//Reading the Image from the file and storing it in to a Matrix object
        String file = "./test_images/Desert.jpg";
        Mat image = Imgcodecs.imread(file);
        System.out.println("Image Loaded");
// Adding Text
        Imgproc.putText(
                image, // Matrix obj of the image
                "Info III.", // Text to be added
                new Point(10, 50), // point
                Imgproc.FONT_HERSHEY_PLAIN, // front face
                4, // front scale
                new Scalar(0, 0, 0), // Scalar object for color
                4 // Thickness
        );
//Drawing a Circle
        Imgproc.circle(
                image, //Matrix obj of the image
                new Point(200, 150), //Center of the circle
                100, //Radius
                new Scalar(0, 0, 255), //Scalar object for color
                4 //Thickness of the circle
        );
// Drawing a line
        Imgproc.line(
                image, //Matrix obj of the image
                new Point(10, 20), //p1
                new Point(300, 20), //p2
                new Scalar(0, 0, 255), //Scalar object for color
                4 //Thickness of the line
        );
// Drawing a Rectangle
        Imgproc.rectangle(
                image, //Matrix obj of the image
                new Point(400, 50), //p1
                new Point(600, 280), //p2
                new Scalar(0, 0, 255), //Scalar object for color
                4);//Thickness of the line

// Drawing an Ellipse
        Imgproc.ellipse(
                image, //Matrix obj of the image
                new RotatedRect( // RotatedRect(Point c, Sizes, double a)
                        new Point(200, 400),
                        new Size(260, 180), 120
                ),
                new Scalar(0, 0, 255), //Scalar object for color
                4 //Thickness of the line
        );
// Drawing polylines
        List<MatOfPoint> list = new ArrayList();
        list.add(
                new MatOfPoint(
                        new Point(75, 100), new Point(350, 100),
                        new Point(75, 150), new Point(350, 150),
                        new Point(75, 200), new Point(350, 200),
                        new Point(75, 250), new Point(350, 250)
                )
        );
        Imgproc.polylines(
                image, // Matrix obj of the image
                list, // java.util.List<MatOfPoint> points
                false, // isClosed
                new Scalar(0, 0, 255), // Scalar object for color
                2 // Thickness of the line
        );
//Drawing a arrow line
        Imgproc.arrowedLine(
                image, // Matrix obj of the image
                new Point(100, 400), // p1
                new Point(690, 400), // p2
                new Scalar(0, 255, 0) // Scalar object for color
        );
        HighGui.imshow("Output", image);
        HighGui.waitKey();
        System.exit(0);
    }
}