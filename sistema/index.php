<!DOCTYPE html>
<html>
<head>
<title>Sistema Academico</title>
<link rel="shortcut icon" href="img/icon_1.png">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<?php require "conexao.php" ?>
</head>
<body>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
  Clique aqui!
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Informações</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        1º Informação é que a gente não conseguiu dá select na tabela professor e aluno para poder logar, então vai ter que comentar o codigo no arquivo index.php a index principal onde tá: $sql = "SELECT * FROM aluno WHERE nome ='$nome' AND matricula ='$matricula'";
           // $sql = "SELECT * FROM professor WHERE nome ='$nome' AND matricula ='$matricula'";.
           Acesso para professor Nome: professor, Matricula: 123.
           Acesso para aluno Nome: aluno, Matricula: 123.
           
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
        <button type="button" class="btn btn-primary">Done</button>
      </div>
    </div>
  </div>
</div>

<div class="logo">
    <img src="img/logo.png"/>
</div>

<div class="caixa_login">
   <?php
    if(isset($_POST['button'])){
        $nome = $_POST['nome'];
        $matricula = $_POST['matricula'];
        
        if($nome == ''){
            echo "<h2>Por favor, digite seu login corretamente!</h2>";
         }

            else if($matricula == ''){
                echo "<h2>Por favor, digite sua senha corretamente!</h2>";
            }
            else{
            $sql = "SELECT * FROM aluno WHERE nome ='$nome' AND matricula ='$matricula'";
           $sql = "SELECT * FROM professor WHERE nome ='$nome' AND matricula ='$matricula'";
            
            $result = mysqli_query($conexao, $sql);
            if(mysqli_num_rows($result) > 0){
                
                while($res_1 = mysqli_fetch_assoc($result)){
                    $nome = $res_1['nome'];
                    $matricula = $res_1['matricula'];
                    $painel = $res_1['painel'];
                    
                    if($matricula == ''){
                        echo "<h2>Digite sua matricula!</h2>";
                    }else{
                        session_start();
                        $_SESSION['nome'] = $nome;
                        $_SESSION['matricula'] = $matricula;
                        $_SESSION['painel'] = $painel;
                        
                        if($painel == professor){
                            echo "<script language='javascript'>window.location='professor';</script>";
                        }
                         else if($painel == aluno){
                            echo "<script language='javascript'>window.location='aluno';</script>";
                        }
                         
                    }
                }
            }else{
                echo "<h2>Dados incorretos</h2>";
            }
        }
        
    }
    ?>
    
    <form name="form" method="post" action="#">
        <table>
            <tr>
                <td><h1>Nome:</h1></td>
            </tr>
            <tr>
                <td><input type="text" name="nome"></td>
            </tr>
            <tr>
                <td><h1>Matricula:</h1></td>
            </tr>
            <tr>
                <td><input type="number" name="matricula"></td>
            </tr>
            <tr>
                <td><input class="input" type="submit" name="button" value="Entrar"></td>
            </tr>
        </table>
    </form>
</div>
<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>