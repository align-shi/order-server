package com.xiaoshi.domain;

import lombok.Data;

/**
 * @ClassName FeedbackDTO
 * @Author xiaoshi
 * @Date 2021/3/28 20:11
 * @Description
 **/
@Data
public class FeedbackDTO {

    private String content;

    private String contract;

    private String deviceModel;

    private String deviceSystem;

    private String appVersion;

    private String username;
}
