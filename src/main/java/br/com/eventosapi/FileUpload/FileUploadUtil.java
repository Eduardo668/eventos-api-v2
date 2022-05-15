package br.com.eventosapi.FileUpload;


import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.*;
import java.nio.file. *;

public class FileUploadUtil {
    public static void saveFile(String uploadDir, String fileName,
                                MultipartFile multipartFile) throws IOException{
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }
        try (InputStream inputStream = multipartFile.getInputStream()){
            Path filePath = uploadPath.resolve(fileName);

        }
    }
}
