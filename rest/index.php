<?php
ini_set('display_errors', 1);
ini_set('display_startup_errors', 1);
error_reporting(E_ALL);

require_once __DIR__.'/../vendor/autoload.php';
require_once __DIR__.'/services/JobService.class.php';
require_once __DIR__.'/services/WorkerService.class.php';
require_once __DIR__.'/services/ReviewService.class.php';
require_once __DIR__.'/dao/UserDao.class.php';

Flight::register('workerService', 'WorkerService');
Flight::register('jobService', 'JobService');
Flight::register('reviewService', 'ReviewService');
Flight::register('userDao', 'UserDao');

require_once __DIR__.'/routes/WorkerRoutes.php';
require_once __DIR__.'/routes/JobRoutes.php';
require_once __DIR__.'/routes/UserRoutes.php';
require_once __DIR__.'/routes/ReviewRoutes.php';

Flight::start();
?>