<?php
require_once __DIR__.'/BaseDao.class.php';

class WorkerDao extends BaseDao{
  /**
  * constructor of dao class
  */
  public function __construct(){
    parent::__construct("worker");
  }

  public function get_worker_by_job_id($id){
    return $this->query("SELECT * FROM worker WHERE worker_job_id = :job_id", ['job_id' => $id]);
  }
}

?>