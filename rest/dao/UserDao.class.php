<?php
require_once __DIR__.'/BaseDao.class.php';

class UserDao extends BaseDao{

  /**
  * constructor of dao class
  */
  public function __construct(){
    parent::__construct("users");
  }

  public function get_user_by_email($email){
    return $this->query_unique("SELECT * FROM users WHERE email = :email", ['email' => $email]);
  }
 
  public function add($entity){
    return parent::add([
        "password" => md5($entity['password']),
        "user_name" => $entity['user_name'],
        "user_surname" => $entity['user_surname'],
        "city" => $entity['city'],
        "email" =>$entity['email']
      ]);

  }

}

?>