function checkValidation(){
    const isIdOk = checkId();
    if(!isIdOk){
        alert("id가 너무 짧습니다.");
        return false;
    }

    const isPwdOk = checkPwd();
    if(!isPwdOk){
        alert('비밀번호가 일치하지 않습니다.');
        return false;
    }

    return true;
}

function checkId(){
    const memberId = document.querySelector('main input[name=memberId]').value;
    if(memberId.length < 4){
        return false;
    }else{
        return true;
    }
}

function checkPwd(){
    //비밀번호 일치 여부 체크
    const pwd1 = document.querySelector('main input[name=memberPwd]').value;
    const pwd2 = document.querySelector('main input[name=memberPwd2]').value;

    if(pwd1 === pwd2){
        return true;
    }else{
        return false;
    }
}

