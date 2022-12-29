



async function registerUser(){
    event.preventDefault();
    var name = document.getElementById('registername').value;
    var registeremail = document.getElementById('registeremail').value;
    var registerpassword = document.getElementById('registerpassword').value
   
       var param = {
        name:name,
        email:registeremail,
        password:registerpassword
   }
       try{   
       let res = await fetch(`http://localhost:8880/Users`,{
           method:'POST',
         body : JSON.stringify(param),
         headers:{
           'Content-Type':'application/json',
          
         },
       
       
       
       });
       let fdata=await res.json();
       console.log('fdata :',fdata);
       }catch(err){
           console.log('err :',err);
       }









}

function logOut(){
    signinArr.splice(0,1)
   
    localStorage.setItem("signin",JSON.stringify(signinArr))


    alert("Logged out !")
    window.location.href="login.html"
}