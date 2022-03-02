package com.greencity.study.pictureGPS;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.Directory;

import org.apache.sanselan.ImageReadException;

import com.drew.metadata.Tag;
import org.apache.sanselan.Sanselan;
import org.apache.sanselan.common.IImageMetadata;
import org.apache.sanselan.formats.jpeg.JpegImageMetadata;
import org.apache.sanselan.formats.tiff.TiffImageMetadata;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2021/9/5/005 16:36
 */
public class PictureInfo {
    public static void main(String[] args) {
        System.out.println("开始读取图片信息...");
        File jpegFile = new File("D:\\壁纸\\图片3.jpg");
        //Metadata metadata;
        try {
           /* metadata = JpegMetadataReader.readMetadata(jpegFile);
            Iterator<Directory> it = metadata.getDirectories().iterator();
            while (it.hasNext()) {
                Directory exif = it.next();
                Iterator<Tag> tags = exif.getTags().iterator();
                while (tags.hasNext()) {
                    Tag tag = (Tag) tags.next();
                    System.out.println(tag);
                }
            }*/
            IImageMetadata metadata = Sanselan.getMetadata(jpegFile);
            ArrayList items = metadata.getItems();
            for (Object item : items)
            {
                System.err.println(item);
            }
            System.err.println("GPS info:");
            if (metadata instanceof JpegImageMetadata)
            {
                JpegImageMetadata jpegMetadata = (JpegImageMetadata) metadata;

                TiffImageMetadata exifMetadata = jpegMetadata.getExif();
                if (null != exifMetadata)
                {
                    TiffImageMetadata.GPSInfo gpsInfo = exifMetadata.getGPS();
                    if (null != gpsInfo)
                    {
                        double longitude = gpsInfo.getLongitudeAsDegreesEast();
                        double latitude = gpsInfo.getLatitudeAsDegreesNorth();

                        System.err.println("GPS Description: " + gpsInfo);
                        System.err.println("GPS Longitude (Degrees East): " + longitude);
                        System.err.println("GPS Latitude (Degrees North): " + latitude);
                    }
                }
            }

            System.out.println("图片信息读取完成！");


        } catch (IOException e) {
            e.printStackTrace();
        }catch (ImageReadException e) {
            e.printStackTrace();
        }
    }
}
