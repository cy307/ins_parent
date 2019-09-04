package com.ins.base.controller;

import com.ins.base.service.FileUploadService;
import com.ins.common.result.CommonCode;
import com.ins.common.result.CommonResult;
import com.ins.common.util.JwtUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author : hcq
 * @date : 2019/7/12
 */

@ApiOperation("图片上传api")
@RestController
@RequestMapping("fileUpload")
public class FileUploadController {

    @Autowired
    FileUploadService fileUploadService;

    @ApiOperation("上传头像")
    @PostMapping("uploadHeadPhoto")
    public CommonResult uploadHeadPhoto(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest httpServletRequest) throws IOException {
//        String customerId = JwtUtil.getUserIdFromJwtHeader(httpServletRequest);
        String customerId = "3";
        fileUploadService.uploadHeadPhoto(customerId, multipartFile.getBytes());
        return new CommonResult<String>(CommonCode.SUCCESS, null);
    }

    @ApiOperation("动态图片上传")
    @PostMapping("uploadMomentPhoto")
    public CommonResult uploadMomentPhoto(@RequestParam("momentId") String momentId, @RequestParam("file") MultipartFile multipartFile, HttpServletRequest httpServletRequest) throws IOException {
//        String customerId = JwtUtil.getUserIdFromJwtHeader(httpServletRequest);
        String customerId = "3";
        fileUploadService.uploadMomentPhoto(customerId, momentId, multipartFile.getBytes());
        return new CommonResult<String>(CommonCode.SUCCESS, null);
    }


}
