<template>
	<div class="foot">
        <div class="footer">
            <div class="callMe"><img src="../assets/Footer/tel.png" alt=""><span>联系我们</span></div>
            <div class="tel">
            客服电话：<span class="phoneNumber">400-898-9991 </span><span>(周一至周日 09:00-20:00)</span>
            </div>
            <div class="adress mt">
                公司地址: 北京市海淀区北四环中路283号高思教育大厦
            </div>
            <div class="mail mt">
                邮箱: 91haoke@gaosiedu.com
            </div>
            <div class="e-code">
                <img src="../assets/Footer/e-code.png" alt="">
                <p class="publicNumber">微信公众号</p>
            </div>
        </div>
        <div class="end">
            Copyright © 2018 厚朴教育 All Rights Reserved 京ICP备12028606号-22
        </div>
    </div>
</template>
<script type="text/javascript">
	
</script>
<style scoped>
.foot{
    width: 100%;
    height: 250px;
    background: #2D3339;
    margin-top: 10px;
}
.footer{
    width: 1200px;
    height: 204px;
    margin: 0 auto;
    color: #fff;
    border-bottom: 1px solid #3c454c;
    position: relative;
}
.callMe span{
    display: inline-block;
     margin-top: 26px;
    font-size: 16px;
}
.callMe img{
    margin-right: 12px;
}
.tel{
    margin-top: 16px;
}
.phoneNumber{
    font-size: 30px;
}
.mt{
    margin-top: 20px;
}
.adress{
    font-size: 14px;
}
.e-code{
    position: absolute;
    top: 31px;
    right: 53px;
    text-align: center;
}
.e-code img{
    width: 110px;
    height: 110px;
    border-radius: 5px;
}
.publicNumber{
    font-size: 14px;
    margin-top: 17px;
}
.end{
    text-align: center;
    opacity: 0.3;
    font-family: MicrosoftYaHei;
    font-size: 14px;
    color: #FFFFFF;
    line-height: 40px;
}
</style>