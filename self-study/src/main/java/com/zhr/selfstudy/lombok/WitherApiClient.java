package com.zhr.selfstudy.lombok;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Wither;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName WitherApiClient
 * @Date 2019/5/10 11:13
 * @description 用wither方式构建对象，这在Objective-C 中比较多见。
 * 适用的场景是，使用几个必要的参数构建对象，其他参数，动态的拼装。举个例子，我们构建一个ApiClient，它的用户名和密码是必须的，
 * 他的ApiService的地址有一个默认值，然后我们可以自己定制这个地址。
 **/
@RequiredArgsConstructor
@Wither
@AllArgsConstructor
public class WitherApiClient {

    @NonNull
    private String appId;
    @NonNull
    private String appKey;
    private String endpoint = "http://api.pollyduan.com/myservice";

}
