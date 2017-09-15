;(function () {
    $("#signUpFrom").submit(function(){
    	var error = true;
	    $.ajax({
		    type: 'post',
		    url: '/user/register.do',
		    async: 'false',
		    dataType:"json",
		    data: $("#signUpFrom").serialize(),
		    success: function(data) {
		    	if(data.code == "000000"){
		    	   $('#alertMsg').hide();
		    	   window.location.href=data.data.url;
		    	}
		    	return true;
		    },
		    error:function(data){
		    	var errMsg = data.responseJSON.errors[0].defaultMessage;
		    	$('#alertMsg').html(errMsg);
		    	$('#alertMsg').show();
		    	error = false;
		    	return error;
		    }
		});
		return false;
	})

}());