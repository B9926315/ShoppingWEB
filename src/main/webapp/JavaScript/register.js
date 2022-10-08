//用户名
var usernameInput = document.getElementById('username');
usernameInput.onblur = checkUserName;

function checkUserName() {
    let username = usernameInput.value.trim();
    var reg = /^\w{1,10}$/;
    var flag = reg.test(username);
    if (flag) {
        document.getElementById("username-error").style.display = 'none';
    } else {
        document.getElementById("username-error").style.display = '';
    }
    return flag;
}
// 密码
var passwordInput = document.getElementById('password');
passwordInput.onblur = checkpassword;

function checkpassword() {
    let password = passwordInput.value.trim();
    var reg = /^\w{6,12}$/;
    var flag = reg.test(password);
    if (flag) {
        document.getElementById("password-error").style.display = 'none';
    } else {
        document.getElementById("password-error").style.display = '';
    }
    return flag;
}

//二次输入密码
var repasswordInput = document.getElementById('repassword');
repasswordInput.onblur = checkrepassword;

function checkrepassword() {
    let password = passwordInput.value.trim();
    let repassword = repasswordInput.value.trim();

    if (password == repassword) {
        document.getElementById("password-different").style.display = 'none';
    } else {
        document.getElementById("password-different").style.display = '';
    }
    return flag;
}

//手机号
var phoneInput = document.getElementById('phoneNumber');
phoneInput.onblur = checkphoneNumber;

function checkphoneNumber() {
    let phone = phoneInput.value.trim();
    var regphone = /^1[0-9]{10}$/;
    let flag = regphone.test(phone);
    if (flag) {
        document.getElementById("phone-error").style.display = 'none';
    } else {
        document.getElementById("phone-error").style.display = '';
    }
    return flag;
}

//邮箱
var emailInput = document.getElementById('email');
emailInput.onblur = checkemail;

function checkemail() {
    let email = emailInput.value.trim();
    var pattern = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/
    let flag = pattern.test(email);
    if (flag) {
        document.getElementById("email-error").style.display = 'none';
    } else {
        document.getElementById("email-error").style.display = '';
    }
    return flag;
}

//表单
/*let registerForm = document.getElementById("register-form");
registerForm.onsubmit = function () {
    return checkUserName() && checkpassword() && checkrepassword() && checkphoneNumber() && checkemail();
}*/
var errori=location.search;// ?error=yes
let s = errori.substr(7,3);
if (s=='yes'){
    alert("用户名已存在！");
}
