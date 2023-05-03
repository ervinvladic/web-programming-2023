<?php

use Firebase\JWT\JWT;
use Firebase\JWT\Key;

Flight::route('POST /login', function(){
    $login = Flight::request()->data->getData();
    $user = Flight::userDao()->get_user_by_email($login['email']);
    if (isset($user['id'])){
      if($user['password'] == md5($login['password'])){
        unset($user['password']);
        $jwt = JWT::encode(["id" => $user["id"], "r" => $user["role"]], Config::JWT_SECRET(), 'HS256');
        Flight::json(['token' => $jwt]);
      }else{
        Flight::json(["message" => "Wrong password"], 404);
      }
    }else{
      Flight::json(["message" => "User doesn't exist"], 404);
    }
});

Flight::route('POST /register', function(){
    try{
        Flight::json(Flight::userDao()->add(Flight::request()->data->getData()));
      }catch (\Exception $e) {
        Flight::json(["message" => "Email is already in use"], 400);
    
      }
});


?>