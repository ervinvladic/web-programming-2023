<?php
use Firebase\JWT\JWT;
use Firebase\JWT\Key;

/**
* @OA\Post(
*     path="/login",
*     description="Login to the system",
*     tags={"login"},
*     @OA\RequestBody(description="Basic user info", required=true,
*       @OA\MediaType(mediaType="application/json",
*    			@OA\Schema(
*    				@OA\Property(property="email", type="string", example="user@gmail.com",	description="Email"),
*    				@OA\Property(property="password", type="string", example="1234",	description="Password" )
*        )
*     )),
*     @OA\Response(
*         response=200,
*         description="JWT Token on successful response"
*     ),
*     @OA\Response(
*         response=404,
*         description="Wrong Password | User doesn't exist"
*     )
* )
*/
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
/**
 * @OA\Post(path="/register",tags={"login"},description="Register to the system",
 * @OA\RequestBody(description="Basic user info", required=true,
 *    @OA\MediaType(
 *      mediaType="application/json",
 *      @OA\Schema(
 *        @OA\Property(property="password", type="string", example="password", description="Users password"),
 *        @OA\Property(property="user_name", type="string", example="user", description="Users name"),
 *        @OA\Property(property="user_surname", type="string", example="lastname", description="Users surname"),
 *        @OA\Property(property="city", type="string", example="Sarajevo", description="Users city of residence"),
 *        @OA\Property(property="email", type="string", example="username@gmail.com", description="Users email")
 *      )
 *    )
 *   ),
 * @OA\Response(response="200", description="User that has been added to the database"),
 * @OA\Response(
 *         response=400,
 *         description="Email in use | User already exists"
 *     )
 * )
 */
Flight::route('POST /register', function(){
  try{
    Flight::json(Flight::userDao()->add(Flight::request()->data->getData()));
  }catch (\Exception $e) {
    Flight::json(["message" => "Email is already in use"], 400);

  }

});


?>
