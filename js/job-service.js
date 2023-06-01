var JobService = {
    init: function(){
      $('#addJobForm').validate({
        submitHandler: function(form) {
          var job = Object.fromEntries((new FormData(form)).entries());
          JobService.add(job);
        }
      });

      JobService.list();
    },

    list: function(){
      $.ajax({
         url: "rest/job",
         type: "GET",
         beforeSend: function(xhr){
           xhr.setRequestHeader('Authorization', localStorage.getItem('token'));
         },
         success: function(data) {
           $("#job-list").html("");
           var html = "";
           for(let i = 0; i < data.length; i++){
             html += `
             <div class="col-lg-3">
               <div class="card" style="margin-top:30px;">
                 <img class="card-img-top" src="slika1.jpg" alt="Card image cap">
                 <div class="card-body">
                   <h5 class="card-title">`+ data[i].job_name +`</h5>
                   <p class="card-text">`+ data[i].job_description +`</p>
                   <div class="btn-group" role="group">
                     <button  type="button" class="btn btn-primary job-button hidden" onclick="JobService.get(`+data[i].id+`)">Uredi</button>
                     <button  type="button" class="btn btn-danger job-button hidden" onclick="JobService.delete(`+data[i].id+`)">Obriši</button>
                     <button type="button" class="btn btn-outline-primary job-button" onclick="WorkerService.list_by_job_id(`+data[i].id+`)">Svi radnici</button>
                   </div>
                 </div>
               </div>
             </div>
             `;
           }
           $("#job-list").html(html);

           let userInfo = UserService.parseJWT(localStorage.getItem("token"));
           if(userInfo.r == "ADMIN"){

             $('.job-button').removeClass("hidden");
           }
         },
         error: function(XMLHttpRequest, textStatus, errorThrown) {
           toastr.error(XMLHttpRequest.responseJSON.message);
           UserService.logout();
         }
      });
    },

    get: function(job_id){

      $('.job-button').attr('disabled', true);
      $.ajax({
        url: 'rest/job/'+job_id,
        type: 'GET',
        beforeSend: function(xhr){
          xhr.setRequestHeader('Authorization', localStorage.getItem('token'));
        },
        success: function(data){
        $("#job_name").val(data.job_name);
        $("#job_id").val(data.id);
        $("#job_description").val(data.job_description);
        $("#exampleModal").modal("show");
        $('.job-button').attr('disabled', false);
      }
      })
    },

    add: function(job){
      $.ajax({
        url: 'rest/job',
        type: 'POST',
        beforeSend: function(xhr){
          xhr.setRequestHeader('Authorization', localStorage.getItem('token'));
        },
        data: JSON.stringify(job),
        contentType: "application/json",
        dataType: "json",
        success: function(result) {
            $("#job-list").html('<div class="spinner-border" role="status"> <span class="sr-only"></span>  </div>');
            JobService.list(); // perf optimization
            $("#addJobModal").modal("hide");
        }
      });
    },

    update: function(){
      $('.save-job-button').attr('disabled', true);
      var job = {};

      job.job_name = $('#job_name').val();
      job.job_description = $('#job_description').val();

      $.ajax({
        url: 'rest/job/'+$('#job_id').val(),
        type: 'PUT',
        beforeSend: function(xhr){
          xhr.setRequestHeader('Authorization', localStorage.getItem('token'));
        },
        data: JSON.stringify(job),
        contentType: "application/json",
        dataType: "json",
        success: function(result) {
            $("#exampleModal").modal("hide");
            $('.save-job-button').attr('disabled', false);
            $("#job-list").html('<div class="spinner-border" role="status"> <span class="sr-only"></span>  </div>');
            JobService.list(); // perf optimization
        }
      });
    },

    delete: function(job_id){
      $('.job-button').attr('disabled', true);
      $.ajax({
        url: 'rest/job/'+job_id,
        type: 'DELETE',
        beforeSend: function(xhr){
          xhr.setRequestHeader('Authorization', localStorage.getItem('token'));
        },
        success: function(result) {
            $("#job-list").html('<div class="spinner-border" role="status"> <span class="sr-only"></span>  </div>');
            JobService.list();
        }
      });
    },
}
