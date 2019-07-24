package com.ins.user.client;

import com.ins.api.moment.MomentControllerApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("INS-MOMENT-SERVICE")
public interface MomentClient extends MomentControllerApi {

}
