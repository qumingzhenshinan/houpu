<template>
    <div class="totalw">
        <Header></Header>
        <div class="totalm">
            <el-container style="margin-top:20px;">
                <el-aside width="130px">
                    <Menu></Menu>
                </el-aside>
                <el-main>
                    <el-row>
                        <el-col :span="24">
                            <div style="width:100%;height:100%;text-align:center;">
                                <img src="../../assets/img/空白头像.jpg" alt="" style="widh:140px;height:140px;">
                                <el-form label-width="450px" >
                                    <el-row>
                                        <el-col :span="14">
                                            <el-form-item label="昵称:" prop="username">
                                                <el-input v-model="username" size="small" style="width:112%"/>
                                            </el-form-item>
                                        </el-col>
                                    </el-row>
                                    <el-row>
                                        <el-col :span="14">
                                            <el-form-item label="年级:" prop="classname">
                                                <el-input v-model="classname" size="small" style="width:112%"/>
                                            </el-form-item>
                                        </el-col>
                                    </el-row>
                                </el-form>
                                <el-button type="primary" size="medium" style="width:100px;margin-top:20px;">完成</el-button>
                                <el-button  size="medium" style="width:100px;margin-top:20px;" >取消</el-button>
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
import Menu from './menu.vue'
import Header from '@/components/Header'
import Footer from '@/components/Footer'
  export default {
        components:{Menu,Header,Footer},
      data(){
        return {
           username:"李磊",
           classname:'一年级',
        }
    },
    created(){

    },
    methods: {

    }
  }
</script>
<style scoped>
    .el-form-item {
        margin: 0;
    }
</style>
