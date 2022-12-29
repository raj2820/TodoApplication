let form=document.querySelector("form")
let signinArr=JSON.parse(localStorage.getItem("signin"))||[]
if(signinArr.length >0){
    alert("Logout of current session !")
    window.location.href="todoDashboard.html";
}



async function userlogin(){
event.preventDefault();

    
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value




    try{
        let res = await fetch(`http://localhost:8880/getUser/${email}`);
       let data=await res.json();
       signUp(data)
console.log('data :',data);
    }catch(err){
        console.log('err :',err);
    }



}


function signUp(data){
   
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value

if(data.email==email && data.password==password){
     let signinObj={
        userId:data.userId,
        name:data.name,
        email:email,
        password:password,
            }

           signinArr.push(signinObj)
           localStorage.setItem("signin",JSON.stringify(signinArr))
           alert("Signin Successful")
           window.location.href="todoDashboard.html";
}else{
alert("wrong credentials ! ")


}


}
function logOut(){
    signinArr.splice(0,1)
   
    localStorage.setItem("signin",JSON.stringify(signinArr))


    alert("Logged out !")
    window.location.href="login.html"
}