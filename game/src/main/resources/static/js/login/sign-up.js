;(function () {
    $("#signUpFrom").submit(function(){
    	var error = true;
	    $.ajax({
		    type: 'post',
		    url: '/user/register.do',
		    async: 'false',
		    data: $("#signUpFrom").serialize(),
		    success: function(data) {
		    	$('#alertMsg').hide();
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