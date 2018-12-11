<template>
	<div class="payment totalw">
		<orderH></orderH>
		<div class="payments totalm">
			<p>支付订单</p>
		</div>
		<Footer></Footer>
	</div>
</template>
<script>
import orderH from "../orderHeader"
import Footer from "@/components/Footer"
export default {
	name: 'payment',
	data() {
		return {
			
		}
	},
	components: {
		orderH,
		Footer
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
</style>