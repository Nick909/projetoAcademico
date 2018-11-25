<?php

//session_start();

$id = 0;
$update = false;
$nome = '';
$matricula = '';
$curso = '';
$nota1 = '';
$nota2 = '';
$id_disciplina = '';

$mysqli = new mysqli('localhost', 'root', '', 'sistema_academico') or die (mysqli_error($mysqli));

if (isset($_POST['enviar'])){
    $nome = $_POST['nome'];
    $matricula = $_POST['matricula'];
    $curso = $_POST['curso'];
    
    $mysqli->query("INSERT INTO aluno (nome, matricula, curso) VALUES('$nome','$matricula', '$curso')") or die($mysqli->error);
    
    $_SESSION['message'] = "Dados salvos!";
    $_SESSION['msg_type'] = "success";
    
    header("location: index.php");
    
}

if (isset($_GET['delete'])){
    $id = $_GET['delete'];
    $mysqli->query("DELETE FROM aluno WHERE id=$id") or die ($mysqli->error());
    
    $_SESSION['message'] = "Dados deletados!";
    $_SESSION['msg_type'] = "danger";
    
    header("location: index.php");
}

if (isset($_POST['submit'])){
    $nota1 = $_POST['nota1'];
    $nota2 = $_POST['nota2'];
    $id_disciplina = $_POST['id_disciplina'];
    
    $mysqli->query("INSERT INTO nota (nota1, nota2, id_disciplina) VALUES('$nota1','$nota2','$id_disciplina')") or die($mysqli->error);
    
    $_SESSION['message'] = "Dados salvos!";
    $_SESSION['msg_type'] = "success";
    
    header("location: index.php");
    
}

if (isset($_GET['edit'])){
    $id = $_GET['edit'];
    $update = true;
    $result = $mysqli->query("SELECT * FROM aluno WHERE id=$id") or die ($mysqli->error());
    $pkCount = (is_array($result) ? count($result) : 1);
    if ($pkCount == 1){
        $row = $result->fetch_array();
        $nome = $row['nome'];
        $matricula = $row['matricula'];
        $curso = $row['curso'];
    }
}

if (isset($_POST['update'])){
    $id = $_POST['id'];
    $nome = $_POST['nome'];
    $matricula = $_POST['matricula'];
    $curso = $_POST['curso'];
    
    $mysqli->query("UPDATE aluno SET nome='$nome', matricula='$matricula', curso='$curso' WHERE id=$id") or die ($mysqli->error);
    
    $_SESSION['message'] = "Dados atualizado!";
    $_SESSION['msg_type'] = "warning";
    
    header('location: index.php');
}