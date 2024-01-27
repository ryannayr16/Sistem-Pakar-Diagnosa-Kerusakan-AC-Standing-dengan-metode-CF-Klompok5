<?php
require_once 'kon.php';
    $sql = "SELECT * FROM kerusakan";
    $results = mysqli_query($conn, $sql);
    $response = array();
    while( $row = mysqli_fetch_assoc($results) ){
        array_push($response, 
        array(
            'id_kerusakan'=>$row['id_kerusakan'], 
            'nama_kerusakan'=>$row['nama_kerusakan'], 
            'keterangan'=>$row['keterangan'],
            'solusi'=>$row['solusi'],
            'ciri'=>$row['ciri'])
        );
    }
    echo json_encode($response); 
mysqli_close($conn);
?>
