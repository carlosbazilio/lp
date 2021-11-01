#consumindo uma api Rest
#endpoint obtida atraves do link https://github.com/public-apis/public-apis

require 'rest-client' #no console rodar 'gem install rest-client' e em seguida 'bundle'
require 'json'

endpoint = "http://universities.hipolabs.com/search?country=Brazil"

resposta = RestClient.get endpoint, {accept: :json}
resposta = JSON.parse(resposta.body) #extrai o corpo da mensagem (um array de hashes)

lista = resposta.map{ |e| e["name"] } #extrai os valores correspondentes a chave 'name' de cada elemento

lista_ord = lista.sort

#lista de algumas universidades brasileiras
lista_ord.each { |i| print "#{i}\n" }