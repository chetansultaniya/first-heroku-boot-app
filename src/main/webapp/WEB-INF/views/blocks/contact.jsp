
<!-- Contact Section -->
<section class="page-section" id="contact">
	<div class="container">

		<!-- Contact Section Heading -->
		<h2
			class="page-section-heading text-center text-uppercase text-secondary mb-0">Contact
			Me</h2>

		<!-- Icon Divider -->
		<div class="divider-custom">
			<div class="divider-custom-line"></div>
			<div class="divider-custom-icon">
				<i class="fas fa-star"></i>
			</div>
			<div class="divider-custom-line"></div>
		</div>

		<!-- Contact Section Form -->
		<div class="row">
			<div class="col-lg-8 mx-auto">
				<!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
				<form name="sentMessage" id="contactUsForm" novalidate="novalidate">
					<div class="control-group">
						<div
							class="form-group floating-label-form-group controls mb-0 pb-2">
							<label>Name</label> <input class="form-control" id="name" name="name"
								type="text" placeholder="Name" required="required"
								data-validation-required-message="Please enter your name.">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div class="control-group">
						<div
							class="form-group floating-label-form-group controls mb-0 pb-2">
							<label>Email Address</label> <input class="form-control"
								id="email" name="email" type="email" placeholder="Email Address"
								required="required"
								data-validation-required-message="Please enter your email address.">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div class="control-group">
						<div
							class="form-group floating-label-form-group controls mb-0 pb-2">
							<label>Phone Number</label> <input class="form-control"
								id="mobile" name="mobile" type="tel" placeholder="Phone Number"
								required="required"
								data-validation-required-message="Please enter your phone number.">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div class="control-group">
						<div
							class="form-group floating-label-form-group controls mb-0 pb-2">
							<label>Message</label>
							<textarea class="form-control" id="message" name="message" rows="5"
								placeholder="Message" required="required"
								data-validation-required-message="Please enter a message."></textarea>
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<br>
					<div id="success"></div>
					<div class="form-group">
						<button type="button" class="btn btn-primary btn-xl"
							id="sendMessageButton">Send</button>
						<p id="successMessage" style="pading:2px;color:Green"></p>	
					</div>
				</form>
			</div>
		</div>

	</div>
</section>

<script type="text/javascript">

$(document).ready(function(){
	  $("#sendMessageButton").click(function(){
		  var formData = {
					name:$("#name").val(),
					email:$("#email").val(),
					mobile:$("#mobile").val(),
					message:$("#message").val()
					};
		  //alert(JSON.stringify(formData));
		  $.ajax({
			    url : "http://localhost:9394/contactUs/save",
			    type: "POST",
			    data : JSON.stringify(formData),
			    dataType:'json',
			    contentType: 'application/json',
			    success: function(data, textStatus, jqXHR)
			    {
			        $('#successMessage').text('Submitted Successfully! Thank you for your response.')
			    },
			    error: function (jqXHR, textStatus, errorThrown)
			    {
			    	$('#successMessage').text('Error');
			    }
			});
	  });
	});
</script>