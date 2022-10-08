//阅读模式
var color=document.querySelector("tbody").querySelectorAll("tr");
for (let i = 0; i < color.length; i++) {
    //1.鼠标经过事件
    color[i].onmouseover=function () {
        this.className='bgc';
    }
    //2.鼠标离开事件
    color[i].onmouseout=function () {
        this.className='';
    }
}
let addGoodsBTN = document.getElementById("addGoods");
addGoodsBTN.onclick=function () {
    location.href="/ShoppingWEB/addGoods.jsp";
}