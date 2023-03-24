<?php
ini_set('display_errors', 1);
ini_set('display_startup_errors', 1);
error_reporting(E_ALL);

require_once 'dao/JobDao.class.php';
require_once '../vendor/autoload.php';

Flight::register('jobDao', 'JobDao');

// CRUD operations for job entity

/**
* List all jobs
*/
Flight::route('GET /job', function(){
  Flight::json(Flight::jobDao()->get_all());
});

/**
* List invidiual job
*/
Flight::route('GET /job/@job_id', function($id){
  Flight::json(Flight::jobDao()->get_by_id($id));
});

/**
* add job
*/
Flight::route('POST /job', function(){
  Flight::json(Flight::jobDao()->add(Flight::request()->data->getData()));
});

/**
* update job
*/
Flight::route('PUT /job/@id', function($id){
  $data = Flight::request()->data->getData();
  $data['id'] = $id;
  Flight::json(Flight::jobDao()->update($data));
});

/**
* delete job
*/
Flight::route('DELETE /job/@id', function($id){
  Flight::jobDao()->delete($id);
  Flight::json(["message" => "Deleted!"]);
});



Flight::start();
?>