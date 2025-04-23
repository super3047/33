package org.example;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Texture_test {
    public static void main(String[] args) {
        System.loadLibrary(org.opencv.core.Core.NATIVE_LIBRARY_NAME);
        String texturePath = "D:\\idea.2023\\ideaproject\\Project6_2\\muwen.jpeg";
        ImageFormat jpgImage = new JPG(new Texture(texturePath));
        Mat processedImage = jpgImage.processImage("D:\\idea.2023\\ideaproject\\Project6_2\\pyy.jpg");
        String outputPath = "D:\\idea.2023\\ideaproject\\Project6_2\\Texture_pyy.jpg";
        boolean saved = Imgcodecs.imwrite(outputPath, processedImage);

        if (saved) {
            System.out.println("处理后的图片已成功保存到: " + outputPath);
        } else {
            System.out.println("保存图片时出错。");
        }
    }
}
