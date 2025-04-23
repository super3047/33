package org.example;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;

class Cutout implements Filter {
    @Override
    public Mat applyFilter(Mat image) {
        Mat gray = new Mat();
        Imgproc.cvtColor(image, gray, Imgproc.COLOR_BGR2GRAY);
        Mat blurred = new Mat();
        Imgproc.GaussianBlur(gray, blurred, new Size(5, 5), 0);
        Mat edges = new Mat();
        Imgproc.Canny(blurred, edges, 50, 150);
        Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(3, 3));
        Mat dilatedEdges = new Mat();
        Imgproc.dilate(edges, dilatedEdges, kernel);
        Mat result = new Mat(image.size(), image.type(), new Scalar(255, 255, 255));
        for (int i = 0; i < dilatedEdges.rows(); i++) {
            for (int j = 0; j < dilatedEdges.cols(); j++) {
                if (dilatedEdges.get(i, j)[0] == 255) {
                    result.put(i, j, new double[]{0, 0, 0});
                }
            }
        }

        return result;
    }
}
