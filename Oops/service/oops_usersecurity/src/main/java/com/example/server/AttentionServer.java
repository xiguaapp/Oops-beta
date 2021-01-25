package com.example.server;

import com.example.po.OpAttentionEntity;

import java.util.List;

public interface AttentionServer {

    //查询关注
    List<OpAttentionEntity> attention(int attentionUid);

    //查询粉丝
    List<OpAttentionEntity> fans(int beattentionuid);

    //判断是否关注了这个用户
    OpAttentionEntity verdict(int auserid,int buserid);

    //关注某个用户
    int inverdict(int attentionUid,int beAttentionUid);

    //取消关注
    int deverdict(int attentionUid,int beAttentionUid);


}
