<?php $painel_atual = "aluno"; ?>
<?php require "../config.php"; ?>

<!doctype html>
<html lang="pt-br">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="shortcut icon" href="img/icon_1.png">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <title>Sistema Academico!</title>
  </head>
  <body>
  <div class="d-flex p-2"><h1><?php echo "Bem vindo "?><?php echo $nome ?></h1>
  </div>
  
  <?php require_once 'processo.php' ?>
  
  <?php
    if(isset($_SESSION['message'])): ?>
    
    <div class="alert alert-<?=$_SESSION['msg_type']?>">
       
       <?php
            echo $_SESSION['message'];
            unset($_SESSION['message']);
    ?>  
    </div>
    <?php endif ?>    
  <div class="container">
  <?php
        $mysqli = new mysqli('localhost', 'root', '', 'sistema_academico') or die (mysqli_error($mysqli));
        $result = $mysqli->query("SELECT * FROM disciplina,nota") or die ($mysqli->error);
        //pre_r($result);
      ?>
      
      <div class="row justify-content-center">
          <table class="table">
              <thread>
                  <tr>
                      <th>Nome</th>
                      <th>Descricao</th>
                      <th>AVP1</th>
                      <th colspan="-2">AVP2</th>
                  </tr>
              </thread>
      <?php 
              while ($row = $result->fetch_assoc()): ?>
              
              <tr>
                  <td><?php echo $row['nome']; ?></td>
                  <td><?php echo $row['descricao']; ?></td>
                  <td><?php echo $row['nota1']; ?></td>
                    <td><?php echo $row['nota2']; ?></td>
              </tr>
              <?php endwhile; ?>
          </table>
          
      </div>
      
      <?php
        function pre_r($array){
            echo '<prev>';
            print_r($array);
            echo '<prev';
        }
      ?>
   
    </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>