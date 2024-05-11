<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<style>
.row{
margin-top:20px;
}
.card-content{
border:2px solid black;
background-color:#f7f7f7;
}
.card-content h3{
margin:10px 0px 10px 0px;
}
tr{
border:0px !important;
}

form table tr td{
padding:0px;
}
input{
padding:0px 5px 0px 5px !important;
border-radius:3px !important;
background-color:#929aab !important;

}
</style>
<head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script> 
 <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background: url(img/form.png);background-size:cover ;background-attachment:fixed;">
   
    <div class="container">
       
      <div class="row">
       <div class="col s6 offset-s3">
        <div class="card">
        <div class="card-content center-align" >
         <h3 style="padding:0px;" >Register here !!</h3>
         <h5 id="msg"></h5>
        <div class="form center-align">
        
         <form id="myform" action="signin" method="post" >
          <table>
           <tr>
            <td><input type="text" name="name" placeholder="Enter user-name"/></td>
           </tr>
           <tr>
            <td><input type="password" name="password" placeholder="Enter password"/></td>
           </tr>
           <tr>
            <td><input type="email" name="email" placeholder="Enter email"/></td>
           </tr>
          </table>
          
          <div class="file-field input-field">
           <div class="btn">
             <span>File</span>
             <input name="inputfile" type="file">
           </div>
           <div class="file-path-wrapper">
             <input class="file-path validate" type="text">
           </div>
        </div>
          
          <button type="submit" class="btn #00b0ff light-blue accent-3 ">submit</button>
         </form>
         </div>
            <div class="loader" style="display:none;">
            <div class="progress">
                <div class="indeterminate"></div>
                
            </div>
            <h5>please wait....</h5>
            </div>
         </div>
        </div>
       </div>
      </div>
    </div>
 


<!-- Compiled and minified JavaScript -->
      
    <script src="https://code.jquery.com/jquery-3.7.1.js" 
    integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" 
    crossorigin="anonymous"></script>
      
     <script type="text/javascript">
     
     $(document).ready(function(){
    	 console.log("page is ready....")
    	 
    	 $('#myform').on("submit",function(event){
    		 event.preventDefault();
    		// var f=$(this).serialize();    //in case of only text data which can be serialize
    		let f = new FormData(this); //incase of different different type of data like image,pdf,text etc
    		
    		console.log(f);
    		 $(".loader").show();
			 $(".form").hide();
			 
    		 $.ajax({
    			 url:"signin",
    			 data:f,
    			 type:'Post',
    			 success:function(data,textStatus,jqXHR){
    				 console.log("success....");
    				 console.log(data);
    				 $(".loader").hide();
    				 $(".form").show();
    				 if(data.trim()==='done'){
    					 $("#msg").html("Successfully Registered");
    					 $("#msg").addClass('green-text');
    					 window.setTimeout(function(){
    		                 // do whatever you want to do     
    		                  }, 1500);
    					    window.location.href = "list";
    				 }
    				 else{
    					 $("#msg").html("Something went wrong");
    					 $("#msg").addClass('red-text');

    				 }
    			 },
    			 error:function(jqXHR,textStatus,errorThrown){
    				 console.log(data);
    				 console.log("error....");
    				 $(".loader").hide();
    				 $(".form").show();
    				 $("#msg").html("Something went wrong");
    				 $("#msg").addClass('red-text');
    			 },
    			 processData:false,
    			 contentType:false
    		 })
    		 
    	 })
    	 
     })
     
     </script>
</body>
</html>


