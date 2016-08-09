
//bcrypt 샘플코드, bower_components의 julien-sarazin/js-bcrypt/bCrypt.js

function result(hash){
        $("#hash").val(hash);
}
function crypt(){
        var salt;
        if($("#salt").val().length != 0){
                salt = $("#salt").val();
        }else{
                try{
                        salt = bcrypt.gensalt($("#rounds").val());
                }catch(err){
                        alert(err);
                        return;
                }
                $("#salt").val(salt);
        }
        try{

                bcrypt.hashpw($("#password").val(), $("#salt").val(), result, function() {});
        }catch(err){
                alert(err);
                return;
        }
}