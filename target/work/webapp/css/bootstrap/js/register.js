/*----------------------注册验证------------------------*/
$(document).ready(function () {
	$("form").submit(function(){
	/*  验证输入的账户是否合法  */
	if (/^[\u4e00-\u9fa5]+$/.test($('#username').val())) {
		alert("账号不能为中文！");
		return false;
	}
	/*验证输入的联系电话是否合法 */

	/*  验证两次输入的密码是否一致*/

	if($("#pwd").val()!=$("#pwd1").val()||$("#pwd").val().length<6||$("#pwd").val().length>12||$("#pwd1").val().length<6||$("#pwd1").val().length>12){
		alert("密码输入不正确！");
			return false;
		}

	})
	
	/*  手机号验证*/
	$("#tel").keyup(function(){
		
		if($("#tel").val().length==3||$("#tel").val().length==8)
			{
			$("#tel").val($("#tel").val()+" ");
			}
	})
	$("#tel").blur(function(){
		if($("#tel").val()){
		    if(/^1[34578]\d{1}\s\d{4}\s\d{4}$/.test($("#tel").val())==false){
			alert("请输入正确格式！");
			return false;
		      }
		  }
	})
	
	/*验证码*/
	$("#CheckCode1").click(function(){
		document.getElementById("CheckCode1").src =  document.getElementById("CheckCode1").src+ "?nocache=" + new Date().getTime();
	})
	$("input").each(function(){
     	$(this).click(function(){
	
		    $(this).tooltip('');
	  })
	})
	return true;
})
  
