$().ready(function() {
	
	$('#distanceSlider').slider({
		tooltip: 'always'
	});
	
    $("#washerRegForm").validate({
        rules: {
            firstName: {
                required: true
            },
            lastName: {
                required: true
            },
            phone: {
                required: true,
                digits: true,
                rangelength: [8,10]
            },
            addressLine1: {
                required: true
            },
            suburb: {
                required: true
            },
            postcode: {
                required: true,
                digits: true,
                rangelength: [4, 4]
            },

            email: {
                required: true,
                email: true
            },
            password: {
                required: true
            },
            confirmPassword: {
                required: true,
                equalTo: "#password"
            },
            bankName: {
            	required: true
            },
            accountHolder: {
                required: true
            },
            bsb: {
                required: true,
                digits: true
            },
            accountNumber: {
                required: true,
                digits: true
            },
            washerHasVacuume: {
            	required: true
            }
        },

        messages: {
            firstName: {
                required: "please enter your first name"
            },
            lastName: {
                required: "please enter your last name"
            },
            phone: {
                required: "please enter your phone number",
                digits: "phone number can only contain numbers"
            },
            addressLine1: {
                required: "please enter your street address"
            },
            suburb: {
                required: "please enter your city"
            },
            postcode: {
                required: "please enter your postcode",
                digits: "postcode can only contain numbers",
                rangelength: "postcode should be 4 digits"
            },

            email: {
                required: "please enter your email",
                email: "incorrect email format"
            },
            password: {
                required: "please enter a password"
            },
            confirmPassword: {
                required: "please confirm your password",
                equalTo: "your must enter the same password"
            },
            bankName: {
            	required: "please enter the name of your bank"
            },
            accountHolder: {
                required: "please enter your account name"
            },
            bsb: {
                required: "please enter your BSB",
                digits: "BSB can only contain numbers"
            },
            accountNumber: {
                required: "please enter your bank number",
                digits: "bank number can only contain numbers"
            },
            washerHasVacuume: {
            	required: "please tell us if you have a vacuum"
            }
        },

        errorPlacement: function(error, element)
        {
            if ( element.is(":radio") )
            {
                error.appendTo( element.parents('#topic-hasVacuum') );
            }
            else
            { // This is the default behavior
                error.insertAfter( element );
            }
         }
    });


})

