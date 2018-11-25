<?php
    require "conexao.php";

@session_start();

$nome = $_SESSION['nome'];
$matricula = $_SESSION['matricula'];
$painel = $_SESSION['painel'];

if($nome == ''){
    echo "<script language='javascript'>window.location='../index.php';</script>";
}
else if($matricula == ''){
    echo "<script language='javascript'>window.location='../index.php';</script>";
}else{
    if($painel_atual != $painel){
        echo "<script language='javascript'>window.location='../index.php';</script>";
    }
}
?>