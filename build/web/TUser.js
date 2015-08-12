$(function(){
    $("#wong").on("click", function() {
        alert("Hi");
        
       $.get("newMessage", { 
           name: $("#wong").val()      //how to get this one into the database  
       }).done(function() {
          
       });

           url ="lobby.html";
           
           location.href = url;
   }); 
    $("#chan").on("click", function() {
        alert("Hi");
        
       $.get("newMessage", { 
           name: $("#chan").val()      //how to get this one into the database  
       }).done(function() {
          
       });

           url ="lobby.html";
           
           location.href = url;
   });
});