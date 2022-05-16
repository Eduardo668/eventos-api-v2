//package br.com.eventosapi.FileUpload;
//
//
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.io.*;
//import java.nio.file. *;
//
///* A função dessa classe é de criar um diretorio caso ele não exista e
//salvar o arquivo upado que vem do multipartFile salvando isso no sistema de arquivos */
//
//public class FileUploadUtil {
//    public static void saveFile(String uploadDir, String fileName,
//                                MultipartFile multipartFile) throws IOException{
//        Path uploadPath = Paths.get(uploadDir);
//
//        if (!Files.exists(uploadPath)){
//            Files.createDirectories(uploadPath);
//        }
//        try (InputStream inputStream = multipartFile.getInputStream()){
//            Path filePath = uploadPath.resolve(fileName);
//            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
//        }catch (IOException ioe){
//            throw new IOException("Não foi possivel savar esta imagem: "+ fileName, ioe);
//        }
//    }
//}
