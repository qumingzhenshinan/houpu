<template>
	<div id="test">
		<Header></Header>
		<Footer></Footer>
	</div>
</template>
<script type="text/javascript">
import Header from '../../components/Header.vue'
import Footer from '../../components/Footer.vue'
export default{
data(){
	return {
		
	}
},
components:{
	Header,
	Footer
}
}
</script>
<style type="text/css" media="screen">
#test{
	width: 1366px;
	/* height: 1000px; */
	margin: 0 auto;
	/* border: 1px solid #000; */
}
</style>