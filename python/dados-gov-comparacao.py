# -*- coding: utf-8 -*-

# Jairo Alves, Julho/2017
# Acesso a dataset de UBS em funcionamento do site dados.gov.br
# http://dados.gov.br/dataset/mspainelsage_101

import requests 

url = 'http://dados.gov.br/api/action/datastore_search'
cidades = ['Maca', 
           'Rio Bonito', 
           'Rio das Ostras',
           'Rio de Janeiro',
           'Remgio'] # Lista de Cidades desejadas


def extrai_campos(registro):
#    Retorna nome, bairro, rua, cidade, estado do dado
    return registro['no_fantasia'], registro['no_bairro'], \
           registro['no_logradouro'], registro['cidade'], registro['uf']

def esp_horizontal(caractere='-', compr=40):
#    Espacamento horizontal
    linha = ''
    for cont in range(compr):
        linha = linha + caractere
    print (linha)

def esp_vertical(num_linhas):
    [print() for i in range(num_linhas)]
    
def compara_ubs(cidades, verboso = 0):
    # compara os dados das UBS entre as cidades
    
    print("Cidade             No. UBS     Qtd Bairros")
    print("--------------    ---------    -----------")
    for cidade in cidades:
        params = dict(
            resource_id='9175f184-59a0-47a4-81f8-0d3c983b3a2d',
            q = cidade 
        )
        
        resp = requests.get(url=url, params=params)
        dados = resp.json()['result']['records']
        bairros = set()
        num_postos = 0
        
        for registro in dados:
            nome, bairro, rua, cidade_lida, estado = extrai_campos(registro)
            if(cidade_lida != cidade):
                continue
            num_postos = num_postos + 1
            
            if(verboso):
                esp_horizontal()
                print('Nome: ' + nome)
                print(rua.strip() + '.', 'Bairro:', bairro)
                print(cidade_lida + ',', estado + '.')
            bairros.add(bairro)
            
        
        print('{:<20}'.format(cidade), '{:>3}'.format(num_postos), \
              '{:>12}'.format(len(bairros)) )
esp_horizontal('-', 42)

esp_vertical(4)
compara_ubs(cidades)