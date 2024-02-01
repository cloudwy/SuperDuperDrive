package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/home/files")
public class FilesController {
    private FileService fileService;
    private UserService userService;

    public FilesController(FileService fileService, UserService userService) {
        this.fileService = fileService;
        this.userService = userService;
    }

    @PostMapping("/home/files")
    public String uploadFile(Authentication authentication, @RequestParam("fileUpload") MultipartFile file, Model model)  throws IOException {
        String username = authentication.getName();
        ModelAndView modelAndView = new ModelAndView("result");

//        File newFile = new File();
//        newFile.setFilename(file.getOriginalFilename());
//        newFile.setContentype(file.getContentType());
//        newFile.setFilesize(Long.toString(file.getSize()));
//        newFile.setUserId(this.userService.getUserId(username));
//        newFile.setFiledata(file.getBytes());


        if(file.isEmpty()){
            model.addAttribute("error","File not found!");
        }
        else if (fileService.isFileNameAvailable(file.getOriginalFilename()) == false){
            model.addAttribute("error","It is not possible to upload two files with the same name!");
        }

        else {
            Integer fileId = fileService.addFile(file, this.userService.getUserId(username));
            if (fileId != null){
                model.addAttribute("param.success", true);
                model.addAttribute("param.error", false);
            }
            else {
                model.addAttribute("param.success", false);
                model.addAttribute("param.error", true);
            }
        }

        return "result";
    }

}
