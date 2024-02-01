package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CredentialsMapper {
    @Select("SELECT * FROM CREDENTIALS")
    List<Credentials> findAll();

    @Select("Select * from CREDENTIALS where userid = #{userId}")
    List<Credentials> getAllUserCredentials(Integer userId);

    @Select("Select * from CREDENTIALS where credentialid=#{credentialId}")
    Credentials getCredentialById(Integer credentialId);

    @Insert("INSERT INTO CREDENTIALS (url,username,key,password,userid) values (#{url},#{username},#{key},#{password},#{userId})")
    @Options(useGeneratedKeys = true,keyProperty = "credentialId")
    int addCredential(Credentials credential);

    @Update("Update CREDENTIALS SET url=#{url}, username=#{username}, key=#{key}, password=#{password} where credentialid=#{credentialId}")
    int editCredential(Credentials credential);

    @Delete("Delete from CREDENTIALS where credentialid=#{credentialId}")
    int deleteCredential(Integer credentialId);
}
