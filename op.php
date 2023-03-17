<?php
ini_set('display_errors', 1);
ini_set('display_startup_errors', 1);
error_reporting(E_ALL);

require_once("rest/dao/JobDao.class.php");

$dao = new JobDao();

$op = $_REQUEST['op'];

switch ($op) {
  case 'add':
    $job_name = $_REQUEST['job_name'];
    $job_description = $_REQUEST['job_description'];
    $dao->add($job_name, $job_description);
    echo "ADDED";
    break;

  case 'delete':
    $id = $_REQUEST['id'];
    $dao->delete($id);
    echo "DELETED $id";
    break;

  case 'update':
    $id = $_REQUEST['id'];
    $job_name = $_REQUEST['job_name'];
    $job_description = $_REQUEST['job_description'];
    $dao->update($id, $job_name, $job_description);
    echo "UPDATED $id";
    break;

  case 'get':
  default:
    $results = $dao->get_all();
    print_r($results);
    break;
}
?>