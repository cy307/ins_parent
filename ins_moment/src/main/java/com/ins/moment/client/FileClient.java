package com.ins.moment.client;

import com.ins.api.base.FileControllerApi;
import com.ins.api.user.UserControllerApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("INS-BASE-SERVICE")
public interface FileClient extends FileControllerApi {

}
