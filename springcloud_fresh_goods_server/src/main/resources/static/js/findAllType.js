$(function() {
	$.post("good/findAllType",null,function(data){
		var str="";
		$.each(data,function(index,item){
			str +=' <li><a href="javascript:uptno('+item.tno+')" class="fruit">'+item.tname+'</a></li>'
		})
		$("#subnav").html("").append($(str));
},"json");
})
