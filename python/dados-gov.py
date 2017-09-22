# Acesso a dataset de UBS em funcionamento do site dados.gov.br
# http://dados.gov.br/dataset/mspainelsage_101

# Python Requests Docs: http://docs.python-requests.org/en/master/

import requests
# url = 'http://dados.gov.br/api/action/datastore_search?resource_id=9175f184-59a0-47a4-81f8-0d3c983b3a2d&q="Rio das Ostras"'
url = 'http://dadosabertos.rio.rj.gov.br/apiTransporte/apresentacao/rest/index.cfm/obterPosicoesDoOnibus/C47695'
fileobj = requests.get(url)
print fileobj.json()
