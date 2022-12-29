

let form=document.getElementById("addForm")

let container = document.getElementById("container");

// fetch('http://localhost:8080/getAllTasks').then(function(res){


// return res.json();

// // console.log("x :",x);
// }).then(function(res){
//     console.log("res :",res)
// }).catch(function(err){
//     console.log(err);
// });

async function getData(){

    try{
        let res = await fetch('http://localhost:8888/getAllTasks');


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
todo.innerText=el.todo;

let imagec=document.createElement('td')
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
if(el.status==false){
status.innerText="Not completed";
}else{
    status.innerText="Completed";  
}
let action = document.createElement('td');
let deletebtn=document.createElement('button');
deletebtn.innerText="delete";
deletebtn.addEventListener("click",function(){
    deltePost(id);
})
let update=document.createElement('button');
update.innerText="update";
update.addEventListener("click",function(){

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
//     let table=document.querySelector("table");
// let addTaskbtn=document.getElementById("addTask");
//     addTaskbtn.style="display:block";
//     table.style="display:block";

  const payload=new FormData(form);


let taskName = document.getElementById('tsk').value;
let formtodo = document.getElementById('td').value;
let formImage = document.getElementById('fi').value;
let sdata={
    taskName:taskName,
    todo:formtodo,
    image:formImage
}

try{   
let res = await fetch(`http://localhost:8888/addNewTask/1`,{
    method:'POST',
  body : JSON.stringify({
    "todoId": 11,
    "image": formImage,
    "taskName": taskName,
    "todo": formtodo,
    "status": false,
    "createdDate": "2022-12-27",
    "updatedDate": null
  }),
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

let res = await fetch(`http://localhost:8880/deleteTaskStatus/${id}/1`,{
    method:'DELETE',
    headers:{
        'Content-Type':'application/json',
       
      },
    

});
let fdata=await res.json();
console.log('fdata :',fdata);
location. reload()
}


async function updatePost(){
    let res = await fetch(`http://updateTask/1`,{
        method:'PUT',
        headers:{
            'Content-Type':'application/json',
           
          },
        
    
    });
    let fdata=await res.json();
    console.log('fdata :',fdata);

}