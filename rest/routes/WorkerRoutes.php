<?php
// CRUD operations for worker entity

/**
* List all workers
*/
Flight::route('GET /worker', function(){
  Flight::json(Flight::workerService()->get_all());
});

/**
* List invidiual worker
*/
Flight::route('GET /worker/@id', function($id){
  Flight::json(Flight::workerService()->get_by_id($id));
});

/**
* add worker
*/
Flight::route('POST /worker', function(){
  Flight::json(Flight::workerService()->add(Flight::request()->data->getData()));
});

/**
* update worker
*/
Flight::route('PUT /worker/@id', function($id){
  $data = Flight::request()->data->getData();
  Flight::json(Flight::workerService()->update($id, $data));
});

/**
* delete worker
*/
Flight::route('DELETE /worker/@id', function($id){
  Flight::workerService()->delete($id);
  Flight::json(["message" => "deleted"]);
});
/**
* List invidiual reviews for worker
*/
Flight::route('GET /worker/@id/review', function($id){
  Flight::json(Flight::reviewService()->get_review_by_worker_id($id));
});

Flight::route('GET /search/@search', function($search){
  Flight::json(Flight::workerService()->get_worker_by_search($search));
});

?>
?>