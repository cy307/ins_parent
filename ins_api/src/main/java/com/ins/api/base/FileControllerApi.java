package com.ins.api.base;

import com.ins.common.result.CommonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author : hcq
 * @date : 2019/5/28
 */
@ApiOperation("关注功能api")
@RequestMapping("fileUpload")
public interface FileControllerApi {

    @ApiOperation("上传头像")
    @PostMapping("uploadHeadPhoto")
    CommonResult uploadHeadPhoto(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest httpServletRequest) throws IOException;

    @ApiOperation("动态图片上传")
    @PostMapping("uploadMomentPhoto")
    CommonResult uploadMomentPhoto(@RequestParam("momentId") String momentId, @RequestParam("file") MultipartFile multipartFile, HttpServletRequest httpServletRequest) throws IOException;

    @ApiOperation("获取moment图片")
    @PostMapping("findMomentPhotosByMomentId")
    CommonResult<List<String>> findMomentPhotosByMomentId(@RequestParam("momentId") String momentId);


}

