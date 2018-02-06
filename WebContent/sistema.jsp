<!DOCTYPE html>
<html>
	<head>
		<title>Sistema Aula</title>
		
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.css"/>
     	<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.js"  ></script>
     	<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		
	</head>
	<body>
		<h2>Gravar Dados</h2>
		
		<fieldset>
			<legend>Cliente</legend>
			
			<form action="Controle?cmd=gravar" method="post">
			
				<label for="idNome"> Nome:</label>
				<input type="text" id="idNome" name="nome" size="50" required="required"
				pattern="{a-z A-Z}{2,50}" placeholder="Entre com o nome aqui" title="Entre com o nome" />
				
				<br/><br/>
				
				<label for="idEmail"> Email:</label>
				<input type="email" id="idEmail" name="email"   required="required"
				placeholder="Entre com o email aqui" title="Entre com o email"
				/>
				
				
				<br/><br/>
				
				<label for="idlogradouro"> Logradouro:</label>
				<input type="text" id="idlogradouro" name="logradouro" size="50"  required="required"
				placeholder="Entre com o endereço aqui" title="Entre com o endereco"
				/>
				
				<br/><br/>
				
				<label for="idbairro"> Bairro:</label>
				<input type="text" id="idbairro" name="bairro"  size="50" required="required"
				placeholder="Entre com o bairro aqui" title="Entre com o bairro"
				/>
				
				<br/><br/>
				
				<label for="idcidade"> Cidade:</label>
				<input type="text" id="idcidade" name="cidade"  size="50" required="required"
				placeholder="Entre com a cidade aqui" title="Entre com o cidade"
				/>
				
				<br/><br/>
				
				<label for="idestado"> Estado:</label>
				<input type="text" id="idestado" name="estado" size="20" required="required"
				placeholder="Entre com o estado aqui" title="Entre com o estado"
				/>
				
				<br/><br/>
				
				<label for="idcep"> Cep:</label>
				<input type="text" id="idcep" name="cep"  required="required"
				placeholder="Entre com o cep aqui" title="Entre com o cep"
				/>
				
				<br/><br/>
				
				
				<button type="submit">Gravar</button>
				
				<br/><br/>
				${msg}
				
			</form>
			
		</fieldset>
		
	</body>
	
	<script type="text/javascript">
	
		$("document").ready(function () {
			
			$("#idcep").change(function(){
				var vcep = $(this).val();
				if(vcep<=0){
					return;	
				}
				$.get("http://apps.widenet.com.br/busca-cep/api/cep/cep.json", {code: vcep}, function(result){
					if(result.status!=1){
                        alert ("Nenhum cep conhecido");
                        return;
                    }
                    
                    $("#idcep").val(result.code);
                    $("#idlogradouro").val(result.address);
                    $("#idbairro").val(result.district);
                    $("#idcidade").val(result.city);
                    $("#idestado").val(result.state);
                    
                    
				});
			});
		
		});	
	
	</script>
</html>