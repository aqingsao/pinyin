$(function(){
  $("#email").blur(function(){
    var email_reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    if(!email_reg.test($(this).val())) {
      $(this).parent(".form-group").removeClass("has-success").addClass("has-error");
    }
    else{
      $(this).parent(".form-group").removeClass("has-error").addClass("has-success");
    }
  });

  $("#cardNo").blur(function(){
    if(!luhn.isValid($(this).val())) {
      $(this).parent(".form-group").removeClass("has-success").addClass("has-error");
    }
    else{
      $(this).parent(".form-group").removeClass("has-error").addClass("has-success");
    }
  });
})