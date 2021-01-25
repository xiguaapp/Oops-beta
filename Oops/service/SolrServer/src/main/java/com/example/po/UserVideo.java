package com.example.po;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;
import java.util.Objects;

@Data
public class UserVideo implements Serializable {

    private static final long serialVersionUID=1L;
    @Field("id")
    private String aout;
    @Field("prod_username")
    private String username;
    @Field("prod_head")
    private String head;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserVideo userVideo = (UserVideo) o;
        return Objects.equals(username, userVideo.username);
    }
    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
    @Field("prod_videoId")
    private String videoId;
    @Field("prod_videoUrl")
    private String videoUrl;
    @Field("prod_videoCount")
    private String videoCount;
    @Field("prod_videoDescript")
    private String videoDescript;
    @Field("prod_videoTime")
    private String videoTime;
    @Field("prod_signature")
    private String signature;
    @Field("prod_userid")
    private String userid;
}
