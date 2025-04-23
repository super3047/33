package org.example;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

class Texture implements Filter {
    private String texturePath;

    public Texture(String texturePath) {
        this.texturePath = texturePath;
    }

    @Override
    public Mat applyFilter(Mat image) {
        Mat texture = Imgcodecs.imread(texturePath);
        if (texture.empty()) {
            System.err.println("无法读取纹理图像: " + texturePath);
            return image;
        }
        Imgproc.resize(texture, texture, image.size());
        texture.convertTo(texture, image.type());
        Mat result = new Mat();
        Core.addWeighted(image, 0.7, texture, 0.3, 0, result);

        return result;
    }
}
