#!/usr/bin/env python

from sys import argv 
import requests
import random
import time

uri = argv[1]

paths = ['foo','bar','baz','bomf']
referers = [
    "www.google.com#q=docker",
    "vtcodecamp.org",
    "vtcodecamp.org/2014/sessions#deploying-your-applications-with-docker",
    "www.docker.com"]
    
while True:
    url = uri + random.choice(paths)
    r = requests.get(url, headers={'Referer' : random.choice(referers)})
    print url
    time.sleep(random.random())
    
