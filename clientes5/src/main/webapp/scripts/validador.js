/**
 * validação de formulário
 */
 
 function validar()
 {
	// alert('teste')
	let nome = frmContato.nome.value
	let fone = frmContato.fone.value
	
	if (nome === "")
	{
		alert('Preencha o campo nome')
		frmContato.nome.focus() //retoma o cursor para o campo nome
		return false //não envia os dados
	}
	else if(fone === "")
	{
		alert('Preencha o campo Fone')
		frmContato.fone.focus()
		return false
	}
	else
	{
		document.forms["frmContato"].submit()
	}
	
}