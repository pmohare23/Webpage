function wrongPerson(){
    document.cookie= "name=null;"+" expires=Thu, 01-Jan-95 00:00:01 GMT";
    location.reload();
}

function welc(){
    var welc_message=document.getElementById("welcome");
    var message='<h2>Good ';
    var hour=new Date().getHours();
    if (hour<12) message+='Morning ';
    else if (hour<18) message+='Afternoon ';
    else message+='Evening ';
    var name;
    if (document.cookie){
        var myCookie=unescape(document.cookie);
        var cookieTokens=myCookie.split("=");
        name=cookieTokens[1];
    }
    else{
        name=window.prompt("Please enter your name","");
        var exp=new Date();
        exp.setDate(exp.getDate+1);
        document.cookie="name="+escape(name)+"; expires="+exp;
    }
    message+=name+",<br>Welcome to SWE642 Survey</h2>";
    message+="<a href='javascript:wrongPerson()'>"+"Click here if you are not "+name+"</a>";
    welc_message.innerHTML=message;
}

function valForm(event) {
    var err="";
    if (!document.getElementById("firstname").value.match(/^[A-Za-z]+$/)) {
        err+="First Name should only contain Alphabets\n";
        document.getElementById("firstname").value="";
    }
    if (!document.getElementById("lastname").value.match(/^[A-Za-z]+$/)) {
        err+="Last Name should only contain Alphabets\n";
        document.getElementById("lastname").value="";
    }
    if (!document.getElementById("street").value.match(/^[A-Za-z0-9]+$/)) {
        err+="Street address text boxes should only contain numeric, alphabetic or alphanumeric characters\n";
        document.getElementById("street").value="";
    }
    if (!document.getElementById("email").value.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/)) {
        err+="Email id should be valid. \n";
        document.getElementById("email").value="";
    }
    var like=document.getElementsByName("likes");
    var count=0;
    for (var i=0;i<like.length;i++){
        if (like[i].checked){ count++;}
    }
    if (count<2){err+="Please check atleast 2 options for what you like about GMU\n";}
    var interest = document.getElementsByName("interest");
    checked=false;
    for (var i=0;i<interest.length;i++){
        if (interest[i].checked){
            checked=true;
            break;
        }
    }
    if (!checked){ err+="Please check what interested you the most at GMU\n";}
    if (document.getElementById("recommend").value==''){err+="Please Enter Recommendation\n";}
    if (document.getElementById("data").value.split(',').length<10){err+="Please Enter atleast 10 comma seperated numbers";}
    if (err=="") {
        alert("Feedback submitted!");
        return true;
    } else { 
        alert(err);
        event.preventDefault();
        return false;
    }
}

function clear() {
    document.getElementById('firstname').innerHTML="";
    document.getElementById('lastname').innerHTML="";
    document.getElementById("studentID").innerHTML="";
    document.getElementById("street").innerHTML="";
    document.getElementById("city").innerHTML="";
    document.getElementById("state").innerHTML="";
    document.getElementById('zip').innerHTML="";
    document.getElementById('phone').innerHTML="";
    document.getElementById("email").innerHTML="";
    document.getElementById("url").innerHTML="";
    document.getElementById("dsurvey").innerHTML="";
    document.getElementById("interest").innerHTML="";
    document.getElementById('recommend').innerHTML="";
    document.getElementById('gradmonth').innerHTML="";
    document.getElementById("gradyear").innerHTML="";
    document.getElementById("comments").innerHTML="";
    document.getElementById("data").innerHTML="";
    }