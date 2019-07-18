package com.ins.api.moment;

import com.ins.common.result.CommonResult;
import com.ins.model.moment.Moment;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : hcq
 * @date : 2019/5/28
 */
@ApiOperation("动态接口")
@RequestMapping("moment")
public interface MomentControllerApi {

    @ApiOperation("查询动态")
    @GetMapping("{id}")
    CommonResult getMomentById(@PathVariable("id") String id);

    @ApiOperation("增加动态")
    @PostMapping
    CommonResult saveMoment(@RequestBody Moment moment);

    @ApiOperation("更新动态")
    @PutMapping
    CommonResult updateMoment(@RequestBody Moment moment);

    @ApiOperation("删除动态")
    @DeleteMapping
    CommonResult deleteMoment(@RequestParam("id") String id);

    @ApiOperation("查询用户动态")
    @GetMapping("getCommentsByUserId")
    CommonResult getCommentsByUserId(@RequestParam("userId") String userId);

    @ApiOperation("查看具体动态")
    @GetMapping("detail")
    CommonResult getCommentsByUserId(@RequestParam("userId") String userId, @RequestParam("momentId") String momentId);

    @ApiOperation("查看具体动态")
    @GetMapping("getMomentByIds")
    CommonResult getMomentByIds( @RequestParam("ids") String ids);


}

