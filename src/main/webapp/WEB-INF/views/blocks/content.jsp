<!-- Masthead -->
<header class="masthead bg-primary text-white text-center">
	<div class="container d-flex align-items-center flex-column">

		<!-- Masthead Avatar Image -->
		<img class="masthead-avatar mb-5" src="${baseURL}/img/avataaars.svg"
			alt="">

		<!-- Masthead Heading -->
		<h1 class="masthead-heading text-uppercase mb-0">Start ChetChat</h1>

		<!-- Icon Divider -->
		<div class="divider-custom divider-light">
			<div class="divider-custom-line"></div>
			<div class="divider-custom-icon">
				<i class="fas fa-star"></i>
			</div>
			<div class="divider-custom-line"></div>
		</div>
		
		<p class="masthead-subheading font-weight-light mb-0">ChetChat a chat application!!!!</p>
		<!-- Entry section for chat -->
		<form action="${baseURL}/chatpage" method="post">
			<div class="row" id="showchatentry" style="">
	    		<div class="col-sm-6" style="">
	    			<div class="input-group input-group-lg mt-3">
	  					<input type="password" class="form-control" placeholder="Secret Key. . ." name="key">
					</div>
	    		</div>
	    		<div class="col-sm-6" style="">
	    			<div class="input-group input-group-lg mt-3">
	  					<input type="text" class="form-control" placeholder="Name. . ." name="name">
					</div>
	    		</div>
	    		<div class="text-center col-sm-12 mt-3" id="startchatbutton">
					<button type="submit" class="btn btn-xl btn-outline-light btn-block"> 
					<i class="far fa-comment mr-2"></i> Start Chat
					</button>
				</div>
	  		</div>
  		</form>
		<!-- Masthead Subheading -->
		
		
		
	</div>
</header>