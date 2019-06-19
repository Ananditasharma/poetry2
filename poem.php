<?php
   
    define('DB_HOST', 'localhost');
    define('DB_USER', 'root');
    define('DB_PASS', 'root');
    define('DB_NAME', 'poems');
    
    $conn = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);
    if (mysqli_connect_errno()) {
        echo "Failed to connect to MySQL: " . mysqli_connect_error();
        die();
    }
    
   $stmt = $conn->prepare("SELECT id, title, shortdesc, rating, poetry, image FROM poem;");
    

    $stmt->execute();

    $stmt->bind_result($id, $title, $shortdesc, $rating, $poetry, $image);
    
    $poem = array();
    

    while($stmt->fetch()){
        $temp = array();
        $temp['id'] = $id;
        $temp['title'] = $title;
        $temp['shortdesc'] = $shortdesc;
        $temp['rating'] = $rating;
        $temp['poetry'] = $poetry;
        $temp['image'] = $image;
        array_push($poem, $temp);
    }
  
    echo json_encode($poem);
    
