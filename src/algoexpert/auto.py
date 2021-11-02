import os
import re

dir_path = os.path.dirname(os.path.realpath(__file__))
folderName = input("\ninput directory name:\n")
folderName = re.sub('([a-zA-Z])', lambda x: x.groups()[0].upper(), folderName, 1)
level = int(input("\ninput level\neasy: 1 \tmedium: 2 \thard: 3 \tvery hard: 4\n"))
if level == 1: level = "easy"
elif level == 2: level = "medium"
elif level == 3: level = "hard"
elif level == 4: level = "veryHard"
else: raise ValueError('not the correct input')

path = os.path.join(dir_path, level)
path = os.path.join(path, folderName)
os.mkdir(path) 

java = os.path.join(path, "solution.java")
python = os.path.join(path, "solution.py")
javascript = os.path.join(path, "solution.js")
read = os.path.join(path, "readMe.md")

f = open(python, "x")
f = open(javascript, "x")
f = open(read, "x")
res_list = []
res_list = re.findall('[A-Z][^A-Z]*', folderName)
f.write(" ".join(res_list))
f.close()
f = open(java, "x")
f.write("package algoexpert." + level +"." + folderName + ";")
f.close()