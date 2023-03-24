<?php

class JobDao{

  private $conn;

  /**
  * constructor of DAO class
  */
  public function __construct(){
    $servername = "localhost:3307";
    $username = "root";
    $password = "0000";
    $this->conn = new PDO("mysql:host=$servername;dbname=radnikba", $username, $password);
    // set the PDO error mode to exception
    $this->conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
  }

  /**
  * Method used to get all jobs from database
  */
  public function get_all(){
    $stmt = $this->conn->prepare("SELECT * FROM job");
    $stmt->execute();
    return $stmt->fetchAll(PDO::FETCH_ASSOC);
  }

  /* Method used to read individual job objects from database */
  public function get_by_id($id){
    $stmt = $this->conn->prepare("SELECT * FROM job WHERE id = :id");
    $stmt->execute(['id' => $id]);
    $result = $stmt->fetchAll(PDO::FETCH_ASSOC);
    return reset($result);
  }

  /**
  * Method used to add job to the database
  * $job_name refers to job name
  * $job_description refers to description of the job
  */
  public function add($jobs){
    $stmt = $this->conn->prepare("INSERT INTO job (job_name, job_description) VALUES (:job_name, :job_description)");
    $stmt->execute($jobs);
    $jobs['id'] = $this->conn->lastInsertId();
    return $jobs;
  }

  /**
  * Delete job from the database (id is passed)
  */
  public function delete($id){
    $stmt = $this->conn->prepare("DELETE FROM job WHERE id=:id");
    $stmt->bindParam(':id', $id); // SQL injection prevention
    $stmt->execute();
  }

  /**
  * Update job in the database(id,job_name and job_description passed)
  */
  public function update($jobs){
    $stmt = $this->conn->prepare("UPDATE job SET job_name=:job_name, job_description=:job_description WHERE id=:id");
    $stmt->execute($jobs);
    return $jobs;
  }

}

?>