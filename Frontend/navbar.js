function navbarFunc(){

return `<div class="container-fluid">
<a class="navbar-brand" href="index.html">Netcore Cloud To Do app</a>
<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
  <span class="navbar-toggler-icon"></span>
</button>
<div class="collapse navbar-collapse" id="navbarSupportedContent">
  <ul class="navbar-nav me-auto mb-2 mb-lg-0 flex-row-reverse">
    <li class="nav-item">
      <a class="nav-link active" aria-current="page" href="login.html">Login</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="todoDashboard.html">To Do Dashboard</a>
    </li>
    <li class="nav-item">
      <button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasScrolling" aria-controls="offcanvasScrolling">Logout</button>
    </li>
  </ul>
 
</div>
</div>`



}



export{navbarFunc}