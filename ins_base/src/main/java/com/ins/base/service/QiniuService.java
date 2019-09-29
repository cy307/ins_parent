package com.ins.base.service;

import com.ins.common.result.CommonCode;
import com.ins.common.result.CommonResult;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author : hcq
 * @date : 2019/9/3
 */
@Service
public class QiniuService {

    @Value("${qiniu.accessKey}")
    private String accesskey;

    @Value("${qiniu.secretKey}")
    private String secretKey;

    @Value("${qiniu.bucketName}")
    private String bucketName;

    @Value("${qiniu.domainUrl}")
    private String domainUrl;

    @Value("${qiniu.photoFormatName}")
    private String photoFormatName;


    private Auth auth;
    private String uploadToken;

    private UploadManager uploadManager;

    @PostConstruct
    public void init() {
        //初始化上传token
        auth = Auth.create(accesskey, secretKey);
        uploadToken = auth.uploadToken(bucketName);
        //初始化上传对象
        Zone z = Zone.autoZone();
        Configuration c = new Configuration(z);
        uploadManager = new UploadManager(c);
    }


    public CommonResult<String> upload(byte[] data, String fileName) {
        try {
            //调用put方法上传，这里指定的key和上传策略中的key要一致
            Response res = uploadManager.put(data, fileName, uploadToken);
            //打印返回的信息
            return new CommonResult<>(CommonCode.SUCCESS, res.bodyString());
        } catch (QiniuException e) {
            return new CommonResult<>(CommonCode.FAIL, e.getMessage());
        }
    }

    public String download(String url) {
        //图片裁剪
        String downloadUrl = auth.privateDownloadUrl(url + "-" + photoFormatName, 3600);
        return domainUrl + downloadUrl;
    }

}
