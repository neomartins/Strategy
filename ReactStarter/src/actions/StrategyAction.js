import * as Fetch from '../fetchUtils';


export function getQuantidadePessoa(ladoSalao1, ladoSalao2, ladoMesa, func){
	return Fetch.fetchUtil('pessoa?ladoSalao1=' + ladoSalao1+'&ladoSalao2='+ ladoSalao2 + '&ladoMesa=' + ladoMesa, {}, func);
}
