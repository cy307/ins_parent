package com.ins.base.dao;

import com.ins.model.base.RecordPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : hcq
 * @date : 2019/7/15
 */
@Repository
public interface RecordPhotoDao extends JpaRepository<RecordPhoto, String> {
}
