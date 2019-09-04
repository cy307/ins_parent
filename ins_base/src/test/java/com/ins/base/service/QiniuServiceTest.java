package com.ins.base.service;

import com.ins.common.photo.PhotoType;
import com.ins.common.photo.UploadUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author : hcq
 * @date : 2019/7/30
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class QiniuServiceTest {

    @Autowired
    QiniuService qiniuService;

    @Autowired
    FileUploadService fileUploadService;
    @Autowired
    FileUploadService uploadHeadPhoto;

    @Test

    public void testUpLoad() throws IOException {
        File f = new File("D://imag.png");
        byte[] bytes = Files.readAllBytes(f.toPath());
        uploadHeadPhoto.uploadHeadPhoto("1",bytes);
    }

}
