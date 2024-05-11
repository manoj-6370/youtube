<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">


<style type="text/css">
table tr td{
padding:0px 0px 0px 0px;

}
.card-content{

}

.form{
text-align:center;

}
td input{
margin:0px !important;
padding:0px 5px 0px 5px !important;
border-radius:3px !important;
background-color:#929aab !important;
}
</style>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background:url(img/back.png);background-size:cover;background-attachment:fixed;">

<div class="container">
 <div style="margin-top:15px;" class="row" >
  <div class="col s6 offset-s3">
    <div  class="card">
    
   <div class="card-content #90a4ae blue-grey lighten-2">
   <h3 style="margin:0px;">Register Here !</h3>
   <h3 id="msg"></h3>
      <div class="form">
      
         <form id="myform" action="login" method="post" >
            <table>
              <tr>
              <td>Name:<input type="text" name="name" placeholder="Enter your name" /></td>
              </tr>
              <tr>
              <td>Email Id:<input type="text" name="email" placeholder="Enter your email" /></td>
              </tr>
              <tr>
              <td>Password:<input type="password" name="password" placeholder="Enter your password" /></td>
              </tr>
              <!--  
              <tr>
                  <td> 
                     <p style="padding:3px; margin:2px;">
                     <label>
                       <input  type="checkbox" class="filled-in" checked="checked" name="condition" />
                       <span class="black-text">Agree terms and conditions</span>
                     </label>
                    </p>
                  </td>
             </tr>
             -->
            </table>
             <button class="btn waves-effect waves-light #2196f3 blue" type="submit" name="action">Submit
                      <i class="material-icons right">send</i>
             </button>
             <span></span>
             <button type="reset"  class="btn #2196f3 blue ">Reset</button>
         </form>
         
         </div>
         <!-- Loader... -->
         <div id="loader" style=" padding:6px;margin:4px 0px 0px 0px;display:none;">
         
    <div class="preloader-wrapper active">
    <div class="spinner-layer spinner-red-only">
      <div class="circle-clipper left">
        <div class="circle"></div>
      </div><div class="gap-patch">
        <div class="circle"></div>
      </div><div class="circle-clipper right">
        <div class="circle"></div>
      </div>
    </div>
  </div>
         
         </div>
          <!-- Loader... -->
     
    </div>
             
              </div>
            </div>
           </div>
          </div>






<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
  
  <script type="text/javascript">
  
   $(document).ready(function(){
	   console.log("page is ready...")
	 
	$('#myform').on("submit",function(event){
		event.preventDefault();
		var f=$(this).serialize();
		console.log(f);
		$('#loader').show();
		$('#myform').hide();
		
		$.ajax({
			url:"login",
			data:f,
			type:'post',
			success:function(data,textStatus,jqXHR){
		     console.log("success....")
			 console.log(data);
		     $('#loader').hide();
		     $('#myform').show();
		     if(data.trim()==="done"){
		     $('#msg').html("Login successful") ;
		     $('#msg').addClass("green-text");
		     }
		     else{
		    	 $('#msg').html("Something went wrong") ;
			     $('#msg').addClass("red-text"); 
		     }
				
			},
			error:function(textStatus,jqXHR,errorThrown){
				 $('#loader').hide();
			     $('#myform').show();
				 console.log(data);

				console.log("error...");
				$('#msg').html("Something went wrong") ;
			     $('#msg').addClass("red-text"); 
			     
			}
			
		})
		
	})
	   
   })
  
  </script>
  
</body>
</html>