let signinArr=JSON.parse(localStorage.getItem("signin"))||[]
let userId=0;

signinArr.forEach(function(ele){
    userId=ele.userId
   
    })


console.log(userId)
async function getData(){

    try{
        let res = await fetch(`http://localhost:8880/getAllTasks/${userId}`);


       let data=await res.json();
       appendDetails(data)
console.log('data :',data);
    }catch(err){
        console.log('err :',err);
    }
}
getData();


let tbody= document.querySelector("tbody");
let count=0;
function appendDetails(data){
    tbody.innerHTML=""
data.forEach(el => {
   count++;
    let tr=document.createElement("tr");
    let id=el.todoId;
    let sr=document.createElement('td');
    sr.innerText=count;
    let title =document.createElement('td')
    title.innerText=el.taskName;
    
let todo=document.createElement('td');
todo.innerText=el.todoDesc;

let imagec=document.createElement('td')
imagec.id="imagec"
let img=document.createElement('img');
img.src=el.image;
imagec.append(img);

let createdDate=document.createElement('td');
createdDate.innerText=el.createdDate;

let updateDate=document.createElement('td');
if(el.updatedDate==null){
updateDate.innerText="-";
}else{
    updateDate.innerText=el.updatedDate;
}

let status=document.createElement('td');
let statusBtn=document.createElement('button')
statusBtn.id="status-btn"
if(el.status==false){
    statusBtn.innerText="Not completed";
    statusBtn.style="background-color: yellow "
}else{
    statusBtn.innerText="Completed";  
    statusBtn.style="background-color :green "
}
status.append(statusBtn)

statusBtn.addEventListener("click",function(){
    statusUp(id,el.status);
})
let action = document.createElement('td');
let deletebtn=document.createElement('button');
deletebtn.innerText="delete";
deletebtn.addEventListener("click",function(){
    deltePost(id);
})
let update=document.createElement('button');
update.innerText="update";
update.addEventListener("click",function(){
    displayUpdateForm(id);
})
action.append(update,deletebtn);
tr.append(sr,title,todo,imagec,createdDate,updateDate,status,action);
tbody.append(tr);

});



}



function getForm(){
    let table=document.querySelector("table");
    let addTaskbtn=document.getElementById("addTask");
    addTaskbtn.style="display:none";
    table.style="display:none";
    let t1 = document.getElementById("addForm")
    t1.style="display:block";
    }

async function submitTask(){
        let table=document.querySelector("table");
    let addTaskbtn=document.getElementById("addTask");
        addTaskbtn.style="display:block";
        table.style="display:block";
    
    //   const payload=new FormData(form);
    
    
    // let taskName = document.getElementById('tsk').value;
    // let formtodo = document.getElementById('td').value;
    // let formImage = document.getElementById('fi').value;

 var taskName = document.getElementById('tsk').value;
 var todoDesc = document.getElementById('td').value;
 var image=document.getElementById('fi').value

    // let sdata={
    //     taskName:taskName,
    //     todo:formtodo,
    //     image:formImage
    // }
    var param = {
  taskName:taskName,
todoDesc:todoDesc,
image:image
}
    try{   
    let res = await fetch(`http://localhost:8880/todos/${userId}`,{
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
    
      
    //     let t1 = document.getElementById("addForm")
    // t1.style="display:none";
    }
    
    
    async function deltePost(id){
  
    let res = await fetch(`http://localhost:8880/deleteTask/${id}/1`,{
        method:'DELETE',
        headers:{
            'Content-Type':'application/json',
           
          },
        
    
    });
    alert("Todo task delted !")
 
    window.location.reload();
    }
let temp=0;

function displayUpdateForm(id){
    temp=id;
    let table=document.querySelector("table");
    let addTaskbtn=document.getElementById("addTask");
    addTaskbtn.style="display:none";
    table.style="display:none";
    let t1 = document.getElementById("putForm")
    t1.style="display:block";

}

    async function updatePost(){
        var taskName = document.getElementById('put-tsk').value;
        var todoDesc = document.getElementById('put-td').value;
        // var image=document.getElementById('put-fi').value
        var param = {
            todoId:temp,
            taskName:taskName,
          todoDesc:todoDesc,
        //   image:image
          }
try{ 
  let res = await fetch(`http://localhost:8880/updateTask`,{
            method:'PUT',
            body : JSON.stringify(param),
            headers:{
                'Content-Type':'application/json',
               
              },
            
        
        });
        let fdata=await res.json();
        console.log('fdata :',fdata);
} catch(err){
        console.log('err :',err);
    } 
}
    


   async function statusUp(id , status){
  let flag=false;
if(status===false){
    flag=true;
}else{
    flag=false;
}


    try{ 
        let res = await fetch(`http://localhost:8880/updateTaskStatus/${flag}/${id}`,{
                  method:'PUT',
                  headers:{
                      'Content-Type':'application/json',
                     
                    },
                  
              
              });
              let fdata=await res.json();
              console.log('fdata :',fdata);
              
      } catch(err){
              console.log('err :',err);
          } 

          if(status===false){
            alert("Status updated as complete !")
          }else{
            alert("Status updated as not complete !")
          }
         
        //   let alertDiv=getElementById("alert-div")
        //   alertDiv.innerHTML=`<div class="alert alert-warning alert-dismissible fade show" role="alert">
        //   <strong>Status updated !</strong> 
        //   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        // </div>`
          window.location.reload();

   }

//    <div class="alert alert-warning alert-dismissible fade show" role="alert">
//   <strong>Holy guacamole!</strong> You should check in on some of those fields below.
//   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
// </div>


function logOut(){
    signinArr.splice(0,1)
   
    localStorage.setItem("signin",JSON.stringify(signinArr))


    alert("Logged out !")
    window.location.href="login.html"
}