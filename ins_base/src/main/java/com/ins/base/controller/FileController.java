package com.ins.base.controller;

import com.ins.api.base.FileControllerApi;
import com.ins.base.service.FileUploadService;
import com.ins.base.service.RecordPhotoService;
import com.ins.common.result.CommonCode;
import com.ins.common.result.CommonResult;
import com.ins.common.util.JwtUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author : hcq
 * @date : 2019/7/12
 */

@ApiOperation("图片上传api")
@RestController
@RequestMapping("fileUpload")
public class FileController implements FileControllerApi {

    @Autowired
    FileUploadService fileUploadService;
    @Autowired
    RecordPhotoService recordPhotoService;

    @Override
    @ApiOperation("上传头像")
    @PostMapping("uploadHeadPhoto")
    public CommonResult uploadHeadPhoto(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest httpServletRequest) throws IOException {
        String customerId = JwtUtil.getUserIdFromJwtHeader(httpServletRequest);
        fileUploadService.uploadHeadPhoto(customerId, multipartFile.getBytes());
        return new CommonResult<String>(CommonCode.SUCCESS, null);
    }

    @Override
    @ApiOperation("动态图片上传")
    @PostMapping("uploadMomentPhoto")
    public CommonResult uploadMomentPhoto(@RequestParam("momentId") String momentId, @RequestParam("file") MultipartFile multipartFile, HttpServletRequest httpServletRequest) throws IOException {
        String customerId = JwtUtil.getUserIdFromJwtHeader(httpServletRequest);
        fileUploadService.uploadMomentPhoto(customerId, momentId, multipartFile.getBytes());
        return new CommonResult<String>(CommonCode.SUCCESS, null);
    }

    @Override
    @ApiOperation("获取moment图片")
    @PostMapping("findMomentPhotosByMomentId")
    public CommonResult<List<String>> findMomentPhotosByMomentId(@RequestParam("momentId") String momentId) {
        List<String> photos = recordPhotoService.findMomentPhotosByMomentId(momentId);
        return new CommonResult<>(CommonCode.SUCCESS, photos);
    }


}
