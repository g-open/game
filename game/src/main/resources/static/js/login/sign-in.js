;(function () {
    $("#signInFrom").submit(function(){
    	var error = false;
	    $.ajax({
		    type: 'post',
		    url: '/user/login.do',
		    async: 'false',
		    dataType:"json",
		    data: $("#signInFrom").serialize(),
		    success: function(data) {
		    	if(data.code != "000000"){
		    		$('#alertMsg').html(data.msg);
		    	    $('#alertMsg').show();
		    	    error = false;
		    	    return error;
		    	}
		    	$('#alertMsg').hide();
		    	window.location.href=data.data.url+"?username="+data.data.username;
		    	return true;
		    },
		    error:function(data){
//		    	var errMsg = data.responseJSON.errors[0].defaultMessage;
//		    	$('#alertMsg').html(errMsg);
//		    	$('#alertMsg').show();
		    	error = false;
		    	return error;
		    }
		});
		return error;
	})

}());