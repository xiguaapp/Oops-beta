package com.example.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideObjet {
    private  int videoId;
    private  int userId;
    private  String videoUrl;
    private  int videoCount;
    private  int weight;
    private  int videoStatus;
    private  Date videoTime;
    private  String videoDescript;
    private  String oosId;
    private  String userName;
    private  String head;
}
