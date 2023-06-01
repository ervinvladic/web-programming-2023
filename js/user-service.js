var UserService = {
  init: function(){
    var token = localStorage.getItem("token");
    if (token){
      window.location.replace("index.html");
    }
    $('#login-form').validate({
      submitHandler: function(form) {
        var entity = Object.fromEntries((new FormData(form)).entries());
        UserService.login(entity);
      }
    });
    $('#register-form').validate({
      submitHandler: function(form) {
        var user = Object.fromEntries((new FormData(form)).entries());
        UserService.register(user);
      }
    });
  },
  login: function(entity){
    $.ajax({
      url: 'rest/login',
      type: 'POST',
      data: JSON.stringify(entity),
      contentType: "application/json",
      dataType: "json",
      success: function(result) {
        console.log(result);
        localStorage.setItem("token", result.token);
        window.location.replace("index.html");
      },
      error: function(XMLHttpRequest, textStatus, errorThrown) {
        toastr.error(XMLHttpRequest.responseJSON.message);
      }
    });
  },

  logout: function(){
    localStorage.clear();
    window.location.replace("login.html");
  },
  showRegisterForm: function(){
    $("#login-form-container").addClass("hidden");
    $("#register-form-container").removeClass("hidden");

  },
  showLoginForm: function(){
    $("#register-form-container").addClass("hidden");
    $("#login-form-container").removeClass("hidden");

  },
  parseJWT: function(token){
    var base64Url = token.split('.')[1];
      var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
      var jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
          return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
      }).join(''));
      return JSON.parse(jsonPayload);
  },
  register: function(user){
    $.ajax({
      url: 'rest/register',
      type: 'POST',
      beforeSend: function(xhr){
        xhr.setRequestHeader('Authorization', localStorage.getItem('token'));
      },
      data: JSON.stringify(user),
      contentType: "application/json",
      dataType: "json",
      success: function() {
        toastr.success("Added !");
        $("#register-form-container").addClass("hidden");
        $("#login-form-container").removeClass("hidden");
      },
      error: function(XMLHttpRequest, textStatus, errorThrown) {
        toastr.error(XMLHttpRequest.responseJSON.message);
      }
    });
  }
}
