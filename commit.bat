@ECHO OFF

ECHO ***********************************************************************
ECHO Automatizacao para fazer commits sem trocar as credenciais da maquina!!!
ECHO ***********************************************************************

SET /P "name=Informe seu nome: "
SET /P "email=Informe seu e-mail: "
SET /P "commitMessage=Informe a mensagem do commit: "

ECHO .
git add .
ECHO .

git -c "user.name=%name%" -c "user.email=%email%" commit -m "%commitMessage%"

ECHO ***************************************************
ECHO Obrigado por nao zoar as credenciais git da maquina
ECHO ***************************************************

PAUSE 