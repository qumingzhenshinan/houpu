<template>
	<div class="payment totalw">
		<orderH></orderH>
		<div class="payments totalm">
			<p class="payments_p">支付订单</p>
			<div class="border_b payments_box2">
				<span>订单编号：201607089820357509</span>
				<div>
					<span>实付：</span>
					<p>￥9999.00</p>
				</div>
			</div>
			<div class="payments_box3">
				<div @click="payments(false)" :class="{border_box: payment1}">
					<p v-if="payment === false">
						<i class="el-icon-check"></i>
					</p>
					<img src="@/assets/img/wechats.png" alt="">
				</div>
				<div @click="payments(true)" :class="{border_box: payment2}">
					<p v-if="payment === true">
						<i class="el-icon-check"></i>
					</p>
					<img src="@/assets/img/zfb.jpg" alt="">
				</div>
				<p class="clearfix">
					
				</p>
				<p class="payment_box4">
					<el-button type="primary">立即支付</el-button>
					<span><i class="el-icon-info"></i>&nbsp;&nbsp;请在 24小时 以内支付完成，如未完成此订单会自动关闭。课程需重新购买！</span>
				</p>
			</div>
		</div>
		<Footer></Footer>
		<el-dialog
		  :visible.sync="dialogVisible"
		  width="30%">
		  <span>您已购买课程，不能重复购买</span>
		  <span slot="footer" class="dialog-footer">
		    <el-button @click="dialogVisible = false">取 消</el-button>
		    <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
		  </span>
		</el-dialog>
		<el-dialog
			title="请在新打开的页面完成支付"
		  :visible.sync="gopay"
		  center
		  width="30%">
		  <span>
		  	<p>支付完成前，请不要关闭此窗口</p>
		  	<p>支付完成后，将返回订单中心</p>
		  	<p>如支付失败，可在我的订单中查看是否成功</p>
			</span>
		  <span slot="footer" class="dialog-footer">
		    <el-button @click="gopay = false">取 消</el-button>
		    <el-button type="primary" @click="gopay = false">确 定</el-button>
		  </span>
		</el-dialog>
	</div>
</template>
<script>
import orderH from "../orderHeader"
import Footer from "@/components/Footer"
import api from "@/api"
export default {
	name: 'payment',
	data() {
		return {
			payment: null,
			payment1: false,
			payment2: false,
			dialogVisible: false,
			gopay: true
		}
	},
	components: {
		orderH,
		Footer
	},
	created() {
		// api.findCourse({
		// 	gclass: "四年级",
		// 	gsbuject: "",
		// 	gclassify: "专题课"
		// }).then(data => {
		// 	console.log(data);
		// })
	},
	methods: {
		payments(i) {
			this.payment = i
			if(i === false) {
				this.payment1 = true
				this.payment2 = false
			}else {
				this.payment1 = false
				this.payment2 = true
			}
		}
	}
}
</script>
<style scoped>
.payments {
	height: 500px;
	box-shadow: 0 0 6px 0 rgba(136,136,136,0.20);
	border-radius: 4px;
	margin-bottom: 40px;
	padding: 15px;
	box-sizing: border-box;
}

.border_b {
	border-bottom: 1px solid #E6EEF0;
	padding-bottom: 10px;	
}

.payments_p {
	font-size: 20px;
	color: #2D3339;
}

.payments_box2 {
	height: 50px;
	line-height: 60px;
}

.payments_box2>span {
	float: left;
	font-size: 12px;
	color: #999999;
}

.payments_box2>div {
	float: right;
	width: 200px;
	margin-right: 30px;

}

.payments_box2>div>span {
	float: left;
}

.payments_box2>div>p {
	float: right;
	font-size: 24px;
	color: #F5A623;
}

.payments_box3 {
	padding: 30px 0;
}

.payments_box3>div {
	border: 2px solid #F3F3F3;
	border-radius: 4px;
	width: 200px;
	height: 90px;
	float: left;
	margin-right: 20px;
	text-align: center;
	line-height: 115px;
	position: relative;
	overflow: hidden;
}

.payments_box3>div:hover {
	border: 2px solid #0099FF;
}

.border_box {
	border: 2px solid #0099FF !important;
}

.payments_box3>div img {
	width: 100px;
	height: 30px;
}

.payments_box3>div>p {
	position: absolute;
	bottom: -3px;
	right: 0;
	border: 15px solid #09f;
	border-color: #fff #09f #09f #fff;
	background-color: #09f;
}

.payments_box3>div>p i {
	float: right;
	color: #fff;
	position: absolute;
	top: -5px;
	left: -1px;
}

.payment_box4 {
	float: right;
	width: 450px;
	margin-top: 50px;
	text-align: right;
}

.payment_box4 span {
	float: right;
	font-size: 12px;
	color: #666;
	margin-top: 10px;
}

.payment_box4 span i {
	color: #F5A623;
}



</style>