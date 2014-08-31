/*
List of GUI windows in use:
7: Update Notifier

*/

; ######################################################################################################
; ########################################### HEADER SECTION ###########################################
; ######################################################################################################

/*
Subheadings:

	#AUTO-EXECUTE

*/

; Only one instance of the program can be running at a time.
#SingleInstance Force
; Change the name of the program in the tray menu, then remove the standard tray items
; and add the ones relevant to this program.
SplitPath, A_ScriptName,,,,ScriptNameNoExt
menu, tray, tip, %ScriptNameNoExt%
; Configure the auto updater.
IniRead, CurrentVersion, GTA III Toughened.ini, InstallSettings, Version
if (CurrentVersion = "ERROR")
{
	MsgBox, The current version could not be determined. `nThe auto-updater will shut down.
	ExitApp
}
VersionURL := "http://pastebin.com/download.php?i=pc9QbQCK"
ProgramName := "GTA III Toughened"
File1 := "GTA III Toughened Setup.exe"
goto UpdateCheck




; ######################################################################################################
; ########################################### UPDATE CHECKER ###########################################
; ######################################################################################################

/*
Subheadings:

	UpdateCheck
	7ButtonYes
	7GuiClose/7GuiEscape/7ButtonNo
*/

UpdateCheck:
; Avast stops the program from functioning correctly, presumably because it tries to connect to the internet for the 
; update checker. So we will read the registry to see if Avast has been installed. The location of the registry key
; by which we determine if Avast is installed depends on whether the OS is 64 or 32 bit. If it is 64 bit, the key 
; can be in one of two locations (one for the 32 bit version of Avast and one for the 64 bit version). The 32 bit
; OS only has one possible location.
if (A_Is64bitOS)
{
	SetRegView 64
	RegRead, AvastInstalled, HKLM, Software\Wow6432Node\Microsoft\Windows\CurrentVersion\Uninstall\Avast, DisplayName
	if ErrorLevel = 1
		RegRead, AvastInstalled, HKLM, Software\Microsoft\Windows\CurrentVersion\Uninstall\Avast, DisplayName
}
else
	RegRead, AvastInstalled, HKLM, Software\Microsoft\Windows\CurrentVersion\Uninstall\Avast, DisplayName
; If there was no problem reading the registry the registry key exists, so Avast is installed. In this case
; let the user know the update checker has been disabled and skip it.
if ErrorLevel = 0
{
	outputdebug %AvastInstalled% detected
	MsgBox, Avast has been detected on your computer. `nThe auto-updater will shut down.
	return
}
UrlDownloadToFile, %VersionURL%, Version.ini
if ErrorLevel = 0 ; Check if the version file was downloaded successfully.
{
	; Check if a newer version is released. If this is the case, show the update screen with the current
	; version (stored internally), a description and the version it will update to (both read from the version file).
	IniRead, NewestVersion, Version.ini, Version, %ProgramName%
	if (NewestVersion != "ERROR" AND NewestVersion > CurrentVersion)
	{
		Gui 7:-MinimizeBox -MaximizeBox +LastFound
		Gui, 7:Font, Q3
		Gui, 7:Add, Text,, An update is available. Current version`: v%CurrentVersion%. `nNew version`: v%NewestVersion%. Would you like to update now`?
		IniRead, DescriptionText, Version.ini, %ProgramName% Files, Description
		if (DescriptionText != "ERROR" AND DescriptionText != "")
		{
			Gui, 7:Font, w700 Q3 ; Bold
			Gui, 7:Add, Text,, Update description`:
			Gui, 7:Font, w400 Q3 ; Normal
			Gui, 7:Add, Text,h0 w0 Y+4,
			StringSplit, DescriptionTextArray, DescriptionText, `|
			Loop %DescriptionTextArray0%
				Gui, 7:Add, Text,Y+1, % DescriptionTextArray%A_Index%
		}
		Gui, 7:Add, Text,h0 w0 Y+4,
		Gui, 7:Add, Button, section default, Yes
		Gui, 7:Add, Button, ys, No
		Gui, 7:Show
		return
	}
	else
	{
		MsgBox, You are using the most recent version of %ProgramName%.
		FileDelete, Version.ini
		ExitApp
	}
}
Else
{
	MsgBox, The newest version could not be determined. `nThe auto-updater will shut down.
	ExitApp
}
	

; If the user accepts, show a splash text that the new version is being downloaded. 
7ButtonYes:
Gui, 7:Destroy
SplashTextOn , 350 , , Downloading the new version. This might take some time...
; Download the file, from the location specified in the previously downloaded version.ini
IniRead, FileLink, Version.ini, %ProgramName% Files, %File1%
UrlDownloadToFile, %FileLink%, %File1%
; We don't need the version file anymore, so delete it.
FileDelete, Version.ini
outputdebug %File1%
Run, "GTA III Toughened Setup.exe" /silent , ,

ExitApp

;If the user declines the update, delete the version file and continue running the program.
7GuiClose:
7GuiEscape:
7ButtonNo:
Gui, 7:Destroy
FileDelete, Version.ini
ExitApp
