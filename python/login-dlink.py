import requests
r = requests.get('http://10.1.1.1', auth=('admin', 'admin'))
r.status_code
r.headers['content-type']
r.text
