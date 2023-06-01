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
  public function get_worker_by_search($search){
    return $this->query("SELECT * FROM worker w join job j on w.worker_job_id = j.id where LOWER(w.worker_name) LIKE CONCAT('%',:search,'%') OR
     LOWER(w.worker_city) LIKE CONCAT('%',:search,'%') OR  LOWER(j.job_name) LIKE CONCAT('%',:search,'%')",['search' => strtolower($search)]);
  }

}

?>
