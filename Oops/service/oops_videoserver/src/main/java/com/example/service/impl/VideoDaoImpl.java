package com.example.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.*;
import com.example.dao.VideoDao;
import com.example.po.Op_Video;
import com.example.po.VideObjet;
import com.example.service.VideoServer;
import com.example.utils.ConstantVodUtils;
import com.example.utils.InitObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import java.io.InputStream;
import java.util.List;
import java.util.Map;


@Service
public class VideoDaoImpl implements VideoServer {

    @Autowired
    private VideoDao videoDao;

    @Override
    public List<Op_Video> personage(Integer userId) {
        return videoDao.personage(userId);
    }

    @Override
    public Op_Video peVideo(Integer videoId) {
        return videoDao.peVideo(videoId);
    }

    @Override
    public List<VideObjet> getListByWeight() {
        return videoDao.getListByWeight();
    }

    @Override
    public List<VideObjet> getListByCount() {
        return videoDao.getListByCount();
    }

    @Override
    public List<VideObjet> attentionlist(Integer attentionUid) {
        return videoDao.attentionlist(attentionUid);
    }

    @Override
    public int updatecount(Map<String, Object> map) {
        System.out.println("修改作品的喜欢数"+map);
        return videoDao.updatecount(map);
    }


    String accessKeyId = "LTAI4G92Y3pq7eS3QWMiT4fA";
    String accessKeySecret = "k9zwymDQv34vkk1lN8AL2HhPxYFcpx";

    @Override
    public String uploadVideoAly(MultipartFile file) {
        //accessKeyId, accessKeySecret
        //fileName：上传文件原始名称
        try {
            String fileName = file.getOriginalFilename();
            //title：上传之后显示名称
            String title = fileName.substring(0, fileName.lastIndexOf("."));
            System.out.println("名称"+title);
            //inputStream：上传文件输入流
            InputStream inputStream = file.getInputStream();
            System.out.println("id"+ ConstantVodUtils.ACCESS_KEY_ID+"sele"+ConstantVodUtils.ACCESS_KEY_SECRET+"title, fileName, inputStream)"+title+fileName+inputStream);
            UploadStreamRequest request = new UploadStreamRequest(ConstantVodUtils.ACCESS_KEY_ID,ConstantVodUtils.ACCESS_KEY_SECRET, title, fileName, inputStream);

            System.out.println("request:"+request);
            UploadVideoImpl uploader = new UploadVideoImpl();
            UploadStreamResponse response = uploader.uploadStream(request);

            String videoId = null;
            if (response.isSuccess()) {
                videoId = response.getVideoId();
            } else { //如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因
                videoId = response.getVideoId();
            }
//            GetVideoPlayAuthResponse response1=new GetVideoPlayAuthResponse();
            System.out.println("ID"+videoId);
            return videoId;
        }catch(Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
    }

    @Override
    public String selecturl(String id) {
        DefaultAcsClient client = InitObject.initVodClient("LTAI4G92Y3pq7eS3QWMiT4fA","k9zwymDQv34vkk1lN8AL2HhPxYFcpx");
        System.out.println("视频地址");
        //创建获取视频地址request和response
        GetPlayInfoRequest request1 = new GetPlayInfoRequest();
        GetPlayInfoResponse response2 = new GetPlayInfoResponse();

        //向request对象里面设置视频id
        request1.setVideoId(id);

        //调用初始化对象里面的方法，传递request，获取数据
        try {
            response2 = client.getAcsResponse(request1);
            String  url="";

            List<GetPlayInfoResponse.PlayInfo> playInfoList = response2.getPlayInfoList();
            //播放地址
            for (GetPlayInfoResponse.PlayInfo playInfo : playInfoList) {
                url=playInfo.getPlayURL();
                System.out.print("PlayInfo.PlayURL = " + playInfo.getPlayURL() + "\n");
            }
            //Base信息
            System.out.print("VideoBase.Title = " + response2.getVideoBase().getTitle() + "\n");
            return  url;
        }catch (Exception c){
            return "视频不存在";
        }
    }


    //删除视频
    @Override
    public int delete(String id) {
        DefaultAcsClient client = InitObject.initVodClient(accessKeyId,accessKeySecret);

        //初始化对象
        //创建删除视频request对象
        DeleteVideoRequest request = new DeleteVideoRequest();
        //向request设置视频id
        request.setVideoIds(id);
        //调用初始化对象的方法实现删除
        try {
            client.getAcsResponse(request);
        }catch (Exception c){
            return 0;
        }
        return 1;
    }

    @Override
    public int invideo(Map<String, Object> map) {
        return videoDao.invideo(map);
    }

}