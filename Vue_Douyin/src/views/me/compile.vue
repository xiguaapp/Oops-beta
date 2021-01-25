
<template>
<div class="mobile-wrap center mobile-wrap-mb">
        <header>
        	<span class="return">
        		返回
        	</span>
        </header>
        <main>
        	<div class="inform">
        		<h3 class="xty">账号管理</h3>
        		<div class="inform-list xoi" >
                      <el-tabs v-model="activeName">
          				<el-tab-pane label="信息编辑" name="first">
                              <div class="zks">
                        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                          <!-- 头像 -->
                        <el-upload
                        class="avatar-uploader"
                        action="http://localhost:9003/addimg"
                        :show-file-list="false"
                        :on-success="handleAvatarSuccess"
                        :before-upload="beforeAvatarUpload">
                        <a class="zjs">点击更换头像</a>
                        <img v-if="imageUrl" :src="ruleForm.head" class="avatar">
                        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                        </el-upload>

                         </el-form-item>
                          <!-- <div>
                        <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
                          </div> -->
                        <el-form-item label="名称" prop="userName">
                        <el-input v-model="ruleForm.userName" style="width: 65%;"></el-input>
                        </el-form-item>

                         <!-- OOps号 -->
                        <el-form-item label="OOps号" prop="userId">
                         <el-input v-model="ruleForm.userId" disabled style="width: 65%;"></el-input>
                        </el-form-item>

                            <!-- OOps号 -->
                            <!-- <el-form-item label="OOps号" style="width: 100%;">
                                <el-input v-model="form.id" style="width: 65%;"></el-input>
                            </el-form-item> -->

                             <!-- 简介 --> 
                           <el-form-item label="简介" prop="signature">
                                   <el-input type="textarea" style="width: 65%;" v-model="ruleForm.signature"></el-input>
                            </el-form-item>

                             <!-- 性别 -->
                              <!-- <el-form-item label="性别" style="width: 100%;">
                                <el-input v-model="form.name" style="width: 65%;"></el-input>
                            </el-form-item> -->

                            <!-- 生日 -->
                            <!-- <el-form-item label="生日" prop="birthday">
                                <el-col :span="11">
                                <el-date-picker type="date" placeholder="日期" v-model="ruleForm.birthday" style="width: 140%;"></el-date-picker>
                                </el-col>
                            </el-form-item> -->

                            <!-- 地区 -->

                            <!-- 隐私用户 -->
                            <!-- <el-form-item label="隐私用户" prop="delivery">
                                <el-switch v-model="ruleForm.delivery"></el-switch>
                            </el-form-item> -->
                          <!-- <el-form-item>
                            
                            </el-form-item> -->
                            <el-form-item>
                              <el-popover
  placement="top"
  width="160"
  v-model="visible">
  <p>请确认是否要修改资料内容</p>
  <div style="text-align: right; margin: 0">
    <el-button size="mini" type="text" @click="visible = false">取消</el-button>
    <el-button type="primary" size="mini"  @click="submitForm('ruleForm')" >确定</el-button>
  </div>
                            <el-button type="primary"  slot="reference" >立即修改</el-button>
                              </el-popover>
                            <el-button @click="resetForm('ruleForm')">重置</el-button>
                            </el-form-item>
                        </el-form>
                              </div>
                        </el-tab-pane>
        				<el-tab-pane label="修改密码" name="second">
                          <el-form :model="ruleForm1" status-icon :rules="rules" ref="ruleForm1" label-width="100px" class="demo-ruleForm">

                            <el-form-item label="手机号" prop="Mobile">
                                <el-input type="Mobile" style="width: 65%;" v-model="ruleForm1.Mobile" autocomplete="off"></el-input>
                            </el-form-item>

                            <el-form-item label="密码" prop="pass">
                                <el-input type="password" style="width: 65%;" v-model="ruleForm1.pass" autocomplete="off"></el-input>
                            </el-form-item>
                            <el-form-item label="确认密码" prop="checkPass">
                                <el-input type="password" style="width: 65%;" v-model="ruleForm1.checkPass" autocomplete="off"></el-input>
                            </el-form-item>

                            <el-form-item>
                                <el-popover
  placement="top"
  width="160"
  v-model="visibles">
  <p>请谨慎修改密码</p>
  <div style="text-align: right; margin: 0">
    <el-button size="mini" type="text" @click="visibles = false">取消</el-button>
    <el-button type="primary" size="mini"  @click="submitForm1('ruleForm1')" >确定</el-button>
  </div>
                            <el-button type="primary"  slot="reference" >立即修改</el-button>
                              </el-popover>
                                <!-- <el-button type="primary" @click="submitForm1('ruleForm1')">提交</el-button> -->
                                <el-button @click="resetForm1('ruleForm1')">重置</el-button>

                            </el-form-item>
                            </el-form>
                        </el-tab-pane>
                        </el-tabs>
        			
        		</div>
               </div>
                     		
        </main>
</div>
</template>

<script>
//引入api
import {pslhpage,amend,changepwd} from '@/api/user.js';
export default {

 created(){
   const Pthis=this;
          pslhpage().then(res => {
              //console.log("返回值"+res.data.data.user.use2.userName)
              ////localStorage.setItem('token',"这个是一个token"),
               Pthis.ruleForm=res.data.data.user.use2;
              console.log("用户:"+res.data.data.user.use2.userName)
          })
  },
     data() {
           var checkAge = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('年龄不能为空'));
        }
        setTimeout(() => {
          if (!Number.isInteger(value)) {
            callback(new Error('请输入数字值'));
          } else {
            if (value < 18) {
              callback(new Error('必须年满18岁'));
            } else {
              callback();
            }
          }
        }, 1000);
      };
      
var validateMobile = (rule, value, callback) => {
        var regtel = /^1[345789]{1}\d{9}$/;
        if (value === '') {
          callback(new Error('请输入手机号'));
        } else if (!regtel.test(value)) {
          callback(new Error('请输入正确的手机号'));
        }{
          if (this.ruleForm1.checkPass !== '') {
            this.$refs.ruleForm1.validateField('checkPass');
          }
          callback();
        }
      };

      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.ruleForm1.checkPass !== '') {
            this.$refs.ruleForm1.validateField('checkPass');
          }
          callback();
        }
      };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.ruleForm1.pass) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
      return {
          imageUrl: require('../../assets/img/xxx.jpeg'),
          activeName: 'first',
          ruleForm1:{
          pass: '',
          checkPass: '',
          age: '',
          Mobile:''
          },
        visible: false,
        visibles: false,
        ruleForm: {
            // 头像
          head: '',
           //OOPS号
          userId:'',
          // 名称
          userName:'',
          //生日
          // birthday:'',
          //简介
          signature:'',
          // //性别
          // sex:'',
          // //是否选择将用户隐藏
          // delivery: false,
        },
        rules1:{
         
        },
         rules: {
          name: [
            { required: true, message: '请输入名称', trigger: 'blur' },
            { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
          ],
          Mobile:[{
             validator: validateMobile, trigger: 'blur'
          }],
          pass: [
            { validator: validatePass, trigger: 'blur' }
          ],
          checkPass: [
            { validator: validatePass2, trigger: 'blur' }
          ],
          age: [
            { validator: checkAge, trigger: 'blur' }
          ]
       
        }
      };
      },
        //资料修改
        methods: {
          submitForm(formName) {
            this.visible=false
        this.$refs[formName].validate((valid) => {
          //获取表单的值
          const _this=this
          if (valid) {
              alert('submit 值'+_this.ruleForm);
              amend(_this.ruleForm).then(res => {
              //console.log("返回值"+res.data.data.user.use2.userName)
              ////localStorage.setItem('token',"这个是一个token"),
              //  Pthis.ruleForm=res.data.data.user.use2;
              console.log("是否修改:"+res.data.success)
              if (res.data.success==true) {
                 //修改成功
                  this.$message({
                  message: '修改成功',
                  type: 'success'
                   });
              }else{
                //修改失败
                  this.$message.error('修改失败');
              }
          })
          } else {
            console.log('error submit!!');
            this.$message.error('修改失败');
            return false;
          }
        });
      },
        // 密码修改
         submitForm1(formName) {
          this.visibles=false  
        this.$refs[formName].validate((valid) => {
          //获取表单的值
          const _this=this
           alert('submit!'+_this.ruleForm1.Mobile);
          if (valid) {
              changepwd(_this.ruleForm1).then(res => {
              //console.log("返回值"+res.data.data.user.use2.userName)
              ////localStorage.setItem('token',"这个是一个token"),
              //  Pthis.ruleForm=res.data.data.user.use2;
              console.log("是否修改:"+res.data.success)
              if (res.data.success==true) {
                 //修改成功
                  this.$message({
                  message: '修改成功',
                  type: 'success'
                   });
                  sessionStorage.clear()
                  window.location.reload();
              }else{
                //修改失败
                   this.$message.error('手机号不正确');
              }
          })
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      // 资料清空
      resetForm(formName1) {
        this.$refs[formName1].resetFields();
      },
    // 密码清空
       resetForm1(formName1) {
        this.$refs[formName1].resetFields();
      },
    // 图片上传
     handleAvatarSuccess(res, file) {
        this.ruleForm.head= URL.createObjectURL(file.raw);
      },
      beforeAvatarUpload(file) {
        const isJPG = file.type === 'image/jpeg';
        const isLt2M = file.size / 1024 / 1024 < 2;

        if (!isJPG) {
          this.$message.error('上传头像图片只能是 JPG 格式!');
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!');
        }
        return isJPG && isLt2M;
      }
    }
  }

</script>

<style scoped>
body,p,h1,h2,h3,h4,h5,li,span,i,ul,img,a,strong,input,textarea,select,dl,dd,dt{margin:0;padding:0;}
body{font-family:"microsoft yahei","Arial";font-size: 0.24rem;line-height: 1;color:#333;-webkit-user-select:none;-webkit-text-size-adjust: 100% !important; text-size-adjust: 100% !important;-moz-text-size-adjust: 100% !important;}
::-webkit-scrollbar{width: 0;height: 0;}/*滚动条宽高设为0*/
*{-webkit-tap-highlight-color:rgba(0,0,0,0);-webkit-box-sizing: border-box;-moz-box-sizing: border-box;box-sizing: border-box;}
[class|="ico"]{-webkit-background-size: 100% 100%;background-size: 100% 100%;display: inline-block;vertical-align: middle;}
[class|="icon-"]{font-family:"iconfont" !important;font-size:.24rem !important;font-style:normal;-webkit-font-smoothing: antialiased;-moz-osx-font-smoothing: grayscale;}
li{list-style-type:none; float:left;}
a{text-decoration:none;color: #333;}
img{border:none;vertical-align: middle;margin-top: 0;}
i,var,em{font-style:normal;}

 .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    position: fixed;
    left: 31%;
    top: 15%;
    height: 11%;
    width: 20%;
    border-radius: 50%;
  }

.zjs{
    position: fixed;
    left: 28%;
    top: 26%;
}

.xty{
    position: fixed;
    left: 41%;
    top: 0%;
}

.xoi{
    position: absolute;
    left: 0%;
    top: 6%;
    width: 100%;
}

.zks{
    position: fixed;
    left: -5%;
    top: 31%;
}
</style>