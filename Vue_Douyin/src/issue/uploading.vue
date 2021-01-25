<template>

<!-- <div class="publish">
<div class="pub-top">
<div class="back">
<span>x</span>
</div>
<div><span><span class="iconfont icon-yinfu"></span>选择音乐</span></div>
</div>

<div class="upload-box">
<video ref="video"style="width:100%;height:687px;object.fit:fill" src=""></video> 
<div class="upload-bar">
    <div class="bar-item">
    <div class="icon"></div>
       <p>道具</p>
    </div>
<div class="bar-item" @click="getCamera ">
   <div class="pub-border">
   <div class="pub"></div>
   </div>
</div>
<div class="bar-item">
   <div class="icon"></div>
   <p>
   </p>
   </div>
</div>
</div>
</div> -->
<!-- <div>
<video :src="videoSrc" controls="controls" width="500" height="400" 
 autoplay="autoplay" 
></video>
<input type="file" @change="getBigectURL($event)" />

<el-upload style="display: inline;"
           class="upload-ckd"
           ref="upload"
           action="doUpload"
           :limit="1"
           :before-upload="beforeUpload">
  <el-button slot="trigger" type="primary" style="margin-left: 10px;">上传</el-button>
</el-upload>
</div> -->

<div>
<el-form-item label="视频上传" prop="Video">
  <!-- action必选参数, 上传的地址 -->
    <el-upload class="avatar-uploader el-upload--text" :action="uploadUrl" :show-file-list="false" :on-success="handleVideoSuccess" :before-upload="beforeUploadVideo" :on-progress="uploadVideoProcess">
        <video v-if="videoForm.Video !='' && videoFlag == false" :src="videoForm.Video" class="avatar" controls="controls">您的浏览器不支持视频播放</video>
        <i v-else-if="videoForm.Video =='' && videoFlag == false" class="el-icon-plus avatar-uploader-icon"></i>
        <el-progress v-if="videoFlag == true" type="circle" :percentage="videoUploadPercent" style="margin-top:30px;"></el-progress>
    </el-upload>
    <P class="text">请保证视频格式正确，且不超过10M</P>
</el-form-item>


</div>
</template>

<script>
export default {
    data () {
    return {
      videoSrc: ''
    }
  },
  methods: {
    getBigectURL (event) {
      console.log('getBigectURL', event)
      var current = event.target.files[0]
      var fileReader = new FileReader()
      fileReader .readAsDataURL(current)
      var that = this
      fileReader .onload = function (e) {
        that.videoSrc = e.currentTarget.result
      }
    },
    updated(){
    this.$refs.videos.play()
  }
},
beforeUpload(file){
  if(isEmpty(file.name)){
    this.$message.warning('请选择要上传的文件！')
    return false
  }
  this.files = file;
  const extension = file.name.split('.')[1] === 'xls'
  const extension2 = file.name.split('.')[1] === 'xlsx'
  const extension3 = file.name.split('.')[1] === 'XLS'
  const extension4 = file.name.split('.')[1] === 'XLSX'
  const isMt10M = file.size / 1024 / 1024 >10
  if (!extension && !extension2 && !extension3 && !extension4) {
    this.$message.warning('上传模板只能是 xls、xlsx格式!')
    return
  }
  if (isMt10M) {
    this.$message.warning('上传模板大小不能超过 10MB!')
    return
  }
  this.fileName = file.name;
  setTimeout(() => {
    this.submitUpload();
  },500);
  return false // 返回false不会自动上传
},
submitUpload() {
  let fileFormData = new FormData();
  alert(fileFormData)
  fileFormData.append('file', this.files, this.fileName);//filename是键，file是值，就是要传的文件，test.zip是要传的文件名
  this.commonPost({
    url: HMD_UPLOADCKD,
    params: fileFormData,
    requestBody: true
  }).then((data) =>{
    if(data){
      this.$message.success("上传成功");
      this.loadData();
    }
  },(error) => {
    console.log(error);
    this.$message.error("上传失败");
    this.loadData();
  })
}
}

//     data(){
//         return{
//         }
//     },
//     methods:{
//         getCamera(){
//             navigator.mediaDevices.getUserMedia({
//             video:true
//             }).then(success=>{
//                 alert("开启摄像头成功")
//                 this.$refs['video'].srcObject =success
//                 this.$$refs['video'].play()
//             }).catch(err=>{
//                 console.log(err)
//             })
//     }
//     },
//      watch: {
//      '$route': 'getCamera'
//   }
// }
//   var vm = new Vue({
//         el: '#app',
//         data: {
//             videoFlag: false,
//             //是否显示进度条
//             videoUploadPercent: "",
//             //进度条的进度，
//             isShowUploadVideo: false,
//             //显示上传按钮
//             videoForm: {
//                 showVideoPath: ''
//             }
//         },
//         methods: {
//             //上传前回调
//             beforeUploadVideo(file) {
//                 var fileSize = file.size / 1024 / 1024 < 50;
//                 if (['video/mp4', 'video/ogg', 'video/flv', 'video/avi', 'video/wmv', 'video/rmvb', 'video/mov'].indexOf(file.type) == -1) {
//                     layer.msg("请上传正确的视频格式");
//                     return false;
//                 }
//                 if (!fileSize) {
//                     layer.msg("视频大小不能超过50MB");
//                     return false;
//                 }
//                 this.isShowUploadVideo = false;
//             },
//             //进度条
//             uploadVideoProcess(event, file, fileList) {
//                 this.videoFlag = true;
//                 this.videoUploadPercent = file.percentage.toFixed(0) * 1;
//             },
//             //上传成功回调
//             handleVideoSuccess(res, file) {
//                 this.isShowUploadVideo = true;
//                 this.videoFlag = false;
//                 this.videoUploadPercent = 0;
                
//                 //前台上传地址
//                 //if (file.status == 'success' ) {
//                 //    this.videoForm.showVideoPath = file.url;
//                 //} else {
//                 //     layer.msg("上传失败，请重新上传");
//                 //}

//                 //后台上传地址
//                 if (res.Code == 0) {
//                     this.videoForm.showVideoPath = res.Data;
//                 } else {
//                     layer.msg(res.Message);
//                 }
//             }
//         }
//     })
</script>


<style scoped>
/* .publish{
background-color:#CCCCCC ;
color: #fff ;
}
.pub-top{ 
height: 44px;
line-height: 44px;
display: flex;
justify-content: center;
color:#fff;
font-size: 16px;
position: relative; 
}
.back{
position: absolute; 
left: 10px;
}
.back span{
font-size: 28px;
}
.upload-box{ 
    height: -webkit-fill-available; 

background-color:#CCCCCC; 
}
.upload-box .upload-bar{
position: fixed;
bottom: 0;
display: flex; 
height: 120px ;
justify-content: space-between;
width: 100%;
padding: 0 50px; 
box-sizing: border-box;
background-color:#CCCCCC; 

}
.upload-box .upload-bar .icon{ 
width: 30px ;
height: 30px;
border-radius: 5px;
border: 1px red solid;
margin-bottom: 5px;
}
.pub-border{
display: flex;
align-items: center;
justify-content: center;
height:50px;width:50px;
border-radius: 50%;
border:1px #CB6074 solid;
box-shadow: -5px 0 5px #CB6074,5px 6 5px 0 #CB6074,0 -5px 5px #CB6074,0 5px 5px; 
}

.pub{
height: 45px;width: 45px;
border-radius: 50%;
background-color: #FE2C55;
} */

</style>