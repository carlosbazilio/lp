#import urrlib.request
import urllib2
import json
#import requests

url = 'https://graph.facebook.com/SiteDilmaRousseff/'
resp = urllib2.urlopen(url).read()
#resp = requests.get(url)
data = json.loads(resp.decode('utf-8'))
#data = json.loads(resp)
print data

