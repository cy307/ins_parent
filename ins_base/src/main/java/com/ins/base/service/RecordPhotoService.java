package com.ins.base.service;

import com.ins.base.dao.RecordPhotoDao;
import com.ins.model.base.RecordPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : hcq
 * @date : 2019/7/15
 */
@Service
public class RecordPhotoService {

    @Autowired
    RecordPhotoDao recordPhotoDao;
    @Autowired
    FileUploadService fileUploadService;

    public List<String> findMomentPhotosByMomentId(String momentId) {
        List<String> photosUrl = new ArrayList<>();
        List<RecordPhoto> photos = recordPhotoDao.getByMomentId(momentId);
        for (RecordPhoto recordPhoto : photos) {
            photosUrl.add(fileUploadService.download(recordPhoto.getFileKey()));
        }
        return photosUrl;
    }

}
