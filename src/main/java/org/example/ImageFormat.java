package org.example;

import org.opencv.core.Mat;

abstract class ImageFormat {
    protected Filter filter;

    public ImageFormat(Filter filter) {
        this.filter = filter;
    }

    public abstract Mat readImage(String path);

    public Mat processImage(String path) {
        Mat image = readImage(path);
        return filter.applyFilter(image);
    }
}
