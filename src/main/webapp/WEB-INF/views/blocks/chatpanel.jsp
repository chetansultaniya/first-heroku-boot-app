<div class="container-fluid bodyhtml">
	<div class="row justify-content-center h-100">
		<div class="col-sm-11 col-lg-8 chat">
			<div class="card">
				<div class="card-header msg_head">
					<div class="d-flex bd-highlight">
						<div class="img_cont">
							<img src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg" class="rounded-circle user_img">
							<span class="online_icon"></span>
						</div>
						<div class="user_info">
							<span>ChetChat Window</span>
							<p>Messages</p>
						</div>
						<div class="video_cam">
							<span><i class="fas fa-video"></i></span>
							<span><i class="fas fa-phone"></i></span>
						</div>
					</div>
					<span id="action_menu_btn"><i class="fas fa-ellipsis-v"></i></span>
					<div class="action_menu">
						<ul>
							<li><i class="fas fa-user-circle"></i> View profile</li>
							<li><i class="fas fa-users"></i> Add to close friends</li>
							<li><i class="fas fa-plus"></i> Add to group</li>
							<li><i class="fas fa-ban"></i> Block</li>
						</ul>
					</div>
				</div>
				<div class="card-body msg_card_body" id="chatmessage">
					<!-- messages are getting append here...... -->
				</div>
				<div class="card-footer">
					<div class="input-group">
						<div class="input-group-append">
							<span class="input-group-text attach_btn"><i class="fas fa-paperclip"></i></span>
						</div>
						<input type="text" id="message" class="form-control type_msg" placeholder="Type your message..."></textarea>
						<div class="input-group-append" id="send">
							<button class="input-group-text send_btn" type="submit"><i class="fas fa-location-arrow"></i></button>
							<input type="hidden" id="key" value="${key}">
							<input type="hidden" id="name" value="${name}">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>