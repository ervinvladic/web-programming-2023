<?php
require_once __DIR__.'/BaseService.class.php';
require_once __DIR__.'/../dao/WorkerDao.class.php';

class WorkerService extends BaseService{

  public function __construct(){
    parent::__construct(new WorkerDao());
  }

  public function get_worker_by_job_id($job_id){
    return $this->dao->get_worker_by_job_id($job_id);
  }
  public function get_worker_by_search($search){
    return $this->dao->get_worker_by_search($search);
  }
}
?>
