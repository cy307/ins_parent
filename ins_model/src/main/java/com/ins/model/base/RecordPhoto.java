package com.ins.model.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "record_photo")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class RecordPhoto {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    private String id;

    @ApiModelProperty("用户Id")
    private String customerId;

    @ApiModelProperty("上传类型(动态或者头像)")
    private String type;

    @ApiModelProperty("动态Id(当上传类型为动态时才有)")
    private String momentId;

    @ApiModelProperty("返回内容")
    private String response;

    @ApiModelProperty("图片上传渠道")
    private String channel;

    @ApiModelProperty("上传状态")
    private Integer status;

    @ApiModelProperty("文件保存路径")
    private String fileKey;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;
}
