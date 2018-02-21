function init () {
    $(".balance").hide();
}

function pinEnter() {
    var pin = $('.pin-input').val();
    $.ajax({
        url: "./account/" + pin,
        type:"GET",
        success:function(data){
            $(".pin-div").hide();
            $(".balance").show();
            $(".balance .amount").text(data.amount + "$")
        },

        error:function(data){
            $(".pin-div h2").text("Wrong PIN")
        }
     });
}

function update(caller) {
    var pin = $('.pin-input').val();
    var amount = $('.amount-input').val();
    var queryString = caller.className === "withdraw"? "?delta=-" : "?delta=";
    $.ajax({
            url: "./account/" + pin + queryString + amount,
            type:"PUT",
            success:function(data){
                $(".balance .amount").text(data.amount + "$")
            },

            error:function(data){
                $(".balance h2").text("Something went wrong")
            }
         });
}