import axios, {isCancel, AxiosError, Axios} from 'axios';

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
        'taskName':taskName,
       'todo':formtodo,
        'image':formImage
    }
    
    // try{   
    // let res = await fetch(`http://localhost:8888/addNewTask/1`,{
    //     method:'POST',
    //   body : JSON.stringify({
    //     taskName:taskName,
    //     todo:formtodo,
    //     image:formImage
    //   }),
    //   headers:{
    //     'Content-Type':'application/json',
       
    //   },
    
    
    
    // });
    // let fdata=await res.json();
    // console.log('fdata :',fdata);
    // }catch(err){
    //     console.log('err :',err);
    // }
    Axios.post('http://localhost:8888/addNewTask/1',sdata).then((response)=>{
        console.log(response.data)
    })
      
    //     let t1 = document.getElementById("addForm")
    // t1.style="display:none";
    }