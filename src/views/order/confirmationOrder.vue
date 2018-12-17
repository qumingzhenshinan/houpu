<template>
	<div class="confirm totalw">
		<orderH></orderH>
		<div class="confirms totalm">
			<p class="confirm_p border_b">确认订单</p>
			<div class="confirm_box border_b">
				<img src="@/assets/img/Bitmap.png" alt="">
				<p>初一数学强化练习班（创新班）（秋季）初一数学强化练习班（创新班）（秋季）</p>
				<span>￥199.00</span>
			</div>
			<div class="coupon border_b" v-for="(item,index) in coupons" @click="takeCoupon(index)">
				<el-checkbox v-model="item.checked"></el-checkbox> {{item.name}} &nbsp;&nbsp;&nbsp;￥{{item.price}}
			</div>
			<div class="payment">
				<p><span>商品金额：</span><span>￥199.00</span></p>
				<p><span>优惠卷：</span><span v-for="(item,index) in coupons" v-show="item.checked">-￥{{coupons[index].price}}</span></p>
				<p><span>应付金额：</span><span v-if="couponIndex != null">￥{{199 - coupons[couponIndex].price}}</span></p>
				<p><el-button size="medium" type="primary">去付款</el-button></p>
			</div>
			<div class="clearfix">
				
			</div>
		</div>
		<Footer></Footer>
	</div>
</template>
<script>
import orderH from "./orderHeader"
import Footer from "@/components/Footer"
export default {
	name: 'confirm',
	data() {
		return {
			couponIndex: null,
			coupons: [
				{
					name: '使用优惠卷',
					price: 192.00,
					checked: false
				},{
					name: '使用优惠卷',
					price: 198.00,
					checked: false
				},{
					name: '使用优惠卷',
					price: 193.00,
					checked: false
				}
			]
		}
	},
	components: {
		orderH,
		Footer
	},
	methods: {
		takeCoupon(index) {
			if (this.coupons[index].checked === false) {
				this.couponIndex = index
				this.coupons.forEach(item => {
					item.checked = false
				})
				this.coupons[index].checked = true
				console.log(this.couponIndex,this.coupons[this.couponIndex].price);
			} else {
				this.couponIndex = null
				this.coupons[index].checked = false
			}
		}
	}
}
</script>
<style scoped>
.confirms {
	box-shadow: 0 0 6px 0 rgba(136,136,136,0.20);
	border-radius: 8px;
	padding: 15px;
	margin-bottom: 40px;
	box-sizing: border-box;
}

.confirm_p {
	font-size: 20px;
	color: #2D3339;
}

.border_b {
	border-bottom: 1px solid #E6EEF0;
	padding-bottom: 10px;	
}

.confirm_box {
	padding: 25px 15px;
	height: 80px;
}

.confirm_box img {
	width: 140px;
	height: 80px;
	float: left;
	margin-right: 20px;
}

.confirm_box p {
	color: #33495F;
	width: 460px;
	float: left;
}

.confirm_box span {
	float: right;
	font-size: 20px;
	color: #F5A623;
	margin-top: 30px;
}

.coupon {
	padding: 15px 0;
	line-height: 20px;
	cursor: pointer;
}

.payment {
	float: right;
	width: 320px;
	padding: 15px 0;
}

.payment>p {
	padding: 8px 0;
	height: 21px;

}

.payment>p>span:nth-child(1) {
	width: 85px;
	text-align: right;
	float: left;
	color: #90A4AA;
}

.payment>p>span {
	color: #33495F;
	float: right;
}

.payment>p:nth-child(3)>span:nth-child(1) {
	width: 85px;
	text-align: right;
	float: left;
	color: #90A4AA;
	font-size: 16px;
}

.payment>p:nth-child(3) span {
	font-size: 30px;
	color: #F5A623;
}

.payment>p>button {
	float: right;
	margin: 8px 0;
}

</style>