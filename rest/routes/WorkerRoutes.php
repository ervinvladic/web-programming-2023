<?php
// CRUD operations for worker entity


Flight::route('GET /worker', function(){
  Flight::json(Flight::workerService()->get_all());
});


Flight::route('GET /worker/@id', function($id){
  Flight::json(Flight::workerService()->get_by_id($id));
});


Flight::route('POST /worker', function(){
  Flight::json(Flight::workerService()->add(Flight::request()->data->getData()));
});


Flight::route('PUT /worker/@id', function($id){
  $data = Flight::request()->data->getData();
  Flight::json(Flight::workerService()->update($id, $data));
});


Flight::route('DELETE /worker/@id', function($id){
  Flight::workerService()->delete($id);
  Flight::json(["message" => "deleted"]);
});

Flight::route('GET /worker/@id/review', function($id){
  Flight::json(Flight::reviewService()->get_review_by_worker_id($id));
});



?>