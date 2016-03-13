automato estado [] pilha =
	if (pilha == "I") then True 
	else False

automato estado (prim:restocadeia) (cabeca:restopilha) = 
	let (novoestado, novapilha) = delta (estado, prim, cabeca) in 
		if (novoestado == "") then False 
		else automato novoestado restocadeia (novapilha ++ restopilha) 

--numero de a é 2x o numero de b

delta ("1",'a','I') = ("2","AI")
delta ("2",'a','A') = ("1","A") 
delta ("1",'a','A') = ("2","AA")
delta ("1",'b','A') = ("3","") 
delta ("3",'b','A') = ("3","")
delta ("3",_,'I') = ("4","I")
delta (_,_,_) = ("","")

main = print (automato "1" "aab" "I")

