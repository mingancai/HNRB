package com.hnzx.hnrb.requestbean;

import com.alibaba.fastjson.TypeReference;
import com.hnzx.hnrb.network.GetData;
import com.hnzx.hnrb.responsebean.BaseBeanRsp;

/**
 * @author: mingancai
 * @Time: 2017/4/10 0010.
 */

public class SetTopicCommentsSupportReq extends BaseBeanReq<String> {
    public Object topic_id, comment_id;

    @Override
    public String myAddr() {
        return GetData.SupportTopicComment;
    }

    @Override
    public TypeReference<BaseBeanRsp<String>> myTypeReference() {
        return new TypeReference<BaseBeanRsp<String>>() {
        };
    }
}
