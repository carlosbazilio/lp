a = {}

u = "uff"
a[u] = 34

print(a["uff"])
print(a[u])


a[u] = {1,2,"puro"}
print(a[u])

for elemento in pairs(a) do  -- as funcoes pairs e ipairs retorna iteradores
  print(a[elemento])         -- imprime os elementos da table
end


for elemento in pairs(a) do
  print(elemento)            -- imprime o iterador
end


a[u] = {1,2,"puro"}

for elemento in pairs(a) do
  print(a[elemento])             
end


for elemento in pairs(a) do
  print(a[u][elemento])
end


os.exit()   -- sair do modo interativo
            -- acho que ctr-d tb serve pra unix





