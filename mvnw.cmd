@echo off
REM Lightweight project wrapper: if mvn is installed it will be used; otherwise this script downloads a Maven binary into .mvn\wrapper and runs it.
setlocal
set MAVEN_VERSION=3.9.16

:: If mvn is available on PATH, use it
where mvn >nul 2>nul
if %ERRORLEVEL%==0 (
  mvn %*
  exit /b %ERRORLEVEL%
)

:: If we already downloaded a local Maven, use it
if exist ".mvn\apache-maven-%MAVEN_VERSION%\bin\mvn.cmd" (
  ".mvn\apache-maven-%MAVEN_VERSION%\bin\mvn.cmd" %*
  exit /b %ERRORLEVEL%
)

echo Maven not found on this machine. Attempting to download Maven %MAVEN_VERSION% to .mvn\wrapper ...
powershell -NoProfile -Command "
$ProgressPreference = 'SilentlyContinue';
$m = '%MAVEN_VERSION%';
$zip = 'apache-maven-' + $m + '-bin.zip';
$url = 'https://archive.apache.org/dist/maven/maven-3/' + $m + '/binaries/' + $zip;
$outDir = Join-Path (Get-Location) '.mvn\wrapper';
if (-not (Test-Path $outDir)) { New-Item -ItemType Directory -Path $outDir | Out-Null }
$out = Join-Path $outDir $zip;
Write-Host 'Downloading ' $url '...';
Invoke-WebRequest -Uri $url -OutFile $out;
Write-Host 'Extracting...';
Expand-Archive -Path $out -DestinationPath $outDir -Force;
# Move extracted folder up one level to .mvn\apache-maven-<version>
$extracted = Join-Path $outDir ('apache-maven-' + $m);
if (Test-Path $extracted) {
  Move-Item -Path $extracted -Destination (Join-Path (Get-Location) ('.mvn\apache-maven-' + $m)) -Force
}
" || (
  echo Failed to download or extract Maven. Please install Maven manually and add it to PATH.
  exit /b 1
)

:: Run the downloaded mvn
if exist ".mvn\apache-maven-%MAVEN_VERSION%\bin\mvn.cmd" (
  ".mvn\apache-maven-%MAVEN_VERSION%\bin\mvn.cmd" %*
) else (
  echo Failed to prepare Maven. Please install it manually.
  exit /b 1
)
endlocal

