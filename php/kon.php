<?php
$host = "localhost";
$username = "id19959321_yeovil";
$password = "Djokobayu25!";
$dbname = "id19959321_bantu";
$connection = null;
$conn = mysqli_connect($host, $username, $password, $dbname);

try{
    $database = "mysql:dbname=$dbname;host=$host";
    $connection = new PDO($database, $username, $password);
    $connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

} catch (PDOException $e){
    echo "Error ! " . $e->getMessage();
    die;
}
?>