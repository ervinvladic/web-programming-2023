<?php

class Config {

  public static function DB_HOST(){
    return Config::get_env("DB_HOST", "localhost");
  }
  public static function DB_USERNAME(){
    return Config::get_env("DB_USERNAME", "root");
  }
  public static function DB_PASSWORD(){
    return Config::get_env("DB_PASSWORD", "0000");
  }
  public static function DB_SCHEME(){
    return Config::get_env("DB_SCHEME", "radnikba");
  }
  public static function DB_PORT(){
    return Config::get_env("DB_PORT", "3307");
  }
}
  ?>