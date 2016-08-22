$().ready(function() {

    $("#passwordChangeForm").validate({
        rules: {
        	currentPassword:{
        		required: true,
        	},
            newPassword: {
                required: true,
            },
            confirmNewPassword: {
                required: true,
                equalTo: "#password"
            },
        },

        messages: {
            currentPassword:{
            	required: "please enter your current password"
            },
        	newPassword: {
                required: "please enter a new password"
            },
            confirmNewPassword: {
                required: "please confirm your password",
                equalTo: "your must enter the same password"
            },

        },
    });


})

