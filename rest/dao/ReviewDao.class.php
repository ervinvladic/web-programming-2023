<?php
require_once __DIR__.'/BaseDao.class.php';

class ReviewDao extends BaseDao{
  /**
  * constructor of dao class
  */
  public function __construct(){
    parent::__construct("review");
  }

  public function get_review_by_worker_id($id){
    return $this->query("SELECT * FROM review WHERE worker_id = :worker_id", ['worker_id' => $id]);
  }
}

?>