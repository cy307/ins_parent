package com.ins.common.photo;

import java.time.LocalDateTime;

/**
 * @author : hcq
 * @date : 2019/9/4
 */
public class UploadUtils {
    public static String generatePath(String userId, String photoType) {
        return userId + "_" + photoType + "_" + LocalDateTime.now();
    }
}
