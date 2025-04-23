package org.example;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

class Blur implements Filter {
    @Override
    public Mat applyFilter(Mat image) {
        Mat result = new Mat();
        Imgproc.GaussianBlur(image, result, new org.opencv.core.Size(5, 5), 0);
        return result;
    }
}
