//package com.example.vueboot.util;
//
//
//import com.aliyun.vod.upload.impl.UploadVideoImpl;
//import com.aliyun.vod.upload.req.UploadVideoRequest;
//import com.aliyun.vod.upload.resp.UploadVideoResponse;
//import com.aliyuncs.DefaultAcsClient;
//import com.aliyuncs.vod.model.v20170321.GetPlayInfoRequest;
//import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse;
//import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
//import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
//import sun.applet.Main;
//
//import java.util.List;
//
//public class Text {
//    public void  S(String fileName,String accessKeyId,String accessKeySecret){
//
//        String title = "Oops欢迎您";   //上传之后文件名称
//        //本地文件路径和名称
//        //上传视频的方法
//        UploadVideoRequest request = new UploadVideoRequest(accessKeyId, accessKeySecret, title, fileName);
//        /* 可指定分片上传时每个分片的大小，默认为2M字节 */
//        request.setPartSize(2 * 1024 * 1024L);
//        /* 可指定分片上传时的并发线程数，默认为1，(注：该配置会占用服务器CPU资源，需根据服务器情况指定）*/
//        request.setTaskNum(1);
//
//        UploadVideoImpl uploader = new UploadVideoImpl();
//        UploadVideoResponse response = uploader.uploadVideo(request);
//
//        if (response.isSuccess()) {
//            System.out.print("VideoId=" + response.getVideoId() + "\n");
//        } else {
//            /* 如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因 */
//            System.out.print("VideoId=" + response.getVideoId() + "\n");
//            System.out.print("ErrorCode=" + response.getCode() + "\n");
//            System.out.print("ErrorMessage=" + response.getMessage() + "\n");
//        }
//    }
//}
