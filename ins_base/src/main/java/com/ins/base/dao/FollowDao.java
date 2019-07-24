package com.ins.base.dao;

import com.ins.model.base.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : hcq
 * @date : 2019/7/15
 */
@Repository
public interface FollowDao extends JpaRepository<Follow, String> {
    /**
     *
     * @param userId
     * @param targetUserId
     * @param status
     * @return
     */
    Boolean existsByUserIdAndTargetUserIdAndStatus(String userId,String targetUserId,boolean status);

    Follow getByUserIdAndTargetUserIdAndStatus(String userId,String targetUserId,boolean status);

    List<Follow> getByUserIdAndStatus(String userId,boolean status);

    List<Follow> getByTargetUserIdAndStatus(String targetUserId,boolean status);
}
