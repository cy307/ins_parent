package com.ins.base.service;

import com.ins.base.dao.RecordPhotoDao;
import com.ins.common.photo.PhotoType;
import com.ins.common.photo.UploadUtils;
import com.ins.common.result.CommonResult;
import com.ins.common.status.CommonStatus;
import com.ins.model.base.RecordPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author : hcq
 * @date : 2019/9/4
 */
@Service
public class FileUploadService {

    @Autowired
    QiniuService qiniuService;
    @Autowired
    RecordPhotoDao recordPhotoDao;

    public void uploadHeadPhoto(String customerId, byte[] data) {

        String path = UploadUtils.generatePath(customerId, PhotoType.HEAD);
        RecordPhoto recordPhoto = new RecordPhoto()
                .setCustomerId(customerId)
                .setFileKey(path)
                .setType(PhotoType.HEAD)
                .setStatus(CommonStatus.CREATED)
                .setCreateTime(LocalDateTime.now())
                .setUpdateTime(LocalDateTime.now());
        recordPhotoDao.save(recordPhoto);
        CommonResult<String> result = qiniuService.upload(data, path);
        if (result.isSuccess()) {
            recordPhoto.setStatus(CommonStatus.SUCCESS);
        } else {
            recordPhoto.setStatus(CommonStatus.FAILED);
        }
        recordPhoto.setResponse(result.getData());
        recordPhoto.setUpdateTime(LocalDateTime.now());
        recordPhotoDao.save(recordPhoto);
    }

    public void uploadMomentPhoto(String customerId, String momentId, byte[] data) {

        String path = UploadUtils.generatePath(customerId, PhotoType.HEAD);
        RecordPhoto recordPhoto = new RecordPhoto()
                .setCustomerId(customerId)
                .setFileKey(path)
                .setType(PhotoType.MOMENT)
                .setMomentId(momentId)
                .setStatus(CommonStatus.CREATED)
                .setCreateTime(LocalDateTime.now())
                .setUpdateTime(LocalDateTime.now());
        recordPhotoDao.save(recordPhoto);

        CommonResult<String> result = qiniuService.upload(data, path);
        if (result.isSuccess()) {
            recordPhoto.setStatus(CommonStatus.SUCCESS);
        } else {
            recordPhoto.setStatus(CommonStatus.FAILED);
        }
        recordPhoto.setResponse(result.getData());
        recordPhoto.setUpdateTime(LocalDateTime.now());
        recordPhotoDao.save(recordPhoto);
    }

    public String download(String url) {
        return qiniuService.download(url);
    }
}
