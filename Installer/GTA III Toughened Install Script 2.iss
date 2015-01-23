#define AppName "GTA III Toughened"
#define AppVersion "0.7"

[Setup]
AppName={#AppName}
AppVersion={#AppVersion}
AppId=GTA3ToughenedModLighnat0rEidgod
AppPublisher=Lighnat0r
AppPublisherURL=mailto:Lighnat0r@gmail.com
DefaultDirName={pf}\Grand Theft Auto 3
; DefaultGroupName={#AppName}
AppendDefaultDirName=no
UninstallDisplayIcon={app}\{#AppName}.exe
Compression=lzma2
SolidCompression=yes
OutputDir=.
DisableProgramGroupPage=yes
CloseApplicationsFilter=*.*
DirExistsWarning=no
; InfoAfterFile=Toughened Readme.txt            ACTIVATE THIS TO AUTOMATICALLY SHOW THE README IN THE INSTALL WIZARD
InfoBeforeFile={#AppName} Install Guide.txt
OutputBaseFilename={#AppName} Setup
WizardImageFile={#AppName} Install Boxart.bmp                                   
WizardSmallImageFile={#AppName} Icon.bmp 
; SetupLogging=yes                              ACTIVATE THIS TO GENERATE A DEBUG LOG IN THE TEMP FOLDER

[Files]
Source: "{#AppName}.exe"; DestDir: "{app}";     
Source: "toughened.gxt"; DestDir: "{app}\TEXT";
Source: "objtgh.dat"; DestDir: "{app}\data";
Source: "tough.scm"; DestDir: "{app}\data";  
Source: "tghm.txd"; DestDir: "{app}\models";   
Source: "{#AppName} Readme.txt"; DestDir: "{app}"; Flags:isreadme;
Source: "{#AppName} Install Guide.txt"; DestDir: "{app}";
Source: "{#AppName} Update Checker.exe"; DestDir: "{app}";

Source: "a4_e.wav"; DestDir: "{app}\audio";
Source: "a4_f.wav"; DestDir: "{app}\audio";
Source: "a4_g.wav"; DestDir: "{app}\audio";
Source: "a4_h.wav"; DestDir: "{app}\audio";
Source: "a4_i.wav"; DestDir: "{app}\audio";
Source: "a4_j.wav"; DestDir: "{app}\audio";
Source: "s1_pfe.wav"; DestDir: "{app}\audio";
Source: "s1_r.wav"; DestDir: "{app}\audio";
Source: "s3_aed.wav"; DestDir: "{app}\audio";
Source: "s5_led.mp3"; DestDir: "{app}\audio";
Source: "bang.mp3"; DestDir: "{app}\audio";
Source: "END_a.mp3"; DestDir: "{app}\audio";

[Icons]
Name: "{commondesktop}\{#AppName}"; Filename: "{app}\{#AppName}.exe"; Tasks: desktopicon

[INI]
Filename: "{app}\{#AppName}.ini"; Section: "InstallSettings"; Key:"Version"; String: "{#AppVersion}"

[UninstallDelete]
Type: files; Name: "{app}\{#AppName}.ini"

[Tasks]
Name: desktopicon; Description: "Create a &desktop icon"; GroupDescription: "Additional icons:"
Name: desktopicon\common; Description: "For all users"; GroupDescription: "Additional icons:"; Flags: exclusive
Name: desktopicon\user; Description: "For the current user only"; GroupDescription: "Additional icons:"; Flags: exclusive unchecked
Name: quicklaunchicon; Description: "Create a &Quick Launch icon"; GroupDescription: "Additional icons:"; Flags: unchecked

[Code]
function IsStrFloat(S: string): Boolean;
begin
  try
    StrToFloat(S);
    Result := True;
  except
    Result := False;
  end;
end;

// Check if the user has just selected the install location, then check the existence of some files/folders (can't do them all) to be reasonably sure it is a valid GTA3 install folder.
function NextButtonClick(CurPageID: Integer): Boolean;
var
  TempVar: String;
  InstalledVersion: String;
  AppVer: String;
begin
  case CurPageID of
    wpSelectDir:
      begin
        TempVar := ExpandConstant('{app}');
//        if WizardSilent() then 
//         begin
          InstalledVersion := GetIniString('InstallSettings', 'Version', '0.0', TempVar + '\{#AppName}.ini');
          AppVer := '{#AppVersion}'
          //MsgBox(InstalledVersion, mbError, MB_OK)
          if IsStrFloat(InstalledVersion) and IsStrFloat(AppVer) then
           begin
            StrToFloat(InstalledVersion)
            StrToFloat(AppVer)
            if InstalledVersion >= AppVer then
             begin
              if MsgBox('Same or newer version detected (v' + InstalledVersion + '). Are you sure you want to continue installation? (This will restore all files to v{#AppVersion})', mbInformation, MB_YESNO) = IDNO then 
               begin
                Abort()
               end;
             end
             else
               //MsgBox('Older version installed', mbInformation, MB_OK);
             end;
//            end;
        if FileExists(TempVar + '\gta3.exe') and DirExists(TempVar + '\TEXT') and DirExists(TempVar + '\data') and DirExists(TempVar + '\models') and DirExists(TempVar + '\txd') then
          Result := True
        else
          MsgBox('GTA III installation not detected. Please select the correct folder.', mbError, MB_OK);
      end;
  else
    Result := True;
  end;
end;
