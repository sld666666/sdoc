import os
import shutil

sourceAndTargetDirc = {r"E:\project\github\sdoc\sdoc-web\src\main\resources\application.properties" : r"E:\project\github\sdoc\sdoc-biz\src\test\resources\test.properties"}

def  convert(sourceAndTargetDirc):
    for k, v in sourceAndTargetDirc.items():
        print(k)
        print(v)
        os.remove(v)
        shutil.copyfile(k,v)


if __name__ == "__main__":
    print(type(sourceAndTargetDirc))
    convert(sourceAndTargetDirc)
    print("finished")

