@echo off
SET app_path=E:\untitled\out\production\untitled\
cd %app_path%
::set Path = %Path%;%app_path%;
@java -cp .;%app_path%;D:\java_lib\*; com.company.Main
pause
@echo on