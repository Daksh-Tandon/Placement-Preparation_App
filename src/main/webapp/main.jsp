<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List"%>
<%
List<String> num = (List<String>) request.getAttribute("list");
List<Integer> n=(List<Integer>) request.getAttribute("scores");
%>

    
    
  



<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <style>
  *{
    margin:0;
    padding:0;
    box-sizing:border-box;
}

body{
    font-family:'Segoe UI',sans-serif;
    background:#f1f5f9;
    padding:20px;
    color:#1e293b;
}

/* ================= HEADER ================= */

.header{
    background:white;
    padding:25px;
    border-radius:15px;
    box-shadow:0 5px 15px rgba(0,0,0,.08);
    margin-bottom:25px;
}

.header h1{
    margin-bottom:20px;
    text-align:center;
}

.info{
    display:grid;
    grid-template-columns:repeat(auto-fit,minmax(250px,1fr));
    gap:15px;
}

.info p,
.info a{
    font-size:16px;
    color:#334155;
    text-decoration:none;
}

.logout{
    display:inline-block;
    background:#ef4444;
    color:white !important;
    padding:10px 20px;
    border-radius:8px;
    cursor:pointer;
}

/* ================= TOP CARDS ================= */

.Practice{
    display:grid;
    grid-template-columns:repeat(auto-fit,minmax(280px,1fr));
    gap:20px;
    margin:25px 0;
}

.leetcode,
.Github,
.notification{
    background:white;
    padding:20px;
    border-radius:15px;
    box-shadow:0 5px 15px rgba(0,0,0,.08);
}

.leetcode a,
.Github a{
    display:inline-block;
    margin-top:10px;
    background:#2563eb;
    color:white;
    padding:10px 20px;
    border-radius:8px;
    text-decoration:none;
}

/* ================= TASK SECTION ================= */

.container{
    background:white;
    padding:25px;
    border-radius:15px;
    margin-top:25px;
    box-shadow:0 5px 15px rgba(0,0,0,.08);
}

.container ul{
    list-style:none;
}

.container li{
    display:flex;
    justify-content:space-between;
    align-items:center;
    padding:15px;
    margin:10px 0;
    background:#f8fafc;
    border-radius:10px;
}

.actions{
    display:flex;
    gap:10px;
}

.complete-btn,
.delete-btn{
    text-decoration:none;
    padding:8px 12px;
    border-radius:8px;
}

.complete-btn{
    background:#22c55e;
    color:white;
}

.delete-btn{
    background:#ef4444;
    color:white;
}

/* ================= NOTES LINKS ================= */

.Study-notes{
    margin-top:30px;
    background:white;
    padding:25px;
    border-radius:15px;
    box-shadow:0 5px 15px rgba(0,0,0,.08);
}

.notes-flex{
    display:flex;
    justify-content:center;
    flex-wrap:wrap;
    gap:20px;
    margin-top:20px;
}

.notes-flex div{
    background:#2563eb;
    padding:15px 25px;
    border-radius:10px;
}

.notes-flex a{
    color:white;
    text-decoration:none;
    font-weight:600;
}

/* ================= SUGGESTION ================= */

.suggestion{
    background:white;
    padding:20px;
    border-radius:15px;
    margin:25px 0;
    box-shadow:0 5px 15px rgba(0,0,0,.08);
}

/* ================= LEADERBOARD ================= */

ul{
    list-style:none;
}

ul li{
    background:white;
    padding:15px;
    border-radius:10px;
    margin:10px 0;
    display:flex;
    justify-content:space-between;
    box-shadow:0 3px 10px rgba(0,0,0,.05);
}

/* ================= NOTES SECTION ================= */

.notes-section{
    background:white;
    padding:25px;
    border-radius:15px;
    box-shadow:0 5px 15px rgba(0,0,0,.08);
}

#notes{
    width:100%;
    min-height:200px;
    margin-top:15px;
    padding:15px;
    border:1px solid #cbd5e1;
    border-radius:10px;
    resize:vertical;
}

.notes-section button{
    margin-top:15px;
    margin-right:10px;
    padding:10px 20px;
    border:none;
    border-radius:8px;
    background:#2563eb;
    color:white;
    cursor:pointer;
}

/* ================= MOBILE ================= */

@media(max-width:768px){

    body{
        padding:10px;
    }

    .header h1{
        font-size:1.5rem;
    }

    .container li{
        flex-direction:column;
        align-items:flex-start;
        gap:10px;
    }

    .actions{
        width:100%;
        justify-content:flex-end;
    }

    ul li{
        flex-direction:column;
        gap:10px;
        text-align:center;
    }

    .notes-section button{
        width:100%;
        margin-bottom:10px;
    }
}
.info{
    background:white;
    padding:25px;

    border-radius:15px;

    display:flex;
    flex-direction:column;
    gap:12px;

    box-shadow:0 5px 15px rgba(0,0,0,0.08);
}

.info p{
    font-size:16px;
    color:#334155;
    font-weight:500;
}

.info a{
    text-decoration:none;
    color:#2563eb;
    font-weight:600;
}

.info a:hover{
    text-decoration:underline;
}

.info hr{
    border:none;
    height:1px;
    background:#e2e8f0;
}

.logout{
    display:inline-block;
    width:fit-content;

    margin-top:10px;

    background:#ef4444;
    color:white !important;

    padding:10px 18px;
    border-radius:8px;

    cursor:pointer;
    transition:.3s;
}

.logout:hover{
    background:#dc2626;
    transform:translateY(-2px);
}
   
    
    </style>

</head>

<body>
<div class="header">
<h1>Welcome ${name} 😉</h1>

<div class="info">
<p>Email: ${email}</p>
<hr>
<p><a href="https://www.google.com/search?q=${college}">College: ${college}</a></p>
<hr>
<p>Semester: ${sem}</p>
<hr>
<p>CGPA: ${Math.round(cgpa*100.0)/100.0}</p>
<hr>
<a class="logout" onclick="logout()">Logout</a>



</div>



</div>
<div class="Practice">
<div class="leetcode">

<p>Do Leetcode Question </p>

<a href="${link}" target="_blank">Leetcode</a>
</div>
<div class="Github">
<p>GitHub Profile</p>
<a href="${glink}" target="_blank">GitHub</a>


</div>
<div class="notification">
<h1>Recent Notifications</h1>
<p>${msg}</p>
</div>



</div>





<hr>



<div class="container">
    <h2>📋 Today Task</h2>
    <ul>
        <li>
            <span>Complete DSA Question</span>
            <div class="actions">
              
                <a href="task?tid=3" class="complete-btn">✔</a>
                <a class="delete-btn">🗑</a>
            </div>
        </li>

        <li>
            <span >Study DBMS</span>
            <div class="actions">
                <a  href="task?tid=2" class="complete-btn">✔</a>
                <a class="delete-btn">🗑</a>
            </div>
        </li>
        
          <li>
            <span >Study OOPS</span>
            <div class="actions">
                <a href="task?tid=1" class="complete-btn">✔</a>
                <a class="delete-btn">🗑</a>
            </div>
        </li>
    </ul>
</div>
<div class="Study-notes">
    <h1>Refer here For Notes</h1>
    <div class="notes-flex">
        <div class="Dbms"><a href="https://dotnotes.in">DBMS</a></div>
        <div class="Java"><a href="https://dotnotes.in">Java</a></div>
        <div class="OOPS"><a href="https://dotnotes.in" target="_blank">OOPS</a></div>
    </div>
</div>
<hr>
<div class="suggestion">
<h3>🎯 Suggestion</h3>
<p>${suggestion}</p>
</div>
<br>
 
 <h2>🏆 Leaderboard</h2>


<ul>
<% 
if(num != null){
    for(int i=0;i<num.size();i++){ 
%>
    <li><h3>👤 <%= num.get(i) %> </h3>
     <h3><%= n.get(i)  %></h3></li>
<% 
    }
}
%>
</ul>

<br>
<div class="notes-section">
<h2> Notes Section</h2>
<textarea id="notes" placeholder="You can write your notes" ></textarea>
<button onclick="handle()">Make Notes</button>
<button id="buttshow" onclick="show()">Show Notes</button>
<div id="notespdf"></div>
</div>


</body>
<script>
let arr=[];


function handle(){
	
	let e=document.getElementById("notes");
	
	if(e.value){
		localStorage.setItem("Date",new Date().toLocaleString());
		localStorage.setItem("notespdf",e.value);
		e.value="";
		let ele=document.getElementById("buttshow");
		ele.disabled=false;
	
	}
}
function show(){
	let h=document.getElementById("notespdf");
	h.className="ntuser";
	


    let ele=document.getElementById("buttshow");
	ele.disabled=true;
	
    let date = localStorage.getItem("Date") || "";
    let note = localStorage.getItem("notespdf") || "";
    let main=document.getElementsByClassName("notes-section")[0];
    arr.push(date + "\n" + note)

    h.textContent= arr;
    
    
    
    
}
function logout(){
	localStorage.removeItem("Date");
	localStorage.clear(); 
    window.location.href = "index.html";
}
</script>
</html>




