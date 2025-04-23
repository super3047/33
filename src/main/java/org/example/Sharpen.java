package org.example;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;

class Sharpen implements Filter {
    @Override
    public Mat applyFilter(Mat image) {
        Mat kernel = new Mat(3, 3, CvType.CV_32F, new Scalar(0));
        kernel.put(0, 1, -1);
        kernel.put(1, 0, -1);
        kernel.put(1, 1, 5);
        kernel.put(1, 2, -1);
        kernel.put(2, 1, -1);
        Mat result = new Mat();
        Imgproc.filter2D(image, result, image.depth(), kernel);

        return result;
    }
}
