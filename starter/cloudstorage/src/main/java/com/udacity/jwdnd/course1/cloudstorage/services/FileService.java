package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileService {
    private FileMapper fileMapper;

    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    public int addFile(MultipartFile fileUpload, Integer userId) throws IOException{
        File file = new File();
        try{
            file.setContentype(fileUpload.getContentType());
            file.setFiledata(fileUpload.getBytes());
            file.setFilename(fileUpload.getOriginalFilename());
            file.setFilesize(Long.toString(fileUpload.getSize()));
            file.setUserId(userId);
        } catch (IOException e){
            throw e;
        }
        return fileMapper.addFile(file);
    }

    public List<File> getUploadedFiles(Integer userid){
        return fileMapper.getAllUserFiles(userid);
    }

    public void deleteFile(int fileId){
        fileMapper.deleteFile(fileId);
    }

    public File getFileById(Integer fileId){
        return fileMapper.getFileById(fileId);
    }

    public boolean isFileNameAvailable(String filename) {
        return fileMapper.getFileByName(filename) == null;
    }

}
