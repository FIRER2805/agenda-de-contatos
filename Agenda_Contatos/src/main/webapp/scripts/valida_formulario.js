/**
 * 
 */
 
function alerta()
{
	let valor_nome = formulario.nome.value;
	let valor_telefone = formulario.telefone.value;
	if(valor_nome === "" && valor_telefone === "")
	{
		alert("os campos nome e telefone são obrigatórios");
		formulario.nome.focus();
		return false;
	}
	else if(valor_nome === "")
	{
		alert("o campo nome é obrigatório");
		formulario.nome.focus();
		return false;
	}
	else if(valor_telefone === "")
	{
		alert("o campo telefone é obrigatório");
		formulario.telefone.focus();
		return false;
	}
	else
	{
		document.forms["formulario"].submit();
	}
}