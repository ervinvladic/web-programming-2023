var WorkerService = {

  add: function(worker){
    $.ajax({
      url: 'rest/worker',
      type: 'POST',
      beforeSend: function(xhr){
        xhr.setRequestHeader('Authorization', localStorage.getItem('token'));
      },
      data: JSON.stringify(worker),
      contentType: "application/json",
      dataType: "json",
      success: function(result) {
        // append to the list
        $("#job-workers").append(`<div class="list-group-item job-worker-`+result.id+`">
          <button class="btn btn-danger btn-sm float-end " onclick="WorkerService.delete(`+result.id+`)">Obriši</button>
          <button class="btn btn-success btn-sm float-end" onclick="ReviewService.list_by_worker_id(`+result.id+`)">Komentari</button>
          <p class="list-group-item-text">`+'Ime: '+result.worker_name+' | Grad: '+result.worker_city+' | Telefon: '+result.worker_phone_number+' | Email: '+result.worker_email+' | Adresa: '+result.worker_address+`</p>
        </div>`);
        toastr.success("Added !");
      }
    });
  },

  list_by_job_id: function(id){
    $("#job-workers").html('loading ...');

    $.ajax({
       url: "rest/job/"+id+"/worker",
       type: "GET",
       beforeSend: function(xhr){
         xhr.setRequestHeader('Authorization', localStorage.getItem('token'));
       },
       success: function(data) {
         var html = "";
         for(let i = 0; i < data.length; i++){
           html += `<div class="list-group-item job-worker-`+data[i].id+`">
             <button class="btn btn-danger btn-sm float-end admin-panel hidden" onclick="WorkerService.delete(`+data[i].id+`)">Obriši</button>
             <button class="btn btn-success btn-sm float-end" onclick="ReviewService.list_by_worker_id(`+data[i].id+`)">Komentari</button>
             <p class="list-group-item-text">`+'Ime: '+data[i].worker_name+' | Grad: '+data[i].worker_city+' | Telefon: '+data[i].worker_phone_number+' | Email: '+data[i].worker_email+' | Adresa: '+data[i].worker_address+`</p>
           </div>`;
         }
         $("#job-workers").html(html);
         let userInfo = UserService.parseJWT(localStorage.getItem("token"));
         if(userInfo.r == "ADMIN"){

           $('.admin-panel').removeClass("hidden");
         }
       },
       error: function(XMLHttpRequest, textStatus, errorThrown) {
         toastr.error(XMLHttpRequest.responseJSON.message);
         UserService.logout();
       }
    });

    // note id populate and form validation
    $('#add-worker-form input[name="worker_job_id"]').val(id);

    $('#add-worker-form').validate({
      submitHandler: function(form) {
        var entity = Object.fromEntries((new FormData(form)).entries());
        WorkerService.add(entity);
        $('#add-worker-form input[name="worker_name"]').val("");
        $('#add-worker-form input[name="worker_email"]').val("");
        $('#add-worker-form input[name="worker_city"]').val("");
        $('#add-worker-form input[name="worker_phone_number"]').val("");
        $('#add-worker-form input[name="worker_address"]').val("");
        toastr.info("Adding ...");
      }
    });
    $("#workerModal").modal('show');
  },

  delete: function(id){
    var old_html = $("#job-workers").html();
    $('.job-worker-'+id).remove();
    toastr.info("Deleting in background ...");
    $.ajax({
      url: 'rest/worker/'+id,
      type: 'DELETE',
      beforeSend: function(xhr){
        xhr.setRequestHeader('Authorization', localStorage.getItem('token'));
      },
      success: function(result) {
        toastr.success("Deleted !");
      },
      error: function(XMLHttpRequest, textStatus, errorThrown) {
        toastr.error(XMLHttpRequest.responseJSON.message);
        $("#job-workers").html(old_html);
        //alert("Status: " + textStatus); alert("Error: " + errorThrown);
      }
    });
  },



}
