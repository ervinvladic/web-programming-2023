<?php

Flight::route('GET /review', function(){
  Flight::json(Flight::reviewService()->get_all());
});


Flight::route('GET /review/@id', function($id){
  Flight::json(Flight::reviewService()->get_by_id($id));
});


Flight::route('POST /review', function(){
  $data = Flight::request()->data->getData();
  Flight::json(Flight::reviewService()->add($data));
});


Flight::route('DELETE /review/@id', function($id){
  Flight::reviewService()->delete($id);
  Flight::json(["message" => "deleted"]);
});

?>
