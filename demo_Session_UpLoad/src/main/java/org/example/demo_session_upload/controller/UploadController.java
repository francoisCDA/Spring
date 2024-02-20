package org.example.demo_session_upload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/upload")
public class UploadController {

    private String location = "upload-dir";


    @GetMapping("/form")
    public String form() {
        return "upload-form";
    }

    @GetMapping("/files")
    @ResponseBody
    public List<String> getFiles() throws IOException {
        List<String> liste = new ArrayList<>();
        Files.walk(Paths.get(location)).forEach(path -> {liste.add(path.getFileName().toString());
        });
        return liste;
    }

    @PostMapping("/submitform")
    public String submitform(@RequestParam("image") MultipartFile image ) throws IOException {
        Path destinationFile = Paths.get(location).resolve(Paths.get(image.getOriginalFilename())).toAbsolutePath();
        InputStream stream = image.getInputStream();
        Files.copy(stream,destinationFile, StandardCopyOption.REPLACE_EXISTING);

        return "redirect:/upload/files";

    }


}
