$().ready(function() {

    $("#washeeRegForm").validate({
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

            carType: {
            	required: true
            },
            electricity: {
            	required: true
            },
            waterSource: {
            	required: true
            },
            vacuum: {
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

            carType: {
            	required: "please select your car type"
            },
            electricity: {
            	required: "please tell us what electricity source is available"
            },
            waterSource: {
            	required: "please tell us what water source is available"
            },
            vacuum: {
            	required: "please tell us if vacuum is available"
            }
        },

        errorPlacement: function(error, element)
        {
            if ( element.attr("name") == "carType" )
            {
                error.appendTo( element.parents('#topic-carType') );
            }
            else if ( element.attr("name") == "electricity" )
            {
                error.appendTo( element.parents('#topic-electricity') );
            }
            else if ( element.attr("name") == "waterSource" )
            {
                error.appendTo( element.parents('#topic-waterSource') );
            }
            else if ( element.attr("name") == "vacuum" )
            {
                error.appendTo( element.parents('#topic-vacuum') );
            }
            else
            { // This is the default behavior
                error.insertAfter( element );
            }
         }
    });


})

