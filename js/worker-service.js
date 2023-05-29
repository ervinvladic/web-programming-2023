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
          <button class="btn btn-danger btn-sm float-end" onclick="WorkerService.delete(`+result.id+`)">Obriši</button>
          <p class="list-group-item-text">`+result.worker_name+', '+result.worker_city+', '+result.worker_phone_number+', '+result.worker_email+', '+result.worker_address+`</p>
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
             <button class="btn btn-danger btn-sm float-end" onclick="WorkerService.delete(`+data[i].id+`)">Obriši</button>
             <p class="list-group-item-text">`+data[i].worker_name+', '+data[i].worker_city+', '+data[i].worker_phone_number+', '+data[i].worker_email+', '+data[i].worker_address+`</p>
           </div>`;
         }
         $("#job-workers").html(html);
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