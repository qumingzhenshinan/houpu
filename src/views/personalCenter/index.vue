<template>
    <div class="totalw">
        <Header></Header>
        <div class="totalm">
            <el-container style="margin-top:20px;">
                <el-aside width="130px">
                    <el-row>
                        <el-col :span="24">
                            <Menu></Menu>
                        </el-col>
                    </el-row>
                </el-aside>
                <el-main>
                    <el-row>
                        <el-col :span="24">
                            <div style="width:100%;height:100%;text-align:center;">
                                <img src="../../assets/img/空白头像.jpg" alt="" style="widh:140px;height:140px;">
                                <p style="margin-top:20px;">昵称：李磊</p>
                                <p style="color:#ccc;font-size:12px;margin-top:10px;">年级：一年级</p>
                                <el-button type="primary" size="medium" style="width:100px;margin-top:20px;" @click="Setup">设置</el-button>
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
           
        }
    },
    created(){

    },
    methods: {
        Setup(){
            this.$router.push({name:'personalCenterdetail'})
        }
    }
  }
</script>
<style scoped>

</style>
