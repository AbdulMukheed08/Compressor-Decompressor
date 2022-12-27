/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compressordecompressor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author Abdul Mukheed
 */
public class decompressor {
    public static void method(File file)throws IOException{
        String fileDirectory = file.getParent();
        //assigning file into the fileinputstream
        FileInputStream fis = new FileInputStream(file);
        //creating a new file in fileDirectory to store decompressed file
        FileOutputStream fos = new FileOutputStream(fileDirectory+"\\decompressed2");
        //assigning gzipinputstream to fileoutputstream to unzip the data
        GZIPInputStream unzip = new GZIPInputStream(fis);
        
        byte[] buffer = new byte[1024];
        int len;
        while((len = unzip.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        
        fos.close();
        unzip.close();
    }
}
