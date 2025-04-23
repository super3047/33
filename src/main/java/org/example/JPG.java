package org.example;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

class JPG extends ImageFormat {
    public JPG(Filter filter) {
        super(filter);
    }

    @Override
    public Mat readImage(String path) {
        return Imgcodecs.imread(path);
    }
}