<template>
    <div>
        <el-row>
            <el-col :span="24">
                <el-menu
                    style="border:0;"
                    default-active="1"
                    class="el-menu-vertical-demo">
                    <el-menu-item index="1" class="menuborser">
                        <i><img src="../../assets/名片.png" alt=""></i>
                        <span slot="title">个人资料</span>
                    </el-menu-item>
                    <el-menu-item index="2" class="menuborser">
                        <i><img src="../../assets/优惠劵.jpg" alt=""></i>
                        <span slot="title">我的优惠卷</span>
                    </el-menu-item>
                    <el-menu-item index="3" class="menuborser">
                        <i><img src="../../assets/订单2.png" alt=""></i>
                        <span slot="title">我的订单</span>
                    </el-menu-item>
                    <el-menu-item index="4" class="menuborser">
                        <i><img src="../../assets/笔1.png" alt=""></i>
                        <span slot="title">我的小测试</span>
                    </el-menu-item>
                    <el-menu-item index="4" class="menuborser">
                        <i><img src="../../assets/锁2.png" alt=""></i>
                        <span slot="title">修改密码</span>
                    </el-menu-item>
                </el-menu>
            </el-col>
        </el-row>
    </div>
</template>
<script>
import Vue from 'vue'
  export default {
      data(){
        return {
           
        }
    },
    created(){

    },
    methods: {

    }
  }
</script>
<style scoped>
    .menuborser {
       border-bottom:1px solid #ccc;
    }
</style>