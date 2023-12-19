package com.book.harrypotterbook.controller;

import com.book.harrypotterbook.Repo.Documentrepo;
import com.book.harrypotterbook.entity.Document;
import com.book.harrypotterbook.exception.Notfoundexception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
public class Documentcontroller {
    @Autowired
    Documentrepo documentrepo;
    @GetMapping("/upload")
    public String displayupload(){
        return "display upload";
    }

    @PostMapping("/uploadedd")
    public String displaymethods(@RequestParam("file")MultipartFile multipartFile,@RequestParam("id")long id) throws IOException {
        Document document=new Document();
        document.setId(id);
        document.setName(multipartFile.getName());
        document.setData(multipartFile.getBytes());
        documentrepo.save(document);
        return "display";
    }
    @GetMapping("/{id}/download")
    public ResponseEntity<byte[]> downloadDocument(@PathVariable Long id) {
        Document document = documentrepo.findById(id)
                .orElseThrow(() -> new Notfoundexception("Document not found with id: " + id));

        ByteArrayResource resource = new ByteArrayResource(document.getData());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + document.getName())
                .contentType(MediaType.APPLICATION_PDF)
               .body(document.getData());

    }
}
