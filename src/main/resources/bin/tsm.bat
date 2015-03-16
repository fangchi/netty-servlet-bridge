@echo off

if "%OS%" == "Windows_NT" setlocal
rem ---------------------------------------------------------------------------
rem Start script for the tsm Server
rem ---------------------------------------------------------------------------

rem Guess TSM_HOME if not defined
set "CURRENT_DIR=%cd%"
if not "%TSM_HOME%" == "" goto gotHome
set "TSM_HOME=%CURRENT_DIR%"
if exist "%TSM_HOME%\bin\tsm.bat" goto okHome
cd ..
set "TSM_HOME=%cd%"
cd "%CURRENT_DIR%"
:gotHome
if exist "%TSM_HOME%\bin\tsm.bat" goto okHome
echo The TSM_HOME environment variable is not defined correctly
echo This environment variable is needed to run this program
goto end
:okHome

rem Make sure prerequisite environment variables are set
if not "%JAVA_HOME%" == "" goto gotJdkHome
if not "%JRE_HOME%" == "" goto gotJreHome
echo Neither the JAVA_HOME nor the JRE_HOME environment variable is defined
echo At least one of these environment variable is needed to run this program
goto end

:gotJreHome
if not exist "%JRE_HOME%\bin\java.exe" goto noJavaHome
if not exist "%JRE_HOME%\bin\javaw.exe" goto noJavaHome
goto end

:gotJdkHome
if not exist "%JAVA_HOME%\bin\java.exe" goto noJavaHome
if not exist "%JAVA_HOME%\bin\javaw.exe" goto noJavaHome
if not exist "%JAVA_HOME%\bin\javac.exe" goto noJavaHome
if not "%JRE_HOME%" == "" goto okJavaHome
set "JRE_HOME=%JAVA_HOME%"
goto okJavaHome

:noJavaHome
echo The JAVA_HOME environment variable is not defined correctly
echo This environment variable is needed to run this program
echo NB: JAVA_HOME should point to a JDK not a JRE
goto end
:okJavaHome

rem Set standard command for invoking Java.
rem Note that NT requires a window name argument when using start.
rem Also note the quoting as JAVA_HOME may contain spaces.
set _RUNJAVA="%JRE_HOME%\bin\java"

rem Ensure that any user defined CLASSPATH variables are not used on startup,
rem but allow them to be specified in setenv.bat, in rare case when it is needed.
rem Set CLASSPATH

set TSM_LIB="%TSM_HOME%\lib"
setlocal ENABLEDELAYEDEXPANSION
SET _CLASSPATH=.
FOR %%i IN (%TSM_LIB%\*.jar) DO (
   set _CLASSPATH=!_CLASSPATH!;%%i
)
set CLASSPATH=!_CLASSPATH!
setlocal DISABLEDELAYEDEXPANSION

rem ----- Execute The Requested Command ---------------------------------------

echo Using TSM_HOME:   "%TSM_HOME%"
echo Using JRE_HOME:   "%JRE_HOME%"
rem echo Using CLASSPATH:  "%CLASSPATH%"

set _EXECJAVA=%_RUNJAVA%
set MAINCLASS=com.whty.jetty.JettyServer
set ACTION=start

if ""%1"" == """"      goto doStart
if ""%1"" == ""start"" goto doStart
if ""%1"" == ""stop""  goto doStop

echo Usage:  tsm ( [start^|stop] parameters ... )
echo commands:
echo   start             Start tsm in a separate window
echo   stop              Stop tsm
goto end

:doStart
shift
if not "%OS%" == "Windows_NT" goto noTitle
if "%TITLE%" == "" set TITLE=Tomcat
rem set _EXECJAVA=start "%TITLE%" %_RUNJAVA%
set _EXECJAVA=%_RUNJAVA%
goto gotTitle
:noTitle
rem set _EXECJAVA=start %_RUNJAVA%
set _EXECJAVA=%_RUNJAVA%
:gotTitle
goto execCmd

:doStop
shift
set ACTION=stop
goto execCmd

:execCmd
rem Get remaining unshifted command line arguments and save them in the
set CMD_LINE_ARGS=
:setArgs
if ""%1""=="""" goto doneSetArgs
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto setArgs
:doneSetArgs

set JAVA_OPTS=-Xms256m -Xmx612m -XX:MaxNewSize=512m -XX:MaxPermSize=512m

rem Execute Java with the applicable properties
rem %_EXECJAVA% %JAVA_OPTS% -classpath "%CLASSPATH%" -Dtsm.home="%TSM_HOME%" %MAINCLASS% %ACTION%%CMD_LINE_ARGS%
%_EXECJAVA% %JAVA_OPTS% -Djava.library.path="%TSM_HOME%/lib" -Dtsm.home="%TSM_HOME%" %MAINCLASS% %ACTION%%CMD_LINE_ARGS%
:end
