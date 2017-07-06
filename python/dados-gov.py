import urllib
url = 'http://dados.gov.br/api/action/datastore_search?resource_id=9175f184-59a0-47a4-81f8-0d3c983b3a2d&q="Rio das Ostras"'
fileobj = urllib.urlopen(url)
print fileobj.read()

