:: Installed OS
Set _Bitness=64
IF %PROCESSOR_ARCHITECTURE% == x86 (
	IF NOT DEFINED PROCESSOR_ARCHITEW6432 Set _Bitness=32
	)
Echo Operating System is %_Bitness% bit

IF %_Bitness% == 64 (
	for /f "tokens=5*" %%A in ('REG QUERY "HKLM\Software\Wow6432Node\Microsoft\Windows\CurrentVersion\Uninstall\Sanny Builder 3_is1" /v "Inno Setup: App Path"') DO SET SannyDir=%%B\
) ELSE (
	for /f "tokens=5*" %%A in ('REG QUERY "HKLM\Software\Microsoft\Windows\CurrentVersion\Uninstall\Sanny Builder 3_is1" /v "Inno Setup: App Path"') DO SET SannyDir=%%B\
)

:: Uncomment and set the right folder below if the folder cannot be found automatically. Be sure to leave the trailing backslash in!
::SET SannyDir=C:\Program Files\Sanny Builder 3\


START "title" /D "%SannyDir%" /WAIT "sanny.exe" \nosplash \gta3 \compile "%CD%\main.sc" "%CD%\Compiled SCM\tough.scm"

START "title" /D "%SannyDir%" /WAIT "sanny.exe" \nosplash \gta3 \compile "%CD%\main_debug.sc" "%CD%\Compiled SCM\tough_debug.scm"
