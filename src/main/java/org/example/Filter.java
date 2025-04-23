package org.example;

import org.opencv.core.Mat;

interface Filter {
    Mat applyFilter(Mat image);
}
