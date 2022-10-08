let usernameInput = document.getElementById("username");
usernameInput.onblur=checkUserNameLogin;
function checkUserNameLogin() {
    let userName = usernameInput.value.trim();
    return userName == "";
}
//判断密码是否为空
let passwordInput = document.getElementById("password");
passwordInput.onblur=checkPasswordLogin;
function checkPasswordLogin() {
    let password = passwordInput.value.trim();
    return password == "";
}

