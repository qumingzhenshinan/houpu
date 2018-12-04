<template>
    <div class="totalw">
        <Header></Header>
        <div  class="totalm">
            <el-container style="margin-top:20px;">
                <el-aside width="130px">
                    <Menu></Menu>
                </el-aside>
                <el-main>
                    <el-row>
                        <el-col :span="24">
                            <el-tabs v-model="activeName" @tab-click="handleClick">
                                <el-tab-pane label="我的优惠券" name="first">
                                    <div v-for="item in couponlist">
                                        <el-row style="border:1px solid #999;padding:15px;border-radius:5px">
                                            <el-col :span="4">
                                                <img src="../../assets/img/优惠券1.jpg" alt="" style="width:100%;height:100%">
                                            </el-col>
                                            <el-col :span="19" style="margin-left:20px">
                                                <p style="font-weight:600;">立减￥10元</p>
                                                <p style="font-size:13px;margin-top:10px;min-height:50px">优惠券描述：这是一个这是一个这是一个这是一个这是一个这是一个这是一个这是一个这是一个这是一个这是一个这是一个这是一个这是一个这是一个</p>
                                                <p style="font-size:12px;margin-top:10px;">使用期限制：2018-09-20</p>
                                            </el-col>
                                        </el-row>
                                    </div>
                                </el-tab-pane>
                            </el-tabs>
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
           activeName: 'first',
           couponlist:[{

           }]
        }
    },
    created(){

    },
    methods: {

    }
  }
</script>
<style scoped>

    
</style>
