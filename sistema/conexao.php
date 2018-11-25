<?php

function conectar(){
    $servidor = "localhost";
    $usuario = "root";
    $senha = "";
    $bd = "sistema_academico";
    
    $con = new mysqli($servidor, $usuario, $senha, $bd);
    return $con;
} 

$conexao = conectar();
//$mysqli = new mysqli('localhost', 'root', '', 'sistema_academico') or die (mysqli_error($mysqli));
?>