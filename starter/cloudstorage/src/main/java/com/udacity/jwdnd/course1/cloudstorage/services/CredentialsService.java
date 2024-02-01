package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialsMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

@Service
public class CredentialsService {
    private CredentialsMapper credentialsMapper;
    private EncryptionService encryptionService;

    public CredentialsService(CredentialsMapper credentialsMapper, EncryptionService encryptionService) {
        this.credentialsMapper = credentialsMapper;
        this.encryptionService = encryptionService;
    }

    public void addCredentials(Credentials credentials, Integer userId){
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[16];
        random.nextBytes(key);
        String encodedKey = Base64.getEncoder().encodeToString(key);
        String encryptedPassword = encryptionService.encryptValue(credentials.getPassword(), encodedKey);

        Credentials newCredentials = new Credentials();
        newCredentials.setUrl(credentials.getUrl());
        newCredentials.setUsername(credentials.getUsername());
        newCredentials.setKey(credentials.getKey());
        newCredentials.setPassword(credentials.getPassword());
        newCredentials.setUserId(credentials.getUserId());

        credentialsMapper.addCredential(newCredentials);
    }

    public void deleteCredentials(Integer credentialId){
        credentialsMapper.deleteCredential(credentialId);
    }

    public void editCredentials(Credentials credentials){
        Credentials oldCredential = credentialsMapper.getCredentialById(credentials.getCredentialId());
        credentials.setKey(oldCredential.getKey());
        String encryptedPassword = encryptionService.encryptValue(credentials.getPassword(), credentials.getKey());
        credentials.setPassword(encryptedPassword);
        credentialsMapper.editCredential(credentials);
    }

    public List<Credentials> getAllCredentials(Integer userId){
        return credentialsMapper.getAllUserCredentials(userId);
    }

}
