package com.ins.user.client;

import com.ins.api.base.FollowControllerApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("INS-BASE-SERVICE")
public interface FollowClient extends FollowControllerApi {

}
