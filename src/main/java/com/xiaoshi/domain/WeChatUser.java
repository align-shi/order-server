package com.xiaoshi.domain;

import lombok.Data;

/**
 * @ClassName WeChatUser
 * @Author xiaoshi
 * @Date 2021/3/28 15:33
 * @Description
 **/
@Data
public class WeChatUser {

    private String nickName;

    private String gender;

    private String vip;

    private String avatarUrl;
}
