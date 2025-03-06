package com.example.BarqFileOperation.Service;

import com.example.BarqFileOperation.DTO.FileData;
import com.example.BarqFileOperation.Entity.FileEntity;
import com.example.BarqFileOperation.Repository.FileRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.web.multipart.MultipartFile;

        import java.io.IOException;
        import java.nio.file.Files;
        import java.nio.file.Path;
        import java.nio.file.Paths;
        import java.nio.file.StandardOpenOption;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    public String processFile(MultipartFile file) throws IOException {
        // Deserialize JSON file content
        ObjectMapper objectMapper = new ObjectMapper();
        FileData fileData = objectMapper.readValue(file.getInputStream(), FileData.class);

        if (fileData.isPersist()) {
            // Save to database
            FileEntity fileEntity = new FileEntity(fileData.getName(), fileData.getContent());
            fileRepository.save(fileEntity);
            return "File persisted successfully!";
        } else {
            // Print content to console
            System.out.println("Non-Persistent File Content:");
            System.out.println(fileData.getContent());

            // Save to a text file
            saveToFile(fileData.getContent());
            return "File printed and saved as text!";
        }
    }

    private void saveToFile(String content) throws IOException {
        Path path = Paths.get("non_persistent_file.txt");
        Files.write(path, content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}
