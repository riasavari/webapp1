<div class="container">
   
  <!-- NOR USED -->
  <!-- Trigger the modal with a button -->
<!--  <button type="button" id="openModal" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>  -->
 
<!-- Modal -->
  <div class="modal fade" id="numberModal" data-backdrop="static" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Your QuakeCoRE publication number</h4>
        </div>
        <div class="modal-body">
          <p>Your QuakeCoRE publication number for this item is <b> ${pubNo} </b>. Please add the following statement in your acknowledgement.</p>
        <p><b>This project was (partially) supported by QuakeCoRE, a New Zealand Tertiary Education Commission-funded Centre. This is QuakeCoRE publication number ${pubNo}.</b></p>
        <p>You will receive an email with the information above confirming your publication number shortly.</p>
        </div>
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
	<script  src="/js/numberpopup.js"></script> 
</html>

  