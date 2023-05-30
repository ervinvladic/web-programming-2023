<?php
// CRUD operations for review entity

/**
* List all reviews
*/
Flight::route('GET /review', function(){
  Flight::json(Flight::reviewService()->get_all());
});

/**
* List invidiual review
*/
Flight::route('GET /review/@id', function($id){
  Flight::json(Flight::reviewService()->get_by_id($id));
});

/**
* add review
*/
Flight::route('POST /review', function(){
  Flight::json(Flight::reviewService()->add(Flight::request()->data->getData()));
});



/**
* delete review
*/
Flight::route('DELETE /review/@id', function($id){
  Flight::reviewService()->delete($id);
  Flight::json(["message" => "deleted"]);
});

?>