<template>
    <div class="totalw">
        <Header></Header>
        <div class="totalm">
            <el-container style="margin-top:20px;">
                <el-aside width="130px">
                    <el-row>
                        <el-col :span="24">
                            <el-row>
                                <el-col :span="24" style="margin-bottom:20px;">
                                    <el-menu
                                        style="border:0;"
                                        default-active="1"
                                        class="el-menu-vertical-demo">
                                        <el-menu-item index="1" :class="{menuborser:true,active:classstate == '1'}" @click.native="personal">
                                            <i><img src="@/assets/img/business.png" alt=""></i>
                                            <span slot="title">个人资料</span>
                                        </el-menu-item>                   
                                        <el-menu-item index="2" :class="{menuborser:true,active:classstate == '2'}" @click.native="mycoupon">
                                            <i><img src="@/assets/img/Coupon.png" alt=""></i>
                                            <span slot="title">我的优惠卷</span>
                                        </el-menu-item>
                                        <el-menu-item index="3"  :class="{menuborser:true,active:classstate == '3'}" @click.native="myorder">
                                            <i><img src="@/assets/img/order.png" alt=""></i>
                                            <span slot="title">我的订单</span>
                                        </el-menu-item>
                                        <el-menu-item index="4"  :class="{menuborser:true,active:classstate == '4'}" @click.native="mytest">
                                            <i><img src="@/assets/img/pen.png" alt=""></i>
                                            <span slot="title">我的小测试</span>
                                        </el-menu-item>
                                        <el-menu-item index="5"  :class="{menuborser:true,active:classstate == '5'}" @click.native="mypassword">
                                            <i><img src="@/assets/img/password.png" alt=""></i>
                                            <span slot="title">修改密码</span>
                                        </el-menu-item>
                                    </el-menu>
                                </el-col>
                            </el-row>
                        </el-col>
                    </el-row>
                </el-aside>
                <el-main>
                    <el-row  v-show="setupstate == true">
                        <el-col :span="24">
                            <div style="width:100%;height:100%;text-align:center;">
                                <img src="@/assets/img/Headportrait.png" alt="" style="widh:140px;height:140px;">
                                
                                <p style="margin-top:20px;">昵称：李磊</p>
                                <!-- <p style="color:#2D3339;font-size:12px;margin-top:10px;">年级：一年级</p> -->
                                <el-button type="primary" size="medium" style="width:100px;margin-top:20px;" @click="Setup">设置</el-button>
                            </div>
                        </el-col>
                    </el-row>
                    <el-row v-show="setupstate == false">
                        <el-col :span="24">
                            <div style="width:100%;height:100%;text-align:center;">
                                <!-- <img src="@/assets/img/Headportrait.png" alt="" style="widh:140px;height:140px;"> -->
                                <el-upload
                                    class="avatar-uploader"
                                    action=""
                                    :on-change="getInfoFile"
                                    :http-request="uploadSectionFile"
                                    :show-file-list="false"
                                    :on-success="handleAvatarSuccess"
                                    :before-upload="beforeAvatarUpload"
                                    :data="uploadParm">
                                        <img v-if="imageUrl" :src="imageUrl" class="avatar">
                                        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                                </el-upload>
                                <el-form label-width="450px" >
                                    <el-row>
                                        <el-col :span="14">
                                            <el-form-item label="昵称:" prop="username">
                                                <el-input v-model="username" size="small" style="width:112%" @blur="getusername(username)"/>
                                            </el-form-item>
                                        </el-col>
                                    </el-row>
                                    <!-- <el-row>
                                        <el-col :span="14">
                                            <el-form-item label="年级:" prop="classname">
                                                <el-input v-model="classname" size="small" style="width:112%"/>
                                            </el-form-item>
                                        </el-col>
                                    </el-row> -->
                                </el-form>
                                <el-button type="primary" size="medium" style="width:100px;margin-top:20px;" @click="Detailusername">完成</el-button>
                                <el-button  size="medium" style="width:100px;margin-top:20px;" @click="cancelbtn">取消</el-button>
                            </div>
                        </el-col>
                    </el-row>

                </el-main>
            </el-container>
        </div>
        <Footer></Footer>
    </div>
</template>
<script>
import Vue from 'vue'
import api from '@/api'
import url from '@/api/URL'
import Header from '@/components/Header'
import Footer from '@/components/Footer'
import {upload} from '@/api/modules/dashboard'
  export default {
      components:{Header,Footer,upload},
      data(){
        return {
           username:"李磊",
           classname:'一年级',
           setupstate: true,
           classstate:'1',
           usernameval: '',
           filename: '',
           user:"",
           imageUrl: '',
           uploadParm: {},
        }
    },
    created(){
        
    },
    methods: {
        personal(val){
            this.classstate = '1'
            this.$router.push({name:'personalCenter'})
        },
        mycoupon(val){
            this.classstate = '2'
            this.$router.push({name:'myCoupon'})
        },
        myorder(){
            this.classstate = '3'
            this.$router.push({name:'myOrder'})
        },
        mytest(){
            this.classstate = '4'
            this.$router.push({name:'myTest'})
        },
        mypassword(){
            this.classstate = '5'
            this.$router.push({name:'changePassword'})
        },
        Setup(){
            this.setupstate = false
        },
        getusername(val){
            this.usernameval = val
        },
        cancelbtn() {
            this.setupstate = true
        },
        Detailusername(){
            var data = {
                uid: '681f95051bbf4978b455688a285b483a',
                // username: this.usernameval
            }
            api.DetailUsername(data).then(data => {
                // if(dat.status == 200) {
                    // api.UpdataImg(data).then(data => {

                    // })
                // }
            })
            
        },
        getInfoFile(file, fileList){
            this.filename = file
        },
        upload() {
            // var data = {
            //     uid: '681f95051bbf4978b455688a285b483a',
            //     profile: this.filename
            // }
            // var currentTimeStamp = new Date().getTime() / 1000;
            // if (
            //     this.uploadParams == null ||
            //     this.uploadParams.expire + 3 < currentTimeStamp
            // ) {
                // api.UpdataImg({profile: this.filename}).then(data => {
                    // this.uploadParm = req.data;
                // }).catch(err => {
                    // this.$message({ message: err.message, type: "warning" });
                // });
            // } else {
            //     this.uploadParm = this.uploadParams;
            // }
        },
        uploadSectionFile(param){
            console.log(param)
            var visaObj = {
                uid: '681f95051bbf4978b455688a285b483a'
            }
            upload(url.updataimg, param.file, JSON.stringify({uid: '681f95051bbf4978b455688a285b483a'})).then(res => {

            })
        },
        handleAvatarSuccess(res, file) {
            this.imageUrl = URL.createObjectURL(file.raw);         
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
    .el-form-item {
        margin: 0;
    }
    .menuborser {
       border-bottom:1px solid #ccc;
       color: black;
    }
    .active {
        background: #0099ff;
        color: #fff;
    }
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
    width: 178px;
    height: 178px;
    display: block;
  }
</style>
