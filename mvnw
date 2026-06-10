#!/usr/bin/env sh
# Lightweight project wrapper: if mvn is installed it will be used; otherwise this script downloads a Maven binary into .mvn/wrapper and runs it.
MAVEN_VERSION=3.9.16

# If mvn is available, use it
if command -v mvn >/dev/null 2>&1; then
  exec mvn "$@"
fi

MAVEN_DIR=".mvn/apache-maven-$MAVEN_VERSION"
if [ -x "$MAVEN_DIR/bin/mvn" ]; then
  exec "$MAVEN_DIR/bin/mvn" "$@"
fi

echo "Maven not found. Attempting to download Maven $MAVEN_VERSION into .mvn/wrapper..."
mkdir -p .mvn/wrapper

TARBALL="apache-maven-$MAVEN_VERSION-bin.tar.gz"
URL="https://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/$TARBALL"

if command -v curl >/dev/null 2>&1; then
  curl -fsSL -o .mvn/wrapper/$TARBALL "$URL"
elif command -v wget >/dev/null 2>&1; then
  wget -q -O .mvn/wrapper/$TARBALL "$URL"
else
  echo "Please install curl or wget to allow this script to download Maven." >&2
  exit 1
fi

# extract
if command -v tar >/dev/null 2>&1; then
  tar -xzf .mvn/wrapper/$TARBALL -C .mvn/wrapper
else
  echo "tar is required to extract Maven distribution." >&2
  exit 1
fi

if [ -x ".mvn/wrapper/apache-maven-$MAVEN_VERSION/bin/mvn" ]; then
  mv .mvn/wrapper/apache-maven-$MAVEN_VERSION .mvn/apache-maven-$MAVEN_VERSION 2>/dev/null || true
  exec .mvn/apache-maven-$MAVEN_VERSION/bin/mvn "$@"
else
  echo "Failed to download or prepare Maven." >&2
  exit 1
fi

