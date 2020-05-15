let login_info = new Vue({
	el: "#login_info",
	data: {
		nickName:""
	},
	mounted: function(){
		axios.get("/user/admin/check",{params:{}}).then(result => {
			if(result.data.code == 200){
				this.nickName = result.data.data.nickName;
			}else{
				this.nickName == '';
			}
		})
	}
})