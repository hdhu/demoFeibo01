<script type="text/javascript">
//弱：纯数字，纯字母，纯特殊字符
//^(?:\d+|[a-zA-Z]+|[!@#$%^&*]+)$


//校验是否全由数字组成

function isDigit(s)
{
    var patrn=/^[0-9]{1,20}$/;
    if (!patrn.exec(s)) return false
    return true
}

//校验登录名：只能输入5-20个以字母开头、可带数字、“_”、“.”的字串
function isRegisterUserName(s)
{
    var patrn=/^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$/;
    if (!patrn.exec(s)) return false
    return true
}

function isRegisterUserName(s)
{
    var patrn=/^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$/;
    if (!patrn.exec(s)) return false
    return true
}


//校验用户姓名：只能输入1-30个以字母开头的字串
Javascript代码
function isTrueName(s)
{
    var patrn=/^[a-zA-Z]{1,30}$/;
    if (!patrn.exec(s)) return false
    return true
}
}}

//校验密码：只能输入6-20个字母、数字、下划线
function isPasswd(s)
{
    var patrn=/^(\w){6,20}$/;
    if (!patrn.exec(s)) return false
    return true
}

//校验普通电话、传真号码：可以“+”开头，除数字外，可含有“-”
function isTel(s)
{
//var patrn=/^[+]{0,1}(\d){1,3}[ ]?([-]?(\d){1,12})+$/;
    var patrn=/^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;
    if (!patrn.exec(s)) return false
    return true
}

//校验手机号码：必须以数字开头，除数字外，可含有“-”
function isMobil(s)
{
    var patrn=/^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;
    if (!patrn.exec(s)) return false
    return true
}

//校验邮政编码
function isPostalCode(s)
{
//var patrn=/^[a-zA-Z0-9]{3,12}$/;
    var patrn=/^[a-zA-Z0-9 ]{3,12}$/;
    if (!patrn.exec(s)) return false
    return true
}

//校验搜索关键字
function isSearch(s)
{
    var patrn=/^[^`~!@#$%^&*()+=|\\\][\]\{\}:;'\,.<>/?]{1}[^`~!@$%^&()+=|\\\]
 [\]\{\}:;'\,.<>?]{0,19}$/;
    if (!patrn.exec(s)) return false
    return true
}

function isIP(s) //by zergling
{
    var patrn=/^[0-9.]{1,20}$/;
    if (!patrn.exec(s)) return false
    return true
}


<script>