$(function()
{
	$("#loginForm input,#loginForm textarea").jqBootstrapValidation
	(
		{
			preventSubmit : true,
			submitError : function($form, event, errors)
			{
				// additional error messages or events
			},
			submitSuccess : function($form, event)
			{
				event.preventDefault(); // prevent default submit
				
				// behaviour
				// get values from FORM
				var userid = $("input#userid").val();
				var password = $("input#password").val();
				// Message
				// Check for white space in name for Success/Fail
				// message
				if (userid.indexOf(' ') >= 0)
				{
					userid = name.split(' ').slice(0, -1).join(' ');
				}
				$this = $("#sendLoginButton");
				$this.prop("disabled", true);	// Disable submit
												// button until AJAX
												// call is complete
												// to prevent
												// duplicate
												// messages
				$.ajax
				(
					{
						url : "./php/login.php",
						type : "POST",
						data :
						{
							userid : userid,
							password : password
						},
						cache : false,
						success : function()
						{
							// Success message
							$('#success').html
							(
								"<div class='alert alert-success'>"
							);
							
							$('#success > .alert-success').html
							(
								"<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;"
							).append
							(
								"</button>"
							);
							
							$('#success > .alert-success').append
							(
								"<strong>Logged in successfully.</strong>"
							);
							
							$('#success > .alert-success').append
							(
								'</div>'
							);
							// clear all fields
							$('#loginForm').trigger("reset");
						},
						error : function()
						{
							// Fail message
							$('#success').html
							(
								"<div class='alert alert-danger'>"
							);
							
							$('#success > .alert-danger').html
							(
								"<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;"
							).append
							(
								"</button>"
							);
							
							$('#success > .alert-danger').append
							(
								$("<strong>").text
								(
									"Sorry " + userid + ", it seems that the server is not responding. Please try again later!"
								)
							);
							
							$('#success > .alert-danger').append
							(
								'</div>'
							);
							// clear all fields
							$('#loginForm').trigger("reset");
						},
						complete : function()
						{
							setTimeout(function()
							{
								$this.prop("disabled", false); // Re-enable
																// submit
																// button
																// when
																// AJAX
																// call
																// is
																// complete
							}, 1000);
						}
					}
				);
			},
			filter : function()
			{
				return $(this).is(":visible");
			},
		}
	);

	$("a[data-toggle=\"tab\"]").click(function(e)
		{
			e.preventDefault();
			$(this).tab("show");
		}
	);
});

/* When clicking on Full hide fail/success boxes */
$('#name').focus(function() {
	$('#success').html('');
});