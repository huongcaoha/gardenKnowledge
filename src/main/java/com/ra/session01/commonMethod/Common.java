package com.ra.session01.commonMethod;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
@Component
public class Common {
//    @Value("${cloudinary.cloud_name}")
//    private String cloud_name ;
//
//    @Value("${cloudinary.api_key}")
//    private String api_key ;
//
//    @Value("${cloudinary.api_secret}")
//    private String api_secret ;
    public Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dg10ca49n",
            "api_key", "794153818827852",
            "api_secret", "qrAX6DlWgDl--izJcSK7gvAZ8eQ"
    )); ;


    public String uploadImage(MultipartFile file) throws IOException {
        Map<String ,Object> upload = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        return upload.get("secure_url").toString();
    }
}
