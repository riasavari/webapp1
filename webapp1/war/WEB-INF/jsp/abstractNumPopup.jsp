<div class="container">
  
  <!-- Trigger the modal with a button -->
<!--  <button type="button" id="openModal" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>  -->
 
<!-- Modal -->
  <div class="modal fade" id="numberModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Your abstract number</h4>
        </div>
        <div class="modal-body">
          <p>Your abstract number is <b> ${absNo} </b>  </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
    
</div>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <script  src="/lib/jquery-min-latest.js"></script>
	<script  src="bootstrap/js/bootstrap.min.js"></script>
	<script  src="/js/abstractNumPopup.js"></script> 
</html>

  